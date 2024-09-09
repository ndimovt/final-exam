package io.github.ndimovt.validators;

import org.springframework.web.multipart.MultipartFile;

public class FileFormatValidator {

    public static boolean isFileFormatValid (MultipartFile file){
        String filename = file.getOriginalFilename();
        return filename != null && filename.toLowerCase().endsWith(".csv");
    }
}
