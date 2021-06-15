package com.example.String;

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
                    stringOut = stringOut + " " + stringIn.substring(stringIn.lastIndexOf(" ") + 1);
                }
                stringIn = stringIn.substring(0, stringIn.lastIndexOf(" "));
            }

            stringOut = stringOut + " " + stringIn;
        }

        return stringOut;
    }

    // TODO agorozhanko 12.06.2021: копипаст
    // TODO: Viktar Gavrilenko 15.06.2021: оставил один вариант
    // Количество вхождений подстроки в строку
    public int countTargetStr(String str, String target) {
        int countTarger = 0;
        try {
            if (str == null || str.isEmpty()) {
                System.out.println("!!!Введена пустая строка в методе countTargetStr!!!");
            }

            if (target == null || target.isEmpty()) {
                System.out.println("!!!Введена пустая подстрока в методе countTargetStr!!!");
            }
            countTarger = (str.length() - str.replace(target, "").length()) / target.length();

        } catch (NullPointerException e) {
            System.out.println("Строка в методе countTargetStr неинициализирован");
            System.out.println("Метод countTargetStr вернул ошибку " + e);
        }
        return countTarger;
    }

    //  Заменяет каждое второе вхождение строки
    public String replaceEverySecondEntryString(String str, String entryMax, String entryMin) {
        try {
            if (str.isEmpty()) {
                System.out.println("!!!Введена пустая строка в методе replaceEverySecondEntryString!!!");
            } else if (entryMax.isEmpty()) {
                System.out.println("!!!Введена пустая подстрока в методе replaceEverySecondEntryString!!!");
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
                        // TODO agorozhanko 12.06.2021: для чего тут пустые строки?
                        // TODO: Viktar Gavrilenko 14.06.2021: исправил (почему-то думал, что соединять переменные
                        //  в одной строке нужно через пустые кавычки)
                        lowerCaseStr = lowerCaseStr.substring(0, indexEntryMax) + entryMin +
                                lowerCaseStr.substring(indexEntryMax + lengthEntryMax);
                        str = str.substring(0, indexEntryMax) + entryMin + str.substring(indexEntryMax + lengthEntryMax);
                        indexStart = indexEntryMax + entryMin.length();
                    }
                }

            }
        } catch (NullPointerException e) {
            System.out.println("Метод replaceEverySecondEntryString вернул исключение " + e.getMessage());
        }
        return str;

    }

    // Поиск слова с минимальным числом различных символов. Если таких слов несколько, найти первое из них
    public String minNumberDistinctChar(String str) {
        String outWord = "";
        String word;

        if (str == null || str.isEmpty()) {
            System.out.println("!!!Введена пустая строка в методе minNumberDistinctChar!!!");
        } else {
            int countCharMinWord = str.length();
            int countWords = str.split("\\s+").length;
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
}

