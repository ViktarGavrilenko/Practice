package com.example.utilities;

import java.util.Arrays;

public class ArrayUtilities {
    // Вывод на печать двумерного массива
    public static void printTwoDimensionalArray(int[][] inArray) {
        if (checkArrayNullOrEmpty(inArray)) {
            for (int[] ints : inArray) {
                System.out.println(Arrays.toString(ints));
            }
        }
    }

    // Среднее арифметическое значение массива
    public static float getAverageArray(int[] inArray) {
        float averageArray = 0;

        if (checkArrayNullOrEmpty(inArray)) {
            for (int i : inArray) {
                averageArray = averageArray + i;
            }
            averageArray = averageArray / inArray.length;
        }
        return averageArray;
    }

    // Поиск максимального значения в массиве
    public static int getMaxValueArray(int[] inArray) {
        int maxValue = 0;

        if (checkArrayNullOrEmpty(inArray)) {
            maxValue = inArray[0];
            for (int x = 1; x < inArray.length; x++) {
                if (maxValue < inArray[x]) {
                    maxValue = inArray[x];
                }
            }
        }

        return maxValue;
    }

    // Поиск минимального значения в массиве
    public static int getMinValueArray(int[] inArray) {
        int minValue = 0;

        if (checkArrayNullOrEmpty(inArray)) {
            minValue = inArray[0];
            for (int x = 1; x < inArray.length; x++) {
                if (minValue > inArray[x]) {
                    minValue = inArray[x];
                }
            }
        }

        return minValue;
    }

    // Поиск индекса первого элемента массива с определенным значением
    public static int getFirstIndexOfArrayGivenValue(int[] inArray, int givenValue) {
        int indexArray = -1;

        if (checkArrayNullOrEmpty(inArray)) {
            for (int x = 0; x < inArray.length; x++) {
                if (givenValue == inArray[x]) {
                    indexArray = x;
                    break;
                }
            }
        }

        return indexArray;
    }

    // Поиск индекса последнего элемента массива с определенным значением
    public static int getLastIndexOfArrayGivenValue(int[] inArray, int givenValue) {
        int indexArray = -1;

        if (checkArrayNullOrEmpty(inArray)) {
            for (int x = inArray.length - 1; x >= 0; x--) {
                if (givenValue == inArray[x]) {
                    indexArray = x;
                    break;
                }
            }
        }

        return indexArray;
    }

    // Поиск суммы элементов массива между двумя заданными элементами, сами элементы в сумму не включаются
    public static int getSumElementsArray(int[] inArray, int firstElement, int lastElement) {
        int sumElementsArray = 0;
        int tempElement;

        if (firstElement > lastElement) {
            tempElement = firstElement;
            firstElement = lastElement;
            lastElement = tempElement;
        }

        if (checkArrayNullOrEmpty(inArray)) {
            for (int x = firstElement + 1; x < lastElement; x++) {
                sumElementsArray = sumElementsArray + inArray[x];
            }
        }

        return sumElementsArray;
    }

    // Проверка одномерного массива: не инициализирован ли массив или пустой
    public static boolean checkArrayNullOrEmpty(int[] inArray) {
        boolean checkArray;

        if (inArray == null || inArray.length < 1) {
            System.out.println("Массив не инициализирован или пустой!");
            checkArray = false;
        } else {
            checkArray = true;
        }

        return checkArray;
    }

    // Проверка двумерного массива: не инициализирован ли массив или пустой
    public static boolean checkArrayNullOrEmpty(int[][] inArray) {
        boolean checkArray;

        if (inArray == null || inArray.length < 1) {
            System.out.println("Массив не инициализирован или пустой!");
            checkArray = false;
        } else {
            checkArray = true;
        }

        return checkArray;
    }

}
