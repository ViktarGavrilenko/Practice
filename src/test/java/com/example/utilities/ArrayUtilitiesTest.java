package com.example.utilities;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayNullException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayUtilitiesTest {

    int[] NULL_ARRAY = null;
    int[] EMPTY_ARRAY = new int[]{};
    int[] NOT_VALUE_ARRAY = new int[5];
    int[] POSITIVE_ARRAY = new int[]{5, 3, 9, 10};
    int[] NEGATIVE_ARRAY = new int[]{-1, -35, -3};
    int[] NEGATIVE_POSITIVE = new int[]{-1, -35, -3, 3, 7, 0};
    int[] REPEATED_VALUES = new int[]{0, 4, 4, 4};

    // Тесты для метода getAverage
    @Test(description = "Тестируем получение целого среднеарифметического числа", groups = {"getAverage"})
    public void testGetAverageArrayResultInt() {
        Assert.assertEquals(ArrayUtilities.getAverage(REPEATED_VALUES), 3);
    }

    @Test(description = "Тестируем пустой массив", groups = {"getAverage"})
    public void testGetAverageArrayEmpty() {
        Assert.assertEquals(ArrayUtilities.getAverage(EMPTY_ARRAY), 0);
    }

    @Test(description = "Тестируем получение десятичного среднеарифметического числа", groups = {"getAverage"})
    public void testGetAverageArrayResultFloat() {
        Assert.assertEquals(ArrayUtilities.getAverage(POSITIVE_ARRAY), 6.75);
    }

    @Test(description = "Тестируем не инициализированный массив", groups = {"getAverage"})
    public void testGetAverageArrayNull() {
        Assert.assertEquals(ArrayUtilities.getAverage(NULL_ARRAY), 0);
    }

    @Test(description = "Тестируем отрицательные значения в массиве", groups = {"getAverage"})
    public void testGetAverageArrayResultNegative() {
        Assert.assertEquals(ArrayUtilities.getAverage(NEGATIVE_ARRAY), -13);
    }

    // Тесты для метода getMaxValue
    @Test(description = "Тестируем положительные значения в массиве", groups = {"getMaxValue"})
    public void testGetMaxValuePositive() {
        Assert.assertEquals(ArrayUtilities.getMaxValue(POSITIVE_ARRAY), 10);
    }

    @Test(description = "Тестируем отрицательные значения в массиве", groups = {"getMaxValue"})
    public void testGetMaxValueNegative() {
        Assert.assertEquals(ArrayUtilities.getMaxValue(NEGATIVE_ARRAY), -1);
    }

    @Test(description = "Тестируем положительные и отрицательные значения в массиве", groups = {"getMaxValue"})
    public void testGetMaxValueNegativePositive() {
        Assert.assertEquals(ArrayUtilities.getMaxValue(NEGATIVE_POSITIVE), 7);
    }

    @Test(description = "Тестируем не инициализированный массив", groups = {"getMaxValue"})
    public void testGetMaxValueNull() {
        Assert.assertEquals(ArrayUtilities.getMaxValue(NULL_ARRAY), 0);
    }

    @Test(description = "Тестируем пустой массив", groups = {"getMaxValue"})
    public void testGetMaxValueEmpty() {
        Assert.assertEquals(ArrayUtilities.getMaxValue(EMPTY_ARRAY), 0);
    }

    // Тесты для метода getMinValue
    @Test(description = "Тестируем положительные значения в массиве", groups = {"getMinValue"})
    public void testGetMinValuePositive() {
        Assert.assertEquals(ArrayUtilities.getMinValue(POSITIVE_ARRAY), 3);
    }

    @Test(description = "Тестируем отрицательные значения в массиве", groups = {"getMinValue"})
    public void testGetMinValueNegative() {
        Assert.assertEquals(ArrayUtilities.getMinValue(NEGATIVE_ARRAY), -35);
    }

    @Test(description = "Тестируем положительные и отрицательные значения в массиве", groups = {"getMinValue"})
    public void testGetMinValueNegativePositive() {
        Assert.assertEquals(ArrayUtilities.getMinValue(NEGATIVE_POSITIVE), -35);
    }

    @Test(description = "Тестируем не инициализированный массив", groups = {"getMinValue"})
    public void testGetMinValueNull() {
        Assert.assertEquals(ArrayUtilities.getMinValue(NULL_ARRAY), 0);
    }

    @Test(description = "Тестируем пустой массив", groups = {"getMinValue"})
    public void testGetMinValueEmpty() {
        Assert.assertEquals(ArrayUtilities.getMinValue(EMPTY_ARRAY), 0);
    }

    @Test(description = "Тестируем не заполненный массив", groups = {"getMinValue"})
    public void testGetMinValueNotValue() {
        Assert.assertEquals(ArrayUtilities.getMinValue(NOT_VALUE_ARRAY), 0);
    }

    // Тесты для метода getFirstIndexWithGivenValue
    @Test(description = "Тестируем с одним совпадением в массиве", groups = {"getFirstIndexWithGivenValue"})
    public void testGetFirstIndexWithGivenValuePositiveNegative() {
        Assert.assertEquals(ArrayUtilities.getFirstIndexWithGivenValue(NEGATIVE_POSITIVE, -3), 2);
    }

    @Test(description = "Тестируем не заполненный массив", groups = {"getFirstIndexWithGivenValue"})
    public void testGetFirstIndexWithGivenValueNegative() {
        Assert.assertEquals(ArrayUtilities.getFirstIndexWithGivenValue(NOT_VALUE_ARRAY, -6), -1);
    }

    @Test(description = "Тестируем массив без совпадений", groups = {"getFirstIndexWithGivenValue"})
    public void testGetFirstIndexWithGivenValueNotFound() {
        Assert.assertEquals(ArrayUtilities.getFirstIndexWithGivenValue(POSITIVE_ARRAY, 12), -1);
    }

    @Test(description = "Тестируем массив с тремя совпадениями", groups = {"getFirstIndexWithGivenValue"})
    public void testGetFirstIndexWithGivenValueRepeatValue() {
        Assert.assertEquals(ArrayUtilities.getFirstIndexWithGivenValue(REPEATED_VALUES, 4), 1);
    }

    @Test(description = "Тестируем не инициализированный массив массив", groups = {"getFirstIndexWithGivenValue"})
    public void testGetFirstIndexWithGivenValueNull() {
        Assert.assertEquals(ArrayUtilities.getFirstIndexWithGivenValue(NULL_ARRAY, 4), -1);
    }

    // Тесты для метода getLastIndexWithGivenValue
    @Test(description = "Тестируем с одним совпадением в массиве", groups = {"getLastIndexWithGivenValue"})
    public void testGetLastIndexWithGivenValuePositiveNegative() {
        Assert.assertEquals(ArrayUtilities.getLastIndexWithGivenValue(NEGATIVE_POSITIVE, -3), 2);
    }

    @Test(description = "Тестируем не заполненный массив", groups = {"getLastIndexWithGivenValue"})
    public void testGetLastIndexWithGivenValueNegative() {
        Assert.assertEquals(ArrayUtilities.getLastIndexWithGivenValue(NOT_VALUE_ARRAY, 5), -1);
    }

    @Test(description = "Тестируем массив без совпадений", groups = {"getLastIndexWithGivenValue"})
    public void testGetLastIndexWithGivenValueNotFound() {
        Assert.assertEquals(ArrayUtilities.getLastIndexWithGivenValue(POSITIVE_ARRAY, 12), -1);
    }

    @Test(description = "Тестируем массив с тремя совпадениями", groups = {"getLastIndexWithGivenValue"})
    public void testGetLastIndexWithGivenValueRepeatValue() {
        Assert.assertEquals(ArrayUtilities.getLastIndexWithGivenValue(REPEATED_VALUES, 4), 3);
    }

    @Test(description = "Тестируем не инициализированный массив", groups = {"getLastIndexWithGivenValue"})
    public void testGetLastIndexWithGivenValueNull() {
        Assert.assertEquals(ArrayUtilities.getLastIndexWithGivenValue(NULL_ARRAY, 4), -1);
    }

    // Тесты для метода getSumBetweenElements
    @Test(description = "Тестируем массив с первым минимальным и последним максимальным значениями",
            groups = {"getSumBetweenElements"})
    public void testGetSumBetweenElementsFirstMinLastMax() {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(NEGATIVE_POSITIVE, 1,
                3), -3);
    }

    @Test(description = "Тестируем массив с первым максимальным и последним минимальным значениями",
            groups = {"getSumBetweenElements"})
    public void testGetSumBetweenElementsFirstMaxLastMin() {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(NEGATIVE_POSITIVE, 4,
                2), 3);
    }

    @Test(description = "Тестируем массив с первым элементов выходящим за пределы массива",
            groups = {"getSumBetweenElements"})
    public void testGetSumBetweenElementsFirstOutside() {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(POSITIVE_ARRAY, -3,
                2), 0);
    }

    @Test(description = "Тестируем массив с последним элементов выходящим за пределы массива",
            groups = {"getSumBetweenElements"})
    public void testGetSumElementsArrayLastOutside() {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(POSITIVE_ARRAY, 2,
                22), 0);
    }

    @Test(description = "Тестируем массив с одинаковыми первым и последним элементами",
            groups = {"getSumBetweenElements"})
    public void testGetSumBetweenElementsFirstEquallyLast() {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(POSITIVE_ARRAY, 2,
                2), 0);
    }

    @Test(description = "Тестируем не инициализированный массив", groups = {"getSumBetweenElements"})
    public void testGetSumBetweenElementsNull() {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(NULL_ARRAY, 2, 3), 0);
    }

    // Тесты для метода isNullOrEmpty
    @Test(description = "Тестируем не инициализированный массив", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptyNull() {
        Assert.assertFalse(ArrayUtilities.isNullOrEmpty(NULL_ARRAY));
    }

    @Test(description = "Тестируем пустой массив", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptyEmpty() {
        Assert.assertFalse(ArrayUtilities.isNullOrEmpty(EMPTY_ARRAY));
    }

    @Test(description = "Тестируем заполненный массив", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptyWithValue() {
        Assert.assertTrue(ArrayUtilities.isNullOrEmpty(POSITIVE_ARRAY));
    }

    @Test(description = "Тестируем не заполненный двумерный массив", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptyTwoDimensionalNull() {
        Assert.assertTrue(ArrayUtilities.isNullOrEmpty(new int[2][2]));
    }

    @Test(description = "Тестируем пустой двумерный массив", groups = {"isNullOrEmpty"})
    public void testIsNullOrEmptyTwoDimensionalEmpty() {
        Assert.assertFalse(ArrayUtilities.isNullOrEmpty(new int[2][0]));
    }

    // Тесты для метода isNumberOutsideArray
    @Test(description = "Тестируем значение выходящее за пределы массива", groups = {"isNumberOutsideArray"})
    public void testIsNumberOutsideArrayOutside() {
        Assert.assertFalse(ArrayUtilities.isNumberOutsideArray(NOT_VALUE_ARRAY, 7));
    }

    @Test(description = "Тестируем значение в пределах массива", groups = {"isNumberOutsideArray"})
    public void testIsNumberOutsideArrayWithin() {
        Assert.assertTrue(ArrayUtilities.isNumberOutsideArray(POSITIVE_ARRAY, 2));
    }

    @Test(description = "Тестируем не инициализированный массив", groups = {"isNumberOutsideArray"})
    public void testIsNumberOutsideArrayNull() {
        Assert.assertFalse(ArrayUtilities.isNumberOutsideArray(NULL_ARRAY, 1));
    }

    @Test(description = "Тестируем пустой", groups = {"isNumberOutsideArray"})
    public void testIsNumberOutsideArrayEmpty() {
        Assert.assertFalse(ArrayUtilities.isNumberOutsideArray(EMPTY_ARRAY, 1));
    }

    //Тесты для метода isArrayNull
    @Test(description = "Тестирует пустой массива", groups = {"isArrayNull"})
    public void testIsArrayNull() throws ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayNull(EMPTY_ARRAY));
    }

    @Test(description = "Тестирует не инициализированный массив", groups = {"isArrayNull"},
            expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testIsArrayNullWithNull() throws ArrayNullException {
        ArrayUtilities.isArrayNull(NULL_ARRAY);
    }

    @Test(description = "Тестирует массив с данными", groups = {"isArrayNull"})
    public void testIsArrayNullWithText() throws ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayNull(POSITIVE_ARRAY));
    }

    @Test(description = "Тестирует массив без данных", groups = {"isArrayNull"})
    public void testIsArrayNullTextWithSpaces() throws ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayNull(NOT_VALUE_ARRAY));
    }

    //Тесты для метода isArrayEmpty
    @Test(description = "Тестирует пустой массива", groups = {"isArrayEmpty"},
            expectedExceptions = {ArrayEmptyException.class}, expectedExceptionsMessageRegExp = "Массив пустой")
    public void testIsArrayEmpty() throws ArrayEmptyException, ArrayNullException {
        ArrayUtilities.isArrayEmpty(EMPTY_ARRAY);
    }

    @Test(description = "Тестирует не инициализированный массив", groups = {"isArrayEmpty"},
            expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testIsArrayEmptyWithNull() throws ArrayEmptyException, ArrayNullException {
        ArrayUtilities.isArrayEmpty(NULL_ARRAY);
    }

    @Test(description = "Тестирует массив с данными", groups = {"isArrayEmpty"})
    public void testIsArrayEmptyWithText() throws ArrayEmptyException, ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayEmpty(POSITIVE_ARRAY));
    }

    @Test(description = "Тестирует массив без данных", groups = {"isArrayEmpty"})
    public void testIsArrayEmptyTextWithSpaces() throws ArrayEmptyException, ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayEmpty(NOT_VALUE_ARRAY));
    }
}
