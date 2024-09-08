package io.github.ndimovt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long playerId;
    private long matchId;
    private int fromMin;
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
