package io.github.ndimovt.service;

import io.github.ndimovt.exception.InvalidFileFormatException;
import io.github.ndimovt.exception.InvalidFileTypeException;
import io.github.ndimovt.model.Record;
import io.github.ndimovt.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static io.github.ndimovt.validators.FileFormatValidator.*;
import static io.github.ndimovt.validators.NumberAndPlayingTimeValidator.*;

/**
 * Processing file, given and writes the information to database
 */
@Service
public class RecordService {
    @Autowired
    private RecordsRepository recordsRepository;

    /**
     * Returns List of match records to be saved in the database
     * @param file Accepts multipart file
     * @return List of Team objects
     * @throws InvalidFileTypeException if file type is not valid
     * @throws InvalidFileFormatException if there is unsuitable information
     * @throws ArrayIndexOutOfBoundsException if there is missing column
     */

    public List<Record> insertRecords(MultipartFile file) throws InvalidFileTypeException, InvalidFileFormatException, ArrayIndexOutOfBoundsException{
        List<Record> records = new ArrayList<>();
        if (!isFileFormatValid(file)) {
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
                        validateId(info[0]),
                        validateId(info[1]),
                        validateId(info[2]),
                        validatePlayingTime(info[3]),
                        validateMaxPlayingTime(info[4])
                ));
            }
        } catch (IOException ie) {
            throw new InvalidFileFormatException("File can't be uploaded to database, because of corrupted data!");
        }
        return recordsRepository.saveAll(records);
    }
}
