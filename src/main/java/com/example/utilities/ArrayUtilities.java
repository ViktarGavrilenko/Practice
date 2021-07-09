package com.example.utilities;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayNullException;
import com.example.exception.ValueOutsideArrayException;
import org.apache.log4j.Logger;

public class ArrayUtilities {

    private static final Logger log = Logger.getLogger(ArrayUtilities.class);

    // Среднее арифметическое значение массива
    public static float getAverage(int[] inArray) throws ArrayEmptyException, ArrayNullException {
        float averageArray = 0;

        if (isNullOrEmpty(inArray)) {
            for (int i : inArray) {
                averageArray = averageArray + i;
            }
            averageArray = averageArray / inArray.length;
        }
        return averageArray;
    }

    // Поиск максимального значения в массиве
    public static int getMaxValue(int[] inArray) throws ArrayEmptyException, ArrayNullException {
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
    public static int getMinValue(int[] inArray) throws ArrayEmptyException, ArrayNullException {
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
    public static int getFirstIndexWithGivenValue(int[] inArray, int givenValue) throws ArrayEmptyException, ArrayNullException {
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
    public static int getLastIndexWithGivenValue(int[] inArray, int givenValue) throws ArrayEmptyException, ArrayNullException {
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
    public static int getSumBetweenElements(int[] inArray, int firstElement, int lastElement) throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
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
    public static boolean isNullOrEmpty(int[] inArray) throws ArrayEmptyException, ArrayNullException {
        if (!isArrayNull(inArray) || !isArrayEmpty(inArray)) {
            log.error("Массив не инициализирован или пустой!");
            return false;
        } else {
            return true;
        }
    }

    // Проверка двумерного массива: не инициализирован ли массив или пустой
    public static boolean isNullOrEmpty(int[][] inArray) {
        if (inArray == null || inArray.length < 1) {
            log.error("Массив не инициализирован или пустой!");
            return false;
        } else if (inArray[0].length < 1) {
            log.error("Массив пустой!");
            return false;
        } else {
            return true;
        }
    }

    // Проверка массива на инициализацию
    public static boolean isArrayNull(int[] inArray) throws ArrayNullException {
        if (inArray == null) {
            throw new ArrayNullException();
        }
        return true;
    }

    // Проверяем пустой ли массив
    public static boolean isArrayEmpty(int[] inArray) throws ArrayEmptyException, ArrayNullException {
        if (isArrayNull(inArray) && (inArray.length < 1)) {
            throw new ArrayEmptyException();
        }
        return true;
    }

    // Проверяет, что число не выходит за пределы массива
    public static boolean isNumberOutsideArray(int[] inArray, int number) throws ValueOutsideArrayException, ArrayEmptyException, ArrayNullException {
        if (isNullOrEmpty(inArray)) {
            if (-1 < number && number < inArray.length) {
                return true;
            } else {
                throw new ValueOutsideArrayException();
            }
        } else {
            return false;
        }
    }

}
