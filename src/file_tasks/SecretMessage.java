package file_tasks;
//01.03.2023 https://acmp.ru/index.asp?main=task&id_task=34
//
//На секретную базу в Арктике поступила шифровка – последовательность из n десятичных цифр. Она содержит номер секретной базы в Антарктиде, который является последовательностью из k десятичных цифр. При этом для того, чтобы отличить его от ненужной Вам информации, он повторен в шифровке хотя бы два раза (возможно, эти два вхождения перекрываются).
//        Напишите программу, которая по шифровке и длине номера секретной базы определяет, содержит ли шифровка номер базы. Учтите, что у базы может быть несколько номеров, и все они могут быть переданы в шифровке.
//        Входные данные
//        Первая строка входного файла INPUT.TXT содержит два целых числа: n (1 ≤ n ≤ 105) и k (1 ≤ k ≤ 5) – длину шифровки и длину номера секретной базы соответственно. Вторая строка содержит n цифр – шифровку. Помните, что цифры в шифровке не разделяются пробелами.
//        Выходные данные
//        В выходной файл OUTPUT.TXT выведите «YES», если шифровка содержит номер секретной базы, и «NO» в противном случае.
import java.io.*;

public class SecretMessage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("секретное_сообщение.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("секретное_сообщение_out.txt"));

        String s = reader.readLine(); // строка из числа n и числа k
        String[] s1 = s.split(" ");//перевожу в массив двух строковых элементов
        int n = Integer.parseInt(s1[0]);//Перевожу из строки в число "количество цифр в шифровке". Не понятно, зачем это нужно в условии?
        int k = Integer.parseInt(s1[1]);//Перевожу из строки в число "количество цифр в номере базы"
        s = reader.readLine();//считываю строку "шифровку" из чисел без пробелов

        if (check(s,k)) {
            writer.write("YES");
        }else {
            writer.write("NO");
        }
       reader.close();
       writer.close();

    }
    static  boolean check(String s, int k){
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < s.length()-k; i++) {
            s1 = s.substring(i,i+k);//отрезаю от строки k символов
            for (int j = i+1;  j < s.length()-k+1;j++ ) {
                s2 = s.substring(j, j+k);//отрезаю от строки k символов, но на единицу сдвигаю вправо.
                if (s1.equals(s2)){ // если есть совпадение
                    return true;
                }
            }
        }
        return  false;
    }
   // вар. 2
    static  boolean check2(String s, int k){
        String s1 = "";
        for (int i = 0; i < s.length()-k; i++) {
            s1 = s.substring(i,i+k);//отрезаю от строки k символов
            int p = s.indexOf(s1, i+1 );
            if (p !=-1){
                return true;
            }
        }
        return  false;
    }

}
