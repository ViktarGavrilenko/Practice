package com.example.collections;

import com.example.exception.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.utilities.ArrayUtilities.getAverage;
import static com.example.utilities.CollectionsUtilities.isArrayListNotNull;
import static com.example.utilities.StringUtilities.isNullOrEmpty;

/**
 * Tasks with collections
 *
 * @author Viktar Gavrilenko
 * @date 09.09.2021
 */
public class CollectionsTask {

    private static final Logger log = Logger.getLogger(CollectionsTask.class);

    /**
     * Dismiss students with a GPA of less than three
     *
     * @param listStudents is a list with student data
     * @return returns a list of students with a grade point average of three or more
     * @throws ArrayEmptyException    if the array is empty
     * @throws ArrayNullException     if the array is not initialized
     * @throws ArrayListNullException if the ArrayList is not initialized
     */
    public ArrayList<Students> dismissStudentGPALessThree(ArrayList<Students> listStudents) throws ArrayEmptyException,
            ArrayNullException, ArrayListNullException {
        if (isArrayListNotNull(listStudents)) {
            for (int x = listStudents.size() - 1; x >= 0; x--) {
                if (getAverage(marksStudent(listStudents.get(x))) < 3) {
                    listStudents.remove(x);
                }
            }
        }
        return listStudents;
    }

    /**
     * Transfers students with a GPA above and equal to 3 to the next course
     *
     * @param listStudents is a list with student data
     * @return returns a list of students, modifying the course only for those with a GPA greater than or equal to three.
     * @throws ArrayListNullException if the ArrayList is not initialized
     * @throws ArrayEmptyException    if the array is empty
     * @throws ArrayNullException     if the array is not initialized
     */
    public ArrayList<Students> transferStudentNextCourseGPAThreeAndMore(ArrayList<Students> listStudents)
            throws ArrayListNullException, ArrayEmptyException, ArrayNullException {
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

    /**
     * Retrieves only grade data from the list and stores it in an array
     *
     * @param student student information
     * @return returns an array with scores
     */
    public int[] marksStudent(Students student) {
        return new int[]{student.mathMark, student.russianMark, student.englishMark};
    }

    /**
     * Dismiss students with a GPA of less than three and transfers students with a GPA above and
     * equal to 3 to the next course
     *
     * @param listStudents is a list with student data
     * @return returns a list of students, modifying the course only for those with a GPA greater than or
     * equal to three and dismiss students with a GPA of less than three
     * @throws ArrayEmptyException    if the array is empty
     * @throws ArrayListNullException if the ArrayList is not initialized
     * @throws ArrayNullException     if the array is not initialized
     */
    public ArrayList<Students> dismissAndTransferStudents(ArrayList<Students> listStudents)
            throws ArrayEmptyException, ArrayListNullException, ArrayNullException {
        return transferStudentNextCourseGPAThreeAndMore(dismissStudentGPALessThree(listStudents));
    }

    /**
     * Displays a list of students who are studying on this course
     *
     * @param listStudents is a list with student data
     * @param course       is a course in which you need to select students
     * @return returns a list of students who are enrolled in a given course
     * @throws ArrayListNullException if the ArrayList is not initialized
     */
    public ArrayList<Students> printStudentsCourse(ArrayList<Students> listStudents, int course)
            throws ArrayListNullException {
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

    /**
     * Counts how many times each word occurs in a line
     *
     * @param str is source string
     * @return returns a list of words with the number of repetitions in a string
     * @throws StrEmptyException if the string is empty
     * @throws StrNullException  if the string is not initialized
     */
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
