package com.datachampions.Data.Champions.jobs;

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

    public DataIngestionJob(RiotService riotService, MatchService matchService, SummonerService summonerService) {
        this.riotService = riotService;
        this.matchService = matchService;
        this.summonerService = summonerService;
    }

    @Scheduled(initialDelay = 5000, fixedDelay = 600000)
    public void fetchNewMatches(){

        logger.info("[START] Fetching new matches from Riot API");

        try{
            logger.info("Fetching challenger summoners...");

            List<String> challengerPuuids = riotService.getChallengerSummoners();

            for(String puuid : challengerPuuids) {
                logger.info("Fetching match IDs for summoner PUUID: " + puuid);

                List<String> matchIds = riotService.getMatchIdsByPuuid(puuid, 15);

                for (String matchId : matchIds) {

                    logger.info(">>> [JOB] Enviando para o MatchService o ID: '{}'", matchId);


                    matchService.processAndSaveMatch(matchId);

                    Thread.sleep(1500);
                }
            }
        } catch (InterruptedException e) {
            logger.error("O Job foi interrompido.", e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {

            logger.error("Ocorreu um erro inesperado durante a execução do Job.", e);
        }


        logger.info("[END] Finished fetching new matches from Riot API");
    }

}
