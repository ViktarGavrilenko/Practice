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
        vasiliy = new Students("Василий", "Строители", (byte) 4, (byte) 5, (byte) 3, (byte) 3);
        tatiana = new Students("Татьяна", "Дизайнеры", (byte) 2, (byte) 2, (byte) 3, (byte) 2);
        dmitriy = new Students("Дмитрий", "Программисты", (byte) 1, (byte) 1, (byte) 4, (byte) 4);
        natalia = new Students("Наталья", "Строители", (byte) 3, (byte) 2, (byte) 3, (byte) 3);
        ivan = new Students("Иван", "Дизайнеры", (byte) 1, (byte) 5, (byte) 3, (byte) 2);
        alex = new Students("Александр", "Строители", (byte) 1, (byte) 2, (byte) 2, (byte) 2);

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

    // Тесты для метода dismissStudentGPALessThree
    @Test(description = "Тестируем удаление студента со средним баллом меньше трех")
    public void testDismissStudentGPALessThree() throws ArrayEmptyException, ArrayNullException, ArrayListNotNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех при не инициализированном списке",
            expectedExceptions = {ArrayListNotNullException.class},
            expectedExceptionsMessageRegExp = "ArrayList пустой")
    public void testDismissStudentGPALessThreeNull() throws ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(null);
        Assert.assertNull(listStudentsResult);
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех, у всех бал меньше трех")
    public void testDismissStudentGPALessThreeAllLessThree() throws ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsAllLessThree);
        Assert.assertEquals(listStudentsResult, Collections.emptyList());
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех, у первого студента бал меньше трех")
    public void testDismissStudentGPALessThreeFirstLessThree() throws ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsFirstLessThree);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех, когда у всех больше трех")
    public void testDismissStudentGPALessThreeAllMoreThree() throws ArrayEmptyException, ArrayNullException, ArrayListNotNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsAllMoreThree);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }
}