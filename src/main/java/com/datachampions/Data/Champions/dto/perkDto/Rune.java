
package com.datachampions.Data.Champions.dto.perkDto;

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
    "id",
    "key",
    "icon",
    "name",
    "shortDesc",
    "longDesc"
})

public class Rune {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    private String key;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("icon")
    private String icon;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shortDesc")
    private String shortDesc;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("longDesc")
    private String longDesc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shortDesc")
    public String getShortDesc() {
        return shortDesc;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("shortDesc")
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("longDesc")
    public String getLongDesc() {
        return longDesc;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("longDesc")
    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
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
