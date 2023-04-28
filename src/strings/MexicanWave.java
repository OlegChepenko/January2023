package strings;

import java.util.ArrayList;
import java.util.Scanner;

public class MexicanWave {

    static ArrayList<String> wave(String s) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                String p = s.substring(0, i) + Character.toUpperCase(s.charAt(i)) + s.substring(i + 1);
                res.add(p);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String s = scanner.nextLine();

        ArrayList<String> res = wave(s);
        for(String p : res) {
            System.out.println(p);
        }
    }
}
