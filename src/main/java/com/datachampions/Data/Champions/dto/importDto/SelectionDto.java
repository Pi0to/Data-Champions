package com.datachampions.Data.Champions.dto.importDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SelectionDto(int perk) {
}
