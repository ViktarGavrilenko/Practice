package com.example.utilities;

import com.example.exception.MyException;

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
            if (checkNumberLimitValueArray(inArray, firstElement)) {
                if (checkNumberLimitValueArray(inArray, lastElement)) {
                    for (int x = firstElement + 1; x < lastElement; x++) {
                        sumElementsArray = sumElementsArray + inArray[x];
                    }
                }
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
        } else if (inArray[0].length < 1) {
            System.out.println("Массив пустой!");
            checkArray = false;
        } else {
            checkArray = true;
        }

        return checkArray;
    }

    // Проверка массива на инициализацию с помощь моего исключения
    public static void checkArray(int[] inArray) {
        System.out.println("Начало проверки массива на инициализацию");
        try {
            if (inArray == null || inArray.length < 1) {
                throw new MyException();
            }
        } catch (MyException e) {
            System.out.println("Ошибка! Массив не инициализирован или пустой. " + e.toString());
        } finally {
            System.out.println("Проверка массива выполнена");
        }
    }

    // Проверяет, что число не выходит за пределы массива
    public static boolean checkNumberLimitValueArray(int[] inArray, int number) {
        boolean resultCheck = false;
        if (checkArrayNullOrEmpty(inArray)) {
            if (-1 < number && number < inArray.length) {
                resultCheck = true;
            } else {
                System.out.println("Значение выходит за пределы массива");
            }
        }
        return resultCheck;
    }

}
