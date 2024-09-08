package io.github.ndimovt.service;

import io.github.ndimovt.exception.InvalidFileFormatException;
import io.github.ndimovt.exception.InvalidFileTypeException;
import io.github.ndimovt.model.Match;
import io.github.ndimovt.repository.MatchRepository;
import io.github.ndimovt.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

import static io.github.ndimovt.validator.Validator.*;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public List<Match> readMatchesFile(MultipartFile file) throws InvalidFileTypeException, InvalidFileFormatException, ArrayIndexOutOfBoundsException {
        List<Match> matches = new ArrayList<>();
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
                String[] info = line.split(",");

                matches.add(new Match(
                        validateId(info[0]),
                        validateId(info[1]),
                        validateId(info[2]),
                        validateDate(info[3]),
                        validateScore(info[4])
                ));
            }
        } catch (IOException ie) {
            throw new InvalidFileFormatException("File can't be uploaded to database, because of corrupted data!");
        }

        return matchRepository.saveAll(matches);
    }
}
