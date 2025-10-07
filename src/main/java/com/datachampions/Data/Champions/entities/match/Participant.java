package com.datachampions.Data.Champions.entities.match;

import com.datachampions.Data.Champions.entities.champion.Champion;
import com.datachampions.Data.Champions.entities.item.Item;
import com.datachampions.Data.Champions.entities.rune.Rune;
import com.datachampions.Data.Champions.entities.summoner.Summoner;
import com.datachampions.Data.Champions.entities.sumonnerSpell.SummonerSpell;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Summoner summoner;

    @ManyToOne
    @JoinColumn(name = "champion_id", referencedColumnName = "id", nullable = false)
    private Champion champion;

    @ManyToMany
    private Set<Rune> runes = new HashSet<>();

    @ManyToMany
    private Set<Item> items = new HashSet<>();

    @ManyToMany
    private Set<SummonerSpell> summonerSpells = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    private boolean win;
    private int kills;
    private int deaths;
    private int assists;
    private int goldEarned;
    private int totalMinionsKilled;
    private int neutralMinionsKilled;
    private int visionScore;
    private double kda;
    private String role;
    private String lane;


    public Participant() {
    }

    public Participant(Long id, Summoner summoner, Champion champion, Set<Rune> runes, Set<Item> items, Set<SummonerSpell> summonerSpells, Match match, boolean win, int kills, int deaths, int assists, int goldEarned, int totalMinionsKilled, int neutralMinionsKilled, int visionScore, double kda, String role, String lane) {
        this.id = id;
        this.summoner = summoner;
        this.champion = champion;
        this.runes = runes;
        this.items = items;
        this.match = match;
        this.win = win;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.goldEarned = goldEarned;
        this.totalMinionsKilled = totalMinionsKilled;
        this.neutralMinionsKilled = neutralMinionsKilled;
        this.visionScore = visionScore;
        this.role = role;
        this.lane = lane;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Summoner getSummoner() {
        return summoner;
    }

    public void setSummoner(Summoner summoner) {
        this.summoner = summoner;
    }

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    public Set<Rune> getRunes() {
        return runes;
    }

    public void setRunes(Set<Rune> runes) {
        this.runes = runes;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Match getMatch() {
        return match;
    }

    public Set<SummonerSpell> getSummonerSpells() {
        return summonerSpells;
    }

    public void setSummonerSpells(Set<SummonerSpell> summonerSpells) {
        this.summonerSpells = summonerSpells;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }

    public int getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public void setTotalMinionsKilled(int totalMinionsKilled) {
        this.totalMinionsKilled = totalMinionsKilled;
    }

    public int getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public void setNeutralMinionsKilled(int neutralMinionsKilled) {
        this.neutralMinionsKilled = neutralMinionsKilled;
    }

    public int getVisionScore() {
        return visionScore;
    }

    public void setVisionScore(int visionScore) {
        this.visionScore = visionScore;
    }

    public double getKda() {
        return kda;
    }

    public void setKda(double kda) {
        this.kda = kda;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }
}
