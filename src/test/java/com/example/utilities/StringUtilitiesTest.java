package com.example.utilities;

import com.example.exception.StrEmptyException;
import com.example.exception.StrNullException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class StringUtilitiesTest {
    String NULL_STR = null;
    String EMPTY_STR = "";
    String SPACES_STR = "    ";

    // Тесты для метода countTarget
    @Test(description = "Тестируем строку с двумя вхождениями подстроки (русские символы)", groups = {"countTarget"})
    public void testCountTargetRusText() {
        Assert.assertEquals(2, StringUtilities.countTarget("Слова: один два один", "один"));
    }

    @Test(description = "Тестируем строку с тремя вхождениями подстроки (латинские символы)", groups = {"countTarget"})
    public void testCountTargetLatinText() {
        Assert.assertEquals(3, StringUtilities.countTarget("Word: one one two three one", "one"));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"countTarget"})
    public void testCountTargetNullStr() {
        Assert.assertEquals(0, StringUtilities.countTarget(NULL_STR, "one"));
    }

    @Test(description = "Тестируем пустую строку", groups = {"countTargetStr"})
    public void testCountTargetEmptyStr() {
        Assert.assertEquals(0, StringUtilities.countTarget(EMPTY_STR, "one"));
    }

    @Test(description = "Тестируем не инициализированную подстроку", groups = {"countTarget"})
    public void testCountTargetNullTarget() {
        Assert.assertEquals(0, StringUtilities.countTarget("one two three", NULL_STR));
    }

    @Test(description = "Тестируем отсутствие подстроки в строке", groups = {"countTarget"})
    public void testCountTargetNotTarget() {
        Assert.assertEquals(0, StringUtilities.countTarget("one two three", "four"));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"countTarget"})
    public void testCountTargetStrSpaces() {
        Assert.assertEquals(0, StringUtilities.countTarget(SPACES_STR, "four"));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"countTarget"})
    public void testCountTargetTargetSpaces() {
        Assert.assertEquals(0, StringUtilities.countTarget("one two three", SPACES_STR));
    }

    // Тесты для метода countWords
    @Test(description = "Тестируем строку с четырьмя русскими словами", groups = {"countWords"})
    public void testCountWordsRusText() {
        Assert.assertEquals(4, StringUtilities.countWords("Слова: один два один"));
    }

    @Test(description = "Тестируем строку с шестью английскими словами и пробелами вначале и конце строки", groups = {"countWords"})
    public void testCountWordsLatinText() {
        Assert.assertEquals(6, StringUtilities.countWords(" Word:  one one  two three one "));
    }

    @Test(description = "Тестируем с не инициализированной строкой", groups = {"countWords"})
    public void testCountWordsNullStr() {
        Assert.assertEquals(0, StringUtilities.countWords(NULL_STR));
    }

    @Test(description = "Тестируем с пустой строкой", groups = {"countWords"})
    public void testCountWordsEmptyStr() {
        Assert.assertEquals(0, StringUtilities.countWords(EMPTY_STR));
    }

    @Test(description = "Тестируем строку с символами и цифрами", groups = {"countWords"})
    public void testCountWordsDiffStr() {
        Assert.assertEquals(6, StringUtilities.countWords("132 231 >> // qwe цук"));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"countWords"})
    public void testCountWordsSpacesStr() {
        Assert.assertEquals(0, StringUtilities.countWords(SPACES_STR));
    }

    // Тесты для метода isWordPalindrome
    @Test(description = "Тестируем палиндром из латинских символов", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeTrue() {
        Assert.assertTrue(StringUtilities.isWordPalindrome("hiih"));
    }

    @Test(description = "Тестируем строку без палиндрома", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeFalse() {
        Assert.assertFalse(StringUtilities.isWordPalindrome("hello"));
    }

    @Test(description = "Тестируем строку с числовым палиндромам", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeNumber() {
        Assert.assertTrue(StringUtilities.isWordPalindrome("1331"));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeNull() {
        Assert.assertFalse(StringUtilities.isWordPalindrome(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeEmpty() {
        Assert.assertFalse(StringUtilities.isWordPalindrome(EMPTY_STR));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeSpacesStr() {
        Assert.assertFalse(StringUtilities.isWordPalindrome(SPACES_STR));
    }

    // Тесты для метода isWordLatinChar
    @Test(description = "Тестируем не инициализированную строку", groups = {"isWordLatinChar"})
    public void testIsWordLatinChar() {
        Assert.assertTrue(StringUtilities.isWordLatinChar("Hello"));
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharFirstLastSpace() {
        Assert.assertTrue(StringUtilities.isWordLatinChar(" Hello "));
    }

    @Test(description = "Тестируем строку с русскими символами", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharRusText() {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Привет"));
    }

    @Test(description = "Тестируем строку с латинскими словами", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharSpaceStr() {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Hello word"));
    }

    @Test(description = "Тестируем строку с латинскими символами и цифрами", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharStrNumber() {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Hello123"));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharCharNull() {
        Assert.assertFalse(StringUtilities.isWordLatinChar(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharEmpty() {
        Assert.assertFalse(StringUtilities.isWordLatinChar(EMPTY_STR));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharSpacesStr() {
        Assert.assertFalse(StringUtilities.isWordLatinChar(SPACES_STR));
    }

    // Тесты для метода isNullOrEmpty
    @Test(description = "Тестируем строку с латинскими буквами", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptyTrue() {
        Assert.assertTrue(StringUtilities.isNullOrEmpty("Hello"));
    }

    @Test(description = "Тестируем пустую строку", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptyEmpty() {
        Assert.assertFalse(StringUtilities.isNullOrEmpty(EMPTY_STR));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptyNull() {
        Assert.assertFalse(StringUtilities.isNullOrEmpty(NULL_STR));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptySpacesStr() {
        Assert.assertTrue(StringUtilities.isNullOrEmpty(SPACES_STR));
    }

    // Тесты для метода getFirstWord
    @Test(description = "Тестируем строку с латинскими словами", groups = {"getFirstWord"})
    public void testGetFirstWord() {
        Assert.assertEquals("Hello", StringUtilities.getFirstWord("Hello word!"));
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце", groups = {"getFirstWord"})
    public void testGetFirstWordFirstSpace() {
        Assert.assertEquals("Hello", StringUtilities.getFirstWord(" Hello word! "));
    }

    @Test(description = "Тестируем пустую строку", groups = {"getFirstWord"})
    public void testGetFirstWordEmptyStr() {
        Assert.assertNull(StringUtilities.getFirstWord(EMPTY_STR));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"getFirstWord"})
    public void testGetFirstWordNullStr() {
        Assert.assertNull(StringUtilities.getFirstWord(NULL_STR));
    }

    @Test(description = "Тестируем строку цифрами и символами", groups = {"getFirstWord"})
    public void testGetFirstWordSymbol() {
        Assert.assertEquals("11!", StringUtilities.getFirstWord("11! /* "));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"getFirstWord"})
    public void testGetFirstWordSpaceStr() {
        Assert.assertNull(StringUtilities.getFirstWord(SPACES_STR));
    }

    // Тесты для метода deleteFirstWord
    @Test(description = "Тестируем строку английскими словами", groups = {"deleteFirstWord"})
    public void testDeleteFirstWord() {
        Assert.assertEquals("word! one two", StringUtilities.deleteFirstWord("Hello word! one two"));
    }

    @Test(description = "Тестируем строку с пробелами в начале строки", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordFirstSpace() {
        Assert.assertEquals("word! one two", StringUtilities.deleteFirstWord("  Hello word! one two"));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordNullStr() {
        Assert.assertNull(StringUtilities.deleteFirstWord(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordEmptyStr() {
        Assert.assertEquals(EMPTY_STR, StringUtilities.deleteFirstWord(EMPTY_STR));
    }

    @Test(description = "Тестируем строку с одним словом", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordOneWord() {
        Assert.assertEquals("Hello", StringUtilities.deleteFirstWord("Hello"));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordSpaceStr() {
        Assert.assertEquals(SPACES_STR, StringUtilities.deleteFirstWord(SPACES_STR));
    }

    //Тесты для метода isStrEmpty
    @Test(description = "Тестирует выброс сообщения о пустой строке", groups = {"isStrEmpty"},
            expectedExceptions = {StrEmptyException.class}, expectedExceptionsMessageRegExp = "Пустая строка")
    public void testIsStrEmpty() throws StrEmptyException, StrNullException {
        StringUtilities.isStrEmpty(EMPTY_STR);
    }

    @Test(description = "Тестирует строку с текстом", groups = {"isStrEmpty"})
    public void testIsStrEmptyWithText() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isStrEmpty("один one"));
    }

    @Test(description = "Тестирует строку с первыми и последними пробелами в тексте", groups = {"isStrEmpty"})
    public void testIsStrEmptyTextWithSpaces() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isStrEmpty("  один one  "));
    }

    @Test(description = "Тестирует строку только с пробелами", groups = {"isStrEmpty"})
    public void testIsStrEmptyWithSpaces() throws StrEmptyException, StrNullException {
        Assert.assertTrue(StringUtilities.isStrEmpty(SPACES_STR));
    }

    @Test(description = "Тестирует не инициализируемую строку", groups = {"isStrEmpty"},
            expectedExceptions = {StrNullException.class}, expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testIsStrEmptyWithNull() throws StrEmptyException, StrNullException {
        StringUtilities.isStrEmpty(NULL_STR);
    }

    //Тесты для метода isStrNull
    @Test(description = "Тестирует ввод пустой строки", groups = {"isStrNull"})
    public void testIsStrNull() throws StrNullException {
        Assert.assertTrue(StringUtilities.isStrNull(EMPTY_STR));
    }

    @Test(description = "Тестирует строку с текстом", groups = {"isStrNull"})
    public void testIsStrNullWithText() throws StrNullException {
        Assert.assertTrue(StringUtilities.isStrNull("один one"));
    }

    @Test(description = "Тестирует строку с первыми и последними пробелами в тексте", groups = {"isStrNull"})
    public void testIsStrNullTextWithSpaces() throws StrNullException {
        Assert.assertTrue(StringUtilities.isStrNull("  один one  "));
    }

    @Test(description = "Тестирует строку только с пробелами", groups = {"isStrNull"})
    public void testIsStrNullWithSpaces() throws StrNullException {
        Assert.assertTrue(StringUtilities.isStrNull(SPACES_STR));
    }

    @Test(description = "Тестирует не инициализируемую строку", groups = {"isStrNull"},
            expectedExceptions = {StrNullException.class}, expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testIsStrNullWithNull() throws StrNullException {
        StringUtilities.isStrNull(NULL_STR);
    }

}