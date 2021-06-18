// TODO agorozhanko 12.06.2021: методы должны быть универсальными
// TODO: Viktar Gavrilenko 17.06.2021: исправил метод compareAverageArrays

// TODO agorozhanko 12.06.2021: программа должна быть отказоустойчивой, нужно предусматривать в коде критические
//  ситуации, которые могут привести к поломкам программы
// TODO: Viktar Gavrilenko 17.06.2021: исправил (добавил в методы проверку входных параметров c помощью if else)

// TODO agorozhanko 16.06.2021: проверь код на копипаст, многое можно вынести в методы. Если есть общие методы,
//  их нужно вынести в утилиты, так сформируется дополнительный слой проекта
// TODO: Viktar Gavrilenko 17.06.2021: добавил метод getAverageArray
// TODO: Viktar Gavrilenko 17.06.2021: вынес общие методы в отдельный пакет

package com.example;

import com.example.array.ArrayTask;
import com.example.string.StringTask;

import java.util.Arrays;

import static com.example.utilities.ArrayUtilities.printTwoDimensionalArray;

public class MyMainClass {
    public static void main(String[] args) {
        String stringIn = "Object-oriented programming is a programming language" +
                " model organized around objects rather than \"actions\" and data rather than logic." +
                " Object-oriented programming blabla. Object-oriented programming bla.";

        String entryMax = "object-oriented programming";
        String entryMin = "OOP";

        int[] firstArrayToCompare = new int[5];
        int[] secondArrayToCompare = new int[5];
        int[] oneDimensionalArray = {1, 3, -1, 16, 1, 8, 17, 8, 2, 2};
        int[][] twoDimensionalArray = {{5, 8, 88, 3, 42, 10, 10, 6},
                {1, 53, 2, 3, 77, 10, 2, 54},
                {4, 3, 91, 3, 12, 10, 4, 12},
                {6, 3, 11, 3, 22, 10, 5, 60},
                {2, 4, 32, 71, 4, 40, 48, 9}};

        StringTask myString = new StringTask();
        ArrayTask myArray = new ArrayTask();

        System.out.println(myString.putWordsReverseInString("one Two three four")); // Строка с обратным порядком слов
        System.out.println(myString.replaceEverySecondEntryString(stringIn, entryMax, entryMin)); // Заменить каждое
        // второе вхождение строки
        System.out.println(myString.minNumberDistinctChar("  fffff ab f 1234 jkjk ")); // Слово с минимальным числом
        // символов
        firstArrayToCompare = myArray.addValueInArray(firstArrayToCompare);     // Заполняем массивы случайными
        secondArrayToCompare = myArray.addValueInArray(secondArrayToCompare);   // числами от 0 до 5
        System.out.println(Arrays.toString(firstArrayToCompare));   // Выводим первый массив
        System.out.println(Arrays.toString(secondArrayToCompare));  // Выводим второй массив
        myArray.compareAverageArrays(firstArrayToCompare, secondArrayToCompare);    // Сравниваем среднее арифметическое
        // двух массивов
        System.out.println(Arrays.toString(myArray.reverseArray(secondArrayToCompare))); // Меняем элементы массива в
        // обратном порядке
        printTwoDimensionalArray(twoDimensionalArray); // Выводим двумерный массив
        printTwoDimensionalArray(myArray.searchMinMaxValueTwoArray(twoDimensionalArray)); // Максимальное
        // и минимальное значение каждой строки двумерного массива
        System.out.println("------------------------------");
        System.out.println(myString.searchCountWordLatinChar("one Two three раз два три one1 two2 123 ")); // Кол-во
        // слов в предложении содержащих только латинские символы
        System.out.println("------------------------------");
        myString.searchNumericPalindromes("Если есть хвосты по дз, начните с 1 не сданного задания. 123 " +
                "324 111 4554"); // Ищем в строке числовые палиндромы
        System.out.println("------------------------------");
        myArray.searchUniqueValueArray(oneDimensionalArray); // Выводим уникальные значения массива
        System.out.println("------------------------------");
        System.out.println(myArray.calcSumBetweenMinMax(oneDimensionalArray)); // Сумма между максимальным и минимальным
        // элементами массива
    }
}
