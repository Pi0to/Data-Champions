package com.datachampions.Data.Champions.services;

import com.datachampions.Data.Champions.dto.importDto.MatchImportDto;
import com.datachampions.Data.Champions.dto.importDto.ParticipantImportDto;
import com.datachampions.Data.Champions.entities.match.Match;
import com.datachampions.Data.Champions.entities.summoner.Summoner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiotService {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    private static final String API_KEY = "RGAPI-b82f152b-eb43-43f0-8c91-5981f6e1ac4e";
    private static final String BASE_URL = "https://api.riotgames.com";

    public RiotService(WebClient webClient, ObjectMapper objectMapper) {
        this.webClient = webClient;
        this.objectMapper = objectMapper;
    }

    public List<String> getChallengerSummoners() {
        String url = BASE_URL + "/lol/league/v4/challengerleagues/by-queue/RANKED_SOLO_5x5";

        String responseBody = webClient.get()
                .uri(url)
                .header("X-Riot-Token", API_KEY)
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
        String url = BASE_URL + "/lol/match/v5/matches/by-puuid/" + puuid + "/ids?count=" + count;

        return webClient.get()
                .uri(url)
                .header("X-Riot-Token", API_KEY)
                .retrieve()
                .bodyToFlux(String.class)
                .collectList()
                .block();
    }

    public Match getMatchById(String matchId) {
        String url = BASE_URL + "/lol/match/v5/matches/" + matchId;

        String responseBody = webClient.get()
                .uri(url)
                .header("X-Riot-Token", API_KEY)
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


            return matchImportDto.toEntity();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
