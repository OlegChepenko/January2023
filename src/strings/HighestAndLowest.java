package strings;
import java.util.Arrays;
import java.util.Scanner;
//https://www.codewars.com/kata/554b4ac871d6813a03000035/java
//09.02.2023
public class HighestAndLowest {
    public static void main(String[] args) {
        System.out.println("Введите строку");
        Scanner scanner = new Scanner(System.in);
        String p = scanner.nextLine();

        String maxMin = highAndLow(p);
        System.out.println(maxMin);
    }
    // public static String highAndLow(String numbers)
    public static String highAndLow(String p) {
        String[] s = p.split(" ");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(array);
        int min = array[0];
        int max = array[array.length-1];
        String maxMin = min + " " + max;
        return maxMin;
    }
    static void print(String[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
    }

}
