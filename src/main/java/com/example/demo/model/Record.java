package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Record {
    @Id
    @NotNull
    private Long id;
    @NotNull
    private long playerId;
    @NotNull
    private long matchId;
    @NotNull
    @Min(0)
    @Max(89)
    private int fromMin;
    @Pattern(regexp = "^(NULL|[1-9]$|[1-8][0-9]$|90)$")
    private String toMin;

    public Record() {
    }

    public Record(Long id, long playerId, long matchId, int fromMin, String toMin) {
        this.id = id;
        this.playerId = playerId;
        this.matchId = matchId;
        this.fromMin = fromMin;
        this.toMin = toMin;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
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
