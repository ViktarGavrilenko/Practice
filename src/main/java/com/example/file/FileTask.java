package com.example.file;

import com.example.exception.DataNotFilledException;
import com.example.exception.FileNotFoundException;
import com.example.exception.NotFoundCellDataException;
import com.example.exception.NumberOfSheetsOutsideLimitException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.example.constants.Constants.OUT_TEXT_FILE_TXT;
import static com.example.utilities.FileUtilities.*;
import static com.example.utilities.StringUtilities.countWords;

public class FileTask {

    public static void readerTextFileAndWriterInfoInFile(String fileName) throws IOException, FileNotFoundException {

        if (isFileExist(fileName)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
                         (new FileOutputStream(OUT_TEXT_FILE_TXT), StandardCharsets.UTF_8))) {
                int countLine = 0;
                String line;
                while ((line = reader.readLine()) != null) {
                    countLine++;
                    writer.write(countWords(line) + " сл., " + line.length() + " сим\n");
                }
                writer.write(countLine + " стр.");
            }
        }
    }

    public static void parseXlsFile(String fileName, int index) throws IOException, NotFoundCellDataException,
            DataNotFilledException, FileNotFoundException, NumberOfSheetsOutsideLimitException {
        if (isFileExist(fileName)) {
            Sheet sheet = getSheetFromXlsFile(fileName, index);
            String valueCell = "Имя";
            int[] indexCell = searchIndexCell(sheet, valueCell);

            Row row = sheet.getRow(indexCell[0]);

            if (row == null) {
                throw new DataNotFilledException();
            } else {
                getDataWithXls(indexCell, sheet, row);
            }
        }
    }
}