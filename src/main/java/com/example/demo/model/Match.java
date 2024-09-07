package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
public class Match {
    @Id
    private Long id;
    @OneToOne
    @NotNull
    private Team aTeamId;
    @OneToOne
    @NotNull
    private Team bTeamId;
    @DateTimeFormat
    private Date date;
    @NotNull
    @Pattern(regexp = "^(0\\([0-9]\\)-0\\([0-9]\\)|[0-9]-[0-9])$")
    private String score;

    public Match() {
    }

    public Match(Long id, Team aTeamId, Team bTeamId, Date date, String score) {
        this.id = id;
        this.aTeamId = aTeamId;
        this.bTeamId = bTeamId;
        this.date = date;
        this.score = score;
    }

    public Team getaTeamId() {
        return aTeamId;
    }

    public void setaTeamId(Team aTeamId) {
        this.aTeamId = aTeamId;
    }

    public Team getbTeamId() {
        return bTeamId;
    }

    public void setbTeamId(Team bTeamId) {
        this.bTeamId = bTeamId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
