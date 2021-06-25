package com.example.string;

import java.util.ArrayList;

import static com.example.utilities.StringUtilities.*;

public class StringTask {

    // Выводим строку с обратным порядком слов
    public static String putWordsReverseInString(String stringIn) {
        String stringOut = "";

        if (checkStrNullOrEmpty(stringIn)) {
            stringIn = stringIn.trim();
            int countSpaceInStr = countTargetStr(stringIn, " ");

            for (int x = 0; x < countSpaceInStr; x++) {
                if (stringOut.length() == 0) {
                    stringOut = stringIn.substring(stringIn.lastIndexOf(" ") + 1);
                } else {
                    stringOut = new StringBuilder().append(stringOut).append(" ").
                            append(stringIn.substring(stringIn.lastIndexOf(" ") + 1)).toString();
                }
                stringIn = stringIn.substring(0, stringIn.lastIndexOf(" "));
            }

            stringOut = stringOut + " " + stringIn;
        }

        return stringOut;
    }

    //  Заменяет каждое второе вхождение строки
    public static String replaceEverySecondEntryString(String str, String entryMax, String entryMin) {

        if (checkStrNullOrEmpty(str) && checkStrNullOrEmpty(entryMax)) {
            if (entryMin == null) {
                System.out.println("Строка не инициализирована!");
            } else {
                String lowerCaseStr = str.toLowerCase();
                String lowerCaseEntryMax = entryMax.toLowerCase();

                int lengthEntryMax = entryMax.length();
                int countEntryMaxInStr = countTargetStr(lowerCaseStr, lowerCaseEntryMax);
                int indexStart = 0;
                int indexEntryMax;

                for (int x = 0; x < countEntryMaxInStr; x++) {
                    indexEntryMax = lowerCaseStr.indexOf(lowerCaseEntryMax, indexStart);

                    if (x % 2 == 0) {
                        indexStart = indexEntryMax + lengthEntryMax;
                    } else {
                        lowerCaseStr = lowerCaseStr.substring(0, indexEntryMax) + entryMin +
                                lowerCaseStr.substring(indexEntryMax + lengthEntryMax);
                        str = str.substring(0, indexEntryMax) + entryMin + str.substring(indexEntryMax + lengthEntryMax);
                        indexStart = indexEntryMax + entryMin.length();
                    }
                }
            }
        }

        return str;
    }

    // Поиск слова с минимальным числом различных символов. Если таких слов несколько, найти первое из них
    public static String minNumberDistinctChar(String str) {
        String outWord = "";
        String word;

        if (checkStrNullOrEmpty(str)) {
            str = str.trim();

            int countCharMinWord = str.length();
            int countWords = countWordsInStr(str);
            int minChar;
            int lastSpace;

            for (int x = 0; x < countWords; x++) {
                lastSpace = str.lastIndexOf(" ");
                word = str.substring(lastSpace + 1);

                if (lastSpace != -1) {
                    str = str.substring(0, lastSpace);
                }

                minChar = (int) word.chars().distinct().count();

                if (minChar <= countCharMinWord) {
                    countCharMinWord = minChar;
                    outWord = word;
                }

                str = str.trim();
            }
        }

        return outWord;
    }

    // Поиск кол-во слов в предложении, содержащих только символы латинского алфавита
    public static int searchCountWordLatinChar(String str) {
        int countWordLatinChar = 0;
        int lastSpace;
        String word;

        if (checkStrNullOrEmpty(str)) {
            int countWordsStr = countWordsInStr(str);
            str = str.trim();
            for (int x = 0; x < countWordsStr; x++) {
                lastSpace = str.lastIndexOf(" ");
                word = str.substring(lastSpace + 1);

                if (checkWordLatinChar(word)) {
                    countWordLatinChar++;
                }

                if (lastSpace != -1) {
                    str = str.substring(0, lastSpace);
                }

                str = str.trim();
            }
        }

        return countWordLatinChar;
    }

    // Ищем в строке числовые палиндромы
    public static ArrayList<String> searchNumericPalindromes(String str) {
        ArrayList<String> numericPalindromes = new ArrayList<String>();
        String word;

        if (checkStrNullOrEmpty(str)) {
            int countWordStr = countWordsInStr(str);
            str = str.trim();

            for (int x = 0; x < countWordStr; x++) {
                word = getFirstWordStr(str);

                if (word.matches("\\d+") && checkWordPalindrome(word)) {
                    numericPalindromes.add(word);
                }

                str = deleteFirstWordStr(str);
                str = str.trim();
            }
        }

        return numericPalindromes;
    }

}

