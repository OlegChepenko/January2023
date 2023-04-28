package file_tasks;
//https://acmp.ru/index.asp?main=task&id_task=691
//22.02.2023
import java.io.*;

//21.02.2023
/*проверка на правильность входящих автомобильных номеров
*Первая строка входного файла INPUT.TXT содержит единственное натуральное число N – количество записанных Васей номеров (N ≤ 50). Далее следует N строк с записями номеров автобусов. Длины строк от 1 до 300 и содержат только символы с кодами ASCII от 33 до 127 (не содержат пробелов, специальных и русских символов).
*В выходной файл OUTPUT.TXT выведите N строк, в i-й строке должно содержаться «Yes», если соответствующая i-я запись номера верна и «No» в противном случае
* В качестве цифр могут использоваться любые цифры от 0 до 9
* а в качестве букв только прописные буквы A, B, C, E, H, K, M, O, P, T, X, Y
* */
public class BusNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("номера_автобусов.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("номера_автобусов_out.txt"));
        int lenght = Integer.parseInt(reader.readLine());

        String s;

        while ((s = reader.readLine()) != null){
            if (check(s)) {
                writer.write("Yes\n");

            }else writer.write("No\n");
        }
        writer.close();
    }



    static boolean check(String s){
        String validLetter = "ABCEHKMOPTXY";

        if(s.length()!=6) return false;
        if (!validLetter.contains(s.charAt(0) +""))return false;
        if (!Character.isDigit(s.charAt(1))||!Character.isDigit(s.charAt(2))||!Character.isDigit(s.charAt(3))) return false;

        if (!validLetter.contains(s.charAt(4) + "")) return false;
        if (!validLetter.contains(s.charAt(5) + "")) return false;
        return true;
    }

}
