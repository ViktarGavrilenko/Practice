/**
 * Заменить каждое второе вхождение строки
 * Напишите метод, заменяющий в строке каждое второе вхождение
 * «object-oriented programming» (не учитываем регистр символов) на «OOP».
 * Например, строка  * "Object-oriented programming is a programming language
 * model organized around objects rather than "actions" and data rather than logic.
 * Object-oriented programming blabla. Object-oriented programming bla."
 * должна быть преобразована в  * "Object-oriented programming is a
 * programming language model organized around objects
 * rather than "actions" and data rather than logic. OOP blabla. Object-oriented programming bla."
 */

public class StringTask2 {
    public static void main(String[] args) {

        String stringIn = "Object-oriented programming is a programming language" +
                " model organized around objects rather than \"actions\" and data rather than logic." +
                " Object-oriented programming blabla. Object-oriented PROGramming bla." +
                " Object-ORiented programming blabla. one two three object-oriented programming bla.";

        String entryMax = "object-oriented programming";
        String entryMin = "OOP";

        System.out.println(stringIn);

        WorkWithString myReplace = new WorkWithString();
        System.out.println(myReplace.replaceEverySecondEntryString(stringIn, entryMax, entryMin));
    }
}
