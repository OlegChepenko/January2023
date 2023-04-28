package strings;

import java.util.Scanner;

public class SumDigits {

    static int sumDigits(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                sum += s.charAt(i) - '0';
                //sum += Character.digit(s.charAt(i), 10);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку");
        String s = scanner.nextLine();

        int sum = sumDigits(s);
        System.out.println(sum);
    }
}
