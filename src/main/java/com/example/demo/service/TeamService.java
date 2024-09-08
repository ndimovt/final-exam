package com.example.demo.service;

import com.example.demo.exception.InvalidFileFormatException;
import com.example.demo.exception.InvalidFileTypeException;
import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import com.example.demo.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> readTeamsFile(MultipartFile file) throws InvalidFileTypeException, InvalidFileFormatException {
        int count = 0;
        List<Team> teams = new ArrayList<>();
        if (!Validator.isFileFormatValid(file)) {
            throw new InvalidFileTypeException("File type must be csv!");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
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
                count++;

            }
        } catch (IOException ie) {
            throw new InvalidFileFormatException("File can't be uploaded to database, because of corrupted data on line " + count);
        }
        return teamRepository.saveAll(teams);
    }
}
