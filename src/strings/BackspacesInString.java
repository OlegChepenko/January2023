package strings;
import java.util.Scanner;
//09.02.2023
//https://www.codewars.com/kata/5727bb0fe81185ae62000ae3/java
public class BackspacesInString {
    public static void main(String[] args) {
        System.out.println("Введите строку");
        Scanner scanner = new Scanner(System.in);
        String p = scanner.next();
        String str = cleanString(p) ;
        System.out.println("\"" + str + "\"");
    }

    public static String cleanString(String s) {
        String p = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                p += s.charAt(i);
            } else if (p.length() > 0) {
                int indx = p.length() - 1;
                p = p.substring(0, indx);
            }
        }
        return p;
    }
}
