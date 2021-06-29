package com.example.utilities;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayNullException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayUtilitiesTest {

    int[] NULL_ARRAY = null;
    int[] EMPTY_ARRAY = new int[]{};

    // Тесты для метода getAverageArray
    @Test(groups = {"getAverageArray"})
    public void testGetAverageArrayResultInt() {
        Assert.assertEquals(3, ArrayUtilities.getAverage(new int[]{2, 2, 5}));
    }

    @Test(groups = {"getAverageArray"})
    public void testGetAverageArrayEmpty() {
        Assert.assertEquals(0, ArrayUtilities.getAverage(EMPTY_ARRAY));
    }

    @Test(groups = {"getAverageArray"})
    public void testGetAverageArrayResultFloat() {
        Assert.assertEquals(2.5, ArrayUtilities.getAverage(new int[]{2, 3, 5, 0}));
    }

    @Test(groups = {"getAverageArray"})
    public void testGetAverageArrayNull() {
        Assert.assertEquals(0, ArrayUtilities.getAverage(NULL_ARRAY));
    }

    @Test(groups = {"getAverageArray"})
    public void testGetAverageArrayResultNegative() {
        Assert.assertEquals(-13, ArrayUtilities.getAverage(new int[]{-1, -35, -3}));
    }

    // Тесты для метода getMaxValueArray
    @Test(groups = {"getMaxValueArray"})
    public void testGetMaxValueArrayPositive() {
        Assert.assertEquals(50, ArrayUtilities.getMaxValue(new int[]{2, 3, 50}));
    }

    @Test(groups = {"getMaxValueArray"})
    public void testGetMaxValueArrayNegative() {
        Assert.assertEquals(-1, ArrayUtilities.getMaxValue(new int[]{-1, -35, -3}));
    }

    @Test(groups = {"getMaxValueArray"})
    public void testGetMaxValueArrayNegativePositive() {
        Assert.assertEquals(7, ArrayUtilities.getMaxValue(new int[]{-1, -35, -3, 3, 7, 0}));
    }

    @Test(groups = {"getMaxValueArray"})
    public void testGetMaxValueArrayNull() {
        Assert.assertEquals(0, ArrayUtilities.getMaxValue(NULL_ARRAY));
    }

    @Test(groups = {"getMaxValueArray"})
    public void testGetMaxValueArrayEmpty() {
        Assert.assertEquals(0, ArrayUtilities.getMaxValue(EMPTY_ARRAY));
    }

    // Тесты для метода getMinValueArray
    @Test(groups = {"getMinValueArray"})
    public void testGetMinValueArrayPositive() {
        Assert.assertEquals(2, ArrayUtilities.getMinValue(new int[]{2, 3, 50}));
    }

    @Test(groups = {"getMinValueArray"})
    public void testGetMinValueArrayNegative() {
        Assert.assertEquals(-35, ArrayUtilities.getMinValue(new int[]{-1, -35, -3}));
    }

    @Test(groups = {"getMinValueArray"})
    public void testGetMinValueArrayNegativePositive() {
        Assert.assertEquals(-35, ArrayUtilities.getMinValue(new int[]{-1, -35, -3, 3, 7, 0}));
    }

    @Test(groups = {"getMinValueArray"})
    public void testGetMinValueArrayNull() {
        Assert.assertEquals(0, ArrayUtilities.getMinValue(NULL_ARRAY));
    }

    @Test(groups = {"getMinValueArray"})
    public void testGetMinValueArrayEmpty() {
        Assert.assertEquals(0, ArrayUtilities.getMinValue(new int[3]));
    }

    // Тесты для метода getFirstIndexOfArrayGivenValue
    @Test(groups = {"getFirstIndexOfArrayGivenValue"})
    public void testGetFirstIndexOfArrayGivenValuePositiveNegative() {
        Assert.assertEquals(2, ArrayUtilities.getFirstIndexWithGivenValue(new int[]{-3, 4, -5}, -5));
    }

    @Test(groups = {"getFirstIndexOfArrayGivenValue"})
    public void testGetFirstIndexOfArrayGivenValueNegative() {
        Assert.assertEquals(-1, ArrayUtilities.getFirstIndexWithGivenValue(new int[5], -6));
    }

    @Test(groups = {"getFirstIndexOfArrayGivenValue"})
    public void testGetFirstIndexOfArrayGivenValueNotFound() {
        Assert.assertEquals(-1, ArrayUtilities.getFirstIndexWithGivenValue(new int[]{3, 4, 5, 6}, 10));
    }

    @Test(groups = {"getFirstIndexOfArrayGivenValue"})
    public void testGetFirstIndexOfArrayGivenValueRepeatValue() {
        Assert.assertEquals(1, ArrayUtilities.getFirstIndexWithGivenValue(new int[]{3, 4, 4, 4}, 4));
    }

    @Test(groups = {"getFirstIndexOfArrayGivenValue"})
    public void testGetFirstIndexOfArrayGivenValueNull() {
        Assert.assertEquals(-1, ArrayUtilities.getFirstIndexWithGivenValue(NULL_ARRAY, 4));
    }

    // Тесты для метода getLastIndexOfArrayGivenValue
    @Test(groups = {"getLastIndexOfArrayGivenValue"})
    public void testGetLastIndexOfArrayGivenValuePositiveNegative() {
        Assert.assertEquals(0, ArrayUtilities.getLastIndexWithGivenValue(new int[]{-3, 4, -5}, -3));
    }

    @Test(groups = {"getLastIndexOfArrayGivenValue"})
    public void testGetLastIndexOfArrayGivenValueNegative() {
        Assert.assertEquals(-1, ArrayUtilities.getLastIndexWithGivenValue(new int[5], -6));
    }

    @Test(groups = {"getLastIndexOfArrayGivenValue"})
    public void testGetLastIndexOfArrayGivenValueNotFound() {
        Assert.assertEquals(-1, ArrayUtilities.getLastIndexWithGivenValue(new int[]{3, 4, 5, 6}, 10));
    }

    @Test(groups = {"getLastIndexOfArrayGivenValue"})
    public void testGetLastIndexOfArrayGivenValueRepeatValue() {
        Assert.assertEquals(3, ArrayUtilities.getLastIndexWithGivenValue(new int[]{3, 4, 4, 4}, 4));
    }

    @Test(groups = {"getLastIndexOfArrayGivenValue"})
    public void testGetLastIndexOfArrayGivenValueNull() {
        Assert.assertEquals(-1, ArrayUtilities.getLastIndexWithGivenValue(NULL_ARRAY, 4));
    }

    // Тесты для метода getSumElementsArray
    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayFirstMinLastMax() {
        Assert.assertEquals(9, ArrayUtilities.getSumBetweenElements(new int[]{1, -5, 9, 7, 3}, 1,
                3));
    }

    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayFirstMaxLastMin() {
        Assert.assertEquals(7, ArrayUtilities.getSumBetweenElements(new int[]{1, 5, -9, 7, 3}, 4,
                2));
    }

    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayFirstOutside() {
        Assert.assertEquals(0, ArrayUtilities.getSumBetweenElements(new int[]{1, 5, 9, 7, 3}, -3,
                2));
    }

    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayLastOutside() {
        Assert.assertEquals(0, ArrayUtilities.getSumBetweenElements(new int[]{1, 5, 9, 7, 3}, 2,
                22));
    }

    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayFirstEquallyLast() {
        Assert.assertEquals(0, ArrayUtilities.getSumBetweenElements(new int[]{1, 5, 9, 7, 3}, 2,
                2));
    }

    @Test(groups = {"getSumElementsArray"})
    public void testGetSumElementsArrayNull() {
        Assert.assertEquals(0, ArrayUtilities.getSumBetweenElements(NULL_ARRAY, 2, 3));
    }

    // Тесты для метода checkArrayNullOrEmpty
    @Test(groups = {"checkArrayNullOrEmpty"})
    public void testCheckArrayNullOrEmptyNull() {
        Assert.assertFalse(ArrayUtilities.isNullOrEmpty(NULL_ARRAY));
    }

    @Test(groups = {"checkArrayNullOrEmpty"})
    public void testCheckArrayNullOrEmptyEmpty() {
        Assert.assertFalse(ArrayUtilities.isNullOrEmpty(EMPTY_ARRAY));
    }

    @Test(groups = {"checkArrayNullOrEmpty"})
    public void testCheckArrayNullOrEmptyWithValue() {
        Assert.assertTrue(ArrayUtilities.isNullOrEmpty(new int[]{2, 3, 5, -6}));
    }

    @Test(groups = {"checkArrayNullOrEmpty"})
    public void testCheckArrayNullOrEmptyTwoDimensionalNull() {
        Assert.assertFalse(ArrayUtilities.isNullOrEmpty(NULL_ARRAY));
    }

    @Test(groups = {"checkArrayNullOrEmpty"})
    public void testCheckArrayNullOrEmptyTwoDimensionalEmpty() {
        Assert.assertFalse(ArrayUtilities.isNullOrEmpty(new int[2][0]));
    }

    // Тесты для метода checkNumberLimitValueArray
    @Test(groups = {"checkNumberLimitValueArray"})
    public void testCheckNumberLimitValueArrayOutside() {
        Assert.assertFalse(ArrayUtilities.isNumberOutsideArray(new int[2], 5));
    }

    @Test(groups = {"checkNumberLimitValueArray"})
    public void testCheckNumberLimitValueArrayWithin() {
        Assert.assertTrue(ArrayUtilities.isNumberOutsideArray(new int[]{5, 3, 9, 10}, 2));
    }

    @Test(groups = {"checkNumberLimitValueArray"})
    public void testCheckNumberLimitValueArrayNull() {
        Assert.assertFalse(ArrayUtilities.isNumberOutsideArray(NULL_ARRAY, 1));
    }

    //Тесты для метода isArrayNull
    @Test(description = "Тестирует пустой массива", groups = {"isArrayNull"})
    public void testIsArrayNull() throws ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayNull(EMPTY_ARRAY));
    }

    @Test(description = "Тестирует не инициализированный массив", groups = {"isArrayNull"},
            expectedExceptions = {ArrayNullException.class}, expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testIsArrayNullWithNull() throws ArrayNullException {
        ArrayUtilities.isArrayNull(NULL_ARRAY);
    }

    @Test(description = "Тестирует массив с данными", groups = {"isArrayNull"})
    public void testIsArrayNullWithText() throws ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayNull(new int[]{5, 3, 9, 10}));
    }

    @Test(description = "Тестирует массив без данных", groups = {"isArrayNull"})
    public void testIsArrayNullTextWithSpaces() throws ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayNull(new int[5]));
    }


    //Тесты для метода isArrayEmpty
    @Test(description = "Тестирует пустой массива", groups = {"isArrayEmpty"},
            expectedExceptions = {ArrayEmptyException.class}, expectedExceptionsMessageRegExp = "Массив пустой")
    public void testIsArrayEmpty() throws ArrayEmptyException, ArrayNullException {
        ArrayUtilities.isArrayEmpty(EMPTY_ARRAY);
    }

    @Test(description = "Тестирует не инициализированный массив", groups = {"isArrayEmpty"},
            expectedExceptions = {ArrayNullException.class}, expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testIsArrayEmptyWithNull() throws ArrayEmptyException, ArrayNullException {
        ArrayUtilities.isArrayEmpty(NULL_ARRAY);
    }

    @Test(description = "Тестирует массив с данными", groups = {"isArrayEmpty"})
    public void testIsArrayEmptyWithText() throws ArrayEmptyException, ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayEmpty(new int[]{5, 3, 9, 10}));
    }

    @Test(description = "Тестирует массив без данных", groups = {"isArrayEmpty"})
    public void testIsArrayEmptyTextWithSpaces() throws ArrayEmptyException, ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayEmpty(new int[5]));
    }


}
