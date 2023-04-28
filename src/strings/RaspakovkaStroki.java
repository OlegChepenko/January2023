package strings;
//https://acmp.ru/index.asp?main=task&id_task=231
//
//Будем рассматривать только строчки, состоящие из заглавных английских букв. Например, рассмотрим строку AAAABCCCCCDDDD. Длина этой строки равна 14. Поскольку строка состоит только из английских букв, повторяющиеся символы могут быть удалены и заменены числами, определяющими количество повторений. Таким образом, данная строка может быть представлена как 4AB5C4D. Длина такой строки 7. Описанный метод мы назовем упаковкой строки.
//Напишите программу, которая берет упакованную строчку и восстанавливает по ней исходную строку.
//Входные данные
//Входной файл INPUT.TXT содержит одну упакованную строку. В строке могут встречаться только конструкции вида nA, где n — количество повторений символа (целое число от 2 до 99), а A — заглавная английская буква, либо конструкции вида A, то есть символ без числа, определяющего количество повторений. Строка содержит от 1 до 80 символов.
//Выходные данные
//В выходной файл OUTPUT.TXT выведите восстановленную строку. При этом строка должна быть разбита на строчки длиной ровно по 40 символов (за исключением последней, которая может содержать меньше 40 символов).


import java.io.*;


public class RaspakovkaStroki {
    public static void main(String[] args) throws IOException {
        solution();
    }
    static void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("распаковка_строки.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("распаковка_строки_out.txt"));
        String s = reader.readLine();
        int num = 0;
        int lineLength40 = 0;
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                num = num * 10 + (c - '0');
            } else if ('A' <= c && c <= 'Z') {
                if (num == 0) {
                    num = 1;
                }
                for (int j = 0; j < num; j++) {
                    writer.write(c);
                    lineLength40++;
                    if (lineLength40 == 40) {
                        writer.write("\n");
                        lineLength40 = 0;
                    }
                }
                num = 0;
            }
        }
        writer.close();
        reader.close();
    }

}
