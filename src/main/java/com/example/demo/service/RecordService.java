package com.example.demo.service;

import com.example.demo.exception.InvalidFileFormatException;
import com.example.demo.exception.InvalidFileTypeException;
import com.example.demo.model.Record;
import com.example.demo.repository.RecordsRepository;
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
public class RecordService {
    @Autowired
    private RecordsRepository recordsRepository;

    public List<Record> insertRecords(MultipartFile file) throws InvalidFileTypeException, InvalidFileFormatException{
        int count = 0;
        List<Record> records = new ArrayList<>();
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
                String[] info = line.split(",");
                records.add(new Record(
                        Long.parseLong(info[0]),
                        Long.parseLong(info[1]),
                        Long.parseLong(info[2]),
                        Integer.parseInt(info[3]),
                        info[4]));
                count++;
            }
        } catch (IOException ie) {
            throw new InvalidFileFormatException("File can't be uploaded to database, because of corrupted data on line " + count);
        }
        return recordsRepository.saveAll(records);
    }
}
