package io.github.ndimovt.controller;

import io.github.ndimovt.model.dto.LongestPlayingPairDto;
import io.github.ndimovt.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DBResultController {
    @Autowired
    private DBService service;
    @GetMapping("/result")
    public ResponseEntity<List<LongestPlayingPairDto>> showResult(){
        List<LongestPlayingPairDto> result = service.longestPlayingPlayers();
        return ResponseEntity.ok(result);
    }
}
