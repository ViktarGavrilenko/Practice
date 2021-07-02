package com.example.utilities;

import com.example.exception.StrEmptyException;
import com.example.exception.StrNullException;
import org.apache.log4j.Logger;

public class StringUtilities {

    private static final Logger log = Logger.getLogger(StringUtilities.class);

    // Количество вхождений подстроки в строку
    public int countTarget(String str, String target) {
        int countTarger = 0;

        if (isNullOrEmpty(str) && isNullOrEmpty(target)) {
            countTarger = (str.length() - str.replace(target, "").length()) / target.length();
        }

        return countTarger;
    }

    // Кол-во слов в строке
    public int countWords(String str) {
        int countWords = 0;

        if (isNullOrEmpty(str) && !str.matches("\\s+")) {
            str = str.trim();
            countWords = str.split("\\s+").length;
        }

        return countWords;
    }

    // Проверяем является ли слово палиндромом
    public boolean isWordPalindrome(String word) {
        boolean result = false;

        if (isNullOrEmpty(word) && !word.matches("\\s+")) {
            int lengthWord = word.length();

            int firstChar = 0;
            int lastChar = lengthWord - 1;

            for (int x = 0; x < lengthWord / 2; x++) {
                if (word.charAt(firstChar) != word.charAt(lastChar)) {
                    // TODO agorozhanko 27.06.2021: можно использовать return
                    // TODO: Viktar Gavrilenko 28.06.2021: исправил
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
    public boolean isWordLatinChar(String word) {
        boolean checkWord = false;
        if (isNullOrEmpty(word)) {
            word = word.trim();
            checkWord = word.matches("[a-zA-Z]+");
        }
        return checkWord;
    }


    // Проверка строки: не инициализирована ли строка или пустая
    public boolean isNullOrEmpty(String str) {
        boolean checkArray;

        if (str == null || str.isEmpty()) {
            log.error("Получена не инициализированная или пустая строка!");
            checkArray = false;
        } else {
            checkArray = true;
        }
        return checkArray;
    }


    // Проверяем пустая ли строка
    public boolean isStrEmpty(String str) throws StrEmptyException, StrNullException {
        if (isStrNull(str) && str.equals("")) {
            throw new StrEmptyException();
        }
        return true;
    }

    // Проверяем пустая ли строка
    public boolean isStrNull(String str) throws StrNullException {
        if (str == null) {
            throw new StrNullException();
        }
        return true;
    }

    // Получение первого слова в строке
    public String getFirstWord(String str) {
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
    public String deleteFirstWord(String str) {
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
