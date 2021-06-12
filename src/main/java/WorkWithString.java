public class WorkWithString {

    String replaceEverySecondEntryString(String str, String entryMax, String entryMin) {

        String lowerCaseStr = str.toLowerCase();
        String lowerCaseEntryMax = entryMax.toLowerCase();

        int lengthEntryMax = entryMax.length();
        int countEntryMaxInStr = countTargetStr(lowerCaseStr, lowerCaseEntryMax);
        int indexStart = 0;
        int indexEntryMax;

        for (int x = 0; x < countEntryMaxInStr; x++) {
            if (x % 2 == 0) {
                indexStart = lowerCaseStr.lastIndexOf(lowerCaseEntryMax, indexStart) + lengthEntryMax;
            } else {
                indexEntryMax = lowerCaseStr.indexOf(lowerCaseEntryMax, indexStart);
                // TODO agorozhanko 12.06.2021: для чего тут пустые строки?
                lowerCaseStr = lowerCaseStr.substring(0, indexEntryMax) + "" + entryMin + "" + lowerCaseStr.substring(indexEntryMax + lengthEntryMax);
                str = str.substring(0, indexEntryMax) + "" + entryMin + "" + str.substring(indexEntryMax + lengthEntryMax);
                indexStart = indexEntryMax + lengthEntryMax;
            }
        }

        return str;
    }

    // TODO agorozhanko 12.06.2021: копипаст
    int countTargetStr(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
}
