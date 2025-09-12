package com.datachampions.Data.Champions.services;

import com.datachampions.Data.Champions.entities.sumonnerSpell.SummonerSpell;
import com.datachampions.Data.Champions.repositories.SSpellRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SSpellService {

    private final SSpellRepository sSpellRepository;

    public SSpellService(SSpellRepository sSpellRepository) {
        this.sSpellRepository = sSpellRepository;
    }

    public void saveAll(List<SummonerSpell> spells) {
        sSpellRepository.saveAll(spells);
    }
}
