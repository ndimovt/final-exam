package io.github.ndimovt.service;

import io.github.ndimovt.exception.InvalidFileFormatException;
import io.github.ndimovt.exception.InvalidFileTypeException;
import io.github.ndimovt.model.Match;
import io.github.ndimovt.model.Team;
import io.github.ndimovt.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

import static io.github.ndimovt.validators.DateValidator.*;
import static io.github.ndimovt.validators.FileFormatValidator.*;
import static io.github.ndimovt.validators.NumberAndPlayingTimeValidator.*;

/**
 * Processing file, given and writes the information to database
 */
@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    /**
     * Returns List of matches to be saved in the database
     * @param file Accepts multipart file
     * @return List of Team objects
     * @throws InvalidFileTypeException if file type is not valid
     * @throws InvalidFileFormatException if there is unsuitable information
     * @throws ArrayIndexOutOfBoundsException if there is missing column
     */

    public List<Match> readMatchesFile(MultipartFile file) throws InvalidFileTypeException, InvalidFileFormatException, ArrayIndexOutOfBoundsException {
        List<Match> matches = new ArrayList<>();
        if (!isFileFormatValid(file)) {
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
                String[] records = line.split(",");
                matches.add(new Match(
                        validateId(records[0]),
                        validateDate(records[3]),
                        validateScore(records[4]),
                        new Team(validateId(records[1])),
                        new Team(validateId(records[2])
                        )));
            }
        } catch (IOException ie) {
            throw new InvalidFileFormatException("File can't be uploaded to database, because of corrupted data!");
        }
        return matchRepository.saveAll(matches);
    }
}
