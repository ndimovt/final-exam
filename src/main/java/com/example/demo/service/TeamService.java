package com.example.demo.service;

import com.example.demo.exception.InvalidFileFormatException;
import com.example.demo.exception.InvalidFileTypeException;
import com.example.demo.exception.MissingFileException;
import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import com.example.demo.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    private final File match = new File("");
    private final File teams = new File("teams.csv");
    private final File players = new File("");
    private final File records = new File("");

    @Autowired
    private TeamRepository teamRepository;

    public List<Team> readTeamsFile() throws InvalidFileTypeException, InvalidFileFormatException {
        File file = new File("teams.csv");
        List<Team> teams = new ArrayList<>();
        if (!Validator.isFileFormatValid(file)) {
            throw new InvalidFileTypeException("File type must be csv!");
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] headers = line.split(",");
                teams.add(new Team(
                        Long.parseLong(headers[0]),
                        headers[1],
                        headers[2],
                        headers[3].charAt(0)));

            }
        } catch (IOException ie) {
            throw new InvalidFileFormatException("Error reading file: " + ie.getMessage());
        }
        return teamRepository.saveAll(teams);
    }


}
