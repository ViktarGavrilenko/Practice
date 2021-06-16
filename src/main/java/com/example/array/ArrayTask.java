package com.example.array;

import java.util.Arrays;

public class ArrayTask {

    // TODO agorozhanko 12.06.2021: что будет если ввести пустой или неинициализированный массив?
    // TODO: Viktar Gavrilenko 14.06.2021: добавил исключение и сообщения о пустом и неинициализируемом массиве
    //  Меняем элементы массива в обратном порядке
    public int[] reverseArray(int[] inArray) {
        try {
            if (inArray.length < 1) {
                System.out.println("Массив в методе reverseArray пустой ");
            }

            int tempVariable;
            int lastValue = inArray.length - 1;

            for (int x = 0; x < inArray.length / 2; x++) {
                tempVariable = inArray[x];
                inArray[x] = inArray[lastValue];
                inArray[lastValue] = tempVariable;
                lastValue--;
            }

        } catch (NullPointerException e) {
            System.out.println("Массив в методе reverseArray неинициализирован");
            System.out.println("Метод reverseArray вернул ошибку " + e);
        }

        return inArray;
    }

    // Заполняем массив случайными числами от 0 до 5
    public int[] addValueInArray(int[] inArray) {
        try {
            for (int x = 0; x < inArray.length; x++) {
                inArray[x] = (int) (Math.random() * 5);
            }
        } catch (NullPointerException e) {
            System.out.println("Массив в методе addValueInArray неинициализирован");
            System.out.println("Метод addValueInArray вернул ошибку " + e);
        }

        return inArray;
    }

    // Сравниваем средне арифметические значения двух массивов
    public void compareAverageArrays(int[] firstArray, int[] secondArray) {
        float averageFirstArray = 0;
        float averageSecondArray = 0;

        try {
            for (int x = 0; x < 5; x++) {
                averageFirstArray = averageFirstArray + firstArray[x];
                averageSecondArray = averageSecondArray + secondArray[x];
            }

            averageFirstArray = averageFirstArray / firstArray.length;
            averageSecondArray = averageSecondArray / secondArray.length;

            compareValue(averageFirstArray, averageSecondArray);
        } catch (NullPointerException e) {
            System.out.println("Массив в методе compareAverageArrays неинициализирован");
            System.out.println("Метод compareAverageArrays вернул ошибку " + e);
        }
    }

    // TODO agorozhanko 12.06.2021: здесь не имеет смысла хранить и возвращать строковую переменную используй sout
    // TODO: Viktar Gavrilenko 14.06.2021: использовал sout для вывода информации
    // Выводим результат сравнения двух чисел
    public void compareValue(float first, float second) {
        // TODO agorozhanko 12.06.2021: заиспользуй тут оператор switch
        // TODO: Viktar Gavrilenko 14.06.2021: в данном случае рациональнее применить if else
        if (first > second) {
            System.out.println("Среднее арифметическое первого массива больше второго");
        } else if (first < second) {
            System.out.println("Среднее арифметическое второго массива больше первого");
        } else {
            System.out.println("Средние арифметические значения массивов равны");
        }
    }

    // TODO agorozhanko 12.06.2021: метод выполняет 2 действия, каждый метод должен выполнять одну операцию
    // TODO: Viktar Gavrilenko 14.06.2021: создал второй метод printTwoDimensionalArray, для вывода двумерного массива
    // Поиск максимального и минимального значения каждой строки двумерного массива
    public int[][] searchMinMaxValueTwoArray(int[][] inArray) {
        int[][] outArray = new int[5][2];
        int maxValue;
        int minValue;

        try {
            if (inArray.length < 1) {
                System.out.println("Массив в методе searchMinMaxValueTwoArray пустой ");
            }
            for (int x = 0; x < inArray.length; x++) {
                maxValue = inArray[x][0];
                minValue = inArray[x][0];

                for (int y = 0; y < inArray[x].length; y++) {
                    if (maxValue < inArray[x][y]) {
                        maxValue = inArray[x][y];
                    }

                    if (minValue > inArray[x][y]) {
                        minValue = inArray[x][y];
                    }
                }

                outArray[x][0] = maxValue;
                outArray[x][1] = minValue;
            }
        } catch (NullPointerException e) {
            System.out.println("Массив в методе searchMinMaxValueTwoArray неинициализирован");
            System.out.println("Метод searchMinMaxValueTwoArray вернул ошибку " + e);
        }

        return outArray;
    }

    // Вывод на печать двумерного массива
    public void printTwoDimensionalArray(int[][] inArray) {
        try {
            if (inArray.length < 1) {
                System.out.println("Массив в методе printTwoDimensionalArray пустой ");
            }

            for (int x = 0; x < inArray.length; x++) {
                System.out.println(Arrays.toString(inArray[x]));
            }
        } catch (NullPointerException e) {
            System.out.println("Массив в методе printTwoDimensionalArray неинициализирован");
            System.out.println("Метод printTwoDimensionalArray вернул ошибку " + e);
        }
    }
}
