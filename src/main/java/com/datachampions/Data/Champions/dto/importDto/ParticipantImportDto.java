package com.datachampions.Data.Champions.dto.importDto;

import com.datachampions.Data.Champions.entities.champion.Champion;
import com.datachampions.Data.Champions.entities.item.Item;
import com.datachampions.Data.Champions.entities.match.Participant;
import com.datachampions.Data.Champions.entities.rune.Rune;
import com.datachampions.Data.Champions.entities.summoner.Summoner;
import com.datachampions.Data.Champions.entities.sumonnerSpell.SummonerSpell;
import com.datachampions.Data.Champions.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public record ParticipantImportDto(String puuid,
                                   String championName,
                                   PerksDto perks,
                                   int item0,
                                   int item1,
                                   int item2,
                                   int item3,
                                   int item4,
                                   int item5,
                                   int item6,
                                   int summoner1Id,
                                   int summoner2Id,
                                   boolean win,
                                   int kills,
                                   int deaths,
                                   int assists,
                                   int goldEarned,
                                   int totalMinionsKilled,
                                   int neutralMinionsKilled,
                                   int visionScore,
                                   float kda,
                                   String role,
                                   String lane) {

}
