package com.datachampions.Data.Champions.services;

import com.datachampions.Data.Champions.entities.rune.Rune;
import com.datachampions.Data.Champions.repositories.RuneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuneService {

    private final RuneRepository runeRepository;

    public RuneService(RuneRepository runeRepository) {
        this.runeRepository = runeRepository;
    }

    public void saveAll(List<Rune> runes) {
        runeRepository.saveAll(runes);
    }
}
