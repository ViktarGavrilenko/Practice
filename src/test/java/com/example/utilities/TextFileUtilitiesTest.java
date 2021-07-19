package com.example.utilities;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TextFileUtilitiesTest {
    private TextFileUtilities textFileUtilities;
    private String textOutFile;

    @BeforeTest()
    public void setUp() {
        textFileUtilities = new TextFileUtilities();
    }

    // Тесты для метода getTextFromTextFile
    @Test(description = "Тестируем получение текста из текстового файла")
    public void testGetTextFromTextFile() throws IOException {
        textOutFile = "Привет мир!\nОдин два три четыре\nпять\nsix seven";
        Assert.assertEquals(textFileUtilities.getTextFromTextFile("textFile.txt"), textOutFile);
    }

    @Test(description = "Тестируем получение текста из пустого текстового файла")
    public void testGetTextFromTextFileEmpty() throws IOException {
        textOutFile = "";
        Assert.assertEquals(textFileUtilities.getTextFromTextFile("textFileEmpty.txt"), textOutFile);
    }

    @Test(description = "Тестируем получение текста из текстового файла с пустой первой строкой")
    public void testGetTextFromTextFileFirstEmpty() throws IOException {
        textOutFile = "\nдва три\nпять six\n\n  восемь\n";
        Assert.assertEquals(textFileUtilities.getTextFromTextFile("textFileFirstEmpty.txt"), textOutFile);
    }

    @Test(description = "Тестируем получение текста из текстового файла со строками из пробелов")
    public void testGetTextFromTextFileFirstSpacesStr() throws IOException {
        textOutFile = "   \n   \n     ";
        Assert.assertEquals(textFileUtilities.getTextFromTextFile("textFileSpaces.txt"), textOutFile);
    }

    @Test(description = "Тестируем подсчет кол-ва строк, слов, символов в несуществующем файле",
            expectedExceptions = {FileNotFoundException.class})
    public void testGetTextFromTextFileFirstNotFile() throws IOException {
        textOutFile = "";
        Assert.assertEquals(textFileUtilities.getTextFromTextFile("textFileNotFile.txt"), textOutFile);
    }

}