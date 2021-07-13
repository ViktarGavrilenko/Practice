package com.example.collections;

import com.example.exception.ArrayEmptyException;
import com.example.exception.ArrayListNotNullException;
import com.example.exception.ArrayNullException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
    Students vasiliyNextCourse;
    Students tatiana;
    Students dmitriy;
    Students dmitriyNextCourse;
    Students natalia;
    Students ivan;
    Students ivanNextCourse;
    Students alex;

    @BeforeTest()
    public void setUp() {
        vasiliy = new Students("�������", "���������", (byte) 4, (byte) 5, (byte) 3, (byte) 3);
        vasiliyNextCourse = new Students("�������", "���������", (byte) 5, (byte) 5, (byte) 3, (byte) 3);
        tatiana = new Students("�������", "���������", (byte) 2, (byte) 2, (byte) 3, (byte) 2);
        dmitriy = new Students("�������", "������������", (byte) 1, (byte) 1, (byte) 4, (byte) 4);
        dmitriyNextCourse = new Students("�������", "������������", (byte) 2, (byte) 1, (byte) 4, (byte) 4);
        natalia = new Students("�������", "���������", (byte) 3, (byte) 2, (byte) 3, (byte) 3);
        ivan = new Students("����", "���������", (byte) 1, (byte) 5, (byte) 3, (byte) 2);
        ivanNextCourse = new Students("����", "���������", (byte) 2, (byte) 5, (byte) 3, (byte) 2);
        alex = new Students("���������", "���������", (byte) 1, (byte) 2, (byte) 2, (byte) 2);

        collectionsTask = new CollectionsTask();


    }

    @BeforeMethod()
    public void beforeMethod() {

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
    public void testDismissStudentGPALessThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNotNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ���� ��� �� ������������������ ������",
            expectedExceptions = {ArrayListNotNullException.class},
            expectedExceptionsMessageRegExp = "ArrayList ������")
    public void testDismissStudentGPALessThreeNull() throws
            ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(null);
        Assert.assertNull(listStudentsResult);
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ����, � ���� ��� ������ ����")
    public void testDismissStudentGPALessThreeAllLessThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsAllLessThree);
        Assert.assertEquals(listStudentsResult, Collections.emptyList());
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ����, � ������� �������� ��� ������ ����")
    public void testDismissStudentGPALessThreeFirstLessThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsFirstLessThree);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ����, ����� � ���� ������ ����")
    public void testDismissStudentGPALessThreeAllMoreThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsAllMoreThree);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }

    // ����� ��� ������ transferStudentNextCourseGPAThreeAndMore
    @Test(description = "��������� ������� ��������� �� ��������� ����, ���� ������� ���� ���� ��� ����� ����")
    public void testTransferStudentNextCourseGPAThreeAndMore() throws
            ArrayEmptyException, ArrayNullException, ArrayListNotNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.transferStudentNextCourseGPAThreeAndMore(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliyNextCourse, tatiana, dmitriyNextCourse,
                natalia, ivanNextCourse, alex));
    }

    @Test(description = "��������� ������� ��������� �� ��������� ����, ���� ������� ���� � ���� ���� ��� ����� ����")
    public void testTransferStudentNextCourseGPAThreeAndMoreAll() throws
            ArrayEmptyException, ArrayNullException, ArrayListNotNullException {
        ArrayList<Students> listStudentsResult =
                collectionsTask.transferStudentNextCourseGPAThreeAndMore(listStudentsAllMoreThree);
        Assert.assertEquals(listStudentsResult,
                Arrays.asList(vasiliyNextCourse, dmitriyNextCourse, ivanNextCourse));
    }

    @Test(description = "��������� ������� ��������� �� ��������� ����, ���� ������� ���� � ���� ���� ����")
    public void testTransferStudentNextCourseGPALessThreeAll() throws
            ArrayEmptyException, ArrayNullException, ArrayListNotNullException {
        ArrayList<Students> listStudentsResult =
                collectionsTask.transferStudentNextCourseGPAThreeAndMore(listStudentsAllLessThree);
        Assert.assertEquals(listStudentsResult,
                listStudentsAllLessThree);
    }

    @Test(description = "��������� ������� ��������� �� ��������� ����, ���� ������� ���� � ���� ���� ����")
    public void testTransferStudentNextCourseGPAFirstLessThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNotNullException {
        ArrayList<Students> listStudentsResult =
                collectionsTask.transferStudentNextCourseGPAThreeAndMore(listStudentsFirstLessThree);
        Assert.assertEquals(listStudentsResult,
                Arrays.asList(tatiana, vasiliyNextCourse, dmitriyNextCourse, ivanNextCourse));
    }

    @Test(description = "��������� �������� �������� �� ������� ������ ������ ���� ��� �� ������������������ ������",
            expectedExceptions = {ArrayListNotNullException.class},
            expectedExceptionsMessageRegExp = "ArrayList ������")
    public void testTransferStudentNextCourseGPANull() throws
            ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.transferStudentNextCourseGPAThreeAndMore(null);
        Assert.assertNull(listStudentsResult);
    }
}