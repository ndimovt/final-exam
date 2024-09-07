package com.example.demo.validator;

import java.io.File;

public class Validator {
    public static boolean isFileFormatValid(File file){
        return file.getName().endsWith(".csv");
    }

}
