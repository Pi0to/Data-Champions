package com.datachampions.Data.Champions.util;

import com.datachampions.Data.Champions.entities.ChampImage;
import com.datachampions.Data.Champions.entities.Champion;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.datachampions.Data.Champions.dto.ChampionDataDto;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
public class DDragonReader {

    private final ObjectMapper mapper = new ObjectMapper();

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

    private Champion dtoToChampion(ChampionDataDto dto) {

        if(dto == null) System.out.println("DTO is null");
        else if (dto.getAnyChampion() == null) System.out.println("DTO data champ is null");


        Champion champ = new Champion();

        ChampImage image = getChampImage(dto);


        champ.setId(dto.getAnyChampion().getId());
        champ.setKey(Integer.parseInt(dto.getAnyChampion().getKey()));
        champ.setName(dto.getAnyChampion().getName());
        champ.setTitle(dto.getAnyChampion().getTitle());
        champ.setImage(image);

        return champ;
    }

    private static ChampImage getChampImage(ChampionDataDto dto) {
        ChampImage image = new ChampImage();

        image.setFull(dto.getAnyChampion().getImage().getFull());
        image.setSprite(dto.getAnyChampion().getImage().getSprite());
        image.setGroup(dto.getAnyChampion().getImage().getGroup());
        image.setX(dto.getAnyChampion().getImage().getX());
        image.setY(dto.getAnyChampion().getImage().getY());
        image.setW(dto.getAnyChampion().getImage().getW());
        image.setH(dto.getAnyChampion().getImage().getH());
        return image;
    }
}
