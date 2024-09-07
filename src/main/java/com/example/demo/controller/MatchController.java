package com.example.demo.controller;

import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {
    @Autowired
    private MatchService matchService;
    @PostMapping("/match")
    public ResponseEntity<String> insertMatchRecords(){
        matchService.readMatchesFile();
        return ResponseEntity.ok("Yes");
    }
}
