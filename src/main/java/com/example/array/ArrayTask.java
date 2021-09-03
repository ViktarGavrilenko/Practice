package com.example.array;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayNullException;
import com.example.exception.ValueOutsideArrayException;

import java.util.ArrayList;

import static com.example.utilities.ArrayUtilities.*;

/**
 * Performs tasks with arrays
 *
 * @author Viktar Gavrilenko
 * @version 1.0
 */

public class ArrayTask {

    //  Меняем элементы массива в обратном порядке

    /**
     * Swaps the elements of an array in reverse order
     *
     * @param inArray is an array in which to replace the elements with places
     * @return array with replaced elements in reverse order
     * @throws ArrayEmptyException if the array is empty
     * @throws ArrayNullException  if the array is not initialized
     */

    public int[] reverseArray(int[] inArray) throws ArrayEmptyException, ArrayNullException {
        if (isNullOrEmpty(inArray)) {
            int tempVariable;
            int lastValue = inArray.length - 1;

            for (int x = 0; x < inArray.length / 2; x++) {
                tempVariable = inArray[x];
                inArray[x] = inArray[lastValue];
                inArray[lastValue] = tempVariable;
                lastValue--;
            }
        }

        return inArray;
    }

    // Заполняем массив случайными числами от 0 до 5

    /**
     * Fills an array with random numbers from 0 to 5
     *
     * @param inArray is an array to be filled
     * @return filled array
     * @throws ArrayEmptyException if the array is empty
     * @throws ArrayNullException  if the array is not initialized
     */
    public int[] addRandomValue(int[] inArray) throws ArrayEmptyException, ArrayNullException {
        if (isNullOrEmpty(inArray)) {
            for (int x = 0; x < inArray.length; x++) {
                inArray[x] = (int) (Math.random() * 5);
            }
        }

        return inArray;
    }

    // Сравниваем средние арифметические значения двух массивов

    /**
     * Compares the arithmetic mean of two arrays
     *
     * @param firstArray  is first array to compare
     * @param secondArray is second array to compare
     * @return 0 if the values are equal,
     * 1 if the arithmetic mean of the first array is greater than the second,
     * 2 if the arithmetic mean of the first array is less than the second,
     * -1 if the arrays are empty or not initialized
     * @throws ArrayEmptyException if the array is empty
     * @throws ArrayNullException  if the array is not initialized
     */
    public byte compareAverageArrays(int[] firstArray, int[] secondArray) throws ArrayEmptyException, ArrayNullException {
        float resultCompare;
        if (isNullOrEmpty(firstArray) && isNullOrEmpty(secondArray)) {
            resultCompare = Float.compare(getAverage(firstArray), getAverage(secondArray));
            if (resultCompare == 0) {
                return 0;
            } else if (resultCompare > 0) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return -1;
        }
    }

    // Поиск максимального и минимального значения каждой строки двумерного массива

    /**
     * Searches for the maximum and minimum value in each row of a two-dimensional array
     *
     * @param inArray is a two-dimensional array in which the values will be searched
     * @return two-dimensional array with maximum and minimum value for each row
     * @throws ArrayEmptyException if the array is empty
     * @throws ArrayNullException  if the array is not initialized
     */
    public int[][] searchMaxMinValueTwoArray(int[][] inArray) throws ArrayEmptyException, ArrayNullException {
        int[][] outArray = null;
        if (isNullOrEmpty(inArray)) {
            outArray = new int[inArray.length][2];
            for (int x = 0; x < inArray.length; x++) {
                outArray[x][0] = getMaxValue(inArray[x]);
                outArray[x][1] = getMinValue(inArray[x]);
            }
        }
        return outArray;
    }

    // Поиск уникальных значений массива

    /**
     * Finds unique values in an array
     *
     * @param inArray is an array in which to find unique values
     * @return returns a list of unique array values
     * @throws ArrayEmptyException if the array is empty
     * @throws ArrayNullException  if the array is not initialized
     */
    public ArrayList<Integer> searchUniqueValue(int[] inArray) throws ArrayEmptyException, ArrayNullException {
        ArrayList<Integer> uniqueValue = new ArrayList<>();

        if (isNullOrEmpty(inArray)) {
            boolean isUniqueValue = false;
            for (int x = 0; x < inArray.length; x++) {
                for (int y = 0; y < inArray.length; y++) {
                    if (inArray[x] == inArray[y] && x != y) {
                        isUniqueValue = false;
                        break;
                    } else {
                        isUniqueValue = true;
                    }
                }

                if (isUniqueValue) {
                    uniqueValue.add(inArray[x]);
                }
            }
        }
        return uniqueValue;
    }

    // Поиск суммы между максимальным и минимальным элементами массива

    /**
     * Finds the sum of the elements of an array, between the maximum and minimum values
     *
     * @param inArray is an array in which you need to find the sum between the maximum and minimum values
     * @return Returns the sum of the elements between the maximum and minimum values of an array.
     * Returns 0 if the array is empty or not initialized
     * @throws ValueOutsideArrayException if the values are outside the array
     * @throws ArrayEmptyException        if the array is empty
     * @throws ArrayNullException         if the array is not initialized
     */
    public int calcSumBetweenMinMax(int[] inArray) throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        int indexMax;
        int indexMin;
        int maxValue;
        int minValue;

        if (isNullOrEmpty(inArray)) {
            maxValue = getMaxValue(inArray);
            minValue = getMinValue(inArray);

            indexMax = getLastIndexWithGivenValue(inArray, maxValue);
            indexMin = getFirstIndexWithGivenValue(inArray, minValue);

            return getSumBetweenElements(inArray, indexMin, indexMax);
        } else {
            return 0;
        }
    }
}
