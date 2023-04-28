package set_tasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//17.04.2023
//https://pythontutor.ru/lessons/sets/problems/guess_number/
/*Август и Беатриса играют в игру. Август загадал натуральное число от 1 до n.
Беатриса пытается угадать это число, для этого она называет некоторые множества натуральных чисел.
Август отвечает Беатрисе YES, если среди названных ей чисел есть задуманное или NO в противном случае.
После нескольких заданныъх вопросов Беатриса запуталась в том, какие вопросы она задавала и какие ответы получила
и просит вас помочь ей определить, какие числа мог задумать Август.
В первой строке задано n - максимальное число, которое мог загадать Август.
Далее каждая строка содержит вопрос Беатрисы (множество чисел, разделенных пробелом) и ответ Августа на этот вопрос.
Вы должны вывести через пробел, в порядке возрастания, все числа, которые мог задумать Август.
*/
public class UgadayChislo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("UgadayChislo.txt"));
        HashSet<String> augustThought =  new HashSet<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= n; i++) {
        augustThought.add(Integer.toString(i));
        }
        while (true){
            String s = reader.readLine();
            if (s.equals("HELP")) break;
            String[] answ = s.split(" ");
            String yesOrNo = reader.readLine();
            HashSet<String> tmp = new HashSet<>(Arrays.asList(answ));
            if (yesOrNo.equals("YES")){
                augustThought.retainAll(tmp);
            }else {
                augustThought.removeAll(tmp);
            }
        }
        for (String s : augustThought) {
            System.out.println(s);
        }
    }
}
