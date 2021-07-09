package com.example.string;

import com.example.exception.StrEmptyException;
import com.example.exception.StrNullException;
import org.apache.log4j.Logger;

import java.util.ArrayList;

import static com.example.utilities.StringUtilities.*;

public class StringTask {

    private static final Logger log = Logger.getLogger(StringTask.class);

    // Выводим строку с обратным порядком слов
    public String putReverseWordOrder(String stringIn) throws StrEmptyException, StrNullException {
        StringBuilder stringOut = new StringBuilder();
        if (isNullOrEmpty(stringIn) && !stringIn.matches("\\s+")) {
            stringIn = stringIn.trim();
            int countSpaceInStr = countTarget(stringIn, " ");

            for (int x = 0; x < countSpaceInStr; x++) {
                if (stringOut.length() == 0) {
                    stringOut = new StringBuilder(stringIn.substring(stringIn.lastIndexOf(" ") + 1));
                } else {
                    stringOut.append(" ").append(stringIn.substring(stringIn.lastIndexOf(" ") + 1));
                }
                stringIn = stringIn.substring(0, stringIn.lastIndexOf(" "));
            }

            stringOut.append(" ").append(stringIn);
        }

        return stringOut.toString();
    }

    //  Заменяет каждое второе вхождение строки
    public String replaceEverySecondEntry(String str, String entryMax, String entryMin) throws StrEmptyException, StrNullException {
        if (isNullOrEmpty(str) && isNullOrEmpty(entryMax)) {
            if (entryMin == null) {
                log.error("Строка не инициализирована!");
            } else {
                String lowerCaseStr = str.toLowerCase();
                String lowerCaseEntryMax = entryMax.toLowerCase();

                int lengthEntryMax = entryMax.length();
                int countEntryMaxInStr = countTarget(lowerCaseStr, lowerCaseEntryMax);
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
    public String minNumberDistinctChar(String str) throws StrEmptyException, StrNullException {
        String outWord = "";
        String word;

        if (isNullOrEmpty(str)) {
            str = str.trim();

            int countCharMinWord = str.length();
            int countWords = countWords(str);
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
    public int searchCountWordLatinChar(String str) throws StrEmptyException, StrNullException {
        int countWordLatinChar = 0;
        int lastSpace;
        String word;

        if (isNullOrEmpty(str)) {
            int countWordsStr = countWords(str);
            str = str.trim();
            for (int x = 0; x < countWordsStr; x++) {
                lastSpace = str.lastIndexOf(" ");
                word = str.substring(lastSpace + 1);

                if (isWordLatinChar(word)) {
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
    public ArrayList<String> searchNumericPalindromes(String str) throws StrEmptyException, StrNullException {
        ArrayList<String> numericPalindromes = new ArrayList<>();
        String word;

        if (isNullOrEmpty(str) && !str.matches("\\s+")) {
            int countWordStr = countWords(str);
            str = str.trim();

            for (int x = 0; x < countWordStr; x++) {
                word = getFirstWord(str);

                if (word.matches("\\d+") && isWordPalindrome(word)) {
                    numericPalindromes.add(word);
                }

                str = deleteFirstWord(str);
                str = str.trim();
            }
        }

        return numericPalindromes;
    }
}

