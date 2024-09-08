package com.example.demo.service;

import com.example.demo.exception.InvalidFileFormatException;
import com.example.demo.exception.InvalidFileTypeException;
import com.example.demo.model.Player;
import com.example.demo.model.Team;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> insertPlayers(MultipartFile file) throws InvalidFileTypeException, InvalidFileFormatException{
        int count = 0;
        List<Player> players = new ArrayList<>();
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
                String[] records = line.split(",");
                players.add(new Player(
                        Long.parseLong(records[0]),
                        Integer.parseInt(records[1]),
                        records[2],
                        records[3],
                        Long.parseLong(records[4])));
                count++;

            }
        } catch (IOException ie) {
            throw new InvalidFileFormatException("File can't be uploaded to database, because of corrupted data on line " + count);
        }
        return playerRepository.saveAll(players);
    }
}
