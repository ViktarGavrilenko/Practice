package com.example.array;

import java.util.ArrayList;

import static com.example.utilities.ArrayUtilities.*;

public class ArrayTask {

    //  Меняем элементы массива в обратном порядке
    public static int[] reverseArray(int[] inArray) {
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
    public static int[] addRandomValue(int[] inArray) {
        if (isNullOrEmpty(inArray)) {
            for (int x = 0; x < inArray.length; x++) {
                inArray[x] = (int) (Math.random() * 5);
            }
        }

        return inArray;
    }

    // Сравниваем средние арифметические значения двух массивов
    public static byte compareAverageArrays(int[] firstArray, int[] secondArray) {
        float resultCompare;
        byte result = -1;
        if (isNullOrEmpty(firstArray)) {
            if (isNullOrEmpty(secondArray)) {
                resultCompare = Float.compare(getAverage(firstArray), getAverage(secondArray));
                if (resultCompare == 0) {
                    result = 0;
                } else if (resultCompare > 0) {
                    result = 1;
                } else {
                    result = 2;
                }
            }
        }
        return result;
    }

    // Поиск максимального и минимального значения каждой строки двумерного массива
    public static int[][] searchMaxMinValueTwoArray(int[][] inArray) {
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
    public static ArrayList<Integer> searchUniqueValue(int[] inArray) {
        ArrayList<Integer> uniqueValue = new ArrayList<>();

        if (isNullOrEmpty(inArray)) {
            boolean isUniqueValue = false;
            for (int x = 0; x < inArray.length; x++) {
                for (int y = 0; y < inArray.length; y++) {
                    // TODO agorozhanko 27.06.2021: лишняя булиновская переменная, можно обойтись без неё
                    // TODO: Viktar Gavrilenko 01.07.2021: boolean переменная все таки нужна, так как нужно сверить
                    //  проверяемое значение зо всеми элементами массива, и только после этого принять решение
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
    public static int calcSumBetweenMinMax(int[] inArray) {
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
