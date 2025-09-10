
package com.datachampions.Data.Champions.dto.championDto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "key",
    "name",
    "title",
    "image",
    "skins",
    "lore",
    "blurb",
    "allytips",
    "enemytips",
    "tags",
    "partype",
    "info",
    "stats",
    "spells",
    "passive",
    "recommended"
})

public class Champion {

    @JsonProperty("id")
    private String id;
    @JsonProperty("key")
    private String key;
    @JsonProperty("name")
    private String name;
    @JsonProperty("title")
    private String title;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("skins")
    private List<Skin> skins;
    @JsonProperty("lore")
    private String lore;
    @JsonProperty("blurb")
    private String blurb;
    @JsonProperty("allytips")
    private List<String> allytips;
    @JsonProperty("enemytips")
    private List<String> enemytips;
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("partype")
    private String partype;
    @JsonProperty("info")
    private Info info;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("spells")
    private List<Spell> spells;
    @JsonProperty("passive")
    private Passive passive;
    @JsonProperty("recommended")
    private List<Object> recommended;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    @JsonProperty("skins")
    public List<Skin> getSkins() {
        return skins;
    }

    @JsonProperty("skins")
    public void setSkins(List<Skin> skins) {
        this.skins = skins;
    }

    @JsonProperty("lore")
    public String getLore() {
        return lore;
    }

    @JsonProperty("lore")
    public void setLore(String lore) {
        this.lore = lore;
    }

    @JsonProperty("blurb")
    public String getBlurb() {
        return blurb;
    }

    @JsonProperty("blurb")
    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    @JsonProperty("allytips")
    public List<String> getAllytips() {
        return allytips;
    }

    @JsonProperty("allytips")
    public void setAllytips(List<String> allytips) {
        this.allytips = allytips;
    }

    @JsonProperty("enemytips")
    public List<String> getEnemytips() {
        return enemytips;
    }

    @JsonProperty("enemytips")
    public void setEnemytips(List<String> enemytips) {
        this.enemytips = enemytips;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("partype")
    public String getPartype() {
        return partype;
    }

    @JsonProperty("partype")
    public void setPartype(String partype) {
        this.partype = partype;
    }

    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("spells")
    public List<Spell> getSpells() {
        return spells;
    }

    @JsonProperty("spells")
    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    @JsonProperty("passive")
    public Passive getPassive() {
        return passive;
    }

    @JsonProperty("passive")
    public void setPassive(Passive passive) {
        this.passive = passive;
    }

    @JsonProperty("recommended")
    public List<Object> getRecommended() {
        return recommended;
    }

    @JsonProperty("recommended")
    public void setRecommended(List<Object> recommended) {
        this.recommended = recommended;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
