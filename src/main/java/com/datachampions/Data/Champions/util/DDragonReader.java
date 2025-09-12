package com.datachampions.Data.Champions.util;

import com.datachampions.Data.Champions.entities.champion.ChampImage;
import com.datachampions.Data.Champions.entities.champion.Champion;
import com.datachampions.Data.Champions.entities.item.Item;
import com.datachampions.Data.Champions.entities.rune.Rune;
import com.datachampions.Data.Champions.entities.sumonnerSpell.SummonerSpell;
import com.datachampions.Data.Champions.enums.RuneTree;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.datachampions.Data.Champions.dto.championDto.ChampionDataDto;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;

@Component
public class DDragonReader {

    private final ObjectMapper mapper = new ObjectMapper();

    public List<SummonerSpell> parseSpells(File spellFile) throws Exception {
        JsonNode root = mapper.readTree(spellFile);
        JsonNode data = root.get("data");

        List<SummonerSpell> spells = new ArrayList<>();

        for(Iterator<Map.Entry<String, JsonNode>> it = data.fields(); it.hasNext(); ) {

            JsonNode node = it.next().getValue();
            SummonerSpell spell = mapper.treeToValue(node, SummonerSpell.class);

            spell.setDescription(cleanText(spell.getDescription()));

            spells.add(spell);
        }
        return spells;
    }



    public List<Rune> parseRunes(File runeFile) throws Exception {
        JsonNode root = mapper.readTree(runeFile);

        if (!root.isArray() || root.size() == 0) {
            System.out.println("Runes array is empty!");
            return new ArrayList<>();
        }

        List<Rune> runes = new ArrayList<>();

        for (JsonNode treeNode : root) { // cada estilo de runa
            int treeId = treeNode.get("id").asInt();
            RuneTree treeEnum = Arrays.stream(RuneTree.values())
                    .filter(t -> t.getId() == treeId)
                    .findFirst()
                    .orElse(null); // ou lance exceção se preferir

            JsonNode slotsNode = treeNode.get("slots");
            if (slotsNode != null && slotsNode.isArray()) {
                for (JsonNode slotNode : slotsNode) {
                    JsonNode runesNode = slotNode.get("runes");
                    if (runesNode != null && runesNode.isArray()) {
                        for (JsonNode runeNode : runesNode) {
                            Rune rune = mapper.treeToValue(runeNode, Rune.class);

                            // preencher o enum tree
                            rune.setRuneTree(treeEnum);

                            // limpar descrições
                            rune.setShortDesc(cleanText(rune.getShortDesc()));
                            rune.setLongDesc(cleanText(rune.getLongDesc()));

                            runes.add(rune);
                        }
                    }
                }
            }
        }

        return runes;
    }

    public List<Item> parseItems(File itemFile) throws Exception {
        JsonNode root = mapper.readTree(itemFile);
        JsonNode data = root.get("data");

        if (data == null || data.isEmpty()) {
            System.out.println("Data is empty!");;
        }

        List<Item> items = new ArrayList<>();

        for (Iterator<Map.Entry<String, JsonNode>> it = data.fields(); it.hasNext(); ) {

            Map.Entry<String, JsonNode> entry = it.next();

            Item item = mapper.treeToValue(entry.getValue(), Item.class);

            item.setKey(Integer.valueOf(entry.getKey()));
            item.setSellGold(entry.getValue().get("gold").get("sell").asInt());
            item.setTotalGold(entry.getValue().get("gold").get("total").asInt());

            item.setDescription(cleanText(item.getDescription()));

            items.add(item);
        }
        return items;
    }

    public List<Champion> parseChampions(File championFile) throws Exception {
        JsonNode root = mapper.readTree(championFile);
        JsonNode data = root.get("data");

        List<Champion> champs = new ArrayList<>();

        for(Iterator<Map.Entry<String, JsonNode>> it = data.fields(); it.hasNext(); ) {

            JsonNode node = it.next().getValue();
            Champion champ = mapper.treeToValue(node, Champion.class);

            champs.add(champ);
        }
        return champs;
    }
    
    private String cleanText(String desc) {
        return desc.replaceAll("<br\\s*/?>", "\n")
                .replaceAll("<.*?>", "")
                .replaceAll("<[^>]+>", "")
                .replaceAll("<(/?magicDamage)>", "")
                .replaceAll("<(/?trueDamage)>", "")
                .replaceAll("<(/?status)>", "")
                .replaceAll("<(/?attention)>", "");

    }


}
