package io.github.ndimovt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;
    private String managerName;
    private char teamGroup;

    public Team() {
    }

    public Team(Long id, String teamName, String managerName, char group) {
        this.id = id;
        this.teamName = teamName;
        this.managerName = managerName;
        this.teamGroup = group;
    }

    public Team(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return teamGroup;
    }

    public void setGroup(char group) {
        this.teamGroup = group;
    }
}
