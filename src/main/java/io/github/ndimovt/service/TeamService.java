package io.github.ndimovt.service;

import io.github.ndimovt.exception.InvalidFileFormatException;
import io.github.ndimovt.exception.InvalidFileTypeException;
import io.github.ndimovt.model.Team;
import io.github.ndimovt.repository.TeamRepository;
import io.github.ndimovt.validators.PositionAndGroupValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static io.github.ndimovt.validators.FileFormatValidator.*;
import static io.github.ndimovt.validators.NumberAndPlayingTimeValidator.*;
import static io.github.ndimovt.validators.NameValidator.*;
import static io.github.ndimovt.validators.PositionAndGroupValidator.*;
@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> readTeamsFile(MultipartFile file) throws InvalidFileTypeException, InvalidFileFormatException, ArrayIndexOutOfBoundsException {
        List<Team> teams = new ArrayList<>();
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
                String[] headers = line.split(",");
                teams.add(new Team(
                        validateId(headers[0]),
                        validateTeamName(headers[1]),
                        validateManagerName(headers[2]),
                        validateTeamGroup(headers[3].charAt(0))
                ));
            }
        } catch (IOException ie) {
            throw new InvalidFileFormatException("File can't be uploaded to database, because of corrupted data!");
        }
        return teamRepository.saveAll(teams);
    }
}
