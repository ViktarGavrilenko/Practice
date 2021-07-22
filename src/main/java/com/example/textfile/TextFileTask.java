package com.example.textfile;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.example.utilities.StringUtilities.countWords;

public class TextFileTask {

    public void readerTextFileAndWriterInfoInFile(String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream("outTextFile.txt"), StandardCharsets.UTF_8));
        int countLine = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            countLine++;
            writer.write(countWords(line) + " сл., " + line.length() + " сим\n");
        }
        writer.write(countLine + " стр.");
        reader.close();
        writer.close();
    }
}
