package com.example.utilities;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayNullException;
import org.apache.log4j.Logger;

public class ArrayUtilities {

    private final Logger log = Logger.getLogger(ArrayUtilities.class);

    // Среднее арифметическое значение массива
    public static float getAverage(int[] inArray) {
        float averageArray = 0;
        ArrayUtilities arrayUtilities = new ArrayUtilities();
        if (arrayUtilities.isNullOrEmpty(inArray)) {
            for (int i : inArray) {
                averageArray = averageArray + i;
            }
            averageArray = averageArray / inArray.length;
        }
        return averageArray;
    }

    // Поиск максимального значения в массиве
    public int getMaxValue(int[] inArray) {
        int maxValue = 0;

        if (isNullOrEmpty(inArray)) {
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
    public int getMinValue(int[] inArray) {
        int minValue = 0;

        if (isNullOrEmpty(inArray)) {
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
    public int getFirstIndexWithGivenValue(int[] inArray, int givenValue) {
        int indexArray = -1;

        if (isNullOrEmpty(inArray)) {
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
    public int getLastIndexWithGivenValue(int[] inArray, int givenValue) {
        int indexArray = -1;

        if (isNullOrEmpty(inArray)) {
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
    public int getSumBetweenElements(int[] inArray, int firstElement, int lastElement) {
        int sumElementsArray = 0;
        int tempElement;

        if (firstElement > lastElement) {
            tempElement = firstElement;
            firstElement = lastElement;
            lastElement = tempElement;
        }

        if (isNullOrEmpty(inArray) && isNumberOutsideArray(inArray, firstElement)
                && isNumberOutsideArray(inArray, lastElement)) {
            for (int x = firstElement + 1; x < lastElement; x++) {
                sumElementsArray = sumElementsArray + inArray[x];
            }
        }

        return sumElementsArray;
    }


    // Проверка одномерного массива: не инициализирован ли массив или пустой
    public boolean isNullOrEmpty(int[] inArray) {
        boolean checkArray;

        if (inArray == null || inArray.length < 1) {
            log.error("Массив не инициализирован или пустой!");
            checkArray = false;
        } else {
            checkArray = true;
        }

        return checkArray;
    }

    // Проверка двумерного массива: не инициализирован ли массив или пустой
    public boolean isNullOrEmpty(int[][] inArray) {
        boolean checkArray;

        if (inArray == null || inArray.length < 1) {
            log.error("Массив не инициализирован или пустой!");
            checkArray = false;
        } else if (inArray[0].length < 1) {
            log.error("Массив пустой!");
            checkArray = false;
        } else {
            checkArray = true;
        }

        return checkArray;
    }

    // Проверка массива на инициализацию
    public boolean isArrayNull(int[] inArray) throws ArrayNullException {
        if (inArray == null) {
            throw new ArrayNullException();
        }
        return true;
    }

    // Проверяем пустой ли массив
    public static boolean isArrayEmpty(int[] inArray) throws ArrayEmptyException, ArrayNullException {
        ArrayUtilities arrayUtilities = new ArrayUtilities();
        if (arrayUtilities.isArrayNull(inArray) && (inArray.length < 1)) {
            throw new ArrayEmptyException();
        }
        return true;
    }

    // Проверяет, что число не выходит за пределы массива
    public boolean isNumberOutsideArray(int[] inArray, int number) {
        boolean resultCheck = false;
        if (isNullOrEmpty(inArray)) {
            if (-1 < number && number < inArray.length) {
                resultCheck = true;
            } else {
                log.error("Значение выходит за пределы массива");
            }
        }
        return resultCheck;
    }

}
