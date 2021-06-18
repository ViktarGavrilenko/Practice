package com.example.utilities;

import java.util.Arrays;

public class ArrayUtilities {
    // Вывод на печать двумерного массива
    public static void printTwoDimensionalArray(int[][] inArray) {
        if (inArray == null || inArray.length < 1) {
            System.out.println("Массив в методе printTwoDimensionalArray неинициализирован или пустой ");
        } else {
            for (int[] ints : inArray) {
                System.out.println(Arrays.toString(ints));
            }
        }
    }

    // Среднее арифметическое значение массива
    public static float getAverageArray(int[] inArray) {
        float averageArray = 0;

        if (inArray == null || inArray.length < 1) {
            System.out.println("Массив в методе getAverageArray неинициализирован или пустой");
        } else {
            for (int i : inArray) {
                averageArray = averageArray + i;
            }
            averageArray = averageArray / inArray.length;
        }
        return averageArray;
    }

    // Поиск максимального значения в массиве
    public static int getMaxValueArray(int[] inArray){
        int maxValue = 0;
        if (inArray == null || inArray.length < 1) {
            System.out.println("Массив в методе getMaxValueArray неинициализирован или пустой");
        } else {
            maxValue = inArray[0];
            for (int x = 1; x <inArray.length; x++) {
                if(maxValue < inArray[x]) {
                    maxValue = inArray[x];
                }
            }
        }

        return maxValue;
    }

    // Поиск минимального значения в массиве
    public static int getMinValueArray(int[] inArray){
        int minValue = 0;
        if (inArray == null || inArray.length < 1) {
            System.out.println("Массив в методе getMinValueArray неинициализирован или пустой");
        } else {
            minValue = inArray[0];
            for (int x = 1; x <inArray.length; x++) {
                if(minValue > inArray[x]) {
                    minValue = inArray[x];
                }
            }
        }

        return minValue;
    }
}
