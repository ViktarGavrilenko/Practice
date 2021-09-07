package com.example.collections;

import com.example.exception.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CollectionsTaskTest {

    private CollectionsTask collectionsTask;

    private ArrayList<Students> listStudents;
    private ArrayList<Students> listStudentsAllLessThree;
    private ArrayList<Students> listStudentsFirstLessThree;
    private ArrayList<Students> listStudentsAllMoreThree;
    private ArrayList<Students> listStudentsSameCourse;
    private ArrayList<Students> listStudentsEmpty;

    private Students vasiliy;
    private Students vasiliyNextCourse;
    private Students tatiana;
    private Students dmitriy;
    private Students dmitriyNextCourse;
    private Students natalia;
    private Students ivan;
    private Students ivanNextCourse;
    private Students alex;

    private String str;
    private String strEnglish;
    private String emptyStr;
    private String spaceStr;
    private HashMap<String, Integer> correctCountWord;
    private HashMap<String, Integer> correctCountWordEnglish;

    @BeforeTest()
    public void setUp() {
        vasiliy = new Students("Василий", "Строители", (byte) 4, (byte) 5, (byte) 3, (byte) 3);
        vasiliyNextCourse = new Students("Василий", "Строители", (byte) 5, (byte) 5, (byte) 3, (byte) 3);
        tatiana = new Students("Татьяна", "Дизайнеры", (byte) 2, (byte) 2, (byte) 3, (byte) 2);
        dmitriy = new Students("Дмитрий", "Программисты", (byte) 1, (byte) 1, (byte) 4, (byte) 4);
        dmitriyNextCourse = new Students("Дмитрий", "Программисты", (byte) 2, (byte) 1, (byte) 4, (byte) 4);
        natalia = new Students("Наталья", "Строители", (byte) 3, (byte) 2, (byte) 3, (byte) 3);
        ivan = new Students("Иван", "Дизайнеры", (byte) 1, (byte) 5, (byte) 3, (byte) 2);
        ivanNextCourse = new Students("Иван", "Дизайнеры", (byte) 2, (byte) 5, (byte) 3, (byte) 2);
        alex = new Students("Александр", "Строители", (byte) 1, (byte) 2, (byte) 2, (byte) 2);

        str = "один два, три   один, два   четыре один    Один  один.";
        strEnglish = "  one, two three, one two one   ! ";
        emptyStr = "";
        spaceStr = "    ";

        collectionsTask = new CollectionsTask();

        correctCountWord = new HashMap<>();
        correctCountWord.put("один", 4);
        correctCountWord.put("два", 2);
        correctCountWord.put("три", 1);
        correctCountWord.put("четыре", 1);
        correctCountWord.put("Один", 1);

        correctCountWordEnglish = new HashMap<>();
        correctCountWordEnglish.put("one", 3);
        correctCountWordEnglish.put("two", 2);
        correctCountWordEnglish.put("three", 1);

        listStudentsEmpty = new ArrayList<>();
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

        listStudentsSameCourse = new ArrayList<>();
        listStudentsSameCourse.add(dmitriy);
        listStudentsSameCourse.add(ivan);
        listStudentsSameCourse.add(alex);
    }

    // Тесты для метода dismissStudentGPALessThree
    @Test(description = "Тестируем удаление студента со средним баллом меньше трех")
    public void testDismissStudentGPALessThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех при не инициализированном списке",
            expectedExceptions = {ArrayListNullException.class},
            expectedExceptionsMessageRegExp = "ArrayList не инициализирован")
    public void testDismissStudentGPALessThreeNull() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(null);
        Assert.assertNull(listStudentsResult);
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех, у всех бал меньше трех")
    public void testDismissStudentGPALessThreeAllLessThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsAllLessThree);
        Assert.assertEquals(listStudentsResult, Collections.emptyList());
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех, у первого студента бал меньше трех")
    public void testDismissStudentGPALessThreeFirstLessThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsFirstLessThree);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех, когда у всех больше трех")
    public void testDismissStudentGPALessThreeAllMoreThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsAllMoreThree);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliy, dmitriy, ivan));
    }

    @Test(description = "Тестируем удаление студента со средним баллом меньше трех, если список пустой")
    public void testDismissStudentGPALessThreeEmpty() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.dismissStudentGPALessThree(listStudentsEmpty);
        Assert.assertEquals(listStudentsResult, Collections.emptyList());
    }

    // Тесты для метода transferStudentNextCourseGPAThreeAndMore
    @Test(description = "Тестируем перевод студентов на следующий курс, если средний балл выше или равен трем")
    public void testTransferStudentNextCourseGPAThreeAndMore() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.transferStudentNextCourseGPAThreeAndMore(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliyNextCourse, tatiana, dmitriyNextCourse,
                natalia, ivanNextCourse, alex));
    }

    @Test(description = "Тестируем перевод студентов на следующий курс, если средний балл у всех выше или равен трем")
    public void testTransferStudentNextCourseGPAThreeAndMoreAll() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult =
                collectionsTask.transferStudentNextCourseGPAThreeAndMore(listStudentsAllMoreThree);
        Assert.assertEquals(listStudentsResult,
                Arrays.asList(vasiliyNextCourse, dmitriyNextCourse, ivanNextCourse));
    }

    @Test(description = "Тестируем перевод студентов на следующий курс, если средний балл у всех ниже трех")
    public void testTransferStudentNextCourseGPALessThreeAll() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult =
                collectionsTask.transferStudentNextCourseGPAThreeAndMore(listStudentsAllLessThree);
        Assert.assertEquals(listStudentsResult, listStudentsAllLessThree);
    }

    @Test(description = "Тестируем перевод студентов на следующий курс, если средний балл у всех ниже трех")
    public void testTransferStudentNextCourseGPAFirstLessThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult =
                collectionsTask.transferStudentNextCourseGPAThreeAndMore(listStudentsFirstLessThree);
        Assert.assertEquals(listStudentsResult,
                Arrays.asList(tatiana, vasiliyNextCourse, dmitriyNextCourse, ivanNextCourse));
    }

    @Test(description = "Тестируем перевод студентов на следующий курс при не инициализированном списке",
            expectedExceptions = {ArrayListNullException.class},
            expectedExceptionsMessageRegExp = "ArrayList не инициализирован")
    public void testTransferStudentNextCourseGPANull() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {

        ArrayList<Students> listStudentsResult = collectionsTask.transferStudentNextCourseGPAThreeAndMore(null);
        Assert.assertNull(listStudentsResult);
    }

    @Test(description = "Тестируем перевод студентов на следующий курс, если список пустой")
    public void testTransferStudentNextCourseGPAEmpty() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.transferStudentNextCourseGPAThreeAndMore(listStudentsEmpty);
        Assert.assertEquals(listStudentsResult, Collections.emptyList());
    }

    // Тесты для метода dismissAndTransferStudents
    @Test(description = "Тестируем удаление студентов, если средний балл меньше трех и " +
            "перевод на следующий курс, если средний балл выше или равен трем")
    public void testDismissAndTransferStudents() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.dismissAndTransferStudents(listStudents);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliyNextCourse, dmitriyNextCourse, ivanNextCourse));
    }

    @Test(description = "Тестируем студентов со средним баллом только меньше трех в методе удаления и перевода " +
            "студентов на следующий курс")
    public void testDismissAndTransferStudentsAllLessThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.dismissAndTransferStudents(listStudentsAllLessThree);
        Assert.assertEquals(listStudentsResult, Collections.emptyList());
    }

    @Test(description = "Тестируем студентов со средним баллом только больше или равном трем в методе удаления и " +
            "перевода студентов на следующий курс")
    public void testDismissAndTransferStudentsAllMoreThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.dismissAndTransferStudents(listStudentsAllMoreThree);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliyNextCourse, dmitriyNextCourse, ivanNextCourse));
    }

    @Test(description = "Тестируем удаление студентов и перевод на следующий курс, если только у первого студента бал " +
            "меньше трех")
    public void testDismissAndTransferStudentsFirstLessThree() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.dismissAndTransferStudents(listStudentsFirstLessThree);
        Assert.assertEquals(listStudentsResult, Arrays.asList(vasiliyNextCourse, dmitriyNextCourse, ivanNextCourse));
    }

    @Test(description = "Тестируем удаление студентов и перевод на следующий курс, если список не инициализирован",
            expectedExceptions = {ArrayListNullException.class},
            expectedExceptionsMessageRegExp = "ArrayList не инициализирован")
    public void testDismissAndTransferStudentsNull() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.dismissAndTransferStudents(null);
        Assert.assertNull(listStudentsResult);
    }

    @Test(description = "Тестируем удаление студентов и перевод на следующий курс, если список пустой")
    public void testDismissAndTransferStudentsEmpty() throws
            ArrayEmptyException, ArrayNullException, ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.dismissAndTransferStudents(listStudentsEmpty);
        Assert.assertEquals(listStudentsResult, Collections.emptyList());
    }

    // Тесты для метода printStudentsCourse
    @Test(description = "Тестируем вывод студентов с первого курса")
    public void testPrintStudentsCourse() throws ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.printStudentsCourse(listStudents, 1);
        Assert.assertEquals(listStudentsResult, Arrays.asList(dmitriy, ivan, alex));
    }

    @Test(description = "Тестируем курс на котором студенты не учатся")
    public void testPrintStudentsCourseNotCourse() throws ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.printStudentsCourse(listStudents, 6);
        Assert.assertEquals(listStudentsResult, Collections.emptyList());
    }

    @Test(description = "Тестируем вывод студентов с не инициализированного курса",
            expectedExceptions = {ArrayListNullException.class},
            expectedExceptionsMessageRegExp = "ArrayList не инициализирован")
    public void testPrintStudentsCourseNull() throws ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.printStudentsCourse(null, 1);
        Assert.assertNull(listStudentsResult);
    }

    @Test(description = "Тестируем вывод студентов, если список пустой")
    public void testPrintStudentsCourseEmpty() throws ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.printStudentsCourse(listStudentsEmpty, 1);
        Assert.assertEquals(listStudentsResult, Collections.emptyList());
    }

    @Test(description = "Тестируем список студентов одного курса")
    public void testPrintStudentsCourseSame() throws ArrayListNullException {
        ArrayList<Students> listStudentsResult = collectionsTask.printStudentsCourse(listStudentsSameCourse, 1);
        Assert.assertEquals(listStudentsResult, listStudentsSameCourse);
    }

    // Тесты для метода countNumberOfEachWordStr
    @Test(description = "Тестируем количество конкретных слов в строке")
    public void testCountNumberOfEachWordStr() throws StrEmptyException, StrNullException {
        HashMap<String, Integer> countSpecificWords = collectionsTask.countNumberOfEachWordStr(str);
        Assert.assertEquals(countSpecificWords, correctCountWord);
    }

    @Test(description = "Тестируем количество конкретных слов в не инициализированной строке",
            expectedExceptions = {StrNullException.class},
            expectedExceptionsMessageRegExp = "Строка не инициализирована")
    public void testCountNumberOfEachWordStrNull() throws StrEmptyException, StrNullException {
        HashMap<String, Integer> countSpecificWords = collectionsTask.countNumberOfEachWordStr(null);
        Assert.assertNull(countSpecificWords);
    }

    @Test(description = "Тестируем количество конкретных слов в пустой строке",
            expectedExceptions = {StrEmptyException.class},
            expectedExceptionsMessageRegExp = "Пустая строка")
    public void testCountNumberOfEachWordStrEmpty() throws StrEmptyException, StrNullException {
        HashMap<String, Integer> countSpecificWords = collectionsTask.countNumberOfEachWordStr(emptyStr);
        Assert.assertEquals(countSpecificWords, Collections.emptyMap());
    }

    @Test(description = "Тестируем количество конкретных слов в строке с английскими символами и " +
            "пробелами в начале и в конце строки")
    public void testCountNumberOfEachWordStrEnglishSpace() throws StrEmptyException, StrNullException {
        HashMap<String, Integer> countSpecificWords = collectionsTask.countNumberOfEachWordStr(strEnglish);
        Assert.assertEquals(countSpecificWords, correctCountWordEnglish);
    }

    @Test(description = "Тестируем количество конкретных слов в строке состоящей из пробелов")
    public void testCountNumberOfEachWordStrSpaceStr() throws StrEmptyException, StrNullException {
        HashMap<String, Integer> countSpecificWords = collectionsTask.countNumberOfEachWordStr(spaceStr);
        Assert.assertEquals(countSpecificWords, Collections.emptyMap());
    }
}