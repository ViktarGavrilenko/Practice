public class ReverseWords {
    String ReverseWordsInString(String stringIn) {

        int countSpaceInStr = count(stringIn, " ");
        String stringOut = "";

        for (int x = 0; x < countSpaceInStr; x++) {
            if (stringOut.length() == 0) {
                stringOut = stringIn.substring(stringIn.lastIndexOf(" ") + 1);
            } else {
                stringOut = stringOut + " " + stringIn.substring(stringIn.lastIndexOf(" ") + 1);
            }
            stringIn = stringIn.substring(0, stringIn.lastIndexOf(" "));
        }

        stringOut = stringOut + " " + stringIn;

        return stringOut;
    }

    // Количество вхождений подстроки в строку
    int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
}
