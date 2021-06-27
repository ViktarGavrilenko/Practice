package com.example.utilities;

import java.util.ArrayList;

public class StringUtilities {

    // Количество вхождений подстроки в строку
    public static int countTargetStr(String str, String target) {
        int countTarger = 0;

        if (checkStrNullOrEmpty(str)) {
            if (checkStrNullOrEmpty(target)) {
                countTarger = (str.length() - str.replace(target, "").length()) / target.length();
            }
        }

        return countTarger;
    }

    // Кол-во слов в строке
    public static int countWordsInStr(String str) {
        int countWords = 0;

        if (checkStrNullOrEmpty(str)) {
            str = str.trim();
            countWords = str.split("\\s+").length;
        }

        return countWords;
    }

    // Проверяем является ли слово палиндромом
    public static boolean checkWordPalindrome(String word) {
        boolean result = false;

        if (checkStrNullOrEmpty(word)) {
            int lengthWord = word.length();

            int firstChar = 0;
            int lastChar = lengthWord - 1;

            for (int x = 0; x < lengthWord / 2; x++) {
                if (word.charAt(firstChar) != word.charAt(lastChar)) {
                    // TODO agorozhanko 27.06.2021: можно использовать return
                    result = false;
                    break;
                } else {
                    firstChar++;
                    lastChar--;
                    result = true;
                }
            }
        }

        return result;
    }

    // Проверяем слово на содержание символов только латинского алфавита
    public static boolean checkWordLatinChar(String word) {
        boolean checkWord = false;
        if (checkStrNullOrEmpty(word)) {
            word = word.trim();
            checkWord = word.matches("[a-zA-Z]+");
        }
        return checkWord;
    }

    // Проверка строки: не инициализирована ли строка или пустая
    public static boolean checkStrNullOrEmpty(String str) {
        boolean checkArray;

        if (str == null || str.isEmpty()) {
            System.out.println("Получена неинициализированная или пустая строка!");
            checkArray = false;
        } else {
            checkArray = true;
        }
        return checkArray;
    }

    // Вывод на печать списка
    public static void printArrayList(ArrayList<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }

    // Получение первого слова в строке
    public static String getFirstWordStr(String str) {
        String firstWord = null;
        int firstSpace;

        if (checkStrNullOrEmpty(str)) {
            str = str.trim();
            firstSpace = str.indexOf(" ");

            if (firstSpace != -1) {
                firstWord = str.substring(0, firstSpace);
            } else {
                firstWord = str;
            }

        }
        return firstWord;
    }

    // Удалить из строки первое слово
    public static String deleteFirstWordStr(String str) {
        if (checkStrNullOrEmpty(str)) {
            str = str.trim();
            int firstSpace = str.indexOf(" ");
            if (firstSpace != -1) {
                str = str.substring(firstSpace + 1);
            }
        }
        return str;
    }
}
