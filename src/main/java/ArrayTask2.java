import java.util.Arrays;

/**
 * Среднее арифметическое:
 * • Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый
 * • Выведите массивы на экран в двух отдельных строках
 * • Посчитайте среднее арифметическое элементов каждого массива и сообщите,
 * • для какого из массивов это значение оказалось больше (либо сообщите, что их средние арифметические равны)
 */

public class ArrayTask2 {

    public static void main(String[] args) {
        int[] oneArray = new int[5];
        int[] twoArray = new int[5];

        WorkWithArray workArray = new WorkWithArray();

// TODO agorozhanko 12.06.2021: вместо oneArray и twoArray правильнее будет firstArray и secondArray, но в любом случае
//  такие названия не передают сути переменных
        oneArray = workArray.addValueInArray(oneArray);
        twoArray = workArray.addValueInArray(twoArray);

        System.out.println(Arrays.toString(oneArray));
        System.out.println(Arrays.toString(twoArray));

        System.out.println(workArray.compareAverageArrays(oneArray, twoArray));

    }
}
