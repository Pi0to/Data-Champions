package com.datachampions.Data.Champions.entities.match;

import com.datachampions.Data.Champions.enums.GameMode;
import com.datachampions.Data.Champions.enums.QueueType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    private String matchId;

    @Enumerated(EnumType.STRING)
    private GameMode gameMode;
    @Enumerated(EnumType.STRING)
    private QueueType queueType;

    private String gameVersion;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
    private List<Participant> participants;

    public Match() {
    }

    public Match(String matchId, GameMode gameMode, QueueType queueType, String gameVersion, List<Participant> participants) {
        this.matchId = matchId;
        this.gameMode = gameMode;
        this.queueType = queueType;
        this.gameVersion = gameVersion;
        this.participants = participants;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public QueueType getQueueType() {
        return queueType;
    }

    public void setQueueType(QueueType queueType) {
        this.queueType = queueType;
    }


    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }
}
