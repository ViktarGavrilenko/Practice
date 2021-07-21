package com.example.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TextFailUtilities {

    //Запись текста из текстового файла в строку
    public String convertTextFileToStr(String textFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(textFile, StandardCharsets.UTF_8));
        String text = "";
        String line;

        while ((line = reader.readLine()) != null) {
            text = text + line + "\n";
        }
        return text.substring(0, text.length() - 1);
    }
}
