package com.example.array;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayNullException;
import com.example.exception.ValueOutsideArrayException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class ArrayTaskTest {

    private final int[] NULL_ARRAY = null;
    private final int[] EMPTY_ARRAY = new int[]{};
    private final int[] NOT_VALUE_ARRAY = new int[5];
    private final int[] POSITIVE_ARRAY = new int[]{5, 3, 9, 10};
    private final int[] NEGATIVE_ARRAY = new int[]{-1, -35, -3};
    private final int[] NEGATIVE_POSITIVE = new int[]{-1, -35, -3, 3, 7, 0};
    private final int[] REPEATED_VALUES = new int[]{0, 4, 4, 4};
    private final int[] NOT_UNIQUE = new int[]{2, 2, 4, 4};
    private final int[] WITH_UNIQUE = new int[]{0, 2, 2, 5, 4, 4, -1, 6, 6};
    private final int[][] TWO_DIMENSIONAL = {{5, 8, 88, 3, 42, 10, 10, 6},
            {1, 53, 2, 3, 77, 10, 2, 54},
            {4, 3, 91, 3, 12, 10, 4, 12},
            {6, 3, 11, 3, 22, 10, 5, 60},
            {2, 4, 32, 71, 4, 40, 48, 9}};
    private final int[][] MAX_MIN = {{88, 3},
            {77, 1},
            {91, 3},
            {60, 3},
            {71, 2}};

    ArrayTask arrayTask;

    @BeforeTest()
    public void setUp() {
        arrayTask = new ArrayTask();
    }

    // Тесты для метода putWordsReverseInString
    @Test(description = "Тестируем массив с положительными и отрицательными значениями")
    public void testReverseArray() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.reverseArray(NEGATIVE_POSITIVE), new int[]{0, 7, 3, -3, -35, -1});
    }

    @Test(description = "Тестируем не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testReverseArrayNull() throws ArrayEmptyException, ArrayNullException {
        Assert.assertNull(arrayTask.reverseArray(NULL_ARRAY));
    }

    @Test(description = "Тестируем пустой", expectedExceptions = {ArrayEmptyException.class},
            expectedExceptionsMessageRegExp = "Массив пустой")
    public void testReverseArrayEmpty() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.reverseArray(EMPTY_ARRAY), EMPTY_ARRAY);
    }

    @Test(description = "Тестируем не заполненный массив")
    public void testReverseArrayNotValue() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.reverseArray(NOT_VALUE_ARRAY), NOT_VALUE_ARRAY);
    }

    // Тесты для метода putWordsReverseInString
    @Test(description = "Тестируем не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testAddRandomValueNull() throws ArrayEmptyException, ArrayNullException {
        Assert.assertNull(arrayTask.addRandomValue(NULL_ARRAY));
    }

    @Test(description = "Тестируем пустой массив", expectedExceptions = {ArrayEmptyException.class},
            expectedExceptionsMessageRegExp = "Массив пустой")
    public void testAddRandomValueEmpty() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.addRandomValue(EMPTY_ARRAY), EMPTY_ARRAY);
    }

    // Тесты для метода compareAverageArrays
    @Test(description = "Тестируем среднеарифметическое значение первого массива больше второго")
    public void testCompareAverageArraysFirstMore() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.compareAverageArrays(POSITIVE_ARRAY, NEGATIVE_ARRAY), 1);
    }

    @Test(description = "Тестируем среднеарифметическое значение второго массива больше первого")
    public void testCompareAverageArraysSecondMore() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.compareAverageArrays(NEGATIVE_ARRAY, POSITIVE_ARRAY), 2);
    }

    @Test(description = "Тестируем среднеарифметическое одинаковые массивы")
    public void testCompareAverageArraysEqual() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.compareAverageArrays(POSITIVE_ARRAY, POSITIVE_ARRAY), 0);
    }

    @Test(description = "Тестируем не инициализированный первый массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testCompareAverageArraysNull() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.compareAverageArrays(NULL_ARRAY, POSITIVE_ARRAY), -1);
    }

    @Test(description = "Тестируем пустой второй массив", expectedExceptions = {ArrayEmptyException.class},
            expectedExceptionsMessageRegExp = "Массив пустой")
    public void testCompareAverageArraysEmpty() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.compareAverageArrays(NEGATIVE_POSITIVE, EMPTY_ARRAY), -1);
    }

    // Тесты для метода searchMaxMinValueTwoArray
    @Test(description = "Тестируем заполненный двумерный массив")
    public void testSearchMaxMinValueTwoArray() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.searchMaxMinValueTwoArray(TWO_DIMENSIONAL), MAX_MIN);
    }

    @Test(description = "Тестируем не инициализированный двумерный массив")
    public void testSearchMaxMinValueTwoArrayNull() throws ArrayEmptyException, ArrayNullException {

        Assert.assertNull(arrayTask.searchMaxMinValueTwoArray(null));
    }

    @Test(description = "Тестируем пустой двумерный массив")
    public void testSearchMaxMinValueTwoArrayEmpty() throws ArrayEmptyException, ArrayNullException {
        Assert.assertNull(arrayTask.searchMaxMinValueTwoArray(new int[][]{}));
    }

    @Test(description = "Тестируем не заполненный двумерный массив")
    public void testSearchMaxMinValueTwoArrayNotValue() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.searchMaxMinValueTwoArray(new int[2][2]), new int[][]{{0, 0}, {0, 0}});
    }

    // Тесты для метода searchUniqueValue
    @Test(description = "Тестируем массив с одним уникальным значением")
    public void testSearchUniqueValueOne() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.searchUniqueValue(REPEATED_VALUES), Collections.singletonList(0));
    }

    @Test(description = "Тестируем массив только с уникальными значениями")
    public void testSearchUniqueValueAllUnique() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.searchUniqueValue(POSITIVE_ARRAY), Arrays.asList(5, 3, 9, 10));
    }

    @Test(description = "Тестируем массив только с уникальными значениями", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testSearchUniqueValueNull() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.searchUniqueValue(NULL_ARRAY), Collections.emptyList());
    }

    @Test(description = "Тестируем массив только с уникальными значениями", expectedExceptions = {ArrayEmptyException.class},
            expectedExceptionsMessageRegExp = "Массив пустой")
    public void testSearchUniqueValueEmpty() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.searchUniqueValue(EMPTY_ARRAY), Collections.emptyList());
    }

    @Test(description = "Тестируем массив без уникальных значений")
    public void testSearchUniqueValueNotUnique() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.searchUniqueValue(NOT_UNIQUE), Collections.emptyList());
    }

    @Test(description = "Тестируем массив с тремя уникальными значениями")
    public void testSearchUniqueValue() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.searchUniqueValue(WITH_UNIQUE), Arrays.asList(0, 5, -1));
    }

    // Тесты для метода calcSumBetweenMinMax
    @Test(description = "Тестируем массив с положительными и отрицательными значениями")
    public void testCalcSumBetweenMinMax() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {

        Assert.assertEquals(arrayTask.calcSumBetweenMinMax(POSITIVE_ARRAY), 9);
    }

    @Test(description = "Тестируем не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testCalcSumBetweenMinMaxNull() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {

        Assert.assertEquals(arrayTask.calcSumBetweenMinMax(NULL_ARRAY), 0);
    }

    @Test(description = "Тестируем пустой массив", expectedExceptions = {ArrayEmptyException.class},
            expectedExceptionsMessageRegExp = "Массив пустой")
    public void testCalcSumBetweenMinMaxEmpty() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {

        Assert.assertEquals(arrayTask.calcSumBetweenMinMax(EMPTY_ARRAY), 0);
    }

    @Test(description = "Тестируем массив с одним значением")
    public void testCalcSumBetweenMinMaxOneValue() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.calcSumBetweenMinMax(new int[]{2}), 0);
    }

    @Test(description = "Тестируем массив с двумя значениями")
    public void testCalcSumBetweenMinMaxTwoValue() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(arrayTask.calcSumBetweenMinMax(new int[]{2, 5}), 0);
    }

}