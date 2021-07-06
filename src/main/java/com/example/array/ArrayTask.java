package com.example.array;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayNullException;
import com.example.exception.ValueOutsideArrayException;

import java.util.ArrayList;

import static com.example.utilities.ArrayUtilities.*;

public class ArrayTask {

    //  Меняем элементы массива в обратном порядке
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
    public int[] addRandomValue(int[] inArray) throws ArrayEmptyException, ArrayNullException {
        if (isNullOrEmpty(inArray)) {
            for (int x = 0; x < inArray.length; x++) {
                inArray[x] = (int) (Math.random() * 5);
            }
        }

        return inArray;
    }

    // Сравниваем средние арифметические значения двух массивов
    public byte compareAverageArrays(int[] firstArray, int[] secondArray) throws ArrayEmptyException, ArrayNullException {
        float resultCompare;
        byte result = -1;
        if (isNullOrEmpty(firstArray) && isNullOrEmpty(secondArray)) {
            resultCompare = Float.compare(getAverage(firstArray), getAverage(secondArray));
            if (resultCompare == 0) {
                result = 0;
            } else if (resultCompare > 0) {
                result = 1;
            } else {
                result = 2;
            }
        }
        return result;
    }

    // Поиск максимального и минимального значения каждой строки двумерного массива
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
    public int calcSumBetweenMinMax(int[] inArray) throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        int result = 0;
        int indexMax;
        int indexMin;
        int maxValue;
        int minValue;

        if (isNullOrEmpty(inArray)) {
            maxValue = getMaxValue(inArray);
            minValue = getMinValue(inArray);

            indexMax = getLastIndexWithGivenValue(inArray, maxValue);
            indexMin = getFirstIndexWithGivenValue(inArray, minValue);

            result = getSumBetweenElements(inArray, indexMin, indexMax);
        }

        return result;
    }
}
