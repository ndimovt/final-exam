package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Team {
    @Id
    private Long id;
    private String name;
    private String managerName;
    private char group;

    public Team() {
    }

    public Team(String name, String managerName, char group) {
        this.name = name;
        this.managerName = managerName;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
