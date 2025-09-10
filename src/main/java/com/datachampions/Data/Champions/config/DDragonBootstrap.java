package com.datachampions.Data.Champions.config;

import com.datachampions.Data.Champions.entities.champion.Champion;
import com.datachampions.Data.Champions.entities.item.Item;
import com.datachampions.Data.Champions.services.ChampionService;
import com.datachampions.Data.Champions.services.ItemService;
import com.datachampions.Data.Champions.util.DDragonReader;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class DDragonBootstrap {

    private final ChampionService championService;
    private final DDragonReader reader;
    private final ItemService itemService;

    public DDragonBootstrap(ChampionService championService, DDragonReader reader, ItemService itemService) {
        this.championService = championService;
        this.reader = reader;
        this.itemService = itemService;
    }

    @PostConstruct
    public void init() throws Exception {

        System.out.println("Loading champions from DDragon...");

        File champFile = new ClassPathResource("ddragon/15.17.1/data/pt_BR/championFull.json").getFile();

        List<Champion> champions = reader.parseChampions(champFile);

        //championService.saveAll(champions);

        System.out.println("Champions successfully loaded: " + champions.size());



        System.out.println("\nLoading items from DDragon...");

        File itemFile = new ClassPathResource("ddragon/15.17.1/data/pt_BR/item.json").getFile();

        List<Item> items = reader.parseItems(itemFile);

        itemService.saveAll(items);

        System.out.println("Items successfully loaded: " + items.size());

    }

}
