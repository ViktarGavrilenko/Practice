package com.example.array;

import static com.example.utilities.ArrayUtilities.*;

public class ArrayTask {
// TODO agorozhanko 16.06.2021: ловить NullPointerException чтобы проверить что введена пустая переменная - плохой вариант
// TODO agorozhanko 16.06.2021: в целом плохая практика ловить NullPointerException, их не должно быть
// TODO: Viktar Gavrilenko 17.06.2021: исправил

    //  Меняем элементы массива в обратном порядке
    public int[] reverseArray(int[] inArray) {

        if (inArray == null || inArray.length < 1) {
            System.out.println("Массив в методе reverseArray неинициализирован или пустой");
        } else {
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

        if (inArray == null || inArray.length < 1) {
            System.out.println("Массив в методе addValueInArray неинициализирован или пустой");
        } else {
            for (int x = 0; x < inArray.length; x++) {
                inArray[x] = (int) (Math.random() * 5);
            }
        }

        return inArray;
    }

    // Сравниваем средние арифметические значения двух массивов
    public void compareAverageArrays(int[] firstArray, int[] secondArray) {
        float resultCompare;
        if (firstArray == null || firstArray.length < 1) {
            System.out.println("Массив в методе compareAverageArrays неинициализирован или пустой");
        } else if (secondArray == null || secondArray.length < 1) {
            System.out.println("Массив в методе compareAverageArrays неинициализирован или пустой");
        } else {
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

    // Поиск максимального и минимального значения каждой строки двумерного массива
    public int[][] searchMinMaxValueTwoArray(int[][] inArray) {
        int[][] outArray = new int[5][2];
        int maxValue;
        int minValue;

        if (inArray == null || inArray.length < 1) {
            System.out.println("Массив в методе searchMinMaxValueTwoArray неинициализирован или пустой ");
        } else {
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

        if (inArray == null || inArray.length < 1) {
            System.out.println("Массив в методе searchUniqueValueArray неинициализирован или пустой ");
        } else {
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
        int indexMax = 0;
        int indexMin = 0;
        int maxValue;
        int minValue;

        if (inArray == null || inArray.length < 1) {
            System.out.println("Массив в методе searchUniqueValueArray неинициализирован или пустой ");
        } else {
            maxValue = getMaxValueArray(inArray);
            minValue = getMinValueArray(inArray);

            for (int x = 0; x < inArray.length; x++) {
                if (maxValue == inArray[x]) {
                    indexMax = x;
                }
            }

            for (int x = inArray.length - 1; x >= 0; x--) {
                if (minValue == inArray[x]) {
                    indexMin = x;
                }
            }

            if (indexMax > indexMin) {
                for (int x = indexMin + 1; x < indexMax; x++) {
                    result = result + inArray[x];
                }
            } else {
                for (int x = indexMax + 1; x < indexMin; x++) {
                    result = result + inArray[x];
                }
            }
        }

        return result;
    }
}
