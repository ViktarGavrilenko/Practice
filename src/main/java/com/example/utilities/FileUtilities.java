package com.example.utilities;

import com.example.exception.FileNotFoundException;
import com.example.exception.NotFoundCellDataException;
import com.example.exception.NumberOfSheetsOutsideLimitException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.Stream;

import static com.example.constants.Constants.INFO_FILE_XLS;

public class FileUtilities {

    //Запись текста из текстового файла в строку
    public static String getTextFromTextFile(String fileName) throws IOException, FileNotFoundException {
        StringBuilder text = new StringBuilder();
        if (isFileExist(fileName)) {
            String line;
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {

                try (Stream<String> streamString = Files.lines(Path.of(fileName))) {
                    long count = streamString.count();
                    for (int i = 0; i < count; i++) {
                        line = reader.readLine();
                        text.append(line).append("\n");

                        if (i == count - 1) {
                            text = new StringBuilder(text.substring(0, text.length() - 1));
                        }
                    }
                }
            }
        }
        return text.toString();
    }

    public static HSSFSheet getSheetFromXlsFile(String fileName, int index) throws IOException, FileNotFoundException,
            NumberOfSheetsOutsideLimitException {
        HSSFSheet sheet = null;
        if (isFileExist(fileName)) {
            try (InputStream inputStream = new FileInputStream(fileName);
                 HSSFWorkbook workBook = new HSSFWorkbook(inputStream)) {
                int countSheets = workBook.getNumberOfSheets();
                if (index < 0 || index > countSheets) {
                    throw new NumberOfSheetsOutsideLimitException(index) {
                    };
                }
                sheet = workBook.getSheetAt(index);
            }
        }
        return sheet;
    }

    public static int[] searchIndexCell(Sheet sheet, String valueCell) throws NotFoundCellDataException {
        int[] indexCell = new int[2];
        Iterator<Row> it = sheet.iterator();

        boolean isSearch = false;
        outerLoop:

        while (it.hasNext()) {
            Row rowName = it.next();
            for (Cell cellName : rowName) {
                DataFormatter formatter = new DataFormatter();
                String cellData = formatter.formatCellValue(cellName);
                if (cellData.equals(valueCell)) {
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

    public static boolean isFileExist(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        if (f.isFile()) {
            return true;
        } else {
            throw new FileNotFoundException();
        }
    }

    public static void getDataWithXls(int[] indexCell, Sheet sheet, Row row) throws IOException {
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
        writeDataInXls(averageTotal / countStr, maxTotal, minTotal, nameWithMaxTotal, nameWithMinTotal);
    }

    public static void writeDataInXls(double average, double maxTotal, double minTotal, String nameWithMaxTotal,
                                      String nameWithMinTotal) throws IOException {
        try (HSSFWorkbook workbook = new HSSFWorkbook()) {

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
            rowAVG.createCell(2).setCellValue(average);

            sheetOut.autoSizeColumn(1);

            try (FileOutputStream fileOut = new FileOutputStream(INFO_FILE_XLS)) {
                workbook.write(fileOut);
            }
        }
    }
}
