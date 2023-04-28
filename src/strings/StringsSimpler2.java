package strings;
import java.util.Scanner;
//04.02.2023
// Дана строка. Определите, какой символ в ней встречается раньше: 'x' или 'w'.
// Если какого-то из символов нет, вывести сообщение об этом.
//1. Нет двух символов
//2. Нет одного символа
//3. Есь оба символа
public class StringsSimpler2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку содержащую x или w, или не содержащую их");
        String str = scanner.nextLine();
        findeSimbols(str);
    }
    static void findeSimbols(String s){
        char x = 'x';
        char w = 'w';
        if (!s.contains(x + "") && !s.contains(w + ""))
            System.out.println("Строка не содержит букв 'х' и 'w'");
        else if (!s.contains(x + "")){
            System.out.println("Строка не содержит букву 'x'");
        }
        else if (!s.contains(w + "")){
            System.out.println("Строка не содержит букву 'w'");
        }
        else {

//вар.1
            int str1 = s.indexOf('x');
            int str2 = s.indexOf('w');
            if (str1 - str2 > 0){
                System.out.println("Первой встречается буква w");
            }
            else System.out.println("Первой встречается буква x");
//вар.2
         /* for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'x'){
                    str = 'x';
                    break;
                }else if (s.charAt(i) == 'w'){
                    str = 'w';
                    break;
                }
            }
            System.out.println("Первой встречается буква " + str);*/
        }
    }
}
