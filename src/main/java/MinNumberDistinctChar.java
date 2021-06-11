public class MinNumberDistinctChar {

    public String minNumberDistinctChar(String str) {
        String outWord = "";
        String word;

        int countCharMinWord = str.length();
        int countWords = str.split("\\s+").length;
        int minChar;
        int lastSpace;

        for (int x = 0; x < countWords; x++) {
            lastSpace = str.lastIndexOf(" ");
            word = str.substring(lastSpace + 1);

            if (lastSpace != -1) {
                str = str.substring(0, lastSpace);
            }

            minChar = (int) word.chars().distinct().count();

            if (minChar <= countCharMinWord) {
                countCharMinWord = minChar;
                outWord = word;
            }
            str = str.trim();
        }

        return outWord;
    }
}
