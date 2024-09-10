package io.github.ndimovt.model;

import jakarta.persistence.*;

@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player playerId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    private Match matchId;
    private int fromMin;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
