package com.example.textfile;

import com.example.utilities.TextFileUtilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TextFileTaskTest {
    private TextFileTask textFileTask;
    private TextFileUtilities textFileUtilities;
    private String textOutFile;

    @BeforeTest()
    public void setUp() {
        textFileTask = new TextFileTask();
        textFileUtilities = new TextFileUtilities();
    }

    // Тесты для метода readerTextFileAndWriterInfoInFile
    @Test(description = "Тестируем подсчет кол-ва строк, слов, символов в файле")
    public void testReaderTextFileAndWriterInfoInFile() throws IOException {
        textFileTask.readerTextFileAndWriterInfoInFile("textFile.txt");
        textOutFile = "2 сл., 11 сим\n4 сл., 19 сим\n1 сл., 4 сим\n2 сл., 9 сим\n4 стр.";
        Assert.assertEquals(textFileUtilities.getTextFromTextFile("outTextFile.txt"), textOutFile);
    }

    @Test(description = "Тестируем подсчет кол-ва строк, слов, символов в пустом файле")
    public void testReaderTextFileAndWriterInfoInFileEmpty() throws IOException {
        textFileTask.readerTextFileAndWriterInfoInFile("textFileEmpty.txt");
        textOutFile = "0 стр.";
        Assert.assertEquals(textFileUtilities.getTextFromTextFile("outTextFile.txt"), textOutFile);
    }

    @Test(description = "Тестируем подсчет кол-ва строк, слов, символов в несуществующем файле",
            expectedExceptions = {FileNotFoundException.class})
    public void testReaderTextFileAndWriterInfoInFileNotFile() throws IOException {
        textFileTask.readerTextFileAndWriterInfoInFile("textFileNotFile.txt");
    }

    @Test(description = "Тестируем подсчет кол-ва строк, слов, символов в файле только с пробелами")
    public void testReaderTextFileAndWriterInfoInFileSpaces() throws IOException {
        textFileTask.readerTextFileAndWriterInfoInFile("textFileSpaces.txt");
        textOutFile = "0 сл., 3 сим\n0 сл., 3 сим\n0 сл., 5 сим\n3 стр.";
        Assert.assertEquals(textFileUtilities.getTextFromTextFile("outTextFile.txt"), textOutFile);
    }

    @Test(description = "Тестируем подсчет кол-ва строк, слов, символов в файле первая и последняя строка без текста")
    public void testReaderTextFileAndWriterInfoInFileFirstStrEmpty() throws IOException {
        textFileTask.readerTextFileAndWriterInfoInFile("textFileFirstEmpty.txt");
        textOutFile = "0 сл., 0 сим\n2 сл., 7 сим\n2 сл., 8 сим\n0 сл., 0 сим\n1 сл., 8 сим\n0 сл., 0 сим\n6 стр.";
        Assert.assertEquals(textFileUtilities.getTextFromTextFile("outTextFile.txt"), textOutFile);
    }

}
