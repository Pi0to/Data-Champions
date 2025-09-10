package com.datachampions.Data.Champions.entities.champion;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "champions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Champion {

    @Id
    private String id;
    @Column(name = "champ_key")
    private Integer key;
    private String name;
    private String title;

    @Embedded
    private ChampImage image;

    public Champion() {
    }

    public Champion(String id, Integer key, String name, String title, ChampImage image) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.title = title;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ChampImage getImage() {
        return image;
    }

    public void setImage(ChampImage image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Champion champion = (Champion) o;
        return Objects.equals(id, champion.id) && Objects.equals(key, champion.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, key);
    }
}
