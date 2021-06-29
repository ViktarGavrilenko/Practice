package com.example.string;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class StringTaskTest {

    String NULL_STR = null;
    String EMPTY_STR = "";
    String SPACES_STR = "    ";

    // Тесты для метода putWordsReverseInString
    @Test(description = "Тестируем строку со значением NULL", groups = {"putWordsReverseInString"})
    public void testPutWordsReverseInStringNull() {
        Assert.assertEquals(EMPTY_STR, StringTask.putReverseWordOrder(NULL_STR));
    }

    @Test(description = "Тестируем на пустую строку", groups = {"putWordsReverseInString"})
    public void testPutWordsReverseInStringEmpty() {
        Assert.assertEquals(EMPTY_STR, StringTask.putReverseWordOrder(EMPTY_STR));
    }

    @Test(description = "Тестируем строку с тремя словами", groups = {"putWordsReverseInString"})
    public void testPutWordsReverseInStringTrue() {
        Assert.assertEquals("three two one", StringTask.putReverseWordOrder("one two three"));
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце", groups = {"putWordsReverseInString"})
    public void testPutWordsReverseInStringFirstLastSpaces() {
        Assert.assertEquals("three two one", StringTask.putReverseWordOrder("  one two three  "));
    }

    @Test(description = "Тестируем строку с числами", groups = {"putWordsReverseInString"})
    public void testPutWordsReverseInStringNumber() {
        Assert.assertEquals("77 6 55 4 3 2 1", StringTask.putReverseWordOrder("1 2 3 4 55 6 77"));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"putWordsReverseInString"})
    public void testPutWordsReverseInStringSpace() {
        Assert.assertEquals(EMPTY_STR, StringTask.putReverseWordOrder(SPACES_STR));
    }

    // Тесты для метода replaceEverySecondEntryString
    @Test(description = "Тест заменяет слово one в строке на 1", groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringText() {
        Assert.assertEquals("one two 1 three one four 1",
                StringTask.replaceEverySecondEntry("one two one three one four one", "one", "1"));
    }

    @Test(description = "Тестируем входную строку с пробелами в начале и в конце", groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringTextSpace() {
        Assert.assertEquals("    one two 1 three one four 1    ",
                StringTask.replaceEverySecondEntry("    one two one three one four one    ", "one", "1"));
    }

    @Test(description = "Тест на отсутствие необходимой подстроки в строке", groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringNotEntry() {
        Assert.assertEquals("one two one three one four one",
                StringTask.replaceEverySecondEntry("one two one three one four one", "five", "5"));
    }

    @Test(description = "Тестируем пустую входную строку", groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringEmptyStr() {
        Assert.assertEquals(EMPTY_STR, StringTask.replaceEverySecondEntry(EMPTY_STR, "five", "5"));
    }

    @Test(description = "Тестируем не инициализированную сходную строку", groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringNullStr() {
        Assert.assertNull(StringTask.replaceEverySecondEntry(NULL_STR, "five", "5"));
    }

    @Test(description = "Тестируем не инициализированную входную подстроку", groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringNullEntry() {
        Assert.assertEquals("one two three",
                StringTask.replaceEverySecondEntry("one two three", NULL_STR, "5"));
    }

    @Test(description = "Тестируем пустую входную подстроку", groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringEmptyEntry() {
        Assert.assertEquals("one two three",
                StringTask.replaceEverySecondEntry("one two three", EMPTY_STR, "5"));
    }

    @Test(description = "Тестируем не инициализированное заменяемое вхождение", groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringNullEmptyMin() {
        Assert.assertEquals("one two three two",
                StringTask.replaceEverySecondEntry("one two three two", "two", NULL_STR));
    }

    @Test(description = "Тестируем пустое заменяемое вхождение", groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringEmptyEntryMin() {
        Assert.assertEquals("one two three  four",
                StringTask.replaceEverySecondEntry("one two three two four", "two", EMPTY_STR));
    }

    @Test(description = "Тестируем строку из пробелов", groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringStrSpace() {
        Assert.assertEquals(SPACES_STR, StringTask.replaceEverySecondEntry(SPACES_STR, "two", EMPTY_STR));
    }

    @Test(description = "Тестируем подстроку из пробелов", groups = {"replaceEverySecondEntryString"})
    public void testReplaceEverySecondEntryStringEntrySpace() {
        Assert.assertEquals("one two three two four",
                StringTask.replaceEverySecondEntry("one two three two four", SPACES_STR, EMPTY_STR));
    }

    // Тесты для метода minNumberDistinctChar
    @Test(description = "Тестируем строку со словами из одинаковых символов", groups = {"minNumberDistinctChar"})
    public void testMinNumberDistinctChar() {
        Assert.assertEquals("ffff", StringTask.minNumberDistinctChar("ffff sd 12 1 two aabb"));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"minNumberDistinctChar"})
    public void testMinNumberDistinctCharNull() {
        Assert.assertEquals(EMPTY_STR, StringTask.minNumberDistinctChar(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", groups = {"minNumberDistinctChar"})
    public void testMinNumberDistinctCharEmpty() {
        Assert.assertEquals(EMPTY_STR, StringTask.minNumberDistinctChar(EMPTY_STR));
    }

    @Test(description = "Тестируем строку с одним словом", groups = {"minNumberDistinctChar"})
    public void testMinNumberDistinctCharOneWord() {
        Assert.assertEquals("hello", StringTask.minNumberDistinctChar("hello"));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"minNumberDistinctChar"})
    public void testMinNumberDistinctCharOnlySpaces() {
        Assert.assertEquals(EMPTY_STR, StringTask.minNumberDistinctChar(SPACES_STR));
    }

    // Тесты для метода searchCountWordLatinChar
    @Test(description = "Тестируем строку с русскими, латинскими буквами и цифрами в словах", groups = {"searchCountWordLatinChar"})
    public void searchCountWordLatinChar() {
        Assert.assertEquals(2, StringTask.searchCountWordLatinChar("one two1 три four"));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"searchCountWordLatinChar"})
    public void searchCountWordLatinCharNull() {
        Assert.assertEquals(0, StringTask.searchCountWordLatinChar(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", groups = {"searchCountWordLatinChar"})
    public void searchCountWordLatinCharEmpty() {
        Assert.assertEquals(0, StringTask.searchCountWordLatinChar(EMPTY_STR));
    }

    @Test(description = "Тестируем строку в которой нет слов, только с латинскими символами",
            groups = {"searchCountWordLatinChar"})
    public void searchCountWordLatinCharNotLatin() {
        Assert.assertEquals(0, StringTask.searchCountWordLatinChar("one1 two2 три четыре"));
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце строки", groups = {"searchCountWordLatinChar"})
    public void searchCountWordLatinCharFirstLastSpace() {
        Assert.assertEquals(2, StringTask.searchCountWordLatinChar(" one two2 три четыре two "));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"searchCountWordLatinChar"})
    public void searchCountWordLatinCharOnlySpace() {
        Assert.assertEquals(0, StringTask.searchCountWordLatinChar(SPACES_STR));
    }

    // Тесты для метода searchNumericPalindromes
    @Test(description = "Тестируем строку двумя числовыми палиндромами", groups = {"searchNumericPalindromes"})
    public void testSearchNumericPalindromes() {
        Assert.assertEquals(Arrays.asList("11211", "343"), StringTask.searchNumericPalindromes("ono 2tt2 11211 343"));
    }

    @Test(description = "Тестируем строку без числовых палиндромов", groups = {"searchNumericPalindromes"})
    public void testSearchNumericPalindromesNotPalindrome() {
        Assert.assertEquals(Collections.emptyList(), StringTask.searchNumericPalindromes("ono 2twt2 112 43"));
    }

    @Test(description = "Тестируем строку с одним словом являющимся числовым палиндромом", groups = {"searchNumericPalindromes"})
    public void testSearchNumericPalindromesOnePalindrome() {
        Assert.assertEquals(Collections.singletonList("121"), StringTask.searchNumericPalindromes("121"));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"searchNumericPalindromes"})
    public void testSearchNumericPalindromesNullStr() {
        Assert.assertEquals(Collections.emptyList(), StringTask.searchNumericPalindromes(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", groups = {"searchNumericPalindromes"})
    public void testSearchNumericPalindromesEmptyStr() {
        Assert.assertEquals(Collections.emptyList(), StringTask.searchNumericPalindromes(EMPTY_STR));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"searchNumericPalindromes"})
    public void testSearchNumericPalindromesEOnlySpaces() {
        Assert.assertEquals(Collections.emptyList(), StringTask.searchNumericPalindromes(SPACES_STR));
    }
}