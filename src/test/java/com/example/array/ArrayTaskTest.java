package com.example.array;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class ArrayTaskTest {

    int[] NULL_ARRAY = null;
    int[] EMPTY_ARRAY = new int[]{};
    int[] NOT_VALUE_ARRAY = new int[5];
    int[] POSITIVE_ARRAY = new int[]{5, 3, 9, 10};
    int[] NEGATIVE_ARRAY = new int[]{-1, -35, -3};
    int[] NEGATIVE_POSITIVE = new int[]{-1, -35, -3, 3, 7, 0};
    int[] REPEATED_VALUES = new int[]{0, 4, 4, 4};
    int[] NOT_UNIQUE = new int[]{2, 2, 4, 4};
    int[] WITH_UNIQUE = new int[]{0, 2, 2, 5, 4, 4, -1, 6, 6};
    int[][] TWO_DIMENSIONAL = {{5, 8, 88, 3, 42, 10, 10, 6},
            {1, 53, 2, 3, 77, 10, 2, 54},
            {4, 3, 91, 3, 12, 10, 4, 12},
            {6, 3, 11, 3, 22, 10, 5, 60},
            {2, 4, 32, 71, 4, 40, 48, 9}};
    int[][] MAX_MIN = {{88, 3},
            {77, 1},
            {91, 3},
            {60, 3},
            {71, 2}};

    // Тесты для метода putWordsReverseInString
    @Test(description = "Тестируем массив с положительными и отрицательными значениями", groups = {"reverseArray"})
    public void testReverseArray() {
        Assert.assertEquals(ArrayTask.reverseArray(NEGATIVE_POSITIVE), new int[]{0, 7, 3, -3, -35, -1});
    }

    @Test(description = "Тестируем не инициализированный массив", groups = {"reverseArray"})
    public void testReverseArrayNull() {
        Assert.assertNull(ArrayTask.reverseArray(NULL_ARRAY));
    }

    @Test(description = "Тестируем пустой", groups = {"reverseArray"})
    public void testReverseArrayEmpty() {
        Assert.assertEquals(ArrayTask.reverseArray(EMPTY_ARRAY), EMPTY_ARRAY);
    }

    @Test(description = "Тестируем не заполненный массив", groups = {"reverseArray"})
    public void testReverseArrayNotValue() {
        Assert.assertEquals(ArrayTask.reverseArray(NOT_VALUE_ARRAY), NOT_VALUE_ARRAY);
    }

    // Тесты для метода putWordsReverseInString
    @Test(description = "Тестируем не инициализированный массив", groups = {"addRandomValue"})
    public void testAddRandomValueNull() {
        Assert.assertNull(ArrayTask.addRandomValue(NULL_ARRAY));
    }

    @Test(description = "Тестируем пустой массив", groups = {"addRandomValue"})
    public void testAddRandomValueEmpty() {
        Assert.assertEquals(ArrayTask.addRandomValue(EMPTY_ARRAY), EMPTY_ARRAY);
    }

    // Тесты для метода compareAverageArrays
    @Test(description = "Тестируем среднеарифметическое значение первого массива больше второго",
            groups = {"compareAverageArrays"})
    public void testCompareAverageArraysFirstMore() {
        Assert.assertEquals(ArrayTask.compareAverageArrays(POSITIVE_ARRAY, NEGATIVE_ARRAY), 1);
    }

    @Test(description = "Тестируем среднеарифметическое значение второго массива больше первого",
            groups = {"compareAverageArrays"})
    public void testCompareAverageArraysSecondMore() {
        Assert.assertEquals(ArrayTask.compareAverageArrays(NEGATIVE_ARRAY, POSITIVE_ARRAY), 2);
    }

    @Test(description = "Тестируем среднеарифметическое одинаковые массивы",
            groups = {"compareAverageArrays"})
    public void testCompareAverageArraysEqual() {
        Assert.assertEquals(ArrayTask.compareAverageArrays(POSITIVE_ARRAY, POSITIVE_ARRAY), 0);
    }

    @Test(description = "Тестируем не инициализированный первый массив",
            groups = {"compareAverageArrays"})
    public void testCompareAverageArraysNull() {
        Assert.assertEquals(ArrayTask.compareAverageArrays(NULL_ARRAY, POSITIVE_ARRAY), -1);
    }

    @Test(description = "Тестируем пустой второй массив",
            groups = {"compareAverageArrays"})
    public void testCompareAverageArraysEmpty() {
        Assert.assertEquals(ArrayTask.compareAverageArrays(NEGATIVE_POSITIVE, EMPTY_ARRAY), -1);
    }

    // Тесты для метода searchMaxMinValueTwoArray
    @Test(description = "Тестируем заполненный двумерный массив",
            groups = {"searchMaxMinValueTwoArray"})
    public void testSearchMaxMinValueTwoArray() {
        Assert.assertEquals(ArrayTask.searchMaxMinValueTwoArray(TWO_DIMENSIONAL), MAX_MIN);
    }

    @Test(description = "Тестируем не инициализированный двумерный массив",
            groups = {"searchMaxMinValueTwoArray"})
    public void testSearchMaxMinValueTwoArrayNull() {
        Assert.assertNull(ArrayTask.searchMaxMinValueTwoArray(null));
    }

    @Test(description = "Тестируем пустой двумерный массив",
            groups = {"searchMaxMinValueTwoArray"})
    public void testSearchMaxMinValueTwoArrayEmpty() {
        Assert.assertNull(ArrayTask.searchMaxMinValueTwoArray(new int[][]{}));
    }

    @Test(description = "Тестируем не заполненный двумерный массив",
            groups = {"searchMaxMinValueTwoArray"})
    public void testSearchMaxMinValueTwoArrayNotValue() {
        Assert.assertEquals(ArrayTask.searchMaxMinValueTwoArray(new int[2][2]), new int[][]{{0, 0}, {0, 0}});
    }

    // Тесты для метода searchUniqueValue
    @Test(description = "Тестируем массив с одним уникальным значением", groups = {"searchUniqueValue"})
    public void testSearchUniqueValueOne() {
        Assert.assertEquals(ArrayTask.searchUniqueValue(REPEATED_VALUES), Collections.singletonList(0));
    }

    @Test(description = "Тестируем массив только с уникальными значениями", groups = {"searchUniqueValue"})
    public void testSearchUniqueValueAllUnique() {
        Assert.assertEquals(ArrayTask.searchUniqueValue(POSITIVE_ARRAY), Arrays.asList(5, 3, 9, 10));
    }

    @Test(description = "Тестируем массив только с уникальными значениями", groups = {"searchUniqueValue"})
    public void testSearchUniqueValueNull() {
        Assert.assertEquals(ArrayTask.searchUniqueValue(NULL_ARRAY), Collections.emptyList());
    }

    @Test(description = "Тестируем массив только с уникальными значениями", groups = {"searchUniqueValue"})
    public void testSearchUniqueValueEmpty() {
        Assert.assertEquals(ArrayTask.searchUniqueValue(EMPTY_ARRAY), Collections.emptyList());
    }

    @Test(description = "Тестируем массив без уникальных значений", groups = {"searchUniqueValue"})
    public void testSearchUniqueValueNotUnique() {
        Assert.assertEquals(ArrayTask.searchUniqueValue(NOT_UNIQUE), Collections.emptyList());
    }

    @Test(description = "Тестируем массив с тремя уникальными значениями", groups = {"searchUniqueValue"})
    public void testSearchUniqueValue() {
        Assert.assertEquals(ArrayTask.searchUniqueValue(WITH_UNIQUE), Arrays.asList(0, 5, -1));
    }

    // Тесты для метода calcSumBetweenMinMax
    @Test(description = "Тестируем массив с положительными и отрицательными значениями", groups = {"calcSumBetweenMinMax"})
    public void testCalcSumBetweenMinMax() {
        Assert.assertEquals(ArrayTask.calcSumBetweenMinMax(POSITIVE_ARRAY), 9);
    }

    @Test(description = "Тестируем не инициализированный массив", groups = {"calcSumBetweenMinMax"})
    public void testCalcSumBetweenMinMaxNull() {
        Assert.assertEquals(ArrayTask.calcSumBetweenMinMax(NULL_ARRAY), 0);
    }

    @Test(description = "Тестируем пустой массив", groups = {"calcSumBetweenMinMax"})
    public void testCalcSumBetweenMinMaxEmpty() {
        Assert.assertEquals(ArrayTask.calcSumBetweenMinMax(EMPTY_ARRAY), 0);
    }

    @Test(description = "Тестируем массив с одним значением", groups = {"calcSumBetweenMinMax"})
    public void testCalcSumBetweenMinMaxOneValue() {
        Assert.assertEquals(ArrayTask.calcSumBetweenMinMax(new int[]{2}), 0);
    }

    @Test(description = "Тестируем массив с двумя значениями", groups = {"calcSumBetweenMinMax"})
    public void testCalcSumBetweenMinMaxTwoValue() {
        Assert.assertEquals(ArrayTask.calcSumBetweenMinMax(new int[]{2, 5}), 0);
    }

}