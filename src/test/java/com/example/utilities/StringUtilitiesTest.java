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
    public void testCountTargetRusText() {
        Assert.assertEquals(StringUtilities.countTarget("Слова: один два один", "один"), 2);
    }

    @Test(description = "Тестируем строку с тремя вхождениями подстроки (латинские символы)")
    public void testCountTargetLatinText() {
        Assert.assertEquals(StringUtilities.countTarget("Word: one one two three one", "one"), 3);
    }

    @Test(description = "Тестируем не инициализированную строку")
    public void testCountTargetNullStr() {
        Assert.assertEquals(StringUtilities.countTarget(NULL_STR, "one"), 0);
    }

    @Test(description = "Тестируем пустую строку")
    public void testCountTargetEmptyStr() {
        Assert.assertEquals(StringUtilities.countTarget(EMPTY_STR, "one"), 0);
    }

    @Test(description = "Тестируем не инициализированную подстроку")
    public void testCountTargetNullTarget() {
        Assert.assertEquals(StringUtilities.countTarget("one two three", NULL_STR), 0);
    }

    @Test(description = "Тестируем отсутствие подстроки в строке")
    public void testCountTargetNotTarget() {
        Assert.assertEquals(StringUtilities.countTarget("one two three", "four"), 0);
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testCountTargetStrSpaces() {
        Assert.assertEquals(StringUtilities.countTarget(SPACES_STR, "four"), 0);
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testCountTargetTargetSpaces() {
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
    public void testIsWordPalindromeTrue() {
        Assert.assertTrue(StringUtilities.isWordPalindrome("hiih"));
    }

    @Test(description = "Тестируем строку без палиндрома")
    public void testIsWordPalindromeFalse() {
        Assert.assertFalse(StringUtilities.isWordPalindrome("hello"));
    }

    @Test(description = "Тестируем строку с числовым палиндромам")
    public void testIsWordPalindromeNumber() {
        Assert.assertTrue(StringUtilities.isWordPalindrome("1331"));
    }

    @Test(description = "Тестируем не инициализированную строку")
    public void testIsWordPalindromeNull() {
        Assert.assertFalse(StringUtilities.isWordPalindrome(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку")
    public void testIsWordPalindromeEmpty() {
        Assert.assertFalse(StringUtilities.isWordPalindrome(EMPTY_STR));
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testIsWordPalindromeSpacesStr() {
        Assert.assertFalse(StringUtilities.isWordPalindrome(SPACES_STR));
    }

    // Тесты для метода isWordLatinChar
    @Test(description = "Тестируем не инициализированную строку")
    public void testIsWordLatinChar() {
        Assert.assertTrue(StringUtilities.isWordLatinChar("Hello"));
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце")
    public void testIsWordLatinCharFirstLastSpace() {
        Assert.assertTrue(StringUtilities.isWordLatinChar(" Hello "));
    }

    @Test(description = "Тестируем строку с русскими символами")
    public void testIsWordLatinCharRusText() {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Привет"));
    }

    @Test(description = "Тестируем строку с латинскими словами")
    public void testIsWordLatinCharSpaceStr() {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Hello word"));
    }

    @Test(description = "Тестируем строку с латинскими символами и цифрами")
    public void testIsWordLatinCharStrNumber() {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Hello123"));
    }

    @Test(description = "Тестируем не инициализированную строку")
    public void testIsWordLatinCharCharNull() {
        Assert.assertFalse(StringUtilities.isWordLatinChar(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку")
    public void testIsWordLatinCharEmpty() {
        Assert.assertFalse(StringUtilities.isWordLatinChar(EMPTY_STR));
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testIsWordLatinCharSpacesStr() {
        Assert.assertFalse(StringUtilities.isWordLatinChar(SPACES_STR));
    }

    // Тесты для метода isNullOrEmpty
    @Test(description = "Тестируем строку с латинскими буквами")
    public void testIsNullOrEmptyTrue() {
        Assert.assertTrue(StringUtilities.isNullOrEmpty("Hello"));
    }

    @Test(description = "Тестируем пустую строку")
    public void testIsNullOrEmptyEmpty() {
        Assert.assertFalse(StringUtilities.isNullOrEmpty(EMPTY_STR));
    }

    @Test(description = "Тестируем не инициализированную строку")
    public void testIsNullOrEmptyNull() {
        Assert.assertFalse(StringUtilities.isNullOrEmpty(NULL_STR));
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testIsNullOrEmptySpacesStr() {
        Assert.assertTrue(StringUtilities.isNullOrEmpty(SPACES_STR));
    }

    // Тесты для метода getFirstWord
    @Test(description = "Тестируем строку с латинскими словами")
    public void testGetFirstWord() {
        Assert.assertEquals(StringUtilities.getFirstWord("Hello word!"), "Hello");
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце")
    public void testGetFirstWordFirstSpace() {
        Assert.assertEquals(StringUtilities.getFirstWord(" Hello word! "), "Hello");
    }

    @Test(description = "Тестируем пустую строку")
    public void testGetFirstWordEmptyStr() {
        Assert.assertNull(StringUtilities.getFirstWord(EMPTY_STR));
    }

    @Test(description = "Тестируем не инициализированную строку")
    public void testGetFirstWordNullStr() {
        Assert.assertNull(StringUtilities.getFirstWord(NULL_STR));
    }

    @Test(description = "Тестируем строку цифрами и символами")
    public void testGetFirstWordSymbol() {
        Assert.assertEquals(StringUtilities.getFirstWord("11! /* "), "11!");
    }

    @Test(description = "Тестируем строку только с пробелами")
    public void testGetFirstWordSpaceStr() {
        Assert.assertNull(StringUtilities.getFirstWord(SPACES_STR));
    }

    // Тесты для метода deleteFirstWord
    @Test(description = "Тестируем строку английскими словами")
    public void testDeleteFirstWord() {
        Assert.assertEquals(StringUtilities.deleteFirstWord("Hello word! one two"), "word! one two");
    }

    @Test(description = "Тестируем строку с пробелами в начале строки")
    public void testDeleteFirstWordFirstSpace() {
        Assert.assertEquals(StringUtilities.deleteFirstWord("  Hello word! one two"), "word! one two");
    }

    @Test(description = "Тестируем не инициализированную строку")
    public void testDeleteFirstWordNullStr() {
        Assert.assertNull(StringUtilities.deleteFirstWord(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку")
    public void testDeleteFirstWordEmptyStr() {
        Assert.assertEquals(StringUtilities.deleteFirstWord(EMPTY_STR), EMPTY_STR);
    }

    @Test(description = "Тестируем строку с одним словом")
    public void testDeleteFirstWordOneWord() {
        Assert.assertEquals(StringUtilities.deleteFirstWord("Hello"), "Hello");
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordSpaceStr() {
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