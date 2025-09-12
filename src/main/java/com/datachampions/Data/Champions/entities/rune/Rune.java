package com.datachampions.Data.Champions.entities.rune;

import com.datachampions.Data.Champions.entities.item.ItemImage;
import com.datachampions.Data.Champions.enums.RuneTree;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "runes_table")
public class Rune {

    @Id
    private Integer id;
    @Column(name = "rune_key")
    private String key;
    private String icon;
    private String name;
    @Lob
    private String shortDesc;
    @Lob
    private String longDesc;
    @Enumerated(EnumType.STRING)
    private RuneTree runeTree;

    @Embedded
    private ItemImage img;

    public Rune() {
    }

    public Rune(Integer id, String key, String icon, String name, String shortDesc, String longDesc, RuneTree runeTree, ItemImage img) {
        this.id = id;
        this.key = key;
        this.icon = icon;
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.runeTree = runeTree;
        this.img = img;
    }

    public ItemImage getImg() {
        return img;
    }

    public void setImg(ItemImage img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public RuneTree getRuneTree() {
        return runeTree;
    }

    public void setRuneTree(RuneTree runeTree) {
        this.runeTree = runeTree;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rune rune = (Rune) o;
        return Objects.equals(id, rune.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
