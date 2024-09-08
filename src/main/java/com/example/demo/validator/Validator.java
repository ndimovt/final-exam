package com.example.demo.validator;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class Validator {
    public static boolean isFileFormatValid (MultipartFile file){
        String filename = file.getOriginalFilename();
        return filename != null && filename.toLowerCase().endsWith(".csv");
    }

}
