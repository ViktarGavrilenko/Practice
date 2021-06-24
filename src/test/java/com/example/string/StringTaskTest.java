package com.example.string;

import com.example.utilities.StringUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringTaskTest {

    // Тесты для метода putWordsReverseInString
    @Test(groups = {"putWordsReverseInString"})
    public void testPutWordsReverseInStringNull() {
        Assert.assertEquals("", StringTask.putWordsReverseInString(null));
    }

    @Test(groups = {"putWordsReverseInString"})
    public void testPutWordsReverseInStringEmpty() {
        Assert.assertEquals("", StringTask.putWordsReverseInString(""));
    }

    @Test(groups = {"putWordsReverseInString"})
    public void testPutWordsReverseInStringTrue() {
        Assert.assertEquals("three two one", StringTask.putWordsReverseInString("one two three"));
    }

    @Test(groups = {"putWordsReverseInString"})
    public void testPutWordsReverseInStringFirstLastSpaces() {
        Assert.assertEquals("three two one", StringTask.putWordsReverseInString(" one two three "));
    }

    @Test(groups = {"putWordsReverseInString"})
    public void testPutWordsReverseInStringNumber() {
        Assert.assertEquals("77 6 55 4 3 2 1", StringTask.putWordsReverseInString("1 2 3 4 55 6 77"));
    }

    // Тесты для метода replaceEverySecondEntryString
    @Test(groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringText() {
        Assert.assertEquals("one two 1 three one four 1",
                StringTask.replaceEverySecondEntryString("one two one three one four one", "one", "1"));
    }

    @Test(groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringTextSpace() {
        Assert.assertEquals("    one two 1 three one four 1    ",
                StringTask.replaceEverySecondEntryString("    one two one three one four one    ", "one", "1"));
    }

    @Test(groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringNotEntry() {
        Assert.assertEquals("one two one three one four one",
                StringTask.replaceEverySecondEntryString("one two one three one four one", "five", "5"));
    }

    @Test(groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringEmptyStr() {
        Assert.assertEquals("", StringTask.replaceEverySecondEntryString("", "five", "5"));
    }

    @Test(groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringNullStr() {
        Assert.assertEquals(null, StringTask.replaceEverySecondEntryString(null, "five", "5"));
    }

    @Test(groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringNullEntry() {
        Assert.assertEquals("one two three",
                StringTask.replaceEverySecondEntryString("one two three", null, "5"));
    }

    @Test(groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringEmptyEntry() {
        Assert.assertEquals("one two three",
                StringTask.replaceEverySecondEntryString("one two three", "", "5"));
    }

    @Test(groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringNullEmptyMin() {
        Assert.assertEquals("one two three two",
                StringTask.replaceEverySecondEntryString("one two three two", "two", null));
    }

    @Test(groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringEmptyEmptyMin() {
        Assert.assertEquals("one two three  four",
                StringTask.replaceEverySecondEntryString("one two three two four", "two", ""));
    }

    // Тесты для метода minNumberDistinctChar
    @Test(groups = {"minNumberDistinctChar"})
    public void testMinNumberDistinctChar() {
        Assert.assertEquals("ffff", StringTask.minNumberDistinctChar("ffff sd 12 1 two aabb"));
    }

    @Test(groups = {"minNumberDistinctChar"})
    public void testMinNumberDistinctCharNull() {
        Assert.assertEquals("", StringTask.minNumberDistinctChar(null));
    }

    @Test(groups = {"minNumberDistinctChar"})
    public void testMinNumberDistinctCharEmpty() {
        Assert.assertEquals("", StringTask.minNumberDistinctChar(""));
    }

    @Test(groups = {"minNumberDistinctChar"})
    public void testMinNumberDistinctCharOneWord() {
        Assert.assertEquals("hello", StringTask.minNumberDistinctChar("hello"));
    }

    // Тесты для метода searchCountWordLatinChar
    @Test(groups = {"searchCountWordLatinChar"})
    public void searchCountWordLatinChar() {
        Assert.assertEquals(2, StringTask.searchCountWordLatinChar("one two1 три four"));
    }

    @Test(groups = {"searchCountWordLatinChar"})
    public void searchCountWordLatinCharNull() {
        Assert.assertEquals(0, StringTask.searchCountWordLatinChar(null));
    }

    @Test(groups = {"searchCountWordLatinChar"})
    public void searchCountWordLatinCharEmpty() {
        Assert.assertEquals(0, StringTask.searchCountWordLatinChar(""));
    }

    @Test(groups = {"searchCountWordLatinChar"})
    public void searchCountWordLatinCharNotLatin() {
        Assert.assertEquals(0, StringTask.searchCountWordLatinChar("one1 two2 три четыре"));
    }

    @Test(groups = {"searchCountWordLatinChar"})
    public void searchCountWordLatinCharFirstLastSpace() {
        Assert.assertEquals(2, StringTask.searchCountWordLatinChar(" one two2 три четыре two "));
    }

    // Тесты для метода searchNumericPalindromes
    @Test(groups = {"searchNumericPalindromes"})
    public void testSearchNumericPalindromes() {
       // Assert.assertEquals(2, StringTask.searchNumericPalindromes(" one two2 три четыре two "));
    }
}