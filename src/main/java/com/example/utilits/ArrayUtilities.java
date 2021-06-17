package com.example.utilits;

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
}
