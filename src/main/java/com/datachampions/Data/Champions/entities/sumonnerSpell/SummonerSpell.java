package com.datachampions.Data.Champions.entities.sumonnerSpell;

import com.datachampions.Data.Champions.entities.champion.ChampImage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "summoner_spells_table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerSpell {

    @Id
    private String id;
    private String name;
    private String description;

    @Column(name = "spell_key")
    private Integer key;

    @Embedded
    private ChampImage img;

    public SummonerSpell() {
    }

    public SummonerSpell(String id, String name, String description, Integer key, ChampImage img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.key = key;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public ChampImage getImg() {
        return img;
    }

    public void setImg(ChampImage img) {
        this.img = img;
    }
}
