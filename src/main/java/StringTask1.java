/**
 * Вводится строка слов. Вывести слова в обратном порядке
 */

public class StringTask1 {

    public static void main(String[] args) {

        String stringWordsIn = "Один два три четыре пять шесть";
        WorkWithWordsInString myString = new WorkWithWordsInString();

        System.out.println("Введенная строка: " + stringWordsIn);
        System.out.println("Строка на оборот: " + myString.putWordsReverseInString(stringWordsIn));

    }

}
