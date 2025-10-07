package com.datachampions.Data.Champions.dto.importDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record StyleDto(List<SelectionDto> selections) {
}
