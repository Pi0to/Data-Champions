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
    "base",
    "total",
    "sell",
    "purchasable"
})

public class Gold {

    @JsonProperty("base")
    private Integer base;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("sell")
    private Integer sell;
    @JsonProperty("purchasable")
    private Boolean purchasable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("base")
    public Integer getBase() {
        return base;
    }

    @JsonProperty("base")
    public void setBase(Integer base) {
        this.base = base;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("sell")
    public Integer getSell() {
        return sell;
    }

    @JsonProperty("sell")
    public void setSell(Integer sell) {
        this.sell = sell;
    }

    @JsonProperty("purchasable")
    public Boolean getPurchasable() {
        return purchasable;
    }

    @JsonProperty("purchasable")
    public void setPurchasable(Boolean purchasable) {
        this.purchasable = purchasable;
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
