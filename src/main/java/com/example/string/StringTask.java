package com.example.string;

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

    // Кол-во слов в строке
    public int countWordsInStr(String str) {
        int countWords = 0;

        try {
            str = str.trim();
            countWords = str.split("\\s+").length;
        } catch (NullPointerException e) {
            System.out.println("Метод countWordsInStr вернул исключение " + e.getMessage());
            System.out.println("неинициализирована переменная str в методе");
        }

        return countWords;
    }

    // Проверяем слово на содержание символов только латинского алфавита
    public boolean checkWordLatinChar(String word) {
        return word.matches("[a-zA-Z]+");
    }

    // Поиск кол-во слов в предложении, содержащих только символы латинского алфавита
    public int searchCountWordLatinChar(String str) {
        int countWordLatinChar = 0;
        int lastSpace;
        String word;

        try {
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
        } catch (NullPointerException e) {
            System.out.println("Метод findCountWordLatinChar вернул исключение " + e.getMessage());
            System.out.println("неинициализирована переменная str в методе");
        }

        return countWordLatinChar;
    }

    // Ищем в строке числовые палиндромы
    public void searchNumericPalindromes(String str) {
        String word;
        int firstSpace;
        int countWordStr = countWordsInStr(str);

        try {
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

        } catch (NullPointerException e) {
            System.out.println("Метод searchNumericPalindromes вернул исключение " + e.getMessage());
            System.out.println("неинициализирована переменная str в методе");
        }
    }

    // Проверяем является ли слово палиндромом
    public boolean checkWordPalindrome(String word) {
        boolean result = false;
        try {
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
        } catch (NullPointerException e) {
            System.out.println("Метод checkWordPalindrome вернул исключение " + e.getMessage());
            System.out.println("неинициализирована переменная word в методе");
        }
        
        return result;
    }


}

