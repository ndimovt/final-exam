package io.github.ndimovt.controller;

import io.github.ndimovt.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * The class TeamController
 */
@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    /**
     * Reads file content
     * @param file MultipartFile
     * @return ResponseEntity
     */
    @PostMapping("/team/createWithFile")
    public ResponseEntity<String> insertTeamInfo(@RequestParam("file") MultipartFile file){
        teamService.readTeamsFile(file);
        return ResponseEntity.ok("File uploaded and processed successfully");
    }
}
