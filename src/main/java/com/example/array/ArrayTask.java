package com.example.array;

import static com.example.utilities.ArrayUtilities.*;

public class ArrayTask {

    //  Меняем элементы массива в обратном порядке
    public int[] reverseArray(int[] inArray) {
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
    public int[] addRandomValue(int[] inArray) {
        if (isNullOrEmpty(inArray)) {
            for (int x = 0; x < inArray.length; x++) {
                inArray[x] = (int) (Math.random() * 5);
            }
        }

        return inArray;
    }

    // Сравниваем средние арифметические значения двух массивов
    public void compareAverageArrays(int[] firstArray, int[] secondArray) {
        float resultCompare;
        if (isNullOrEmpty(firstArray)) {
            if (isNullOrEmpty(secondArray)) {
                resultCompare = Float.compare(getAverage(firstArray), getAverage(secondArray));
                if (resultCompare == 0) {
                    System.out.println("Средние арифметические значения массивов равны");
                } else if (resultCompare > 0) {
                    System.out.println("Среднее арифметическое первого массива больше второго");
                } else {
                    System.out.println("Среднее арифметическое второго массива больше первого");
                }
            }
        }
    }

    // Поиск максимального и минимального значения каждой строки двумерного массива
    public int[][] searchMinMaxValueTwoArray(int[][] inArray) {
        int[][] outArray = new int[5][2];

        if (isNullOrEmpty(inArray)) {
            for (int x = 0; x < inArray.length; x++) {
                outArray[x][0] = getMaxValue(inArray[x]);
                outArray[x][1] = getMinValue(inArray[x]);
            }
        }

        return outArray;
    }

    // Поиск уникальных значений массива
    public void searchUniqueValue(int[] inArray) {
        boolean uniqueValue = false;

        if (isNullOrEmpty(inArray)) {
            for (int x = 0; x < inArray.length; x++) {
                for (int y = 0; y < inArray.length; y++) {
                    // TODO agorozhanko 27.06.2021: лишняя булиновская переменная, можно обойтись без неё
                    if (inArray[x] == inArray[y] && x != y) {
                        uniqueValue = false;
                        break;
                    } else {
                        uniqueValue = true;
                    }
                }

                if (uniqueValue) {
                    System.out.println(inArray[x]);
                }
            }
        }
    }

    // Поиск суммы между максимальным и минимальным элементами массива
    public int calcSumBetweenMinMax(int[] inArray) {
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
