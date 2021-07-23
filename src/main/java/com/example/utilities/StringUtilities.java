package com.example.utilities;

import com.example.exception.StrEmptyException;
import com.example.exception.StrNullException;
import org.apache.log4j.Logger;

public class StringUtilities {

    private static final Logger log = Logger.getLogger(StringUtilities.class);

    // Количество вхождений подстроки в строку
    public static int countTarget(String str, String target) throws StrEmptyException, StrNullException {
        int countTarget = 0;

        if (isNullOrEmpty(str) && isNullOrEmpty(target)) {
            countTarget = (str.length() - str.replace(target, "").length()) / target.length();
        }

        return countTarget;
    }


    // Кол-во слов в строке
    public static int countWords(String str) {
        int countWords = 0;

        try {
            if (isNullOrEmpty(str) && !str.matches("\\s+")) {
                str = str.trim();
                countWords = str.split("\\s+").length;
            }
        } catch (StrEmptyException | StrNullException e) {
            log.info(e.getMessage());
            return countWords;
        }
        return countWords;
    }

    // Проверяем является ли слово палиндромом
    public static boolean isWordPalindrome(String word) throws StrEmptyException, StrNullException {
        boolean result = false;

        if (isNullOrEmpty(word) && !word.matches("\\s+")) {
            int lengthWord = word.length();

            int firstChar = 0;
            int lastChar = lengthWord - 1;

            for (int x = 0; x < lengthWord / 2; x++) {
                if (word.charAt(firstChar) != word.charAt(lastChar)) {
                    return false;
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
    public static boolean isWordLatinChar(String word) throws StrEmptyException, StrNullException {
        if (isNullOrEmpty(word)) {
            word = word.trim();
            return word.matches("[a-zA-Z]+");
        } else {
            return false;
        }
    }


    // Проверка строки: не инициализирована ли строка или пустая
    public static boolean isNullOrEmpty(String str) throws StrNullException, StrEmptyException {
        if (!isStrNull(str) || !isStrEmpty(str)) {
            log.error("Получена не инициализированная или пустая строка!");
            return false;
        } else {
            return true;
        }
    }


    // Проверяем пустая ли строка
    public static boolean isStrEmpty(String str) throws StrEmptyException, StrNullException {
        if (isStrNull(str) && str.equals("")) {
            throw new StrEmptyException();
        }
        return true;
    }

    // Проверяем пустая ли строка
    public static boolean isStrNull(String str) throws StrNullException {
        if (str == null) {
            throw new StrNullException();
        }
        return true;
    }

    // Получение первого слова в строке
    public static String getFirstWord(String str) throws StrEmptyException, StrNullException {
        String firstWord = null;
        int firstSpace;

        if (isNullOrEmpty(str) && !str.matches("\\s+")) {
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
    public static String deleteFirstWord(String str) throws StrEmptyException, StrNullException {
        if (isNullOrEmpty(str) && !str.matches("\\s+")) {
            str = str.trim();
            int firstSpace = str.indexOf(" ");
            if (firstSpace != -1) {
                str = str.substring(firstSpace + 1);
            }
        }
        return str;
    }
}
