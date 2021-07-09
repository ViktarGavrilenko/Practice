package com.example.collections;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayNullException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionsTaskTest {

    CollectionsTask collectionsTask;

    @BeforeTest()
    public void setUp() {
        collectionsTask = new CollectionsTask();
    }

    // ����� ��� ������ dismissStudentGPALessThree
    @Test(description = "��������� �������� �������� �� ������� ������ ������ ����")
    public void testDismissStudentGPALessThree() throws ArrayEmptyException, ArrayNullException {
        ArrayList<Students> listStudents = new ArrayList<>();

        listStudents.add(new Students("�������", "���������", (byte) 4, (byte) 5, (byte) 3, (byte) 3));
        listStudents.add(new Students("�������", "���������", (byte) 2, (byte) 2, (byte) 3, (byte) 2));
        listStudents.add(new Students("�������", "������������", (byte) 1, (byte) 1, (byte) 4, (byte) 4));
        listStudents.add(new Students("�������", "���������", (byte) 3, (byte) 2, (byte) 3, (byte) 3));
        listStudents.add(new Students("����", "���������", (byte) 1, (byte) 5, (byte) 3, (byte) 2));
        listStudents.add(new Students("���������", "���������", (byte) 1, (byte) 2, (byte) 2, (byte) 2));

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(new Students("�������", "���������",
                        (byte) 4, (byte) 5, (byte) 3, (byte) 3),
                new Students("�������", "������������", (byte) 1, (byte) 1, (byte) 4, (byte) 4),
                new Students("����", "���������", (byte) 1, (byte) 5, (byte) 3, (byte) 2)));
    }


    @Test(description = "��������� �������� �������� �� ������� ������ ������ ���� ��� �� ������������������ ������")
    public void testDismissStudentGPALessThreeNull() throws ArrayEmptyException, ArrayNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(null);
        Assert.assertNull(listStudentsResult);
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ����, � ���� ��� ������ ����")
    public void testDismissStudentGPALessThreeAllLessThree() throws ArrayEmptyException, ArrayNullException {
        ArrayList<Students> listStudents = new ArrayList<>();

        listStudents.add(new Students("�������", "���������", (byte) 4, (byte) 2, (byte) 3, (byte) 3));
        listStudents.add(new Students("�������", "���������", (byte) 3, (byte) 2, (byte) 3, (byte) 1));
        listStudents.add(new Students("����", "���������", (byte) 1, (byte) 1, (byte) 3, (byte) 2));
        listStudents.add(new Students("���������", "���������", (byte) 1, (byte) 2, (byte) 3, (byte) 2));

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList());
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ����, � ������� �������� ��� ������ ����")
    public void testDismissStudentGPALessThreeFirstLessThree() throws ArrayEmptyException, ArrayNullException {
        ArrayList<Students> listStudents = new ArrayList<>();

        listStudents.add(new Students("�������", "���������", (byte) 4, (byte) 2, (byte) 3, (byte) 3));
        listStudents.add(new Students("�������", "���������", (byte) 3, (byte) 5, (byte) 3, (byte) 5));
        listStudents.add(new Students("����", "���������", (byte) 1, (byte) 3, (byte) 3, (byte) 4));
        listStudents.add(new Students("���������", "���������", (byte) 1, (byte) 3, (byte) 3, (byte) 3));

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(new Students("�������", "���������",
                        (byte) 3, (byte) 5, (byte) 3, (byte) 5),
                new Students("����", "���������", (byte) 1, (byte) 3, (byte) 3, (byte) 4),
                new Students("���������", "���������", (byte) 1, (byte) 3, (byte) 3, (byte) 3)));
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ����, ����� � ���� ������ ����")
    public void testDismissStudentGPALessThreeAllMoreThree() throws ArrayEmptyException, ArrayNullException {
        ArrayList<Students> listStudents = new ArrayList<>();

        listStudents.add(new Students("�������", "���������", (byte) 4, (byte) 4, (byte) 5, (byte) 5));
        listStudents.add(new Students("�������", "���������", (byte) 3, (byte) 5, (byte) 3, (byte) 5));
        listStudents.add(new Students("����", "���������", (byte) 1, (byte) 3, (byte) 5, (byte) 4));
        listStudents.add(new Students("���������", "���������", (byte) 1, (byte) 5, (byte) 3, (byte) 3));

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(new Students("�������", "���������",
                        (byte) 4, (byte) 4, (byte) 5, (byte) 5),
                new Students("�������", "���������", (byte) 3, (byte) 5, (byte) 3, (byte) 5),
                new Students("����", "���������", (byte) 1, (byte) 3, (byte) 5, (byte) 4),
                new Students("���������", "���������", (byte) 1, (byte) 5, (byte) 3, (byte) 3)));
    }
}