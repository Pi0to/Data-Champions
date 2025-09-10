package com.datachampions.Data.Champions.entities.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "items_table")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    @Id
    @Column(name = "item_key")
    private Integer key;
    private String name;

    @Lob
    private String description;
    @Lob
    private String plaintext;
    private Integer totalGold;
    private Integer sellGold;

    @ElementCollection
    @CollectionTable(name = "item_maps", joinColumns = @JoinColumn(name = "item_id"))
    @MapKeyColumn(name = "map_key")
    @Column(name = "map_value")
    Map<Integer, Boolean> maps = new LinkedHashMap<Integer, Boolean>();

    public Item() {
    }

    public Item(Integer key, String name, String description, String plaintext, Integer totalGold, Integer sellGold, Map<Integer, Boolean> maps) {
        this.key = key;
        this.name = name;
        this.description = description;
        this.plaintext = plaintext;
        this.totalGold = totalGold;
        this.sellGold = sellGold;
        this.maps = maps;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public Integer getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(Integer totalGold) {
        this.totalGold = totalGold;
    }

    public Integer getSellGold() {
        return sellGold;
    }

    public void setSellGold(Integer sellGold) {
        this.sellGold = sellGold;
    }

    public Map<Integer, Boolean> getMaps() {
        return maps;
    }

    public void setMaps(Map<Integer, Boolean> maps) {
        this.maps = maps;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(key, item.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public String toString() {
        return "item{" +
                "key=" + key +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", plaintext='" + plaintext + '\'' +
                ", totalGold=" + totalGold +
                ", sellGold=" + sellGold +
                ", maps=" + maps +
                '}';
    }
}

