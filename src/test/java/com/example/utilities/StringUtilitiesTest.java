package com.example.utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
        assertTrue(StringUtilities.checkWordPalindrome("hiih"));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeFalse() {
        assertFalse(StringUtilities.checkWordPalindrome("hello"));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeNumber() {
        assertTrue(StringUtilities.checkWordPalindrome("1331"));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeNull() {
        assertFalse(StringUtilities.checkWordPalindrome(null));
    }

    @Test(groups = {"checkWordPalindrome"})
    public void testCheckWordPalindromeEmpty() {
        assertFalse(StringUtilities.checkWordPalindrome(""));
    }

    // Тесты для метода checkWordPalindrome
    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharLatin() {
        assertTrue(StringUtilities.checkWordLatinChar("Hello"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharFirstLastSpace() {
        assertTrue(StringUtilities.checkWordLatinChar(" Hello "));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharRusText() {
        assertFalse(StringUtilities.checkWordLatinChar("Привет"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharSpaceStr() {
        assertFalse(StringUtilities.checkWordLatinChar("Hello word"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharStrNumber() {
        assertFalse(StringUtilities.checkWordLatinChar("Hello123"));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharNull() {
        assertFalse(StringUtilities.checkWordLatinChar(null));
    }

    @Test(groups = {"checkWordLatinChar"})
    public void testCheckWordLatinCharEmpty() {
        assertFalse(StringUtilities.checkWordLatinChar(""));
    }

    // Тесты для метода checkStrNullOrEmpty
    @Test(groups = {"checkStrNullOrEmpty"})
    public void testCheckStrNullOrEmptyTrue() {
        assertTrue(StringUtilities.checkStrNullOrEmpty("Hello"));
    }

    @Test(groups = {"checkStrNullOrEmpty"})
    public void testCheckStrNullOrEmptyEmpty() {
        assertFalse(StringUtilities.checkStrNullOrEmpty(""));
    }

    @Test(groups = {"checkStrNullOrEmpty"})
    public void testCheckStrNullOrEmptyNull() {
        assertFalse(StringUtilities.checkStrNullOrEmpty(null));
    }

}