package com.datachampions.Data.Champions.jobs;

import com.datachampions.Data.Champions.repositories.MatchRepository;
import com.datachampions.Data.Champions.services.MatchService;
import com.datachampions.Data.Champions.services.RiotService;
import com.datachampions.Data.Champions.services.SummonerService;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Component
public class DataIngestionJob {


    private static final Logger logger = LoggerFactory.getLogger(DataIngestionJob.class);

    private final RiotService riotService;
    private final MatchService matchService;
    private final SummonerService summonerService;
    private final MatchRepository matchRepository;

    public DataIngestionJob(RiotService riotService, MatchService matchService, SummonerService summonerService,
                            MatchRepository matchRepository) {
        this.riotService = riotService;
        this.matchService = matchService;
        this.summonerService = summonerService;
        this.matchRepository = matchRepository;
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 600000)
    public void fetchNewMatches(){

        logger.info("[START] Fetching new matches from Riot API");

        try{
            logger.info("Fetching challenger summoners...");

            List<String> challengerPuuids = riotService.getSummonersByQueue("challengerleagues");
            List<String> grandMasterPuuids = riotService.getSummonersByQueue("challengerleagues");
            List<String> masterPuuids = riotService.getSummonersByQueue("challengerleagues");


            this.processMatches(challengerPuuids);
            logger.info("Total challenger summoners fetched: " + challengerPuuids.size());

            this.processMatches(grandMasterPuuids);
            logger.info("Total grand master summoners fetched: " + grandMasterPuuids.size());

            this.processMatches(masterPuuids);
            logger.info("Total master summoners fetched: " + masterPuuids.size());


        } catch (InterruptedException e) {
            logger.error("Job was interrupted", e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {

            logger.error("Occurred an unexpected error during the job execution.", e);
        }


        logger.info("[END] Finished fetching new matches from Riot API");
    }

    private void processMatches(List<String> puuids) throws InterruptedException, Exception {
        for(String puuid : puuids.subList(0, 10)) {
            logger.info("Fetching match IDs for summoner PUUID: " + puuid);

            List<String> matchIds =  riotService.getMatchIdsByPuuid(puuid, 10);

            matchIds.removeAll(matchRepository.findExistingIdsByMatchIdIn(matchIds));

            for (String matchId : matchIds) {

                logger.info(">>> [JOB] Sending to MatchService the ID: '{}'", matchId);


                matchService.processAndSaveMatch(matchId);

                Thread.sleep(10000);
            }
        }
    }

}
