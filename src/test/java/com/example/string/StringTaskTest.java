package com.example.string;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class StringTaskTest {

    private final String NULL_STR = null;
    private final String EMPTY_STR = "";
    private final String SPACES_STR = "    ";

    StringTask stringTask = new StringTask();

    // Тесты для метода putWordsReverseInString
    @Test(description = "Тестируем строку со значением NULL")
    public void testPutWordsReverseInStringNull() {
        Assert.assertEquals(stringTask.putReverseWordOrder(NULL_STR), EMPTY_STR);
    }

    @Test(description = "Тестируем на пустую строку")
    public void testPutWordsReverseInStringEmpty() {
        Assert.assertEquals(stringTask.putReverseWordOrder(EMPTY_STR), EMPTY_STR);
    }

    @Test(description = "Тестируем строку с тремя словами")
    public void testPutWordsReverseInStringTrue() {
        Assert.assertEquals(stringTask.putReverseWordOrder("one two three"), "three two one");
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце")
    public void testPutWordsReverseInStringFirstLastSpaces() {
        Assert.assertEquals(stringTask.putReverseWordOrder("  one two three  "), "three two one");
    }

    @Test(description = "Тестируем строку с числами")
    public void testPutWordsReverseInStringNumber() {
        Assert.assertEquals(stringTask.putReverseWordOrder("1 2 3 4 55 6 77"), "77 6 55 4 3 2 1");
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testPutWordsReverseInStringSpace() {
        Assert.assertEquals(stringTask.putReverseWordOrder(SPACES_STR), EMPTY_STR);
    }

    // Тесты для метода replaceEverySecondEntryString
    @Test(description = "Тест заменяет слово one в строке на 1")
    public void testReplaceEverySecondEntryStringText() {
        Assert.assertEquals(stringTask.replaceEverySecondEntry("one two one three one four one",
                "one", "1"), "one two 1 three one four 1");
    }

    @Test(description = "Тестируем входную строку с пробелами в начале и в конце")
    public void testReplaceEverySecondEntryStringTextSpace() {
        Assert.assertEquals(stringTask.replaceEverySecondEntry("    one two one three one four one    ",
                "one", "1"), "    one two 1 three one four 1    ");
    }

    @Test(description = "Тест на отсутствие необходимой подстроки в строке")
    public void testReplaceEverySecondEntryStringNotEntry() {
        Assert.assertEquals(stringTask.replaceEverySecondEntry("one two one three one four one",
                "five", "5"), "one two one three one four one");
    }

    @Test(description = "Тестируем пустую входную строку")
    public void testReplaceEverySecondEntryStringEmptyStr() {
        Assert.assertEquals(stringTask.replaceEverySecondEntry(EMPTY_STR, "five", "5"), EMPTY_STR);
    }

    @Test(description = "Тестируем не инициализированную сходную строку")
    public void testReplaceEverySecondEntryStringNullStr() {
        Assert.assertNull(stringTask.replaceEverySecondEntry(NULL_STR, "five", "5"));
    }

    @Test(description = "Тестируем не инициализированную входную подстроку")
    public void testReplaceEverySecondEntryStringNullEntry() {
        Assert.assertEquals(stringTask.replaceEverySecondEntry("one two three", NULL_STR, "5"),
                "one two three");
    }

    @Test(description = "Тестируем пустую входную подстроку")
    public void testReplaceEverySecondEntryStringEmptyEntry() {
        Assert.assertEquals(stringTask.replaceEverySecondEntry("one two three", EMPTY_STR, "5"),
                "one two three");
    }

    @Test(description = "Тестируем не инициализированное заменяемое вхождение")
    public void testReplaceEverySecondEntryStringNullEmptyMin() {
        Assert.assertEquals(stringTask.replaceEverySecondEntry("one two three two", "two", NULL_STR),
                "one two three two");
    }

    @Test(description = "Тестируем пустое заменяемое вхождение")
    public void testReplaceEverySecondEntryStringEmptyEntryMin() {
        Assert.assertEquals(stringTask.replaceEverySecondEntry("one two three two four", "two", EMPTY_STR),
                "one two three  four");
    }

    @Test(description = "Тестируем строку из пробелов")
    public void testReplaceEverySecondEntryStringStrSpace() {
        Assert.assertEquals(stringTask.replaceEverySecondEntry(SPACES_STR, "two", EMPTY_STR), SPACES_STR);
    }

    @Test(description = "Тестируем подстроку из пробелов")
    public void testReplaceEverySecondEntryStringEntrySpace() {
        Assert.assertEquals(stringTask.replaceEverySecondEntry("one two three two four", SPACES_STR, EMPTY_STR),
                "one two three two four");
    }

    // Тесты для метода minNumberDistinctChar
    @Test(description = "Тестируем строку со словами из одинаковых символов")
    public void testMinNumberDistinctChar() {
        Assert.assertEquals(stringTask.minNumberDistinctChar("ffff sd 12 1 two aabb"), "ffff");
    }

    @Test(description = "Тестируем не инициализированную строку")
    public void testMinNumberDistinctCharNull() {
        Assert.assertEquals(stringTask.minNumberDistinctChar(NULL_STR), EMPTY_STR);
    }

    @Test(description = "Тестируем пустую строку")
    public void testMinNumberDistinctCharEmpty() {
        Assert.assertEquals(stringTask.minNumberDistinctChar(EMPTY_STR), EMPTY_STR);
    }

    @Test(description = "Тестируем строку с одним словом")
    public void testMinNumberDistinctCharOneWord() {
        Assert.assertEquals(stringTask.minNumberDistinctChar("hello"), "hello");
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testMinNumberDistinctCharOnlySpaces() {
        Assert.assertEquals(stringTask.minNumberDistinctChar(SPACES_STR), EMPTY_STR);
    }

    // Тесты для метода searchCountWordLatinChar
    @Test(description = "Тестируем строку с русскими, латинскими буквами и цифрами в словах")
    public void searchCountWordLatinChar() {
        Assert.assertEquals(stringTask.searchCountWordLatinChar("one two1 три four"), 2);
    }

    @Test(description = "Тестируем не инициализированную строку")
    public void searchCountWordLatinCharNull() {
        Assert.assertEquals(stringTask.searchCountWordLatinChar(NULL_STR), 0);
    }

    @Test(description = "Тестируем пустую строку")
    public void searchCountWordLatinCharEmpty() {
        Assert.assertEquals(stringTask.searchCountWordLatinChar(EMPTY_STR), 0);
    }

    @Test(description = "Тестируем строку в которой нет слов, только с латинскими символами")
    public void searchCountWordLatinCharNotLatin() {
        Assert.assertEquals(stringTask.searchCountWordLatinChar("one1 two2 три четыре"), 0);
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце строки")
    public void searchCountWordLatinCharFirstLastSpace() {
        Assert.assertEquals(stringTask.searchCountWordLatinChar(" one two2 три четыре two "), 2);
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void searchCountWordLatinCharOnlySpace() {
        Assert.assertEquals(stringTask.searchCountWordLatinChar(SPACES_STR), 0);
    }

    // Тесты для метода searchNumericPalindromes
    @Test(description = "Тестируем строку с двумя числовыми палиндромами")
    public void testSearchNumericPalindromes() {
        Assert.assertEquals(stringTask.searchNumericPalindromes("ono 2tt2 11211 343"), Arrays.asList("11211", "343"));
    }

    @Test(description = "Тестируем строку без числовых палиндромов")
    public void testSearchNumericPalindromesNotPalindrome() {
        Assert.assertEquals(stringTask.searchNumericPalindromes("ono 2twt2 112 43"), Collections.emptyList());
    }

    @Test(description = "Тестируем строку с одним словом являющимся числовым палиндромом")
    public void testSearchNumericPalindromesOnePalindrome() {
        Assert.assertEquals(stringTask.searchNumericPalindromes("121"), Collections.singletonList("121"));
    }

    @Test(description = "Тестируем не инициализированную строку")
    public void testSearchNumericPalindromesNullStr() {
        Assert.assertEquals(stringTask.searchNumericPalindromes(NULL_STR), Collections.emptyList());
    }

    @Test(description = "Тестируем пустую строку")
    public void testSearchNumericPalindromesEmptyStr() {
        Assert.assertEquals(stringTask.searchNumericPalindromes(EMPTY_STR), Collections.emptyList());
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testSearchNumericPalindromesEOnlySpaces() {
        Assert.assertEquals(stringTask.searchNumericPalindromes(SPACES_STR), Collections.emptyList());
    }
}