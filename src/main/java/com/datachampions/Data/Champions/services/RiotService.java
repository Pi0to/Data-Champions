package com.datachampions.Data.Champions.services;

import com.datachampions.Data.Champions.dto.importDto.*;
import com.datachampions.Data.Champions.entities.champion.Champion;
import com.datachampions.Data.Champions.entities.item.Item;
import com.datachampions.Data.Champions.entities.match.Match;
import com.datachampions.Data.Champions.entities.match.Participant;
import com.datachampions.Data.Champions.entities.rune.Rune;
import com.datachampions.Data.Champions.entities.summoner.Summoner;
import com.datachampions.Data.Champions.entities.sumonnerSpell.SummonerSpell;
import com.datachampions.Data.Champions.enums.GameMode;
import com.datachampions.Data.Champions.enums.QueueType;
import com.datachampions.Data.Champions.repositories.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class RiotService {

    private final static Logger logger = LoggerFactory.getLogger(RiotService.class);

    private final WebClient regionalWebClient;
    private final WebClient platformWebClient;

    private final ObjectMapper objectMapper;


    private final SummonerRepository summonerRepository;
    private final ChampionRepository championRepository;
    private final RuneRepository runeRepository;
    private final ItemRepository itemRepository;
    private final SSpellRepository sSpellRepository;
    private final ChampionService championService;

    private final SummonerService summonerService;


    public RiotService(@Qualifier("regionalWebClient") WebClient regionalWebClient,
                       @Qualifier("platformWebClient") WebClient platformWebClient,
                       ObjectMapper objectMapper, SummonerRepository summonerRepository, ChampionRepository championRepository, RuneRepository runeRepository, ItemRepository itemRepository, SSpellRepository sSpellRepository, ChampionService championService, SummonerService summonerService) {

        this.regionalWebClient = regionalWebClient;
        this.platformWebClient = platformWebClient;

        this.objectMapper = objectMapper;
        this.summonerRepository = summonerRepository;
        this.championRepository = championRepository;
        this.runeRepository = runeRepository;
        this.itemRepository = itemRepository;
        this.sSpellRepository = sSpellRepository;
        this.championService = championService;
        this.summonerService = summonerService;
    }

    public List<String> getChallengerSummoners() {

        String responseBody = regionalWebClient.get()
                .uri("/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        List<String> puuids = new ArrayList<>();

        try {
            JsonNode root = objectMapper.readTree(responseBody);

            JsonNode entries = root.get("entries");
            if (entries != null && entries.isArray()) {

                for (JsonNode entry : entries) {
                    String summonerId = entry.get("puuid").asText();
                    puuids.add(summonerId);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return puuids;
    }

    public List<String> getMatchIdsByPuuid(String puuid, int count) {

        return platformWebClient.get()
                .uri("/lol/match/v5/matches/by-puuid/" + puuid + "/ids?count=" + count)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {})
                .block();
    }

    public MatchImportDto getMatchById(String matchId) {

        logger.info(">>> [CLIENT] Montando URL final com o ID: '{}'", matchId);

        String responseBody = platformWebClient.get()
                .uri("/lol/match/v5/matches/" + matchId)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        try {

            JsonNode root = objectMapper.readTree(responseBody);
            JsonNode infoNode = root.get("info");
            JsonNode participantsNode = infoNode.get("participants");

            List<ParticipantImportDto> participantsDto = new ArrayList<>();

            for(JsonNode p : participantsNode){
                participantsDto.add(objectMapper.treeToValue(p, ParticipantImportDto.class));
            }

            MatchImportDto matchImportDto = new MatchImportDto(root.get("metadata").get("matchId").asText(),
                    infoNode.get("gameMode").asText(),
                    infoNode.get("queueId").asInt(),
                    infoNode.get("gameVersion").asText(),
                    participantsDto
            );


            return matchImportDto;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getSummonerByPuuid(String puuid) {

        return  regionalWebClient.get()
                .uri("/lol/summoner/v4/summoners/by-puuid/" + puuid)
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }




}
