package com.example.collections;

import com.example.exception.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.utilities.ArrayUtilities.getAverage;
import static com.example.utilities.CollectionsUtilities.isArrayListNotNull;
import static com.example.utilities.StringUtilities.isNullOrEmpty;

public class CollectionsTask {

    private static final Logger log = Logger.getLogger(CollectionsTask.class);

    // Удаляет студентов со средним баллом меньше 3
    public ArrayList<Students> dismissStudentGPALessThree(ArrayList<Students> listStudents) throws ArrayEmptyException,
            ArrayNullException, ArrayListNotNullException {
        if (isArrayListNotNull(listStudents)) {
            for (int x = listStudents.size() - 1; x >= 0; x--) {
                if (getAverage(marksStudent(listStudents.get(x))) < 3) {
                    listStudents.remove(x);
                }
            }
        }
        return listStudents;
    }

    // Переводит студентов со средним балом выше и равный 3 на следующий курс
    public ArrayList<Students> transferStudentNextCourseGPAThreeAndMore(ArrayList<Students> listStudents)
            throws ArrayListNotNullException, ArrayEmptyException, ArrayNullException {
        if (isArrayListNotNull(listStudents)) {
            for (int x = 0; x < listStudents.size(); x++) {
                if (getAverage(marksStudent(listStudents.get(x))) >= 3) {
                    listStudents.set(x, new Students(listStudents.get(x).name, listStudents.get(x).group,
                            (byte) (listStudents.get(x).course + 1), listStudents.get(x).mathMark,
                            listStudents.get(x).englishMark, listStudents.get(x).russianMark));
                }
            }
        }
        return listStudents;
    }

    // Получение оценок в массив
    public int[] marksStudent(Students student) {
        return new int[]{student.mathMark, student.russianMark, student.englishMark};
    }

    // Удаляет студентов со средним баллом <3 и если средний балл>=3, студент переводится на следующий курс
    public ArrayList<Students> dismissAndTransferStudents(ArrayList<Students> listStudents)
            throws ArrayEmptyException, ArrayListNotNullException, ArrayNullException {
        return transferStudentNextCourseGPAThreeAndMore(dismissStudentGPALessThree(listStudents));
    }

    // Вывод студентов которые обучаются на данном курсе
    public ArrayList<Students> printStudentsCourse(ArrayList<Students> listStudents, int course)
            throws ArrayListNotNullException {
        if (isArrayListNotNull(listStudents)) {
            for (int x = listStudents.size() - 1; x >= 0; x--) {
                if (listStudents.get(x).course == course) {
                    log.info(listStudents.get(x).name);
                } else {
                    listStudents.remove(x);
                }
            }
        }
        return listStudents;
    }


    // Считает количество конкретных слов в строке
    public HashMap<String, Integer> countNumberOfEachWordStr(String str) throws StrEmptyException, StrNullException {
        HashMap<String, Integer> countSpecificWords = new HashMap<>();
        final String GROUP_OF_SPACES = "\\s+";
        final String LATIN_AND_RUSSIAN_SYMBOL = "[^a-zA-Zа-яА-Я ]";
        if (isNullOrEmpty(str) && !str.matches(GROUP_OF_SPACES)) {
            str = str.trim();
            String[] words = str.replaceAll(LATIN_AND_RUSSIAN_SYMBOL, "").split(GROUP_OF_SPACES);
            for (String word : words) {
                if (countSpecificWords.containsKey(word)) {
                    countSpecificWords.put(word, countSpecificWords.get(word) + 1);
                } else {
                    countSpecificWords.put(word, 1);
                }
            }
        }
        return countSpecificWords;
    }
}
