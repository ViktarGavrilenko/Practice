package com.example.array;

import static com.example.utilities.ArrayUtilities.*;

public class ArrayTask {

    //  Меняем элементы массива в обратном порядке
    public int[] reverseArray(int[] inArray) {
        if (checkArrayNullOrEmpty(inArray)) {
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
    public int[] addValueInArray(int[] inArray) {
        if (checkArrayNullOrEmpty(inArray)) {
            for (int x = 0; x < inArray.length; x++) {
                inArray[x] = (int) (Math.random() * 5);
            }
        }

        return inArray;
    }

    // Сравниваем средние арифметические значения двух массивов
    public void compareAverageArrays(int[] firstArray, int[] secondArray) {
        float resultCompare;
        if (checkArrayNullOrEmpty(firstArray)) {
            if (checkArrayNullOrEmpty(secondArray)) {
                resultCompare = Float.compare(getAverageArray(firstArray), getAverageArray(secondArray));
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

        if (checkArrayNullOrEmpty(inArray)) {
            for (int x = 0; x < inArray.length; x++) {
                outArray[x][0] = getMaxValueArray(inArray[x]);
                outArray[x][1] = getMinValueArray(inArray[x]);
            }
        }

        return outArray;
    }

    // Поиск уникальных значений массива
    public void searchUniqueValueArray(int[] inArray) {
        boolean uniqueValue = false;

        if (checkArrayNullOrEmpty(inArray)) {
            for (int x = 0; x < inArray.length; x++) {
                for (int y = 0; y < inArray.length; y++) {
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

        if (checkArrayNullOrEmpty(inArray)) {
            maxValue = getMaxValueArray(inArray);
            minValue = getMinValueArray(inArray);

            indexMax = getLastIndexOfArrayGivenValue(inArray, maxValue);
            indexMin = getFirstIndexOfArrayGivenValue(inArray, minValue);

            result = getSumElementsArray(inArray, indexMin, indexMax);
        }

        return result;
    }
}
