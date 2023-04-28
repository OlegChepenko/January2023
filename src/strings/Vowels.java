package strings;

import java.util.Scanner;

public class Vowels {

    static boolean checkVowel(char c) {
        c = Character.toLowerCase(c);
        String vowels = "aoiuye";
        if (vowels.contains(c + ""))
            return true;
        else return false;
    }

    static int countVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (checkVowel(s.charAt(i))) {
                count++;
            }
        }
        return count;
    }

//    static String removeVowels(String s) {
//        for (int i = 0; i < s.length(); i++) {
//            if (checkVowel(s.charAt(i))) {
//                s = s.substring(0, i) + s.substring(i+1);
//                i--;
//            }
//        }
//        return s;
//    }

    static String removeVowels(String s) {
        String p = "";
        for (int i = 0; i < s.length(); i++) {
            if (!checkVowel(s.charAt(i))) {
                p += s.charAt(i);
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку");
        String s = scanner.nextLine();

        int count = countVowels(s);
        System.out.println("Кол-во гласных = " + count);

        s = removeVowels(s);
        System.out.println(s);
    }
}
