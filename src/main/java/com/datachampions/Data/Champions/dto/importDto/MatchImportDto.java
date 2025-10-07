package com.datachampions.Data.Champions.dto.importDto;

import com.datachampions.Data.Champions.entities.match.Match;
import com.datachampions.Data.Champions.entities.match.Participant;
import com.datachampions.Data.Champions.enums.GameMode;
import com.datachampions.Data.Champions.enums.QueueType;

import java.util.List;

public record MatchImportDto(String matchId, String gameMode, Integer queueId, String gameVersion, List<ParticipantImportDto> participants) {



}
