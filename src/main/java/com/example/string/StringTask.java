package com.example.string;

import static com.example.utilities.StringUtilities.*;

public class StringTask {

    // Выводим строку с обратным порядком слов
    public String putWordsReverseInString(String stringIn) {
        String stringOut = "";

        if (stringIn == null || stringIn.isEmpty()) {
            System.out.println("!!!Введена пустая строка в методе putWordsReverseInString!!!");
        } else {
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
    public String replaceEverySecondEntryString(String str, String entryMax, String entryMin) {

        if (str == null || str.isEmpty()) {
            System.out.println("!!!Введена неинициализированая или пустая строка в методе replaceEverySecondEntryString!!!");
        } else if (entryMax == null || entryMax.isEmpty()) {
            System.out.println("!!!Введена неинициализированая или пустая подстрока в методе replaceEverySecondEntryString!!!");
        } else if (entryMin == null) {
            System.out.println("!!!Введена неинициализированая подстрока в методе replaceEverySecondEntryString!!!");
        } else {
            String lowerCaseStr = str.toLowerCase();
            String lowerCaseEntryMax = entryMax.toLowerCase();

            int lengthEntryMax = entryMax.length();
            int countEntryMaxInStr = countTargetStr(lowerCaseStr, lowerCaseEntryMax);
            int indexStart = 0;
            int indexEntryMax = 0;

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

        return str;
    }

    // Поиск слова с минимальным числом различных символов. Если таких слов несколько, найти первое из них
    public String minNumberDistinctChar(String str) {
        String outWord = "";
        String word;

        if (str == null || str.isEmpty()) {
            System.out.println("!!!Введена неинициализированая или пустая строка в методе minNumberDistinctChar!!!");
        } else {
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
    public int searchCountWordLatinChar(String str) {
        int countWordLatinChar = 0;
        int lastSpace;
        String word;

        if (str == null || str.isEmpty()) {
            System.out.println("!!!Введена неинициализированая или пустая строка в методе searchCountWordLatinChar!!!");
        } else {
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
    public void searchNumericPalindromes(String str) {
        String word;
        int firstSpace;
        int countWordStr = countWordsInStr(str);

        if (str == null || str.isEmpty()) {
            System.out.println("!!!Введена неинициализированая или пустая строка в методе searchNumericPalindromes!!!");
        } else {
            str = str.trim();

            for (int x = 0; x < countWordStr; x++) {
                firstSpace = str.indexOf(" ");

                if (firstSpace != -1) {
                    word = str.substring(0, firstSpace);
                } else {
                    word = str;
                }

                if (word.matches("\\d+") && checkWordPalindrome(word)) {
                    System.out.println(word);
                }

                if (firstSpace != -1) {
                    str = str.substring(firstSpace + 1);
                }

                str = str.trim();
            }
        }
    }
}

