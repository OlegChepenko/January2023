//09.02.2023
//https://www.codewars.com/kata/515decfd9dcfc23bb6000006
//Write an algorithm that will identify valid IPv4 addresses in dot-decimal format. IPs should be considered valid if they consist of four octets, with values between 0 and 255, inclusive.
package strings;

import java.util.Scanner;

public class IPValidation {
    public static void main(String[] args) {
        System.out.println("Введите строку");
        Scanner scanner = new Scanner(System.in);
        String p = scanner.next();
        if (is_valid_IP(p)){
        System.out.println("Проверка пройдена");
        }
        else {
            System.out.println("Проверка не пройдена");
        }

    }
    static boolean is_valid_IP(String ipAddres){
        String[] s = ipAddres.split("\\.");
        if (s.length != 4) {
            return false;
        }
        for (String value : s) {
            if (!checkPart(value)) return false;
        }
            return true;
    }
    static boolean checkPart(String part){
// если эта часть начинается с нуля, но не является нулем, то это не годится.
        if (part.startsWith("0") && !part.equals("0")){
            return false;
        }
//Является ли символ цифрой
        for (int i = 0; i < part.length(); i++) {
            if (!Character.isDigit(part.charAt(i)))
                return false;
        }
//Все ли цифры меньше 255
        int number = Integer.parseInt(part);
        if (number > 255) {
            return false;
        }
        return true;
    }
}
