package io.github.ndimovt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Team class
 */
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;
    private String managerName;
    private char teamGroup;

    /**
     * Instantiating Team
     */
    public Team() {
    }

    /**
     * Instantiating Team
     * @param id Long value
     * @param teamName String object
     * @param managerName String object
     * @param group Character value
     */
    public Team(Long id, String teamName, String managerName, char group) {
        this.id = id;
        this.teamName = teamName;
        this.managerName = managerName;
        this.teamGroup = group;
    }

    /**
     * Instantiating Team
     * @param id Long value
     */

    public Team(Long id) {
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
     * Return name
     * @return String object
     */
    public String getName() {
        return teamName;
    }

    /**
     * Updates name
     * @param name String object
     */
    public void setName(String name) {
        this.teamName = name;
    }

    /**
     * Return managerName
     * @return String object
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * Update managerName
     * @param managerName String object
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Return group
     * @return Character value
     */
    public char getGroup() {
        return teamGroup;
    }

    /**
     * Update group
     * @param group Character value
     */
    public void setGroup(char group) {
        this.teamGroup = group;
    }
}
