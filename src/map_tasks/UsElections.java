package map_tasks;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

//https://pythontutor.ru/lessons/dicts/problems/usa_elections/
//В первой строке дано количество записей.
// Далее, каждая запись содержит фамилию кандидата и число голосов, отданных за него в одном из штатов.
// Подведите итоги выборов: для каждого из участника голосования определите число отданных за него голосов.
// Участников нужно выводить в алфавитном порядке.
public class UsElections {
 //   static void Elect(String[] s){}

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("uselect.txt"));
        HashMap<String, Integer> map = new HashMap<>();
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            String name = strings[0];
            Integer v = Integer.parseInt(strings[1]);
            if (map.containsKey(name)){
                map.replace(name, map.get(name)+ v);
            }else {
                map.put(name,v);
            }
        }
        for (String key: map.keySet())
        {
            Integer value = map.get(key);
            System.out.println(key + " --> " + value);
        }
    }
}
