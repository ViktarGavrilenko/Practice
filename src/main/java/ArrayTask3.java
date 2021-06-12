/**
 * Создать двухмерный массив 5х8 и инициализировать его с помощью блока для инициализации.
 * Найти максимальное и минимальное значение в каждой "строке"
 * и записать эти значения в двухмерный массив 5х2. Распечатать оба массива
 */

import java.util.Arrays;

public class ArrayTask3 {
    // TODO agorozhanko 12.06.2021: что будет если ввести все одинаковые числа?
    public static void main(String[] args) {
        int[][] inArray = {{5, 8, 88, 3, 42, 10, 10, 6},
                {1, 53, 2, 3, 77, 10, 2, 54},
                {4, 3, 91, 3, 12, 10, 4, 12},
                {6, 3, 11, 3, 22, 10, 5, 60},
                {2, 4, 32, 71, 4, 40, 48, 9}};

        for (int x = 0; x < inArray.length; x++) {
            System.out.println(Arrays.toString(inArray[x]));
        }

        MinMaxValueTwoArray minMaxArray = new MinMaxValueTwoArray();
        minMaxArray.searchMinMaxValueTwoArray(inArray);

    }
}
