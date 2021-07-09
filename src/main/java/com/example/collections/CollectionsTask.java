package com.example.collections;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayNullException;

import java.util.ArrayList;

import static com.example.utilities.ArrayUtilities.getAverage;

public class CollectionsTask {

    // Удаляет студентов со средним баллом меньше 3
    public ArrayList<Students> dismissStudentGPALessThree(ArrayList<Students> listStudents) throws ArrayEmptyException,
            ArrayNullException {
        if (!(listStudents == null)) {
            int sizeListStudents = listStudents.size();

            for (int x = 0; x < sizeListStudents; x++) {
                int[] mark = new int[]{listStudents.get(x).mathMark, listStudents.get(x).russianMark,
                        listStudents.get(x).englishMark};
                if (getAverage(mark) < 3) {
                    listStudents.remove(x);
                    sizeListStudents--;
                    x--;
                }
            }
        }
        return listStudents;
    }
}
