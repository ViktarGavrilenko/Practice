package com.example.utilities;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayNullException;
import com.example.exception.ValueOutsideArrayException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayUtilitiesTest {

    private final int[] NULL_ARRAY = null;
    private final int[] EMPTY_ARRAY = new int[]{};
    private final int[] NOT_VALUE_ARRAY = new int[5];
    private final int[] POSITIVE_ARRAY = new int[]{5, 3, 9, 10};
    private final int[] NEGATIVE_ARRAY = new int[]{-1, -35, -3};
    private final int[] NEGATIVE_POSITIVE = new int[]{-1, -35, -3, 3, 7, 0};
    private final int[] REPEATED_VALUES = new int[]{0, 4, 4, 4};

    // Тесты для метода getAverage
    @Test(description = "Тестируем получение целого среднеарифметического числа")
    public void testGetAverageArrayResultInt() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getAverage(REPEATED_VALUES), 3);
    }

    @Test(description = "Тестируем пустой массив", expectedExceptions = {ArrayEmptyException.class},
            expectedExceptionsMessageRegExp = "Массив пустой")
    public void testGetAverageArrayEmpty() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getAverage(EMPTY_ARRAY), 0);
    }

    @Test(description = "Тестируем получение десятичного среднеарифметического числа")
    public void testGetAverageArrayResultFloat() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getAverage(POSITIVE_ARRAY), 6.75);
    }

    @Test(description = "Тестируем не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testGetAverageArrayNull() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getAverage(NULL_ARRAY), 0);
    }

    @Test(description = "Тестируем отрицательные значения в массиве")
    public void testGetAverageArrayResultNegative() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getAverage(NEGATIVE_ARRAY), -13);
    }

    // Тесты для метода getMaxValue
    @Test(description = "Тестируем положительные значения в массиве")
    public void testGetMaxValuePositive() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getMaxValue(POSITIVE_ARRAY), 10);
    }

    @Test(description = "Тестируем отрицательные значения в массиве")
    public void testGetMaxValueNegative() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getMaxValue(NEGATIVE_ARRAY), -1);
    }

    @Test(description = "Тестируем положительные и отрицательные значения в массиве")
    public void testGetMaxValueNegativePositive() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getMaxValue(NEGATIVE_POSITIVE), 7);
    }

    @Test(description = "Тестируем не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testGetMaxValueNull() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getMaxValue(NULL_ARRAY), 0);
    }

    @Test(description = "Тестируем пустой массив", expectedExceptions = {ArrayEmptyException.class},
            expectedExceptionsMessageRegExp = "Массив пустой")
    public void testGetMaxValueEmpty() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getMaxValue(EMPTY_ARRAY), 0);
    }

    // Тесты для метода getMinValue
    @Test(description = "Тестируем положительные значения в массиве")
    public void testGetMinValuePositive() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getMinValue(POSITIVE_ARRAY), 3);
    }

    @Test(description = "Тестируем отрицательные значения в массиве")
    public void testGetMinValueNegative() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getMinValue(NEGATIVE_ARRAY), -35);
    }

    @Test(description = "Тестируем положительные и отрицательные значения в массиве")
    public void testGetMinValueNegativePositive() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getMinValue(NEGATIVE_POSITIVE), -35);
    }

    @Test(description = "Тестируем не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testGetMinValueNull() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getMinValue(NULL_ARRAY), 0);
    }

    @Test(description = "Тестируем пустой массив", expectedExceptions = {ArrayEmptyException.class},
            expectedExceptionsMessageRegExp = "Массив пустой")
    public void testGetMinValueEmpty() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getMinValue(EMPTY_ARRAY), 0);
    }

    @Test(description = "Тестируем не заполненный массив")
    public void testGetMinValueNotValue() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getMinValue(NOT_VALUE_ARRAY), 0);
    }

    // Тесты для метода getFirstIndexWithGivenValue
    @Test(description = "Тестируем с одним совпадением в массиве")
    public void testGetFirstIndexWithGivenValuePositiveNegative() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getFirstIndexWithGivenValue(NEGATIVE_POSITIVE, -3), 2);
    }

    @Test(description = "Тестируем не заполненный массив")
    public void testGetFirstIndexWithGivenValueNegative() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getFirstIndexWithGivenValue(NOT_VALUE_ARRAY, -6), -1);
    }

    @Test(description = "Тестируем массив без совпадений")
    public void testGetFirstIndexWithGivenValueNotFound() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getFirstIndexWithGivenValue(POSITIVE_ARRAY, 12), -1);
    }

    @Test(description = "Тестируем массив с тремя совпадениями")
    public void testGetFirstIndexWithGivenValueRepeatValue() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getFirstIndexWithGivenValue(REPEATED_VALUES, 4), 1);
    }

    @Test(description = "Тестируем не инициализированный массив массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testGetFirstIndexWithGivenValueNull() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getFirstIndexWithGivenValue(NULL_ARRAY, 4), -1);
    }

    // Тесты для метода getLastIndexWithGivenValue
    @Test(description = "Тестируем с одним совпадением в массиве")
    public void testGetLastIndexWithGivenValuePositiveNegative() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getLastIndexWithGivenValue(NEGATIVE_POSITIVE, -3), 2);
    }

    @Test(description = "Тестируем не заполненный массив")
    public void testGetLastIndexWithGivenValueNegative() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getLastIndexWithGivenValue(NOT_VALUE_ARRAY, 5), -1);
    }

    @Test(description = "Тестируем массив без совпадений")
    public void testGetLastIndexWithGivenValueNotFound() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getLastIndexWithGivenValue(POSITIVE_ARRAY, 12), -1);
    }

    @Test(description = "Тестируем массив с тремя совпадениями")
    public void testGetLastIndexWithGivenValueRepeatValue() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getLastIndexWithGivenValue(REPEATED_VALUES, 4), 3);
    }

    @Test(description = "Тестируем не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testGetLastIndexWithGivenValueNull() throws ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getLastIndexWithGivenValue(NULL_ARRAY, 4), -1);
    }

    // Тесты для метода getSumBetweenElements
    @Test(description = "Тестируем массив с первым минимальным и последним максимальным значениями")
    public void testGetSumBetweenElementsFirstMinLastMax() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(NEGATIVE_POSITIVE, 1,
                3), -3);
    }

    @Test(description = "Тестируем массив с первым максимальным и последним минимальным значениями")
    public void testGetSumBetweenElementsFirstMaxLastMin() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(NEGATIVE_POSITIVE, 4,
                2), 3);
    }

    @Test(description = "Тестируем массив с первым элементов выходящим за пределы массива",
            expectedExceptions = {ValueOutsideArrayException.class},
            expectedExceptionsMessageRegExp = "Значение выходит за пределы массива")
    public void testGetSumBetweenElementsFirstOutside() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(POSITIVE_ARRAY, -3,
                2), 0);
    }

    @Test(description = "Тестируем массив с последним элементов выходящим за пределы массива",
            expectedExceptions = {ValueOutsideArrayException.class},
            expectedExceptionsMessageRegExp = "Значение выходит за пределы массива")
    public void testGetSumElementsArrayLastOutside() throws ValueOutsideArrayException, ArrayEmptyException,
            ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(POSITIVE_ARRAY, 2,
                22), 0);
    }

    @Test(description = "Тестируем массив с одинаковыми первым и последним элементами")
    public void testGetSumBetweenElementsFirstEquallyLast() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(POSITIVE_ARRAY, 2,
                2), 0);
    }

    @Test(description = "Тестируем не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testGetSumBetweenElementsNull() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        Assert.assertEquals(ArrayUtilities.getSumBetweenElements(NULL_ARRAY, 2, 3), 0);
    }

    // Тесты для метода isNullOrEmpty
    @Test(description = "Тестируем не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testIsNullOrEmptyNull() throws ArrayEmptyException, ArrayNullException {
        Assert.assertFalse(ArrayUtilities.isNullOrEmpty(NULL_ARRAY));
    }

    @Test(description = "Тестируем пустой массив", expectedExceptions = {ArrayEmptyException.class},
            expectedExceptionsMessageRegExp = "Массив пустой")
    public void testIsNullOrEmptyEmpty() throws ArrayEmptyException, ArrayNullException {
        Assert.assertFalse(ArrayUtilities.isNullOrEmpty(EMPTY_ARRAY));
    }

    @Test(description = "Тестируем заполненный массив")
    public void testIsNullOrEmptyWithValue() throws ArrayEmptyException, ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isNullOrEmpty(POSITIVE_ARRAY));
    }

    @Test(description = "Тестируем не заполненный двумерный массив")
    public void testIsNullOrEmptyTwoDimensionalNull() {
        Assert.assertTrue(ArrayUtilities.isNullOrEmpty(new int[2][2]));
    }

    @Test(description = "Тестируем пустой двумерный массив")
    public void testIsNullOrEmptyTwoDimensionalEmpty() {
        Assert.assertFalse(ArrayUtilities.isNullOrEmpty(new int[2][0]));
    }

    // Тесты для метода isNumberOutsideArray
    @Test(description = "Тестируем значение выходящее за пределы массива",
            expectedExceptions = {ValueOutsideArrayException.class},
            expectedExceptionsMessageRegExp = "Значение выходит за пределы массива")
    public void testIsNumberOutsideArrayOutside() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        Assert.assertFalse(ArrayUtilities.isNumberOutsideArray(NOT_VALUE_ARRAY, 7));
    }

    @Test(description = "Тестируем значение в пределах массива")
    public void testIsNumberOutsideArrayWithin() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isNumberOutsideArray(POSITIVE_ARRAY, 2));
    }

    @Test(description = "Тестируем не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testIsNumberOutsideArrayNull() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        Assert.assertFalse(ArrayUtilities.isNumberOutsideArray(NULL_ARRAY, 1));
    }

    @Test(description = "Тестируем пустой", expectedExceptions = {ArrayEmptyException.class},
            expectedExceptionsMessageRegExp = "Массив пустой")
    public void testIsNumberOutsideArrayEmpty() throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        Assert.assertFalse(ArrayUtilities.isNumberOutsideArray(EMPTY_ARRAY, 1));
    }

    //Тесты для метода isArrayNull
    @Test(description = "Тестирует пустой массива")
    public void testIsArrayNull() throws ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayNull(EMPTY_ARRAY));
    }

    @Test(description = "Тестирует не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testIsArrayNullWithNull() throws ArrayNullException {
        ArrayUtilities.isArrayNull(NULL_ARRAY);
    }

    @Test(description = "Тестирует массив с данными")
    public void testIsArrayNullWithText() throws ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayNull(POSITIVE_ARRAY));
    }

    @Test(description = "Тестирует массив без данных")
    public void testIsArrayNullTextWithSpaces() throws ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayNull(NOT_VALUE_ARRAY));
    }

    //Тесты для метода isArrayEmpty
    @Test(description = "Тестирует пустой массива", expectedExceptions = {ArrayEmptyException.class},
            expectedExceptionsMessageRegExp = "Массив пустой")
    public void testIsArrayEmpty() throws ArrayEmptyException, ArrayNullException {
        ArrayUtilities.isArrayEmpty(EMPTY_ARRAY);
    }

    @Test(description = "Тестирует не инициализированный массив", expectedExceptions = {ArrayNullException.class},
            expectedExceptionsMessageRegExp = "Массив не инициализирован")
    public void testIsArrayEmptyWithNull() throws ArrayEmptyException, ArrayNullException {
        ArrayUtilities.isArrayEmpty(NULL_ARRAY);
    }

    @Test(description = "Тестирует массив с данными")
    public void testIsArrayEmptyWithText() throws ArrayEmptyException, ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayEmpty(POSITIVE_ARRAY));
    }

    @Test(description = "Тестирует массив без данных")
    public void testIsArrayEmptyTextWithSpaces() throws ArrayEmptyException, ArrayNullException {
        Assert.assertTrue(ArrayUtilities.isArrayEmpty(NOT_VALUE_ARRAY));
    }
}
