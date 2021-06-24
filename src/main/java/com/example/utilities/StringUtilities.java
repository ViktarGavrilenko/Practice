package com.example.utilities;

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
            checkWord =  word.matches("[a-zA-Z]+");
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
}
