package io.github.ndimovt.service;

import io.github.ndimovt.exception.InvalidFileFormatException;
import io.github.ndimovt.exception.InvalidFileTypeException;
import io.github.ndimovt.model.Player;
import io.github.ndimovt.model.Team;
import io.github.ndimovt.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static io.github.ndimovt.validators.PositionAndGroupValidator.*;
import static io.github.ndimovt.validators.FileFormatValidator.*;
import static io.github.ndimovt.validators.NumberAndPlayingTimeValidator.*;
import static io.github.ndimovt.validators.NameValidator.*;

/**
 * Processing file, given and writes the information to database
 */
@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    /**
     * Returns List of players to be saved in the database
     * @param file Accepts multipart file
     * @return List of Team objects
     * @throws InvalidFileTypeException if file type is not valid
     * @throws InvalidFileFormatException if there is unsuitable information
     * @throws ArrayIndexOutOfBoundsException if there is missing column
     */

    public List<Player> insertPlayers(MultipartFile file) throws InvalidFileTypeException, InvalidFileFormatException, ArrayIndexOutOfBoundsException{
        List<Player> players = new ArrayList<>();
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
                players.add(new Player(
                        validateId(records[0]),
                        validateTeamNumber(records[1]),
                        validatePlayerRole(records[2]),
                        validatePlayerName(records[3]),
                        new Team(validateId(records[4]))
                ));
            }
        } catch (IOException ie) {
            throw new InvalidFileFormatException("File can't be uploaded to database, because of corrupted data!");
        }
        return playerRepository.saveAll(players);
    }
}
