package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Record {
    @Id
    @NotNull
    private Long id;
    @OneToOne
    @NotNull
    private Player playerId;
    @OneToOne
    @NotNull
    private Match matchId;
    @NotNull
    @Min(0)
    @Max(89)
    private int fromMin;
    @Pattern(regexp = "^(NULL|[1-9]$|[1-8][0-9]$|90)$")
    private String toMin;

    public Record() {
    }

    public Record(Long id, Player playerId, Match matchId, int fromMin, String toMin) {
        this.id = id;
        this.playerId = playerId;
        this.matchId = matchId;
        this.fromMin = fromMin;
        this.toMin = toMin;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public Match getMatchId() {
        return matchId;
    }

    public void setMatchId(Match matchId) {
        this.matchId = matchId;
    }

    public int getFromMin() {
        return fromMin;
    }

    public void setFromMin(int fromMin) {
        this.fromMin = fromMin;
    }

    public String getToMin() {
        return toMin;
    }

    public void setToMin(String toMin) {
        this.toMin = toMin;
    }
}
