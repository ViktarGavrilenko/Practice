package com.example.collections;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayListNotNullException;
import com.example.exception.ArrayNullException;

import java.util.ArrayList;

import static com.example.utilities.ArrayUtilities.getAverage;
import static com.example.utilities.CollectionsUtilities.isArrayListNotNull;

public class CollectionsTask {

    // ������� ��������� �� ������� ������ ������ 3
    public ArrayList<Students> dismissStudentGPALessThree(ArrayList<Students> listStudents) throws ArrayEmptyException,
            ArrayNullException, ArrayListNotNullException {
        if (isArrayListNotNull(listStudents)) {
            int sizeListStudents = listStudents.size();

            for (int x = 0; x < sizeListStudents; x++) {
                if (getAverage(marksStudent(listStudents.get(x))) < 3) {
                    listStudents.remove(x);
                    sizeListStudents--;
                    x--;
                }
            }
        }
        return listStudents;
    }

    // ��������� ��������� �� ������� ����� ���� � ������ 3 �� ��������� ����
    public ArrayList<Students> transferStudentNextCourseGPAThreeAndMore(ArrayList<Students> listStudents)
            throws ArrayListNotNullException, ArrayEmptyException, ArrayNullException {
        if (isArrayListNotNull(listStudents)){
            for (int x = 0; x < listStudents.size(); x++){
                if (getAverage(marksStudent(listStudents.get(x))) >= 3) {
                    listStudents.set(x, new Students(listStudents.get(x).name, listStudents.get(x).group,
                            (byte) (listStudents.get(x).course + 1), listStudents.get(x).mathMark,
                            listStudents.get(x).englishMark, listStudents.get(x).russianMark));
                }
            }
        }
        return listStudents;
    }

    // ��������� ������ � ������
    public int[] marksStudent(Students student){
        return new int[]{student.mathMark, student.russianMark, student.englishMark};
    }
}
