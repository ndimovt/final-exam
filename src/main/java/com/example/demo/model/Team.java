package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Team {
    @Id
    @NotNull
    private Long id;
    @NotNull
    @Pattern(regexp = "^\\b\\w+\\b\\s\\b\\w+\\b\\s\\b\\w+\\b$")
    private String teamName;
    @NotNull
    @Pattern(regexp = "^([^\\W\\d_]+-?){1,7}$", message = "Name can't contain special symbols or numbers!")
    private String managerName;
    @NotNull
    private char group;

    public Team() {
    }

    public Team(Long id, String teamName, String managerName, char group) {
        this.id = id;
        this.teamName = teamName;
        this.managerName = managerName;
        this.group = group;
    }

    public String getName() {
        return teamName;
    }

    public void setName(String name) {
        this.teamName = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public char getGroup() {
        return group;
    }

    public void setGroup(char group) {
        this.group = group;
    }
}
