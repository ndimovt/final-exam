package io.github.ndimovt.controller;

import io.github.ndimovt.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MatchController {
    @Autowired
    private MatchService matchService;
    @PostMapping("/match/file/")
    public ResponseEntity<String> insertMatchRecords(@RequestParam("file") MultipartFile file){
        matchService.readMatchesFile(file);
        return ResponseEntity.ok("File processed successfully!");

    }
}
