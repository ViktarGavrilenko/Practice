package com.example.utilities;

import org.testng.Assert;
import org.testng.annotations.Test;


public class StringUtilitiesTest {
    // Тесты для метода getAverageArray
    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrRusText() {
        Assert.assertEquals(2, StringUtilities.countTargetStr("Слова: один два один", "один"));
    }

    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrLatinText() {
        Assert.assertEquals(3, StringUtilities.countTargetStr("Word: one one two three one", "one"));
    }

    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrNullStr() {
        Assert.assertEquals(0, StringUtilities.countTargetStr(null, "one"));
    }

    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrEmptyStr() {
        Assert.assertEquals(0, StringUtilities.countTargetStr("", "one"));
    }

    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrNullTarget() {
        Assert.assertEquals(0, StringUtilities.countTargetStr("one two three", null));
    }

    @Test(groups = {"countTargetStr"})
    public void testCountTargetStrNotTarget() {
        Assert.assertEquals(0, StringUtilities.countTargetStr("one two three", "four"));
    }

    // Тесты для метода getAverageArray
    @Test(groups = {"countWordsInStr"})
    public void testCountWordsInStRusText() {
        Assert.assertEquals(4, StringUtilities.countWordsInStr("Слова: один два один"));
    }

    @Test(groups = {"countWordsInStr"})
    public void testCountWordsInStLatinText() {
        Assert.assertEquals(6, StringUtilities.countWordsInStr(" Word:  one one  two three one "));
    }

    @Test(groups = {"countWordsInStr"})
    public void testCountWordsInStNullStr() {
        Assert.assertEquals(0, StringUtilities.countWordsInStr(null));
    }

    @Test(groups = {"countWordsInStr"})
    public void testCountWordsInStEmptyStr() {
        Assert.assertEquals(0, StringUtilities.countWordsInStr(""));
    }

    @Test(groups = {"countWordsInStr"})
    public void testCountWordsInStDiffStr() {
        Assert.assertEquals(6, StringUtilities.countWordsInStr("132 231 >> // qwe цук"));
    }

    // Тесты для метода checkWordPalindrome
    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeTrue() {
        Assert.assertTrue(StringUtilities.checkWordPalindrome("hiih"));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeFalse() {
        Assert.assertFalse(StringUtilities.checkWordPalindrome("hello"));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeNumber() {
        Assert.assertTrue(StringUtilities.checkWordPalindrome("1331"));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeNull() {
        Assert.assertFalse(StringUtilities.checkWordPalindrome(null));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeEmpty() {
        Assert.assertFalse(StringUtilities.checkWordPalindrome(""));
    }

    // Тесты для метода checkWordPalindrome
    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharLatin() {
        Assert.assertTrue(StringUtilities.checkWordLatinChar("Hello"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharFirstLastSpace() {
        Assert.assertTrue(StringUtilities.checkWordLatinChar(" Hello "));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharRusText() {
        Assert.assertFalse(StringUtilities.checkWordLatinChar("Привет"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharSpaceStr() {
        Assert.assertFalse(StringUtilities.checkWordLatinChar("Hello word"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharStrNumber() {
        Assert.assertFalse(StringUtilities.checkWordLatinChar("Hello123"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharNull() {
        Assert.assertFalse(StringUtilities.checkWordLatinChar(null));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharEmpty() {
        Assert.assertFalse(StringUtilities.checkWordLatinChar(""));
    }

    // Тесты для метода checkStrNullOrEmpty
    @Test(groups = {"checkStrNullOrEmpty"})
    public void testCheckStrNullOrEmptyTrue() {
        Assert.assertTrue(StringUtilities.checkStrNullOrEmpty("Hello"));
    }

    @Test(groups = {"checkStrNullOrEmpty"})
    public void testCheckStrNullOrEmptyEmpty() {
        Assert.assertFalse(StringUtilities.checkStrNullOrEmpty(""));
    }

    @Test(groups = {"checkStrNullOrEmpty"})
    public void testCheckStrNullOrEmptyNull() {
        Assert.assertFalse(StringUtilities.checkStrNullOrEmpty(null));
    }

    // Тесты для метода getFirstWordStr
    @Test(groups = {"getFirstWordStr"})
    public void testGetFirstWordStr() {
        Assert.assertEquals("Hello", StringUtilities.getFirstWordStr("Hello word!"));
    }

    @Test(groups = {"getFirstWordStr"})
    public void testGetFirstWordStrFirstSpace() {
        Assert.assertEquals("Hello", StringUtilities.getFirstWordStr(" Hello word! "));
    }

    @Test(groups = {"getFirstWordStr"})
    public void testGetFirstWordStrEmptyStr() {
        Assert.assertNull(StringUtilities.getFirstWordStr(""));
    }

    @Test(groups = {"getFirstWordStr"})
    public void testGetFirstWordStrNullStr() {
        Assert.assertNull(StringUtilities.getFirstWordStr(null));
    }

    @Test(groups = {"getFirstWordStr"})
    public void testGetFirstWordStrSymbol() {
        Assert.assertEquals("11!", StringUtilities.getFirstWordStr("11! /* "));
    }

    // Тесты для метода getFirstWordStr
    @Test(groups = {"deleteFirstWordStr"})
    public void testDeleteFirstWordStr() {
        Assert.assertEquals("word! one two", StringUtilities.deleteFirstWordStr("Hello word! one two"));
    }

    @Test(groups = {"deleteFirstWordStr"})
    public void testDeleteFirstWordStrFirstSpace() {
        Assert.assertEquals("word! one two", StringUtilities.deleteFirstWordStr("  Hello word! one two"));
    }

    @Test(groups = {"deleteFirstWordStr"})
    public void testDeleteFirstWordStrNullStr() {
        Assert.assertNull(StringUtilities.deleteFirstWordStr(null));
    }

    @Test(groups = {"deleteFirstWordStr"})
    public void testDeleteFirstWordStrEmptyStr() {
        Assert.assertEquals("", StringUtilities.deleteFirstWordStr(""));
    }

    @Test(groups = {"deleteFirstWordStr"})
    public void testDeleteFirstWordStrOneWord() {
        Assert.assertEquals("Hello", StringUtilities.deleteFirstWordStr("Hello"));
    }
}