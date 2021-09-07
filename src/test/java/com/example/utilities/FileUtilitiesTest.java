package com.example.utilities;

import com.example.exception.FileNotFoundException;
import com.example.exception.NotFoundCellDataException;
import com.example.exception.NumberOfSheetsOutsideLimitException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.example.constants.Constants.*;


public class FileUtilitiesTest {

    private String textOutFile;

    // Тесты для метода getTextFromTextFile
    @Test(description = "Тестируем получение текста из текстового файла")
    public void testGetTextFromTextFile() throws IOException, FileNotFoundException {
        textOutFile = "Привет мир!\nОдин два три четыре\nпять\nsix seven";
        Assert.assertEquals(FileUtilities.getTextFromTextFile(TEXT_FILE_TXT), textOutFile);
    }

    @Test(description = "Тестируем получение текста из пустого текстового файла")
    public void testGetTextFromTextFileEmpty() throws IOException, FileNotFoundException {
        textOutFile = "";
        Assert.assertEquals(FileUtilities.getTextFromTextFile(TEXT_FILE_EMPTY_TXT), textOutFile);
    }

    @Test(description = "Тестируем получение текста из текстового файла с пустой первой строкой")
    public void testGetTextFromTextFileFirstEmpty() throws IOException, FileNotFoundException {
        textOutFile = "\nдва три\nпять six\n\n  восемь\n";
        Assert.assertEquals(FileUtilities.getTextFromTextFile(TEXT_FILE_FIRST_EMPTY_TXT), textOutFile);
    }

    @Test(description = "Тестируем получение текста из текстового файла со строками из пробелов")
    public void testGetTextFromTextFileFirstSpacesStr() throws IOException, FileNotFoundException {
        textOutFile = "   \n   \n     ";
        Assert.assertEquals(FileUtilities.getTextFromTextFile(TEXT_FILE_SPACES_TXT), textOutFile);
    }

    @Test(description = "Тестируем подсчет кол-ва строк, слов, символов в несуществующем файле",
            expectedExceptions = {FileNotFoundException.class},
            expectedExceptionsMessageRegExp = "Файл не найден!")
    public void testGetTextFromTextFileFirstNotFile() throws IOException, FileNotFoundException {
        FileUtilities.getTextFromTextFile(NON_EXISTENT_FILE_XLS);
    }

    // Тесты для метода getSheetFromXlsFile

    @Test(description = "Тестируем получение таблицы из xls файла, который отсутствует",
            expectedExceptions = {FileNotFoundException.class},
            expectedExceptionsMessageRegExp = "Файл не найден!")
    public void testGetSheetFromXlsFileNotFile() throws IOException, FileNotFoundException,
            NumberOfSheetsOutsideLimitException {
        FileUtilities.getSheetFromXlsFile(NON_EXISTENT_FILE_XLS, 0);
    }

    @Test(description = "Тестируем получение таблицы из xls файла, за пределами листов таблицы",
            expectedExceptions = {NumberOfSheetsOutsideLimitException.class},
            expectedExceptionsMessageRegExp = "Лист с номером 6 отсутствует в вашем xls файле!")
    public void testGetSheetFromXlsFileNotIndex() throws IOException, FileNotFoundException,
            NumberOfSheetsOutsideLimitException {
        FileUtilities.getSheetFromXlsFile(FILE_XLS, 6);
    }

    // Тесты для метода searchIndexCell
    @Test(description = "Тестируем поиск адреса ячейки из Excel таблицы с определенным текстовым значением")
    public void testSearchIndexCellWithText() throws IOException, FileNotFoundException, NumberOfSheetsOutsideLimitException,
            NotFoundCellDataException {
        Sheet sheet = FileUtilities.getSheetFromXlsFile(FILE_XLS, 1);
        int[] indexCell = {5, 3};
        Assert.assertEquals(FileUtilities.searchIndexCell(sheet, "Имя"), indexCell);
    }

    @Test(description = "Тестируем поиск адреса ячейки из Excel таблицы с определенным числовым значением")
    public void testSearchIndexCellWithNumber() throws IOException, FileNotFoundException, NumberOfSheetsOutsideLimitException,
            NotFoundCellDataException {
        Sheet sheet = FileUtilities.getSheetFromXlsFile(FILE_XLS, 1);
        int[] indexCell = {8, 4};
        String number = "234,3";
        Assert.assertEquals(FileUtilities.searchIndexCell(sheet, number), indexCell);
    }

    @Test(description = "Тестируем поиск адреса ячейки из Excel таблицы, " +
            "если заданное значение в таблице отсутствует",
            expectedExceptions = {NotFoundCellDataException.class},
            expectedExceptionsMessageRegExp = "Требуемые данные в файле не найдены, проверьте файл!")
    public void testSearchIndexCellNoData() throws IOException, FileNotFoundException,
            NumberOfSheetsOutsideLimitException, NotFoundCellDataException {
        Sheet sheet = FileUtilities.getSheetFromXlsFile(FILE_XLS, 1);
        FileUtilities.searchIndexCell(sheet, "Отчество");
    }

    // Тесты для метода isFileExist
    @Test(description = "Тестируем существование заданного файла",
            expectedExceptions = {FileNotFoundException.class},
            expectedExceptionsMessageRegExp = "Файл не найден!")
    public void testIsFileExistNoFile() throws FileNotFoundException {
        FileUtilities.isFileExist(NON_EXISTENT_FILE_XLS);
    }

    @Test(description = "Тестируем существование заданного файла")
    public void testIsFileExist() throws FileNotFoundException {
        Assert.assertTrue(FileUtilities.isFileExist(FILE_XLS));
    }
}