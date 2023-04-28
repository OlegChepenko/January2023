package strings;
//30.01.2023
//задача достать из строки все числа и найти их сумму.
import java.util.Scanner;

public class TovarTask {
    public static void main(String[] args) {
        String text = "milk = 50 rub, apple =100 rub, water =88rub";

        int total = 0;
        int start = 0;
        while (true) {
            int pos1 = text.indexOf('=', start);
            if (pos1 == -1)
                break;
            int pos2 = text.indexOf("rub", pos1);

            String s = text.substring(pos1 + 1, pos2);
            System.out.println(s);
            s = s.strip();// функция стрип убирает пробелы с начала и с конца строки
            int cost = Integer.parseInt(s);
            total += cost;

            start = pos2+3;
        }
        System.out.println(total);
    }

}
