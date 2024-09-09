package io.github.ndimovt.validators;

import org.springframework.web.multipart.MultipartFile;

/**
 * Validates file format
 */
public class FileFormatValidator {
    /**
     * Validates that file given is .csv
     * @param file MultipartFile
     * @return true if file is .csv
     */

    public static boolean isFileFormatValid (MultipartFile file){
        String filename = file.getOriginalFilename();
        return filename != null && filename.toLowerCase().endsWith(".csv");
    }
}
