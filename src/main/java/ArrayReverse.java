public class ArrayReverse {

    public int[] reverseArray(int[] inArray) {

        int tempVariable;
        int lastValue = inArray.length - 1;

        for (int x = 0; x < inArray.length / 2; x++) {
            tempVariable = inArray[x];
            inArray[x] = inArray[lastValue];
            inArray[lastValue] = tempVariable;
            lastValue--;
        }

        return inArray;
    }
}
