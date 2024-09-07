package com.example.demo.service;

import com.example.demo.exception.InvalidFileFormatException;
import com.example.demo.exception.InvalidFileTypeException;
import com.example.demo.model.Match;
import com.example.demo.model.Team;
import com.example.demo.repository.MatchRepository;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.apache.tomcat.util.http.FastHttpDateFormat.parseDate;

@Service
public class MatchService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private MatchRepository matchRepository;
    public List<Match> readMatchesFile() throws InvalidFileTypeException, InvalidFileFormatException {
        File file = new File("matches.csv");
        List<Match> matches = new ArrayList<>();

        // Validate the file type
        if (!isFileFormatValid(file)) {
            throw new InvalidFileTypeException("File type must be csv!");
        }

        // Read the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] headers = line.split(",");
                Long matchId = Long.parseLong(headers[0]);
                Long aTeamId = Long.parseLong(headers[1]);
                Long bTeamId = Long.parseLong(headers[2]);
                //Date matchDate = ;
                String score = headers[4].trim();
                Match match = new Match();

                match.setId(matchId);
                match.setTeamAId(aTeamId);
                match.setTeamBId(bTeamId);
                //match.setDate(matchDate);
                match.setScore(score);

                matches.add(match);
            }
        } catch (IOException ie) {
            throw new InvalidFileFormatException("Error reading file: " + ie.getMessage());
        }

        // Save the matches to the repository
        matches.forEach(System.out::println);
        return matchRepository.saveAll(matches);
    }
    private boolean isTeamValid(String teams){
        String[] header = teams.split(",");
        return header[0].equalsIgnoreCase("id")
                && header[1].equalsIgnoreCase("name")
                && header[2].equalsIgnoreCase("ManagerFullName")
                && header[3].equalsIgnoreCase("group");
    }

    private boolean isFileFormatValid(File file){
        return file.getName().endsWith(".csv");
    }
}
