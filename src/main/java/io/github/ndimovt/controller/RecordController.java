package io.github.ndimovt.controller;

import io.github.ndimovt.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RecordController {
    @Autowired
    private RecordService recordService;
    @PostMapping("/record/createWithFile")
    public ResponseEntity<String> insertRecordsInfo(@RequestParam("file") MultipartFile file){
        recordService.insertRecords(file);
        return ResponseEntity.ok("File uploaded and processed successfully");
    }
}
