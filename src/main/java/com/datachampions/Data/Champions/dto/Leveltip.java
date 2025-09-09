
package com.datachampions.Data.Champions.dto;

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
    "label",
    "effect"
})

public class Leveltip {

    @JsonProperty("label")
    private List<String> label;
    @JsonProperty("effect")
    private List<String> effect;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("label")
    public List<String> getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(List<String> label) {
        this.label = label;
    }

    @JsonProperty("effect")
    public List<String> getEffect() {
        return effect;
    }

    @JsonProperty("effect")
    public void setEffect(List<String> effect) {
        this.effect = effect;
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
