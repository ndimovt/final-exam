package io.github.ndimovt.model;

import jakarta.persistence.*;

/**
 * Player class
 */
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int teamNumber;
    private String position;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team teamId;

    /**
     * Instantiate Player
     */
    public Player() {
    }

    /**
     * Instantiate Player
     * @param id Long value
     * @param teamNumber Integer value
     * @param position String object
     * @param name String object
     * @param teamId Team object
     */
    public Player(Long id, int teamNumber, String position, String name, Team teamId) {
        this.id = id;
        this.teamNumber = teamNumber;
        this.position = position;
        this.name = name;
        this.teamId = teamId;
    }

    /**
     * Instantiate Player
     * @param id Long value
     */
    public Player(Long id) {
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
     * Return teamNumber
     * @return Integer value
     */
    public int getTeamNumber() {
        return teamNumber;
    }

    /**
     * Update teamNumber
     * @param teamNumber Integer value
     */
    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    /**
     * Return position
     * @return String object
     */
    public String getPosition() {
        return position;
    }

    /**
     * Update position
     * @param position String object
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Return name
     * @return String object
     */
    public String getName() {
        return name;
    }

    /**
     * Update name
     * @param name String object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return teamId
     * @return Team object
     */
    public Team getTeamId() {
        return teamId;
    }

    /**
     * Update teamId
     * @param teamId Team object
     */
    public void setTeamId(Team teamId) {
        this.teamId = teamId;
    }
}
