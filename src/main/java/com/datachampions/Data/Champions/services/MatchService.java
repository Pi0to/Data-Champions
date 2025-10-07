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
import com.datachampions.Data.Champions.repositories.ItemRepository;
import com.datachampions.Data.Champions.repositories.MatchRepository;
import com.datachampions.Data.Champions.repositories.RuneRepository;
import com.datachampions.Data.Champions.repositories.SSpellRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class MatchService {

    private static final Logger logger = LoggerFactory.getLogger(MatchService.class);

    private final RiotService riotService;
    private final SummonerService summonerService;
    private final ChampionService championService;

    private final MatchRepository matchRepository;
    private final RuneRepository runeRepository;
    private final ItemRepository itemRepository;
    private final SSpellRepository sSpellRepository;

    public MatchService(MatchRepository matchRepository, RiotService riotService, SummonerService summonerService, ChampionService championService, RuneRepository runeRepository, ItemRepository itemRepository, SSpellRepository sSpellRepository) {
        this.matchRepository = matchRepository;
        this.riotService = riotService;
        this.summonerService = summonerService;
        this.championService = championService;
        this.runeRepository = runeRepository;
        this.itemRepository = itemRepository;
        this.sSpellRepository = sSpellRepository;
    }

    public Match findById(String matchId) {
        return matchRepository.findById(matchId).orElseThrow(() -> new RuntimeException("Match not found"));
    }

    @Transactional
    public void processAndSaveMatch(String matchId) {
        logger.info(">>> [SERVICE] Recebi para processar o ID: '{}'", matchId);

        if(matchRepository.existsById(matchId)) {
            logger.info("Match with ID " + matchId + " already exists. Skipping.");
            return;
        }

        Match match = dtoToMatch( riotService.getMatchById(matchId) );

        if(match == null){
            logger.warn("Match with ID " + matchId + " not found in Riot API.");
        }

        matchRepository.save(match);

        logger.info("Match with ID " + matchId + " saved successfully with " + match.getParticipants().size() + " participants.");


    }

    private Match dtoToMatch(MatchImportDto dto) {
        Match match = new Match();

        match.setMatchId(dto.matchId());
        match.setGameMode(GameMode.valueOf(dto.gameMode()));
        match.setQueueType(QueueType.fromCode(dto.queueId()));
        match.setGameVersion(dto.gameVersion());
        match.setParticipants(dto.participants()
                .stream()
                .map(this::dtoToParticipant)
                .toList());
        return match;
    }

    private Participant dtoToParticipant(ParticipantImportDto dto){
        Participant participant = new Participant();


        Summoner summoner = summonerService.findOrCreate(summonerService.toEntity( riotService.getSummonerByPuuid(dto.puuid()) ));
        Champion champion = championService.findById(dto.championName());

        List<Rune> runes = mapRunes(dto.perks());
        List<Item> items = mapItems(List.of(dto.item0(), dto.item1(), dto.item2(), dto.item3(), dto.item4(), dto.item5(), dto.item6())
                .stream()
                .filter( id -> id != 0)
                .toList());
        List<SummonerSpell> spells = mapSummonerSpells(dto.summoner1Id(), dto.summoner2Id());

        participant.setSummoner(summoner);
        participant.setChampion(champion);
        participant.setRunes(new HashSet<>(runes));
        participant.setWin(dto.win());
        participant.setKills(dto.kills());
        participant.setDeaths(dto.deaths());
        participant.setAssists(dto.assists());
        participant.setGoldEarned(dto.goldEarned());
        participant.setTotalMinionsKilled(dto.totalMinionsKilled());
        participant.setNeutralMinionsKilled(dto.neutralMinionsKilled());
        participant.setVisionScore(dto.visionScore());
        participant.setKda(dto.kda());
        participant.setRole(dto.role());
        participant.setLane(dto.lane());

        return participant;
    }

    private List<Rune> mapRunes(PerksDto perks) {

        List<Rune> runes = new ArrayList<>();

        for( StyleDto style : perks.styles()){

            for(SelectionDto selection : style.selections()){

                int runeId = selection.perk();

                Rune rune = runeRepository.findById(runeId).orElseThrow(() -> new RuntimeException("Rune not found with id: " + runeId));

                runes.add(rune);
            }

        }

        return runes;
    }

    private List<Item> mapItems(List<Integer> itemIds) {

        List<Item> items = new ArrayList<>();

        for(Integer itemId : itemIds){
            Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found with id: " + itemId));

            items.add(item);
        }

        return items;
    }


    private List<SummonerSpell> mapSummonerSpells(int id1, int id2) {

        List<Integer> spellIds = List.of(id1, id2);

        List<SummonerSpell> spells = new ArrayList<>();

        for(Integer spellId : spellIds){
            SummonerSpell spell = sSpellRepository
                    .findByKey(spellId)
                    .orElseThrow(() -> new RuntimeException("Summoner Spell not found with id: " + spellId));

            spells.add(spell);
        }

        return spells;
    }
}
