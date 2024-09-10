package io.github.ndimovt.model;

import jakarta.persistence.*;

/**
 * Record class
 */
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

    /**
     * Instantiating Record
     */
    public Record() {
    }

    /**
     * Instantiating Record
     * @param id Long value
     * @param playerId Player object
     * @param matchId Match object
     * @param fromMin Integer value
     * @param toMin String object
     */
    public Record(Long id, Player playerId, Match matchId, int fromMin, String toMin) {
        this.id = id;
        this.playerId = playerId;
        this.matchId = matchId;
        this.fromMin = fromMin;
        this.toMin = toMin;
    }

    /**
     * Return id
     * @return Long value
     */
    public Long getId() {
        return id;
    }

    /**
     * Update id
     * @param id Long value
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Return playerId
     * @return Player object
     */
    public Player getPlayerId() {
        return playerId;
    }

    /**
     * Update playerId
     * @param playerId Player object
     */
    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    /**
     * Return matchId
     * @return Match object
     */
    public Match getMatchId() {
        return matchId;
    }

    /**
     * Update matchId
     * @param matchId Match object
     */
    public void setMatchId(Match matchId) {
        this.matchId = matchId;
    }

    /**
     * Return fromMin
     * @return Integer value
     */
    public int getFromMin() {
        return fromMin;
    }

    /**
     * Update fromMin
     * @param fromMin Integer value
     */
    public void setFromMin(int fromMin) {
        this.fromMin = fromMin;
    }

    /**
     * Return toMin
     * @return String object
     */
    public String getToMin() {
        return toMin;
    }

    /**
     * Update toMin
     * @param toMin String object
     */
    public void setToMin(String toMin) {
        this.toMin = toMin;
    }
}
