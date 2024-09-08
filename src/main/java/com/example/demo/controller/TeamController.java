package com.example.demo.controller;

import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;
    @PostMapping("/team/file/")
    public ResponseEntity<String> insertTeamInfo(@RequestParam("file") MultipartFile file){
        try {
            teamService.readTeamsFile(file);
            return ResponseEntity.ok("File uploaded and processed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error processing file!");
        }
    }
}
