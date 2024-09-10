package io.github.ndimovt.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Match class
 */
@Entity
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String score;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teamaid", referencedColumnName = "id")
    private Team teamAId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teambid", referencedColumnName = "id")
    private Team teamBId;

    /**
     * Instantiate Match
     */
    public Match() {
    }

    /**
     * Instantiate Match
     * @param id Long value
     * @param date LocalDate object
     * @param score String object
     * @param teamAId Team object
     * @param teamBId Team object
     */
    public Match(Long id, LocalDate date, String score, Team teamAId, Team teamBId) {
        this.id = id;
        this.date = date;
        this.score = score;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
    }

    /**
     * Instantiate Match
     * @param id Long value
     */
    public Match(Long id) {
        this.id = id;
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
     * Return date
     * @return LocalDate object
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Update date
     * @param date LocalDate object
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Return score
     * @return String object
     */
    public String getScore() {
        return score;
    }

    /**
     * Update score
     * @param score String object
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * Return teamAId
     * @return Team object
     */
    public Team getTeamAId() {
        return teamAId;
    }

    /**
     * Update teamAId
     * @param teamAId Team object
     */
    public void setTeamAId(Team teamAId) {
        this.teamAId = teamAId;
    }

    /**
     * Return teamBId
     * @return Team object
     */
    public Team getTeamBId() {
        return teamBId;
    }

    /**
     * Update teamBId
     * @param teamBId Team object
     */
    public void setTeamBId(Team teamBId) {
        this.teamBId = teamBId;
    }
}
