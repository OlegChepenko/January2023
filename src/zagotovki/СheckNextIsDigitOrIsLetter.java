package zagotovki;

public class СheckNextIsDigitOrIsLetter {
    //метод проверяет следующий элемент в строке. Если элемент не является числом,
// буквой или строка закончилась, то возвращает true (значит все, нужно заносить в стек число!)

    static boolean checkNextIsDigitOrIsLetter(String s, int i) {
        if ((i + 1) >= s.length()) {
            return true;
        }
        if (Character.isDigit(s.charAt(i + 1))) {
            return false;
        }
        if (Character.isLetter(s.charAt(i + 1))) {
            return false;
        }
        return true;
    }
}
