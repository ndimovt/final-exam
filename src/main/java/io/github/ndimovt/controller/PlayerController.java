package io.github.ndimovt.controller;

import io.github.ndimovt.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * The class PlayerController
 */
@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    /**
     * Reads file content
     * @param file MultipartFile
     * @return ResponseEntity
     */
    @PostMapping("/player/createWithFile")
    public ResponseEntity<String> insertPlayerInfo(@RequestParam("file") MultipartFile file){
        playerService.insertPlayers(file);
        return ResponseEntity.ok("File uploaded and processed successfully");
    }
}
