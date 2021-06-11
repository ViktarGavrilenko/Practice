/**
 * Слово с минимальным числом символов
 * Найти слово, в котором число различных символов минимально.
 * Слово может содержать буквы и цифры. Если таких слов несколько, найти первое из них.
 * Например, в строке "fffff ab f 1234 jkjk" найденное слово должно быть "fffff".
 */

public class StringTask3 {
    public static void main(String[] args) {
        String str = "fffff ab f 1234 jkjk";

        MinNumberDistinctChar minCharWord = new MinNumberDistinctChar();

        System.out.println(minCharWord.minNumberDistinctChar(str));

    }
}
