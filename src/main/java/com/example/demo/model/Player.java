package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @Pattern(regexp = "^([^\\W\\d_]+-?){1,7}$", message = "Username can't contain special symbols or numbers!")
    private String name;
    @ManyToOne
    private Team teamId;

}
