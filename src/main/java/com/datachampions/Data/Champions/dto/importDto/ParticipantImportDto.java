package com.datachampions.Data.Champions.dto.importDto;

import com.datachampions.Data.Champions.entities.champion.Champion;
import com.datachampions.Data.Champions.entities.item.Item;
import com.datachampions.Data.Champions.entities.match.Participant;
import com.datachampions.Data.Champions.entities.rune.Rune;
import com.datachampions.Data.Champions.entities.summoner.Summoner;
import com.datachampions.Data.Champions.entities.sumonnerSpell.SummonerSpell;
import com.datachampions.Data.Champions.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public record ParticipantImportDto(String puuid, String championName, List<Integer> runes, List<Integer> items, List<Integer> summonerSpells, boolean win,
                                   int kills, int deaths, int assists, int goldEarned, int totalMinionsKilled, int neutralMinionsKilled, int visionScore, float kda, String role, String lane) {

    @Autowired
    private static SummonerRepository summonerRepository;
    @Autowired
    private static ChampionRepository championRepository;
    @Autowired
    private static RuneRepository runeRepository;
    @Autowired
    private static ItemRepository itemRepository;
    @Autowired
    private static SSpellRepository sSpellRepository;

    public Participant toParticipant(){
        Participant participant = new Participant();


        Summoner summoner = summonerRepository.findById(puuid).orElseThrow(() -> new RuntimeException("Summoner not found with puuid: " + puuid));
        Champion champion = championRepository.findByName(championName).orElseThrow(() -> new RuntimeException("Champion not found with name: " + championName));

        participant.setSummoner(summoner);
        participant.setChampion(champion);
        participant.setRunes(mapRunes(runes));
        participant.setItems(mapItems(items));
        participant.setSummonerSpells(mapSummonerSpells(summonerSpells));
        participant.setWin(win);
        participant.setKills(kills);
        participant.setDeaths(deaths);
        participant.setAssists(assists);
        participant.setGoldEarned(goldEarned);
        participant.setTotalMinionsKilled(totalMinionsKilled);
        participant.setNeutralMinionsKilled(neutralMinionsKilled);
        participant.setVisionScore(visionScore);
        participant.setKda(kda);
        participant.setRole(role);
        participant.setLane(lane);

        return participant;
    }

    private List<Rune> mapRunes(List<Integer> runeIds) {

        List<Rune> runes = new ArrayList<>();

        for(Integer runeId : runeIds){
            Rune rune = runeRepository.findById(runeId).orElseThrow(() -> new RuntimeException("Rune not found with id: " + runeId));

            runes.add(rune);
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

    private List<SummonerSpell> mapSummonerSpells(List<Integer> spellIds) {

        List<SummonerSpell> spells = new ArrayList<>();

        for(Integer spellId : spellIds){
            SummonerSpell spell = sSpellRepository.findById(spellId.toString()).orElseThrow(() -> new RuntimeException("Summoner Spell not found with id: " + spellId));

            spells.add(spell);
        }

        return spells;
    }
}
