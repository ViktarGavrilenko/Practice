package com.example.utilities;

import com.example.exception.StrEmptyException;
import com.example.exception.StrNullException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class StringUtilitiesTest {
    String NULL_STR = null;
    String EMPTY_STR = "";
    String SPACES_STR = "    ";
    StringUtilities stringUtilities = new StringUtilities();

    // Тесты для метода countTarget
    @Test(description = "Тестируем строку с двумя вхождениями подстроки (русские символы)", groups = {"countTarget"})
    public void testCountTargetRusText() {
        Assert.assertEquals(stringUtilities.countTarget("Слова: один два один", "один"), 2);
    }

    @Test(description = "Тестируем строку с тремя вхождениями подстроки (латинские символы)", groups = {"countTarget"})
    public void testCountTargetLatinText() {
        Assert.assertEquals(stringUtilities.countTarget("Word: one one two three one", "one"), 3);
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"countTarget"})
    public void testCountTargetNullStr() {
        Assert.assertEquals(stringUtilities.countTarget(NULL_STR, "one"), 0);
    }

    @Test(description = "Тестируем пустую строку", groups = {"countTargetStr"})
    public void testCountTargetEmptyStr() {
        Assert.assertEquals(stringUtilities.countTarget(EMPTY_STR, "one"), 0);
    }

    @Test(description = "Тестируем не инициализированную подстроку", groups = {"countTarget"})
    public void testCountTargetNullTarget() {
        Assert.assertEquals(stringUtilities.countTarget("one two three", NULL_STR), 0);
    }

    @Test(description = "Тестируем отсутствие подстроки в строке", groups = {"countTarget"})
    public void testCountTargetNotTarget() {
        Assert.assertEquals(stringUtilities.countTarget("one two three", "four"), 0);
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"countTarget"})
    public void testCountTargetStrSpaces() {
        Assert.assertEquals(stringUtilities.countTarget(SPACES_STR, "four"), 0);
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"countTarget"})
    public void testCountTargetTargetSpaces() {
        Assert.assertEquals(stringUtilities.countTarget("one two three", SPACES_STR), 0);
    }

    // Тесты для метода countWords
    @Test(description = "Тестируем строку с четырьмя русскими словами", groups = {"countWords"})
    public void testCountWordsRusText() {
        Assert.assertEquals(stringUtilities.countWords("Слова: один два один"), 4);
    }

    @Test(description = "Тестируем строку с шестью английскими словами и пробелами вначале и конце строки", groups = {"countWords"})
    public void testCountWordsLatinText() {
        Assert.assertEquals(stringUtilities.countWords(" Word:  one one  two three one "), 6);
    }

    @Test(description = "Тестируем с не инициализированной строкой", groups = {"countWords"})
    public void testCountWordsNullStr() {
        Assert.assertEquals(stringUtilities.countWords(NULL_STR), 0);
    }

    @Test(description = "Тестируем с пустой строкой", groups = {"countWords"})
    public void testCountWordsEmptyStr() {
        Assert.assertEquals(stringUtilities.countWords(EMPTY_STR), 0);
    }

    @Test(description = "Тестируем строку с символами и цифрами", groups = {"countWords"})
    public void testCountWordsDiffStr() {
        Assert.assertEquals(stringUtilities.countWords("132 231 >> // qwe цук"), 6);
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"countWords"})
    public void testCountWordsSpacesStr() {
        Assert.assertEquals(stringUtilities.countWords(SPACES_STR), 0);
    }

    // Тесты для метода isWordPalindrome
    @Test(description = "Тестируем палиндром из латинских символов", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeTrue() {
        Assert.assertTrue(stringUtilities.isWordPalindrome("hiih"));
    }

    @Test(description = "Тестируем строку без палиндрома", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeFalse() {
        Assert.assertFalse(stringUtilities.isWordPalindrome("hello"));
    }

    @Test(description = "Тестируем строку с числовым палиндромам", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeNumber() {
        Assert.assertTrue(stringUtilities.isWordPalindrome("1331"));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeNull() {
        Assert.assertFalse(stringUtilities.isWordPalindrome(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeEmpty() {
        Assert.assertFalse(stringUtilities.isWordPalindrome(EMPTY_STR));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"isWordPalindrome"})
    public void testIsWordPalindromeSpacesStr() {
        Assert.assertFalse(stringUtilities.isWordPalindrome(SPACES_STR));
    }

    // Тесты для метода isWordLatinChar
    @Test(description = "Тестируем не инициализированную строку", groups = {"isWordLatinChar"})
    public void testIsWordLatinChar() {
        Assert.assertTrue(stringUtilities.isWordLatinChar("Hello"));
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharFirstLastSpace() {
        Assert.assertTrue(stringUtilities.isWordLatinChar(" Hello "));
    }

    @Test(description = "Тестируем строку с русскими символами", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharRusText() {
        Assert.assertFalse(stringUtilities.isWordLatinChar("Привет"));
    }

    @Test(description = "Тестируем строку с латинскими словами", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharSpaceStr() {
        Assert.assertFalse(stringUtilities.isWordLatinChar("Hello word"));
    }

    @Test(description = "Тестируем строку с латинскими символами и цифрами", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharStrNumber() {
        Assert.assertFalse(stringUtilities.isWordLatinChar("Hello123"));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharCharNull() {
        Assert.assertFalse(stringUtilities.isWordLatinChar(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharEmpty() {
        Assert.assertFalse(stringUtilities.isWordLatinChar(EMPTY_STR));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"isWordLatinChar"})
    public void testIsWordLatinCharSpacesStr() {
        Assert.assertFalse(stringUtilities.isWordLatinChar(SPACES_STR));
    }

    // Тесты для метода isNullOrEmpty
    @Test(description = "Тестируем строку с латинскими буквами", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptyTrue() {
        Assert.assertTrue(stringUtilities.isNullOrEmpty("Hello"));
    }

    @Test(description = "Тестируем пустую строку", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptyEmpty() {
        Assert.assertFalse(stringUtilities.isNullOrEmpty(EMPTY_STR));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptyNull() {
        Assert.assertFalse(stringUtilities.isNullOrEmpty(NULL_STR));
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptySpacesStr() {
        Assert.assertTrue(stringUtilities.isNullOrEmpty(SPACES_STR));
    }

    // Тесты для метода getFirstWord
    @Test(description = "Тестируем строку с латинскими словами", groups = {"getFirstWord"})
    public void testGetFirstWord() {
        Assert.assertEquals(stringUtilities.getFirstWord("Hello word!"), "Hello");
    }

    @Test(description = "Тестируем строку с пробелами в начале и конце", groups = {"getFirstWord"})
    public void testGetFirstWordFirstSpace() {
        Assert.assertEquals(stringUtilities.getFirstWord(" Hello word! "), "Hello");
    }

    @Test(description = "Тестируем пустую строку", groups = {"getFirstWord"})
    public void testGetFirstWordEmptyStr() {
        Assert.assertNull(stringUtilities.getFirstWord(EMPTY_STR));
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"getFirstWord"})
    public void testGetFirstWordNullStr() {
        Assert.assertNull(stringUtilities.getFirstWord(NULL_STR));
    }

    @Test(description = "Тестируем строку цифрами и символами", groups = {"getFirstWord"})
    public void testGetFirstWordSymbol() {
        Assert.assertEquals(stringUtilities.getFirstWord("11! /* "), "11!");
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"getFirstWord"})
    public void testGetFirstWordSpaceStr() {
        Assert.assertNull(stringUtilities.getFirstWord(SPACES_STR));
    }

    // Тесты для метода deleteFirstWord
    @Test(description = "Тестируем строку английскими словами", groups = {"deleteFirstWord"})
    public void testDeleteFirstWord() {
        Assert.assertEquals(stringUtilities.deleteFirstWord("Hello word! one two"), "word! one two");
    }

    @Test(description = "Тестируем строку с пробелами в начале строки", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordFirstSpace() {
        Assert.assertEquals(stringUtilities.deleteFirstWord("  Hello word! one two"), "word! one two");
    }

    @Test(description = "Тестируем не инициализированную строку", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordNullStr() {
        Assert.assertNull(stringUtilities.deleteFirstWord(NULL_STR));
    }

    @Test(description = "Тестируем пустую строку", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordEmptyStr() {
        Assert.assertEquals(stringUtilities.deleteFirstWord(EMPTY_STR), EMPTY_STR);
    }

    @Test(description = "Тестируем строку с одним словом", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordOneWord() {
        Assert.assertEquals(stringUtilities.deleteFirstWord("Hello"), "Hello");
    }

    @Test(description = "Тестируем строку только с пробелами", groups = {"deleteFirstWord"})
    public void testDeleteFirstWordSpaceStr() {
        Assert.assertEquals(stringUtilities.deleteFirstWord(SPACES_STR), SPACES_STR);
    }

    //Тесты для метода isStrEmpty
    @Test(description = "Тестирует выброс сообщения о пустой строке", groups = {"isStrEmpty"},
            expectedExceptions = {StrEmptyException.class}, expectedExceptionsMessageRegExp = "Пустая строка")
    public void testIsStrEmpty() throws StrEmptyException, StrNullException {
        stringUtilities.isStrEmpty(EMPTY_STR);
    }

    @Test(description = "Тестирует строку с текстом", groups = {"isStrEmpty"})
    public void testIsStrEmptyWithText() throws StrEmptyException, StrNullException {
        Assert.assertTrue(stringUtilities.isStrEmpty("один one"));
    }

    @Test(description = "Тестирует строку с первыми и последними пробелами в тексте", groups = {"isStrEmpty"})
    public void testIsStrEmptyTextWithSpaces() throws StrEmptyException, StrNullException {
        Assert.assertTrue(stringUtilities.isStrEmpty("  один one  "));
    }

    @Test(description = "Тестирует строку только с пробелами", groups = {"isStrEmpty"})
    public void testIsStrEmptyWithSpaces() throws StrEmptyException, StrNullException {
        Assert.assertTrue(stringUtilities.isStrEmpty(SPACES_STR));
    }

    @Test(description = "Тестирует не инициализируемую строку", groups = {"isStrEmpty"},
            expectedExceptions = {StrNullException.class}, expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testIsStrEmptyWithNull() throws StrEmptyException, StrNullException {
        stringUtilities.isStrEmpty(NULL_STR);
    }

    //Тесты для метода isStrNull
    @Test(description = "Тестирует ввод пустой строки", groups = {"isStrNull"})
    public void testIsStrNull() throws StrNullException {
        Assert.assertTrue(stringUtilities.isStrNull(EMPTY_STR));
    }

    @Test(description = "Тестирует строку с текстом", groups = {"isStrNull"})
    public void testIsStrNullWithText() throws StrNullException {
        Assert.assertTrue(stringUtilities.isStrNull("один one"));
    }

    @Test(description = "Тестирует строку с первыми и последними пробелами в тексте", groups = {"isStrNull"})
    public void testIsStrNullTextWithSpaces() throws StrNullException {
        Assert.assertTrue(stringUtilities.isStrNull("  один one  "));
    }

    @Test(description = "Тестирует строку только с пробелами", groups = {"isStrNull"})
    public void testIsStrNullWithSpaces() throws StrNullException {
        Assert.assertTrue(stringUtilities.isStrNull(SPACES_STR));
    }

    @Test(description = "Тестирует не инициализируемую строку", groups = {"isStrNull"},
            expectedExceptions = {StrNullException.class}, expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testIsStrNullWithNull() throws StrNullException {
        stringUtilities.isStrNull(NULL_STR);
    }
}