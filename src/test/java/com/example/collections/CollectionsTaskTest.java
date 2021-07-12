package com.example.collections;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayListNotNullException;
import com.example.exception.ArrayNullException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CollectionsTaskTest {

    CollectionsTask collectionsTask;

    ArrayList<Students> listStudents;
    ArrayList<Students> listStudentsAllLessThree;
    ArrayList<Students> listStudentsFirstLessThree;
    ArrayList<Students> listStudentsAllMoreThree;

    Students vasiliy;
    Students tatiana;
    Students dmitriy;
    Students natalia;
    Students ivan;
    Students alex;

    @BeforeTest()
    public void setUp() {
        vasiliy = new Students("�������", "���������", (byte) 4, (byte) 5, (byte) 3, (byte) 3);
        tatiana = new Students("�������", "���������", (byte) 2, (byte) 2, (byte) 3, (byte) 2);
        dmitriy = new Students("�������", "������������", (byte) 1, (byte) 1, (byte) 4, (byte) 4);
        natalia = new Students("�������", "���������", (byte) 3, (byte) 2, (byte) 3, (byte) 3);
        ivan = new Students("����", "���������", (byte) 1, (byte) 5, (byte) 3, (byte) 2);
        alex = new Students("���������", "���������", (byte) 1, (byte) 2, (byte) 2, (byte) 2);

        collectionsTask = new CollectionsTask();

        listStudents = new ArrayList<>();
        listStudents.add(vasiliy);
        listStudents.add(tatiana);
        listStudents.add(dmitriy);
        listStudents.add(natalia);
        listStudents.add(ivan);
        listStudents.add(alex);

        listStudentsAllLessThree = new ArrayList<>();
        listStudentsAllLessThree.add(tatiana);
        listStudentsAllLessThree.add(natalia);
        listStudentsAllLessThree.add(alex);

        listStudentsFirstLessThree = new ArrayList<>();
        listStudentsFirstLessThree.add(tatiana);
        listStudentsFirstLessThree.add(vasiliy);
        listStudentsFirstLessThree.add(dmitriy);
        listStudentsFirstLessThree.add(ivan);

        listStudentsAllMoreThree = new ArrayList<>();
        listStudentsAllMoreThree.add(vasiliy);
        listStudentsAllMoreThree.add(dmitriy);
        listStudentsAllMoreThree.add(ivan);
    }

    // ����� ��� ������ dismissStudentGPALessThree
    @Test(description = "��������� �������� �������� �� ������� ������ ������ ����")
    public void testDismissStudentGPALessThree() throws ArrayEmptyException, ArrayNullException, ArrayListNotNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ���� ��� �� ������������������ ������",
            expectedExceptions = {ArrayListNotNullException.class},
            expectedExceptionsMessageRegExp = "ArrayList ������")
    public void testDismissStudentGPALessThreeNull() throws ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(null);
        Assert.assertNull(listStudentsResult);
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ����, � ���� ��� ������ ����")
    public void testDismissStudentGPALessThreeAllLessThree() throws ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsAllLessThree);
        Assert.assertEquals(listStudentsResult, Collections.emptyList());
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ����, � ������� �������� ��� ������ ����")
    public void testDismissStudentGPALessThreeFirstLessThree() throws ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsFirstLessThree);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ����, ����� � ���� ������ ����")
    public void testDismissStudentGPALessThreeAllMoreThree() throws ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsAllMoreThree);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }
}