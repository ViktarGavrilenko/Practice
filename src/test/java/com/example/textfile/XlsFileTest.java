package com.example.textfile;

import com.example.exception.DataNotFilledException;
import com.example.exception.NotFoundCellDataException;
import com.example.utilities.XlsFileUtilities;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class XlsFileTest {

    private XlsFile xlsFile;

    private Sheet sheet;
    private Row rowMax;
    private double maxTotal;
    private String nameWithMaxTotal;
    private Row rowMin;
    private double minTotal;
    private String nameWithMinTotal;
    private Row rowAVG;
    private double avg;

    @BeforeTest()
    public void setUp() {
        xlsFile = new XlsFile();

    }

    // Тесты для метода parseXlsFile
    @Test(description = "Тестируем считывание и запись данных из xls файла")
    public void testParseXlsFile() throws IOException, NotFoundCellDataException, DataNotFilledException {
        xlsFile.parseXlsFile("file.xls", 0);
        sheet = XlsFileUtilities.getSheetFromXlsFile("InfoFile.xls", 0);

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
    public void testParseXlsFileSecondSheet() throws IOException, NotFoundCellDataException, DataNotFilledException {
        xlsFile.parseXlsFile("file.xls", 1);
        sheet = XlsFileUtilities.getSheetFromXlsFile("InfoFile.xls", 0);

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
            expectedExceptions = {FileNotFoundException.class})
    public void testParseXlsFileNotFile() throws IOException, NotFoundCellDataException, DataNotFilledException {
        xlsFile.parseXlsFile("NotFile.xls", 1);
    }

    @Test(description = "Тестируем считывание и запись данных из пустого xls файла",
            expectedExceptions = {DataNotFilledException.class},
            expectedExceptionsMessageRegExp = "Таблица без данных, заполните таблицу!")
    public void testParseXlsFileEmptySheet() throws IOException, NotFoundCellDataException, DataNotFilledException {
        xlsFile.parseXlsFile("file.xls", 2);
    }

    @Test(description = "Тестируем считывание и запись данных из xls файла без данных",
            expectedExceptions = {DataNotFilledException.class},
            expectedExceptionsMessageRegExp = "Таблица без данных, заполните таблицу!")
    public void testParseXlsFileEmptyData() throws IOException, NotFoundCellDataException, DataNotFilledException {
        xlsFile.parseXlsFile("file.xls", 2);
    }
}