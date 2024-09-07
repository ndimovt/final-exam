package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.*;

@Entity
public class Player {
    @Id
    @NotNull
    private Long id;
    @NotNull
    @Min(1)
    @Max(99)
    private int teamNumber;
    @NotNull
    @Size(min = 2, max = 2)
    @Pattern(regexp = "^[A-Z]{2}$", message = "Input must have 2 uppercase symbols!")
    private String position;
    @NotNull
    @Pattern(regexp = "^([^\\W\\d_]+-?){1,7}$", message = "Name can't contain special symbols or numbers!")
    private String name;
    @OneToOne
    private Team teamId;

    public Player() {
    }

    public Player(Long id, int teamNumber, String position, String name, Team teamId) {
        this.id = id;
        this.teamNumber = teamNumber;
        this.position = position;
        this.name = name;
        this.teamId = teamId;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeamId() {
        return teamId;
    }

    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }
}
