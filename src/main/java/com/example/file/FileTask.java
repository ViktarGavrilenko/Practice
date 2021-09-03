package com.example.file;

import com.example.exception.DataNotFilledException;
import com.example.exception.NotFoundCellDataException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.example.constant.Constant.INFO_FILE_XLS;
import static com.example.constant.Constant.OUT_TEXT_FILE_TXT;
import static com.example.utilities.FileUtilities.getSheetFromXlsFile;
import static com.example.utilities.FileUtilities.searchIndexCell;
import static com.example.utilities.StringUtilities.countWords;

public class FileTask {

    public void readerTextFileAndWriterInfoInFile(String fileName) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream(OUT_TEXT_FILE_TXT), StandardCharsets.UTF_8));
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

    public void parseXlsFile(String fileName, int index) throws IOException, NotFoundCellDataException,
            DataNotFilledException {

        Sheet sheet = getSheetFromXlsFile(fileName, index);
        int[] indexCell = searchIndexCell(sheet, "Имя");

        Row row = sheet.getRow(indexCell[0]);

        if (row == null) {
            throw new DataNotFilledException();
        } else {

            Cell cellName = row.getCell(indexCell[1]);
            Cell cellTotal = row.getCell(indexCell[1] + 1);

            String nameWithMaxTotal = cellName.getStringCellValue();
            String nameWithMinTotal = cellName.getStringCellValue();
            double maxTotal = cellTotal.getNumericCellValue();
            double minTotal = cellTotal.getNumericCellValue();
            double averageTotal = 0;

            int countStr = 0;

            while (row != null) {
                countStr++;

                if (cellTotal.getNumericCellValue() > maxTotal) {
                    maxTotal = cellTotal.getNumericCellValue();
                    nameWithMaxTotal = cellName.getStringCellValue();
                }

                if (cellTotal.getNumericCellValue() < minTotal) {
                    minTotal = cellTotal.getNumericCellValue();
                    nameWithMinTotal = cellName.getStringCellValue();
                }

                averageTotal = averageTotal + cellTotal.getNumericCellValue();

                row = sheet.getRow(++indexCell[0]);
                if (row != null) {
                    cellName = row.getCell(indexCell[1]);
                    cellTotal = row.getCell(indexCell[1] + 1);
                }
            }
            // Записываем полученные данные
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheetOut = workbook.createSheet("Info");

            HSSFRow rowMax = sheetOut.createRow(1);
            rowMax.createCell(1).setCellValue("Максимальная сумма");
            rowMax.createCell(2).setCellValue(maxTotal);
            rowMax.createCell(3).setCellValue(nameWithMaxTotal);

            HSSFRow rowMin = sheetOut.createRow(2);
            rowMin.createCell(1).setCellValue("Минимальная сумма");
            rowMin.createCell(2).setCellValue(minTotal);
            rowMin.createCell(3).setCellValue(nameWithMinTotal);

            HSSFRow rowAVG = sheetOut.createRow(4);
            rowAVG.createCell(1).setCellValue("Среднеарифметическое значение");
            rowAVG.createCell(2).setCellValue(averageTotal / countStr);

            sheetOut.autoSizeColumn(1);

            FileOutputStream fileOut = new FileOutputStream(INFO_FILE_XLS);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        }
    }
}
