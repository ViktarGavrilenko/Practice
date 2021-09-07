package com.example.file;

import com.example.exception.DataNotFilledException;
import com.example.exception.FileNotFoundException;
import com.example.exception.NotFoundCellDataException;
import com.example.exception.NumberOfSheetsOutsideLimitException;
import com.example.utilities.FileUtilities;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.example.constants.Constants.*;

public class FileTaskTest {

    private Sheet sheet;
    private Row rowMax;
    private double maxTotal;
    private String nameWithMaxTotal;
    private Row rowMin;
    private double minTotal;
    private String nameWithMinTotal;
    private Row rowAVG;
    private double avg;

    @Test(description = "Тестируем подсчет кол-ва строк, слов, символов в несуществующем файле",
            expectedExceptions = {FileNotFoundException.class},
            expectedExceptionsMessageRegExp = "Файл не найден!")
    public void testReaderTextFileAndWriterInfoInFileNotFile() throws IOException, FileNotFoundException {
        FileTask.readerTextFileAndWriterInfoInFile("textFileNotFile.txt");
    }

    @DataProvider
    public Object[][] dataForFile() {
        return new Object[][]{
                {TEXT_FILE_TXT, "2 сл., 11 сим\n4 сл., 19 сим\n1 сл., 4 сим\n2 сл., 9 сим\n4 стр."},
                {TEXT_FILE_EMPTY_TXT, "0 стр."},
                {TEXT_FILE_SPACES_TXT, "0 сл., 3 сим\n0 сл., 3 сим\n0 сл., 5 сим\n3 стр."},
                {TEXT_FILE_FIRST_EMPTY_TXT, "0 сл., 0 сим\n2 сл., 7 сим\n2 сл., 8 сим\n0 сл., 0 сим\n1 сл., " +
                        "8 сим\n0 сл., 0 сим\n6 стр."},
        };
    }

    @Test(dataProvider = "dataForFile")
    public void testReaderTextFileAndWriterInfoInFile(String fileName, String textOutFile) throws IOException,
            FileNotFoundException {
        FileTask.readerTextFileAndWriterInfoInFile(fileName);
        Assert.assertEquals(FileUtilities.getTextFromTextFile(OUT_TEXT_FILE_TXT), textOutFile);
    }

    // Тесты для метода parseXlsFile
    @Test(description = "Тестируем считывание и запись данных из xls файла")
    public void testParseXlsFile() throws IOException, NotFoundCellDataException, DataNotFilledException,
            FileNotFoundException, NumberOfSheetsOutsideLimitException {
        FileTask.parseXlsFile(FILE_XLS, 0);
        sheet = FileUtilities.getSheetFromXlsFile(INFO_FILE_XLS, 0);

        rowMax = sheet.getRow(1);
        maxTotal = rowMax.getCell(2).getNumericCellValue();
        nameWithMaxTotal = rowMax.getCell(3).getStringCellValue();

        rowMin = sheet.getRow(2);
        minTotal = rowMin.getCell(2).getNumericCellValue();
        nameWithMinTotal = rowMin.getCell(3).getStringCellValue();

        rowAVG = sheet.getRow(4);
        avg = rowAVG.getCell(2).getNumericCellValue();

        Assert.assertEquals(maxTotal, 234.3);
        Assert.assertEquals(nameWithMaxTotal, "Ivan");
        Assert.assertEquals(minTotal, 12);
        Assert.assertEquals(nameWithMinTotal, "Dima");
        Assert.assertEquals(avg, 64.38333333333334);

    }

    @Test(description = "Тестируем считывание и запись данных из второго листа xls файла со смещением таблицы")
    public void testParseXlsFileSecondSheet() throws IOException, NotFoundCellDataException, DataNotFilledException,
            FileNotFoundException, NumberOfSheetsOutsideLimitException {
        FileTask.parseXlsFile(FILE_XLS, 1);
        sheet = FileUtilities.getSheetFromXlsFile(INFO_FILE_XLS, 0);

        rowMax = sheet.getRow(1);
        maxTotal = rowMax.getCell(2).getNumericCellValue();
        nameWithMaxTotal = rowMax.getCell(3).getStringCellValue();

        rowMin = sheet.getRow(2);
        minTotal = rowMin.getCell(2).getNumericCellValue();
        nameWithMinTotal = rowMin.getCell(3).getStringCellValue();

        rowAVG = sheet.getRow(4);
        avg = rowAVG.getCell(2).getNumericCellValue();

        Assert.assertEquals(maxTotal, 321.2);
        Assert.assertEquals(nameWithMaxTotal, "Таня");
        Assert.assertEquals(minTotal, 1.2);
        Assert.assertEquals(nameWithMinTotal, "Петр");
        Assert.assertEquals(avg, 69.46799999999999);

    }

    @Test(description = "Тестируем считывание и запись данных из несуществующего xls файла",
            expectedExceptions = {FileNotFoundException.class},
            expectedExceptionsMessageRegExp = "Файл не найден!")
    public void testParseXlsFileNotFile() throws IOException, NotFoundCellDataException, DataNotFilledException,
            FileNotFoundException, NumberOfSheetsOutsideLimitException {
        FileTask.parseXlsFile(NON_EXISTENT_FILE_XLS, 1);
    }

    @Test(description = "Тестируем считывание и запись данных из пустого xls файла",
            expectedExceptions = {DataNotFilledException.class},
            expectedExceptionsMessageRegExp = "Таблица без данных, заполните таблицу!")
    public void testParseXlsFileEmptySheet() throws IOException, NotFoundCellDataException, DataNotFilledException,
            FileNotFoundException, NumberOfSheetsOutsideLimitException {
        FileTask.parseXlsFile(FILE_XLS, 2);
    }
}
