/**
 * Поменять элементы массива в обратном порядке
 */

import java.util.Arrays;

// TODO agorozhanko 12.06.2021: в названиях не должно быть цифр, только слова 

// TODO agorozhanko 12.06.2021: Названийя классов, переменных, пакетов должны быть более осмысленными и содержательными.
//  Руководствуйся "чистым кодом"

public class ArrayTask1 {

    public static void main(String[] args) {
        int[] inArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(Arrays.toString(inArray));

        ArrayReverse myReverse = new ArrayReverse();
        System.out.println(Arrays.toString(myReverse.reverseArray(inArray)));

    }

}
