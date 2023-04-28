package strings;
//08.02.2023
//https://www.codewars.com/kata/59c5f4e9d751df43cf000035/train/java
import java.util.Scanner;
//08.02.2023
public class LongestVowelСhain {
    public static void main(String[] args) {

        System.out.println("Введите строку");
        Scanner scanner = new Scanner(System.in);
        String p = scanner.next();
        int max = solve(p);
        System.out.println(max);
    }
    public static int solve(String s){
        int length = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (checkVowel(s.charAt(i))){
                length++;
                if (length>max)
                    max = length;
            }
            else length = 0;
        }
        return max;
    }
    static boolean checkVowel(char c){
        String vowels = "aeiou";
        if (vowels.contains(c + ""))
            return true;
        else return false;
    }
}
