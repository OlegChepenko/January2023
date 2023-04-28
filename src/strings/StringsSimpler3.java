package strings;

import java.util.Scanner;

//04.02.2023
// 3. Дана строка. Если она начинается на 'abc', то заменить их на 'www', иначе добавить в конец строки 'zzz'.
public class StringsSimpler3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку содержащую abc");
        String s2 = scanner.nextLine();
        System.out.println(changeABC(s2));
    }
    //если строка начинается с abc, заменить на www
    static String changeABC(String s){
        String s1 = s.toLowerCase();
        String s2 = "www";
        String s3 = "";
        String s4 = "zzz";
        if (s1.startsWith("abc")){
            s3 = s2 + s.substring(3);
        }
        else s3 = s1+s4;
        return s3;
    }
}
