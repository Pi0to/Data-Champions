
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
    "name",
    "description",
    "tooltip",
    "leveltip",
    "maxrank",
    "cooldown",
    "cooldownBurn",
    "cost",
    "costBurn",
    "datavalues",
    "effect",
    "effectBurn",
    "vars",
    "costType",
    "maxammo",
    "range",
    "rangeBurn",
    "image",
    "resource"
})

public class Spell {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("tooltip")
    private String tooltip;
    @JsonProperty("leveltip")
    private Leveltip leveltip;
    @JsonProperty("maxrank")
    private Integer maxrank;
    @JsonProperty("cooldown")
    private List<Integer> cooldown;
    @JsonProperty("cooldownBurn")
    private String cooldownBurn;
    @JsonProperty("cost")
    private List<Integer> cost;
    @JsonProperty("costBurn")
    private String costBurn;
    @JsonProperty("datavalues")
    private Datavalues datavalues;
    @JsonProperty("effect")
    private List<Object> effect;
    @JsonProperty("effectBurn")
    private List<Object> effectBurn;
    @JsonProperty("vars")
    private List<Object> vars;
    @JsonProperty("costType")
    private String costType;
    @JsonProperty("maxammo")
    private String maxammo;
    @JsonProperty("range")
    private List<Integer> range;
    @JsonProperty("rangeBurn")
    private String rangeBurn;
    @JsonProperty("image")
    private Image__1 image;
    @JsonProperty("resource")
    private String resource;
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

    @JsonProperty("tooltip")
    public String getTooltip() {
        return tooltip;
    }

    @JsonProperty("tooltip")
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    @JsonProperty("leveltip")
    public Leveltip getLeveltip() {
        return leveltip;
    }

    @JsonProperty("leveltip")
    public void setLeveltip(Leveltip leveltip) {
        this.leveltip = leveltip;
    }

    @JsonProperty("maxrank")
    public Integer getMaxrank() {
        return maxrank;
    }

    @JsonProperty("maxrank")
    public void setMaxrank(Integer maxrank) {
        this.maxrank = maxrank;
    }

    @JsonProperty("cooldown")
    public List<Integer> getCooldown() {
        return cooldown;
    }

    @JsonProperty("cooldown")
    public void setCooldown(List<Integer> cooldown) {
        this.cooldown = cooldown;
    }

    @JsonProperty("cooldownBurn")
    public String getCooldownBurn() {
        return cooldownBurn;
    }

    @JsonProperty("cooldownBurn")
    public void setCooldownBurn(String cooldownBurn) {
        this.cooldownBurn = cooldownBurn;
    }

    @JsonProperty("cost")
    public List<Integer> getCost() {
        return cost;
    }

    @JsonProperty("cost")
    public void setCost(List<Integer> cost) {
        this.cost = cost;
    }

    @JsonProperty("costBurn")
    public String getCostBurn() {
        return costBurn;
    }

    @JsonProperty("costBurn")
    public void setCostBurn(String costBurn) {
        this.costBurn = costBurn;
    }

    @JsonProperty("datavalues")
    public Datavalues getDatavalues() {
        return datavalues;
    }

    @JsonProperty("datavalues")
    public void setDatavalues(Datavalues datavalues) {
        this.datavalues = datavalues;
    }

    @JsonProperty("effect")
    public List<Object> getEffect() {
        return effect;
    }

    @JsonProperty("effect")
    public void setEffect(List<Object> effect) {
        this.effect = effect;
    }

    @JsonProperty("effectBurn")
    public List<Object> getEffectBurn() {
        return effectBurn;
    }

    @JsonProperty("effectBurn")
    public void setEffectBurn(List<Object> effectBurn) {
        this.effectBurn = effectBurn;
    }

    @JsonProperty("vars")
    public List<Object> getVars() {
        return vars;
    }

    @JsonProperty("vars")
    public void setVars(List<Object> vars) {
        this.vars = vars;
    }

    @JsonProperty("costType")
    public String getCostType() {
        return costType;
    }

    @JsonProperty("costType")
    public void setCostType(String costType) {
        this.costType = costType;
    }

    @JsonProperty("maxammo")
    public String getMaxammo() {
        return maxammo;
    }

    @JsonProperty("maxammo")
    public void setMaxammo(String maxammo) {
        this.maxammo = maxammo;
    }

    @JsonProperty("range")
    public List<Integer> getRange() {
        return range;
    }

    @JsonProperty("range")
    public void setRange(List<Integer> range) {
        this.range = range;
    }

    @JsonProperty("rangeBurn")
    public String getRangeBurn() {
        return rangeBurn;
    }

    @JsonProperty("rangeBurn")
    public void setRangeBurn(String rangeBurn) {
        this.rangeBurn = rangeBurn;
    }

    @JsonProperty("image")
    public Image__1 getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image__1 image) {
        this.image = image;
    }

    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
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
