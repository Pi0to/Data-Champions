
package com.datachampions.Data.Champions.dto.itemDto;

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
    "name",
    "rune",
    "gold",
    "group",
    "description",
    "colloq",
    "plaintext",
    "consumed",
    "stacks",
    "depth",
    "consumeOnFull",
    "from",
    "into",
    "specialRecipe",
    "inStore",
    "hideFromAll",
    "requiredChampion",
    "requiredAlly",
    "stats",
    "tags",
    "maps"
})

public class Basic {

    @JsonProperty("name")
    private String name;
    @JsonProperty("rune")
    private Rune rune;
    @JsonProperty("gold")
    private Gold gold;
    @JsonProperty("group")
    private String group;
    @JsonProperty("description")
    private String description;
    @JsonProperty("colloq")
    private String colloq;
    @JsonProperty("plaintext")
    private String plaintext;
    @JsonProperty("consumed")
    private Boolean consumed;
    @JsonProperty("stacks")
    private Integer stacks;
    @JsonProperty("depth")
    private Integer depth;
    @JsonProperty("consumeOnFull")
    private Boolean consumeOnFull;
    @JsonProperty("from")
    private List<String> from;
    @JsonProperty("into")
    private List<String> into;
    @JsonProperty("specialRecipe")
    private Integer specialRecipe;
    @JsonProperty("inStore")
    private Boolean inStore;
    @JsonProperty("hideFromAll")
    private Boolean hideFromAll;
    @JsonProperty("requiredChampion")
    private String requiredChampion;
    @JsonProperty("requiredAlly")
    private String requiredAlly;
    @JsonProperty("stats")
    private Stats stats;
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("maps")
    private Maps maps;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("rune")
    public Rune getRune() {
        return rune;
    }

    @JsonProperty("rune")
    public void setRune(Rune rune) {
        this.rune = rune;
    }

    @JsonProperty("gold")
    public Gold getGold() {
        return gold;
    }

    @JsonProperty("gold")
    public void setGold(Gold gold) {
        this.gold = gold;
    }

    @JsonProperty("group")
    public String getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(String group) {
        this.group = group;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("colloq")
    public String getColloq() {
        return colloq;
    }

    @JsonProperty("colloq")
    public void setColloq(String colloq) {
        this.colloq = colloq;
    }

    @JsonProperty("plaintext")
    public String getPlaintext() {
        return plaintext;
    }

    @JsonProperty("plaintext")
    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    @JsonProperty("consumed")
    public Boolean getConsumed() {
        return consumed;
    }

    @JsonProperty("consumed")
    public void setConsumed(Boolean consumed) {
        this.consumed = consumed;
    }

    @JsonProperty("stacks")
    public Integer getStacks() {
        return stacks;
    }

    @JsonProperty("stacks")
    public void setStacks(Integer stacks) {
        this.stacks = stacks;
    }

    @JsonProperty("depth")
    public Integer getDepth() {
        return depth;
    }

    @JsonProperty("depth")
    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    @JsonProperty("consumeOnFull")
    public Boolean getConsumeOnFull() {
        return consumeOnFull;
    }

    @JsonProperty("consumeOnFull")
    public void setConsumeOnFull(Boolean consumeOnFull) {
        this.consumeOnFull = consumeOnFull;
    }

    @JsonProperty("from")
    public List<String> getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(List<String> from) {
        this.from = from;
    }

    @JsonProperty("into")
    public List<String> getInto() {
        return into;
    }

    @JsonProperty("into")
    public void setInto(List<String> into) {
        this.into = into;
    }

    @JsonProperty("specialRecipe")
    public Integer getSpecialRecipe() {
        return specialRecipe;
    }

    @JsonProperty("specialRecipe")
    public void setSpecialRecipe(Integer specialRecipe) {
        this.specialRecipe = specialRecipe;
    }

    @JsonProperty("inStore")
    public Boolean getInStore() {
        return inStore;
    }

    @JsonProperty("inStore")
    public void setInStore(Boolean inStore) {
        this.inStore = inStore;
    }

    @JsonProperty("hideFromAll")
    public Boolean getHideFromAll() {
        return hideFromAll;
    }

    @JsonProperty("hideFromAll")
    public void setHideFromAll(Boolean hideFromAll) {
        this.hideFromAll = hideFromAll;
    }

    @JsonProperty("requiredChampion")
    public String getRequiredChampion() {
        return requiredChampion;
    }

    @JsonProperty("requiredChampion")
    public void setRequiredChampion(String requiredChampion) {
        this.requiredChampion = requiredChampion;
    }

    @JsonProperty("requiredAlly")
    public String getRequiredAlly() {
        return requiredAlly;
    }

    @JsonProperty("requiredAlly")
    public void setRequiredAlly(String requiredAlly) {
        this.requiredAlly = requiredAlly;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("maps")
    public Maps getMaps() {
        return maps;
    }

    @JsonProperty("maps")
    public void setMaps(Maps maps) {
        this.maps = maps;
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
