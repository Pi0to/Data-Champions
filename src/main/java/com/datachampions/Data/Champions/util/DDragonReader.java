package com.datachampions.Data.Champions.util;

import com.datachampions.Data.Champions.entities.champion.ChampImage;
import com.datachampions.Data.Champions.entities.champion.Champion;
import com.datachampions.Data.Champions.entities.item.Item;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.datachampions.Data.Champions.dto.championDto.ChampionDataDto;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.*;

@Component
public class DDragonReader {

    private final ObjectMapper mapper = new ObjectMapper();

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


}
