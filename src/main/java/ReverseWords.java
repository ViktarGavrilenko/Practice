public class ReverseWords {

    String putWordsReverseInString(String stringIn) {

        int countSpaceInStr = countTargetStr(stringIn, " ");
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
    int countTargetStr(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
}
