package com.datachampions.Data.Champions.dto.itemDto;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({

})

public class Stats {

    @JsonIgnore
    private Map<String, Double> additionalProperties = new LinkedHashMap<String, Double>();

    @JsonAnyGetter
    public Map<String, Double> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Double value) {
        this.additionalProperties.put(name, value);
    }

}
