package com.datachampions.Data.Champions.config;

import com.datachampions.Data.Champions.entities.champion.Champion;
import com.datachampions.Data.Champions.entities.item.Item;
import com.datachampions.Data.Champions.entities.rune.Rune;
import com.datachampions.Data.Champions.entities.sumonnerSpell.SummonerSpell;
import com.datachampions.Data.Champions.services.ChampionService;
import com.datachampions.Data.Champions.services.ItemService;
import com.datachampions.Data.Champions.services.RuneService;
import com.datachampions.Data.Champions.services.SSpellService;
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
    private final RuneService runeService;
    private final SSpellService sSpellService;

    public DDragonBootstrap(ChampionService championService, DDragonReader reader, ItemService itemService, RuneService runeService, SSpellService sSpellService) {
        this.championService = championService;
        this.reader = reader;
        this.itemService = itemService;
        this.runeService = runeService;
        this.sSpellService = sSpellService;
    }

    @PostConstruct
    public void init() throws Exception {


        System.out.println("Loading champions from DDragon...");

        File champFile = new ClassPathResource("ddragon/15.17.1/data/pt_BR/championFull.json").getFile();

        List<Champion> champions = reader.parseChampions(champFile);

        championService.saveAll(champions);

        System.out.println("Champions successfully loaded: " + champions.size());



        System.out.println("\nLoading items from DDragon...");

        File itemFile = new ClassPathResource("ddragon/15.17.1/data/pt_BR/item.json").getFile();

        List<Item> items = reader.parseItems(itemFile);

        itemService.saveAll(items);

        System.out.println("Items successfully loaded: " + items.size());


        System.out.println("Loading runes from DDragon...");

        File runeFile = new ClassPathResource("ddragon/15.17.1/data/pt_BR/runesReforged.json").getFile();

        List<Rune> runes = reader.parseRunes(runeFile);

        runeService.saveAll(runes);

        System.out.println("Items successfully loaded: " + items.size());


        System.out.println("Loading spells from DDragon...");

        File spellFile = new ClassPathResource("ddragon/15.17.1/data/pt_BR/summoner.json").getFile();

        List<SummonerSpell> spells = reader.parseSpells(spellFile);

        sSpellService.saveAll(spells);

        System.out.println("Spells successfully loaded: " + spells.size());

    }

}
