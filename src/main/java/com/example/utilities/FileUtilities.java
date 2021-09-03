package com.example.utilities;

import com.example.exception.NotFoundCellDataException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class FileUtilities {

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

    public static HSSFSheet getSheetFromXlsFile(String fileName, int index) throws IOException {
        InputStream inputStream;
        HSSFWorkbook workBook;

        inputStream = new FileInputStream(fileName);
        workBook = new HSSFWorkbook(inputStream);

        return workBook.getSheetAt(index);
    }

    public static int[] searchIndexCell(Sheet sheet, String valueCell) throws NotFoundCellDataException {
        int[] indexCell = new int[2];
        Iterator<Row> it = sheet.iterator();

        boolean isSearch = false;
        outerLoop:

        while (it.hasNext()) {
            Row rowName = it.next();
            for (Cell cellName : rowName) {
                if (cellName.getStringCellValue().equals(valueCell)) {
                    indexCell[0] = cellName.getRowIndex() + 1;
                    indexCell[1] = cellName.getColumnIndex();
                    isSearch = true;
                    break outerLoop;
                }
            }
        }

        if (!isSearch) {
            throw new NotFoundCellDataException();
        }

        return indexCell;
    }
}
