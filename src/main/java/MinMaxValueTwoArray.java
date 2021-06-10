import java.util.Arrays;

public class MinMaxValueTwoArray {
    public void searchMinMaxValueTwoArray(int[][] inArray) {
        int[][] outArray = new int[5][2];
        int maxValue;
        int minValue;

        for (int x = 0; x < inArray.length; x++) {
            maxValue = inArray[x][0];
            minValue = inArray[x][0];
            for (int y = 0; y < inArray[x].length; y++) {
                if (maxValue < inArray[x][y]) {
                    maxValue = inArray[x][y];
                }

                if (minValue > inArray[x][y]) {
                    minValue = inArray[x][y];
                }
            }
            outArray[x][0] = maxValue;
            outArray[x][1] = minValue;
        }

        for (int x = 0; x < outArray.length; x++) {
            System.out.println(Arrays.toString(outArray[x]));
        }

    }
}
