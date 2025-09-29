package com.datachampions.Data.Champions.entities.summoner;

import com.datachampions.Data.Champions.entities.match.Participant;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Summoner {

    @Id
    private String puuid;
    private String gameName;
    private String tagLine;

    @OneToMany(mappedBy = "summoner")
    private List<Participant> participantions;

    public Summoner() {
    }

    public Summoner(String puuid, String gameName, String tagLine, List<Participant> participantions) {
        this.puuid = puuid;
        this.gameName = gameName;
        this.tagLine = tagLine;
        this.participantions = participantions;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public List<Participant> getParticipantions() {
        return participantions;
    }

    public void setParticipantions(List<Participant> participantions) {
        this.participantions = participantions;
    }
}
