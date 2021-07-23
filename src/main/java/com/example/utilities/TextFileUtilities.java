package com.example.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileUtilities {

    //Запись текста из текстового файла в строку
    public String getTextFromTextFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
        String text = "";
        String line;

        long count = Files.lines(Paths.get(fileName)).count();
        for (int i = 0; i < count; i++) {
            line = reader.readLine();
            text = text + line + "\n";

            if (i == count - 1) {
                text = text.substring(0, text.length() - 1);
            }
        }

        return text;
    }
}
