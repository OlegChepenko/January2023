package strings;
//01.02.2023
import java.util.Scanner;
//30.01.2023
// 1. Дана строка. Определите общее количество символов '+' и '-' в ней.
public class StringsSimpler1 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Введите строку содержащую +,-");
        String s = scanner.nextLine();
        int n = countPlusAndMinus(s);
        System.out.println("Строка содержит \"+\" и \"-\" :" + n + " раз");

    }
    static int countPlusAndMinus(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='+' || s.charAt(i) == '-'){
                count++;
            }
        }
        return count;
    }
}
