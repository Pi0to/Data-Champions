package com.datachampions.Data.Champions.dto.itemDto;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "isrune",
    "tier",
    "type"
})

public class Rune {

    @JsonProperty("isrune")
    private Boolean isrune;
    @JsonProperty("tier")
    private Integer tier;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("isrune")
    public Boolean getIsrune() {
        return isrune;
    }

    @JsonProperty("isrune")
    public void setIsrune(Boolean isrune) {
        this.isrune = isrune;
    }

    @JsonProperty("tier")
    public Integer getTier() {
        return tier;
    }

    @JsonProperty("tier")
    public void setTier(Integer tier) {
        this.tier = tier;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
