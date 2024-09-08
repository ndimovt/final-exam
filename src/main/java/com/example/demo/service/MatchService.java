package com.example.demo.service;

import com.example.demo.exception.InvalidFileFormatException;
import com.example.demo.exception.InvalidFileTypeException;
import com.example.demo.model.Match;
import com.example.demo.repository.MatchRepository;
import com.example.demo.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@Service
public class MatchService {
    private List<DateTimeFormatter> supportedFormats = Arrays.asList(
            DateTimeFormatter.ofPattern("M/d/yyyy"),
            DateTimeFormatter.ofPattern("MM/dd/yyyy"),
            DateTimeFormatter.ofPattern("MM/dd/yy"),
            DateTimeFormatter.ofPattern("dd-M-yyyy"),
            DateTimeFormatter.ofPattern("d-MM-yyyy"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    @Autowired
    private MatchRepository matchRepository;

    public List<Match> readMatchesFile() throws InvalidFileTypeException, InvalidFileFormatException {
        int count = 0;
        File file = new File("matches.csv");
        List<Match> matches = new ArrayList<>();
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
                String[] info = line.split(",");
                LocalDate matchDate = parseDate(info[3].trim());

                matches.add(new Match(
                        Long.parseLong(info[0]),
                        Long.parseLong(info[1]),
                        Long.parseLong(info[2]),
                        matchDate,
                        info[4]
                ));
                count++;
            }
        } catch (IOException ie) {
            throw new InvalidFileFormatException("File can't be uploaded to database, because of corrupted data on line " + count);
        }

        return matchRepository.saveAll(matches);
    }
    private LocalDate parseDate(String dateString) throws InvalidFileFormatException {
        for (DateTimeFormatter formatter : supportedFormats) {
            try {
                return LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException ignored) {
            }
        }
        throw new InvalidFileFormatException("Unsupported date format: " + dateString);
    }

}
