package zagotovki;

import java.util.Scanner;

public class IsDigit {
    static boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    static int parsString(String s){
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        int n = 0;
        if (!s.isEmpty()&&isDigit(s)) {
            n = Integer.parseInt(s);
        }
        return n;
    }
}
