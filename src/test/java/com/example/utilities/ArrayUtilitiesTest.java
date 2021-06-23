package com.example.utilities;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayUtilitiesTest {

    // Тесты для метода getAverageArray
    @Test(groups = {"getAverageArray"})
    public void testGetAverageArrayResultInt() {
        Assert.assertEquals(3, ArrayUtilities.getAverageArray(new int[]{2, 2, 5}));
    }

    @Test(groups = {"getAverageArray"})
    public void testGetAverageArrayEmpty() {
        Assert.assertEquals(0, ArrayUtilities.getAverageArray(new int[5]));
    }

    @Test(groups = {"getAverageArray"})
    public void testGetAverageArrayResultFloat() {
        Assert.assertEquals(2.5, ArrayUtilities.getAverageArray(new int[]{2, 3, 5, 0}));
    }

    @Test(groups = {"getAverageArray"})
    public void testGetAverageArrayNull() {
        Assert.assertEquals(0, ArrayUtilities.getAverageArray(new int[]{}));
    }

    @Test(groups = {"getAverageArray"})
    public void testGetAverageArrayResultNegative() {
        Assert.assertEquals(-13, ArrayUtilities.getAverageArray(new int[]{-1, -35, -3}));
    }

    // Тесты для метода getMaxValueArray
    @Test(groups = {"getMaxValueArray"})
    public void testGetMaxValueArrayPositive() {
        Assert.assertEquals(50, ArrayUtilities.getMaxValueArray(new int[]{2, 3, 50}));
    }

    @Test(groups = {"getMaxValueArray"})
    public void testGetMaxValueArrayNegative() {
        Assert.assertEquals(-1, ArrayUtilities.getMaxValueArray(new int[]{-1, -35, -3}));
    }

    @Test(groups = {"getMaxValueArray"})
    public void testGetMaxValueArrayNegativePositive() {
        Assert.assertEquals(7, ArrayUtilities.getMaxValueArray(new int[]{-1, -35, -3, 3, 7, 0}));
    }

    @Test(groups = {"getMaxValueArray"})
    public void testGetMaxValueArrayNull() {
        Assert.assertEquals(0, ArrayUtilities.getMaxValueArray(new int[]{}));
    }

    @Test(groups = {"getMaxValueArray"})
    public void testGetMaxValueArrayEmpty() {
        Assert.assertEquals(0, ArrayUtilities.getMaxValueArray(new int[3]));
    }

    // Тесты для метода getMinValueArray
    @Test(groups = {"getMinValueArray"})
    public void testGetMinValueArrayPositive() {
        Assert.assertEquals(2, ArrayUtilities.getMinValueArray(new int[]{2, 3, 50}));
    }

    @Test(groups = {"getMinValueArray"})
    public void testGetMinValueArrayNegative() {
        Assert.assertEquals(-35, ArrayUtilities.getMinValueArray(new int[]{-1, -35, -3}));
    }

    @Test(groups = {"getMinValueArray"})
    public void testGetMinValueArrayNegativePositive() {
        Assert.assertEquals(-35, ArrayUtilities.getMinValueArray(new int[]{-1, -35, -3, 3, 7, 0}));
    }

    @Test(groups = {"getMinValueArray"})
    public void testGetMinValueArrayNull() {
        Assert.assertEquals(0, ArrayUtilities.getMinValueArray(new int[]{}));
    }

    @Test(groups = {"getMinValueArray"})
    public void testGetMinValueArrayEmpty() {
        Assert.assertEquals(0, ArrayUtilities.getMinValueArray(new int[3]));
    }

    // Тесты для метода getFirstIndexOfArrayGivenValue
    @Test(groups = {"getFirstIndexOfArrayGivenValue"})
    public void testGetFirstIndexOfArrayGivenValuePositiveNegative() {
        Assert.assertEquals(2, ArrayUtilities.getFirstIndexOfArrayGivenValue(new int[]{-3, 4, -5}, -5));
    }

    @Test(groups = {"getFirstIndexOfArrayGivenValue"})
    public void testGetFirstIndexOfArrayGivenValueNegative() {
        Assert.assertEquals(-1, ArrayUtilities.getFirstIndexOfArrayGivenValue(new int[5], -6));
    }

    @Test(groups = {"getFirstIndexOfArrayGivenValue"})
    public void testGetFirstIndexOfArrayGivenValueNotFound() {
        Assert.assertEquals(-1, ArrayUtilities.getFirstIndexOfArrayGivenValue(new int[]{3, 4, 5, 6}, 10));
    }

    @Test(groups = {"getFirstIndexOfArrayGivenValue"})
    public void testGetFirstIndexOfArrayGivenValueRepeatValue() {
        Assert.assertEquals(1, ArrayUtilities.getFirstIndexOfArrayGivenValue(new int[]{3, 4, 4, 4}, 4));
    }

    @Test(groups = {"getFirstIndexOfArrayGivenValue"})
    public void testGetFirstIndexOfArrayGivenValueNull() {
        Assert.assertEquals(-1, ArrayUtilities.getFirstIndexOfArrayGivenValue(new int[]{}, 4));
    }

    // Тесты для метода getLastIndexOfArrayGivenValue
    @Test(groups = {"getLastIndexOfArrayGivenValue"})
    public void testGetLastIndexOfArrayGivenValuePositiveNegative() {
        Assert.assertEquals(0, ArrayUtilities.getLastIndexOfArrayGivenValue(new int[]{-3, 4, -5}, -3));
    }

    @Test(groups = {"getLastIndexOfArrayGivenValue"})
    public void testGetLastIndexOfArrayGivenValueNegative() {
        Assert.assertEquals(-1, ArrayUtilities.getLastIndexOfArrayGivenValue(new int[5], -6));
    }

    @Test(groups = {"getLastIndexOfArrayGivenValue"})
    public void testGetLastIndexOfArrayGivenValueNotFound() {
        Assert.assertEquals(-1, ArrayUtilities.getLastIndexOfArrayGivenValue(new int[]{3, 4, 5, 6}, 10));
    }

    @Test(groups = {"getLastIndexOfArrayGivenValue"})
    public void testGetLastIndexOfArrayGivenValueRepeatValue() {
        Assert.assertEquals(3, ArrayUtilities.getLastIndexOfArrayGivenValue(new int[]{3, 4, 4, 4}, 4));
    }

    @Test(groups = {"getLastIndexOfArrayGivenValue"})
    public void testGetLastIndexOfArrayGivenValueNull() {
        Assert.assertEquals(-1, ArrayUtilities.getLastIndexOfArrayGivenValue(new int[]{}, 4));
    }

    // Тесты для метода getSumElementsArray
    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayFirstMinLastMax() {
        Assert.assertEquals(9, ArrayUtilities.getSumElementsArray(new int[]{1, -5, 9, 7, 3}, 1,
                3));
    }

    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayFirstMaxLastMin() {
        Assert.assertEquals(7, ArrayUtilities.getSumElementsArray(new int[]{1, 5, -9, 7, 3}, 4,
                2));
    }

    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayFirstOutside() {
        Assert.assertEquals(0, ArrayUtilities.getSumElementsArray(new int[]{1, 5, 9, 7, 3}, -3,
                2));
    }

    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayLastOutside() {
        Assert.assertEquals(0, ArrayUtilities.getSumElementsArray(new int[]{1, 5, 9, 7, 3}, 2,
                22));
    }

    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayFirstEquallyLast() {
        Assert.assertEquals(0, ArrayUtilities.getSumElementsArray(new int[]{1, 5, 9, 7, 3}, 2,
                2));
    }

    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayNull() {
        Assert.assertEquals(0, ArrayUtilities.getSumElementsArray(new int[]{}, 2, 3));
    }

    // Тесты для метода checkArrayNullOrEmpty
    @Test(groups = {"checkArrayNullOrEmpty"})
    public void testCheckArrayNullOrEmptyNull() {
        Assert.assertFalse(ArrayUtilities.checkArrayNullOrEmpty(new int[]{}));
    }

    @Test(groups = {"checkArrayNullOrEmpty"})
    public void testCheckArrayNullOrEmptyEmpty() {
        Assert.assertFalse(ArrayUtilities.checkArrayNullOrEmpty(new int[0]));
    }

    @Test(groups = {"checkArrayNullOrEmpty"})
    public void testCheckArrayNullOrEmptyWithValue() {
        Assert.assertTrue(ArrayUtilities.checkArrayNullOrEmpty(new int[]{2, 3, 5, -6}));
    }

    @Test(groups = {"checkArrayNullOrEmpty"})
    public void testCheckArrayNullOrEmptyTwoDimensionalNull() {
        Assert.assertFalse(ArrayUtilities.checkArrayNullOrEmpty(new int[][]{}));
    }

    @Test(groups = {"checkArrayNullOrEmpty"})
    public void testCheckArrayNullOrEmptyTwoDimensionalEmpty() {
        Assert.assertFalse(ArrayUtilities.checkArrayNullOrEmpty(new int[2][0]));
    }

    // Тесты для метода checkNumberLimitValueArray
    @Test(groups = {"checkNumberLimitValueArray"})
    public void testCheckNumberLimitValueArrayOutside() {
        Assert.assertFalse(ArrayUtilities.checkNumberLimitValueArray(new int[2], 5));
    }

    @Test(groups = {"checkNumberLimitValueArray"})
    public void testCheckNumberLimitValueArrayWithin() {
        Assert.assertTrue(ArrayUtilities.checkNumberLimitValueArray(new int[]{5, 3, 9, 10}, 2));
    }

    @Test(groups = {"checkNumberLimitValueArray"})
    public void testCheckNumberLimitValueArrayNull() {
        Assert.assertFalse(ArrayUtilities.checkNumberLimitValueArray(new int[]{}, 1));
    }
}
