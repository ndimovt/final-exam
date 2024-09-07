package com.example.demo.controller;

import com.example.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;
    @PostMapping("/team/file/")
    public ResponseEntity<String> insertTeamInfo(){
        teamService.readTeamsFile();
        return ResponseEntity.ok("Ok");
    }
}
