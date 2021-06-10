public class WorkWithArray {

    public int[] addValueInArray(int[] inArray) {
        for (int x = 0; x < inArray.length; x++) {
            inArray[x] = (int) (Math.random() * 5);
        }
        return inArray;
    }

    public String compareAverageArrays(int[] oneArray, int[] twoArray) {
        float averageOne = 0;
        float averageTwo = 0;

        for (int x = 0; x < 5; x++) {
            averageOne = averageOne + oneArray[x];
            averageTwo = averageTwo + twoArray[x];
        }

        averageOne = averageOne / oneArray.length;
        averageTwo = averageTwo / twoArray.length;

        return compareValue(averageOne, averageTwo);
    }

    public String compareValue(float one, float two) {
        String resultCompare;

        if (one > two) {
            resultCompare = "Среднее арифметическое первого массива больше второго";
        } else {
            if (one == two) {
                resultCompare = "Средние арифметические значения массивов равны";
            } else {
                resultCompare = "Среднее арифметическое второго массива больше первого";
            }
        }

        return resultCompare;
    }

}
