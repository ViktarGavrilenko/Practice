package com.example.textfile;

import com.example.utilities.TextFileUtilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TextFileTaskTest {
    private TextFileTask textFileTask;
    private TextFileUtilities textFileUtilities;

    @BeforeTest()
    public void setUp() {
        textFileTask = new TextFileTask();
        textFileUtilities = new TextFileUtilities();
    }

    @Test(description = "Тестируем подсчет кол-ва строк, слов, символов в несуществующем файле",
            expectedExceptions = {FileNotFoundException.class})
    public void testReaderTextFileAndWriterInfoInFileNotFile() throws IOException {
        textFileTask.readerTextFileAndWriterInfoInFile("textFileNotFile.txt");
    }

    @DataProvider
    public Object[][] dataForFile() {
        return new Object[][]{
                {"textFile.txt", "2 сл., 11 сим\n4 сл., 19 сим\n1 сл., 4 сим\n2 сл., 9 сим\n4 стр."},
                {"textFileEmpty.txt", "0 стр."},
                {"textFileSpaces.txt", "0 сл., 3 сим\n0 сл., 3 сим\n0 сл., 5 сим\n3 стр."},
                {"textFileFirstEmpty.txt", "0 сл., 0 сим\n2 сл., 7 сим\n2 сл., 8 сим\n0 сл., 0 сим\n1 сл., " +
                        "8 сим\n0 сл., 0 сим\n6 стр."},
        };
    }

    @Test(dataProvider = "dataForFile")
    public void testReaderTextFileAndWriterInfoInFile(String fileName, String textOutFile) throws IOException {
        textFileTask.readerTextFileAndWriterInfoInFile(fileName);
        Assert.assertEquals(textFileUtilities.getTextFromTextFile("outTextFile.txt"), textOutFile);
    }
}
