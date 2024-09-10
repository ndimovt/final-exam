package io.github.ndimovt.model;

import jakarta.persistence.*;

import java.time.LocalDate;
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

    public Match() {
    }

    public Match(Long id, LocalDate date, String score, Team teamAId, Team teamBId) {
        this.id = id;
        this.date = date;
        this.score = score;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
    }

    public Match(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Team getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(Team teamAId) {
        this.teamAId = teamAId;
    }

    public Team getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(Team teamBId) {
        this.teamBId = teamBId;
    }
}
