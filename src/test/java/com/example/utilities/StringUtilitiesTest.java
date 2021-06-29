package com.example.utilities;

import com.example.exception.StrEmptyException;
import com.example.exception.StrNullException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class StringUtilitiesTest {
    String NULL_STR = null;
    String EMPTY_STR = "";
    String SPACES_STR = "    ";

    // Тесты для метода getAverageArray
    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrRusText() {
        Assert.assertEquals(2, StringUtilities.countTarget("Слова: один два один", "один"));
    }

    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrLatinText() {
        Assert.assertEquals(3, StringUtilities.countTarget("Word: one one two three one", "one"));
    }

    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrNullStr() {
        Assert.assertEquals(0, StringUtilities.countTarget(NULL_STR, "one"));
    }

    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrEmptyStr() {
        Assert.assertEquals(0, StringUtilities.countTarget(EMPTY_STR, "one"));
    }

    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrNullTarget() {
        Assert.assertEquals(0, StringUtilities.countTarget("one two three", NULL_STR));
    }

    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrNotTarget() {
        Assert.assertEquals(0, StringUtilities.countTarget("one two three", "four"));
    }

    // Тесты для метода getAverageArray
    @Test(groups = {"countWordsInStr"})
    public void testCountWordsInStRusText() {
        Assert.assertEquals(4, StringUtilities.countWords("Слова: один два один"));
    }

    @Test(groups = {"countWordsInStr"})
    public void testCountWordsInStLatinText() {
        Assert.assertEquals(6, StringUtilities.countWords(" Word:  one one  two three one "));
    }

    @Test(groups = {"countWordsInStr"})
    public void testCountWordsInStNullStr() {
        Assert.assertEquals(0, StringUtilities.countWords(NULL_STR));
    }

    @Test(groups = {"countWordsInStr"})
    public void testCountWordsInStEmptyStr() {
        Assert.assertEquals(0, StringUtilities.countWords(EMPTY_STR));
    }

    @Test(groups = {"countWordsInStr"})
    public void testCountWordsInStDiffStr() {
        Assert.assertEquals(6, StringUtilities.countWords("132 231 >> // qwe цук"));
    }

    // Тесты для метода checkWordPalindrome
    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeTrue() {
        Assert.assertTrue(StringUtilities.isWordPalindrome("hiih"));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeFalse() {
        Assert.assertFalse(StringUtilities.isWordPalindrome("hello"));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeNumber() {
        Assert.assertTrue(StringUtilities.isWordPalindrome("1331"));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeNull() {
        Assert.assertFalse(StringUtilities.isWordPalindrome(NULL_STR));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeEmpty() {
        Assert.assertFalse(StringUtilities.isWordPalindrome(EMPTY_STR));
    }

    // Тесты для метода checkWordPalindrome
    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharLatin() {
        Assert.assertTrue(StringUtilities.isWordLatinChar("Hello"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharFirstLastSpace() {
        Assert.assertTrue(StringUtilities.isWordLatinChar(" Hello "));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharRusText() {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Привет"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharSpaceStr() {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Hello word"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharStrNumber() {
        Assert.assertFalse(StringUtilities.isWordLatinChar("Hello123"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharNull() {
        Assert.assertFalse(StringUtilities.isWordLatinChar(NULL_STR));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharEmpty() {
        Assert.assertFalse(StringUtilities.isWordLatinChar(EMPTY_STR));
    }

    // Тесты для метода checkStrNullOrEmpty
    @Test(groups = {"checkStrNullOrEmpty"})
    public void testCheckStrNullOrEmptyTrue() {
        Assert.assertTrue(StringUtilities.isNullOrEmpty("Hello"));
    }

    @Test(groups = {"checkStrNullOrEmpty"})
    public void testCheckStrNullOrEmptyEmpty() {
        Assert.assertFalse(StringUtilities.isNullOrEmpty(EMPTY_STR));
    }

    @Test(groups = {"checkStrNullOrEmpty"})
    public void testCheckStrNullOrEmptyNull() {
        Assert.assertFalse(StringUtilities.isNullOrEmpty(NULL_STR));
    }

    // Тесты для метода getFirstWordStr
    @Test(groups = {"getFirstWordStr"})
    public void testGetFirstWordStr() {
        Assert.assertEquals("Hello", StringUtilities.getFirstWord("Hello word!"));
    }

    @Test(groups = {"getFirstWordStr"})
    public void testGetFirstWordStrFirstSpace() {
        Assert.assertEquals("Hello", StringUtilities.getFirstWord(" Hello word! "));
    }

    @Test(groups = {"getFirstWordStr"})
    public void testGetFirstWordStrEmptyStr() {
        Assert.assertNull(StringUtilities.getFirstWord(EMPTY_STR));
    }

    @Test(groups = {"getFirstWordStr"})
    public void testGetFirstWordStrNullStr() {
        Assert.assertNull(StringUtilities.getFirstWord(NULL_STR));
    }

    @Test(groups = {"getFirstWordStr"})
    public void testGetFirstWordStrSymbol() {
        Assert.assertEquals("11!", StringUtilities.getFirstWord("11! /* "));
    }

    // Тесты для метода getFirstWordStr
    @Test(groups = {"deleteFirstWordStr"})
    public void testDeleteFirstWordStr() {
        Assert.assertEquals("word! one two", StringUtilities.deleteFirstWord("Hello word! one two"));
    }

    @Test(groups = {"deleteFirstWordStr"})
    public void testDeleteFirstWordStrFirstSpace() {
        Assert.assertEquals("word! one two", StringUtilities.deleteFirstWord("  Hello word! one two"));
    }

    @Test(groups = {"deleteFirstWordStr"})
    public void testDeleteFirstWordStrNullStr() {
        Assert.assertNull(StringUtilities.deleteFirstWord(NULL_STR));
    }

    @Test(groups = {"deleteFirstWordStr"})
    public void testDeleteFirstWordStrEmptyStr() {
        Assert.assertEquals(EMPTY_STR, StringUtilities.deleteFirstWord(EMPTY_STR));
    }

    @Test(groups = {"deleteFirstWordStr"})
    public void testDeleteFirstWordStrOneWord() {
        Assert.assertEquals("Hello", StringUtilities.deleteFirstWord("Hello"));
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