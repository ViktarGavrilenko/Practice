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

    // Тесты для метода dismissStudentGPALessThree
    @Test(description = "Тестируем удаление студента со средним баллом меньше трех")
    public void testDismissStudentGPALessThree() throws ArrayEmptyException, ArrayNullException {
        ArrayList<Students> listStudents = new ArrayList<>();

        listStudents.add(new Students("Василий", "Строители", (byte) 4, (byte) 5, (byte) 3, (byte) 3));
        listStudents.add(new Students("Татьяна", "Дизайнеры", (byte) 2, (byte) 2, (byte) 3, (byte) 2));
        listStudents.add(new Students("Дмитрий", "Программисты", (byte) 1, (byte) 1, (byte) 4, (byte) 4));
        listStudents.add(new Students("Наталья", "Строители", (byte) 3, (byte) 2, (byte) 3, (byte) 3));
        listStudents.add(new Students("Иван", "Дизайнеры", (byte) 1, (byte) 5, (byte) 3, (byte) 2));
        listStudents.add(new Students("Александр", "Строители", (byte) 1, (byte) 2, (byte) 2, (byte) 2));

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(new Students("Василий", "Строители",
                        (byte) 4, (byte) 5, (byte) 3, (byte) 3),
                new Students("Дмитрий", "Программисты", (byte) 1, (byte) 1, (byte) 4, (byte) 4),
                new Students("Иван", "Дизайнеры", (byte) 1, (byte) 5, (byte) 3, (byte) 2)));
    }


    @Test(description = "Тестируем удаление студента со средним баллом меньше трех при не инициализированном списке")
    public void testDismissStudentGPALessThreeNull() throws ArrayEmptyException, ArrayNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(null);
        Assert.assertNull(listStudentsResult);
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех, у всех бал меньше трех")
    public void testDismissStudentGPALessThreeAllLessThree() throws ArrayEmptyException, ArrayNullException {
        ArrayList<Students> listStudents = new ArrayList<>();

        listStudents.add(new Students("Василий", "Строители", (byte) 4, (byte) 2, (byte) 3, (byte) 3));
        listStudents.add(new Students("Наталья", "Строители", (byte) 3, (byte) 2, (byte) 3, (byte) 1));
        listStudents.add(new Students("Иван", "Дизайнеры", (byte) 1, (byte) 1, (byte) 3, (byte) 2));
        listStudents.add(new Students("Александр", "Строители", (byte) 1, (byte) 2, (byte) 3, (byte) 2));

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList());
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех, у первого студента бал меньше трех")
    public void testDismissStudentGPALessThreeFirstLessThree() throws ArrayEmptyException, ArrayNullException {
        ArrayList<Students> listStudents = new ArrayList<>();

        listStudents.add(new Students("Василий", "Строители", (byte) 4, (byte) 2, (byte) 3, (byte) 3));
        listStudents.add(new Students("Наталья", "Строители", (byte) 3, (byte) 5, (byte) 3, (byte) 5));
        listStudents.add(new Students("Иван", "Дизайнеры", (byte) 1, (byte) 3, (byte) 3, (byte) 4));
        listStudents.add(new Students("Александр", "Строители", (byte) 1, (byte) 3, (byte) 3, (byte) 3));

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(new Students("Наталья", "Строители",
                        (byte) 3, (byte) 5, (byte) 3, (byte) 5),
                new Students("Иван", "Дизайнеры", (byte) 1, (byte) 3, (byte) 3, (byte) 4),
                new Students("Александр", "Строители", (byte) 1, (byte) 3, (byte) 3, (byte) 3)));
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех, когда у всех больше трех")
    public void testDismissStudentGPALessThreeAllMoreThree() throws ArrayEmptyException, ArrayNullException {
        ArrayList<Students> listStudents = new ArrayList<>();

        listStudents.add(new Students("Василий", "Строители", (byte) 4, (byte) 4, (byte) 5, (byte) 5));
        listStudents.add(new Students("Наталья", "Строители", (byte) 3, (byte) 5, (byte) 3, (byte) 5));
        listStudents.add(new Students("Иван", "Дизайнеры", (byte) 1, (byte) 3, (byte) 5, (byte) 4));
        listStudents.add(new Students("Александр", "Строители", (byte) 1, (byte) 5, (byte) 3, (byte) 3));

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(new Students("Василий", "Строители",
                        (byte) 4, (byte) 4, (byte) 5, (byte) 5),
                new Students("Наталья", "Строители", (byte) 3, (byte) 5, (byte) 3, (byte) 5),
                new Students("Иван", "Дизайнеры", (byte) 1, (byte) 3, (byte) 5, (byte) 4),
                new Students("Александр", "Строители", (byte) 1, (byte) 5, (byte) 3, (byte) 3)));
    }
}