package com.example.utilities;

import com.example.exception.StrEmptyException;
import com.example.exception.StrNullException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class StringUtilitiesTest {
    private final String NULL_STR = null;
    private final String EMPTY_STR = "";
    private final String SPACES_STR = "    ";

    // Тесты для метода countTarget
    @Test(description = "Тестируем строку с двумя вхождениями подстроки (русские символы)")
    public void testCountTargetRusText() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.countTarget("Слова: один два один", "один"), 2);
    }

    @Test(description = "Тестируем строку с тремя вхождениями подстроки (латинские символы)")
    public void testCountTargetLatinText() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.countTarget("Word: one one two three one", "one"), 3);
    }

    @Test(description = "Тестируем не инициализированную строку", expectedExceptions = {StrNullException.class},
            expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testCountTargetNullStr() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.countTarget(NULL_STR, "one"), 0);
    }

    @Test(description = "Тестируем пустую строку", expectedExceptions = {StrEmptyException.class},
            expectedExceptionsMessageRegExp = "Пустая строка")
    public void testCountTargetEmptyStr() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.countTarget(EMPTY_STR, "one"), 0);
    }

    @Test(description = "Тестируем не инициализированную подстроку", expectedExceptions = {StrNullException.class},
            expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testCountTargetNullTarget() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.countTarget("one two three", NULL_STR), 0);
    }

    @Test(description = "Тестируем отсутствие подстроки в строке")
    public void testCountTargetNotTarget() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.countTarget("one two three", "four"), 0);
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testCountTargetStrSpaces() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.countTarget(SPACES_STR, "four"), 0);
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testCountTargetTargetSpaces() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.countTarget("one two three", SPACES_STR), 0);
    }

    // Тесты для метода countWords
    @Test(description = "Тестируем строку с четырьмя русскими словами")
    public void testCountWordsRusText() {
        Assert.assertEquals(StringUtilities.countWords("Слова: один два один"), 4);
    }

    @Test(description = "Тестируем строку с шестью английскими словами и пробелами вначале и конце строки")
    public void testCountWordsLatinText() {
        Assert.assertEquals(StringUtilities.countWords(" Word:  one one  two three one "), 6);
    }

    @Test(description = "Тестируем с не инициализированной строкой")
    public void testCountWordsNullStr() {
        Assert.assertEquals(StringUtilities.countWords(NULL_STR), 0);
    }

    @Test(description = "Тестируем с пустой строкой")
    public void testCountWordsEmptyStr() {
        Assert.assertEquals(StringUtilities.countWords(EMPTY_STR), 0);
    }

    @Test(description = "Тестируем строку с символами и цифрами")
    public void testCountWordsDiffStr() {
        Assert.assertEquals(StringUtilities.countWords("132 231 >> // qwe цук"), 6);
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testCountWordsSpacesStr() {
        Assert.assertEquals(StringUtilities.countWords(SPACES_STR), 0);
    }

    // Тесты для метода isWordPalindrome
    @Test(description = "Тестируем палиндром из латинских символов")
    public void testIsWordPalindromeTrue() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isWordPalindrome("hiih"));
    }

    @Test(description = "Тестируем строку без палиндрома")
    public void testIsWordPalindromeFalse() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isWordPalindrome("hello"));
    }

    @Test(description = "Тестируем строку с числовым палиндромам")
    public void testIsWordPalindromeNumber() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isWordPalindrome("1331"));
    }

    @Test(description = "Тестируем не инициализированную строку", expectedExceptions = {StrNullException.class},
            expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testIsWordPalindromeNull() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isWordPalindrome(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", expectedExceptions = {StrEmptyException.class},
            expectedExceptionsMessageRegExp = "Пустая строка")
    public void testIsWordPalindromeEmpty() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isWordPalindrome(EMPTY_STR));
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testIsWordPalindromeSpacesStr() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isWordPalindrome(SPACES_STR));
    }

    // Тесты для метода isWordLatinChar
    @Test(description = "Тестируем не инициализированную строку")
    public void testIsWordLatinChar() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isWordLatinChar("Hello"));
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце")
    public void testIsWordLatinCharFirstLastSpace() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isWordLatinChar(" Hello "));
    }

    @Test(description = "Тестируем строку с русскими символами")
    public void testIsWordLatinCharRusText() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Привет"));
    }

    @Test(description = "Тестируем строку с латинскими словами")
    public void testIsWordLatinCharSpaceStr() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Hello word"));
    }

    @Test(description = "Тестируем строку с латинскими символами и цифрами")
    public void testIsWordLatinCharStrNumber() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Hello123"));
    }

    @Test(description = "Тестируем не инициализированную строку", expectedExceptions = {StrNullException.class},
            expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testIsWordLatinCharCharNull() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isWordLatinChar(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", expectedExceptions = {StrEmptyException.class},
            expectedExceptionsMessageRegExp = "Пустая строка")
    public void testIsWordLatinCharEmpty() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isWordLatinChar(EMPTY_STR));
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testIsWordLatinCharSpacesStr() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isWordLatinChar(SPACES_STR));
    }

    // Тесты для метода isNullOrEmpty
    @Test(description = "Тестируем строку с латинскими буквами")
    public void testIsNullOrEmptyTrue() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isNullOrEmpty("Hello"));
    }

    @Test(description = "Тестируем пустую строку", expectedExceptions = {StrEmptyException.class},
            expectedExceptionsMessageRegExp = "Пустая строка")
    public void testIsNullOrEmptyEmpty() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isNullOrEmpty(EMPTY_STR));
    }

    @Test(description = "Тестируем не инициализированную строку", expectedExceptions = {StrNullException.class},
            expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testIsNullOrEmptyNull() throws StrEmptyException, StrNullException {
        Assert.assertFalse(StringUtilities.isNullOrEmpty(NULL_STR));
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testIsNullOrEmptySpacesStr() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isNullOrEmpty(SPACES_STR));
    }

    // Тесты для метода getFirstWord
    @Test(description = "Тестируем строку с латинскими словами")
    public void testGetFirstWord() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.getFirstWord("Hello word!"), "Hello");
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце")
    public void testGetFirstWordFirstSpace() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.getFirstWord(" Hello word! "), "Hello");
    }

    @Test(description = "Тестируем пустую строку", expectedExceptions = {StrEmptyException.class},
            expectedExceptionsMessageRegExp = "Пустая строка")
    public void testGetFirstWordEmptyStr() throws StrEmptyException, StrNullException {
        Assert.assertNull(StringUtilities.getFirstWord(EMPTY_STR));
    }

    @Test(description = "Тестируем не инициализированную строку", expectedExceptions = {StrNullException.class},
            expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testGetFirstWordNullStr() throws StrEmptyException, StrNullException {
        Assert.assertNull(StringUtilities.getFirstWord(NULL_STR));
    }

    @Test(description = "Тестируем строку цифрами и символами")
    public void testGetFirstWordSymbol() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.getFirstWord("11! /* "), "11!");
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testGetFirstWordSpaceStr() throws StrEmptyException, StrNullException {
        Assert.assertNull(StringUtilities.getFirstWord(SPACES_STR));
    }

    // Тесты для метода deleteFirstWord
    @Test(description = "Тестируем строку английскими словами")
    public void testDeleteFirstWord() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.deleteFirstWord("Hello word! one two"), "word! one two");
    }

    @Test(description = "Тестируем строку с пробелами в начале строки")
    public void testDeleteFirstWordFirstSpace() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.deleteFirstWord("  Hello word! one two"), "word! one two");
    }

    @Test(description = "Тестируем не инициализированную строку", expectedExceptions = {StrNullException.class},
            expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testDeleteFirstWordNullStr() throws StrEmptyException, StrNullException {
        Assert.assertNull(StringUtilities.deleteFirstWord(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", expectedExceptions = {StrEmptyException.class},
            expectedExceptionsMessageRegExp = "Пустая строка")
    public void testDeleteFirstWordEmptyStr() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.deleteFirstWord(EMPTY_STR), EMPTY_STR);
    }

    @Test(description = "Тестируем строку с одним словом")
    public void testDeleteFirstWordOneWord() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.deleteFirstWord("Hello"), "Hello");
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordSpaceStr() throws StrEmptyException, StrNullException {
        Assert.assertEquals(StringUtilities.deleteFirstWord(SPACES_STR), SPACES_STR);
    }

    //Тесты для метода isStrEmpty
    @Test(description = "Тестирует выброс сообщения о пустой строке", expectedExceptions = {StrEmptyException.class},
            expectedExceptionsMessageRegExp = "Пустая строка")
    public void testIsStrEmpty() throws StrEmptyException, StrNullException {
        StringUtilities.isStrEmpty(EMPTY_STR);
    }

    @Test(description = "Тестирует строку с текстом")
    public void testIsStrEmptyWithText() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isStrEmpty("один one"));
    }

    @Test(description = "Тестирует строку с первыми и последними пробелами в тексте")
    public void testIsStrEmptyTextWithSpaces() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isStrEmpty("  один one  "));
    }

    @Test(description = "Тестирует строку только с пробелами")
    public void testIsStrEmptyWithSpaces() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isStrEmpty(SPACES_STR));
    }

    @Test(description = "Тестирует не инициализируемую строку", expectedExceptions = {StrNullException.class},
            expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testIsStrEmptyWithNull() throws StrEmptyException, StrNullException {
        StringUtilities.isStrEmpty(NULL_STR);
    }

    //Тесты для метода isStrNull
    @Test(description = "Тестирует ввод пустой строки")
    public void testIsStrNull() throws StrNullException {
        Assert.assertTrue(StringUtilities.isStrNull(EMPTY_STR));
    }

    @Test(description = "Тестирует строку с текстом")
    public void testIsStrNullWithText() throws StrNullException {
        Assert.assertTrue(StringUtilities.isStrNull("один one"));
    }

    @Test(description = "Тестирует строку с первыми и последними пробелами в тексте")
    public void testIsStrNullTextWithSpaces() throws StrNullException {
        Assert.assertTrue(StringUtilities.isStrNull("  один one  "));
    }

    @Test(description = "Тестирует строку только с пробелами")
    public void testIsStrNullWithSpaces() throws StrNullException {
        Assert.assertTrue(StringUtilities.isStrNull(SPACES_STR));
    }

    @Test(description = "Тестирует не инициализируемую строку", expectedExceptions = {StrNullException.class},
            expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testIsStrNullWithNull() throws StrNullException {
        StringUtilities.isStrNull(NULL_STR);
    }
}