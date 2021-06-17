package com.example.utilits;

public class StringUtilities {

    // Количество вхождений подстроки в строку
    public static int countTargetStr(String str, String target) {
        int countTarger = 0;

        if (str == null || str.isEmpty()) {
            System.out.println("!!!Введена пустая строка в методе countTargetStr!!!");
        } else if (target == null || target.isEmpty()) {
            System.out.println("!!!Введена пустая подстрока в методе countTargetStr!!!");
        } else {
            countTarger = (str.length() - str.replace(target, "").length()) / target.length();
        }

        return countTarger;
    }

    // Кол-во слов в строке
    public static int countWordsInStr(String str) {
        int countWords = 0;

        if (str == null || str.isEmpty()) {
            System.out.println("!!!Введена неинициализированая или пустая строка в методе countWordsInStr!!!");
        } else {
            str = str.trim();
            countWords = str.split("\\s+").length;
        }

        return countWords;
    }

    // Проверяем является ли слово палиндромом
    public static boolean checkWordPalindrome(String word) {
        boolean result = false;

        if (word == null || word.isEmpty()) {
            System.out.println("!!!Введена неинициализированая или пустая строка в методе checkWordPalindrome!!!");
        } else {
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
        return word.matches("[a-zA-Z]+");
    }
}
