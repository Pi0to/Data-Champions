
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
    "description",
    "colloq",
    "plaintext",
    "from",
    "into",
    "image",
    "gold",
    "tags",
    "maps",
    "stats"
})

public class Item {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("colloq")
    private String colloq;
    @JsonProperty("plaintext")
    private String plaintext;
    @JsonProperty("from")
    private List<String> from;
    @JsonProperty("into")
    private List<String> into;
    @JsonProperty("image")
    private com.dataChampions.Data.Champions.dto.itemDto.Image image;
    @JsonProperty("gold")
    private Gold gold;
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("maps")
    private Maps__1 maps;
    @JsonProperty("stats")
    private Stats stats;
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

    @JsonProperty("image")
    public com.dataChampions.Data.Champions.dto.itemDto.Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(com.dataChampions.Data.Champions.dto.itemDto.Image image) {
        this.image = image;
    }

    @JsonProperty("gold")
    public Gold getGold() {
        return gold;
    }

    @JsonProperty("gold")
    public void setGold(Gold gold) {
        this.gold = gold;
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
    public Maps__1 getMaps() {
        return maps;
    }

    @JsonProperty("maps")
    public void setMaps(Maps__1 maps) {
        this.maps = maps;
    }

    @JsonProperty("stats")
    public Stats getStats() {
        return stats;
    }

    @JsonProperty("stats")
    public void setStats(Stats stats) {
        this.stats = stats;
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
