package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
@Entity
public class Match {
    @Id
    private Long id;
    @NotNull
    private long teamAId;
    @NotNull
    private long teamBId;
    @NotNull
    private LocalDate date;
    @NotNull
    private String score;

    public Match() {
    }

    public Match(Long id, Long teamAId, Long teamBId, LocalDate date, String score) {
        this.id = id;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.date = date;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(Long teamAId) {
        this.teamAId = teamAId;
    }

    public Long getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(Long teamBId) {
        this.teamBId = teamBId;
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
}
