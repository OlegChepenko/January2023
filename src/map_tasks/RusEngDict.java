package map_tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RusEngDict {

    static HashMap<String, ArrayList<String>> readFile() throws IOException {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("словарь.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] a = line.split("-");
            String rusWord = a[0].trim();
            String[] engWords = a[1].trim().split(",");
            ArrayList<String> listEngWords = new ArrayList<>(List.of(engWords));
            map.put(rusWord, listEngWords);
        }
        reader.close();

        return map;
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList<String>> map = readFile();

        Scanner scanner = new Scanner(System.in);
        int action;

        do {
            System.out.println("1.Перевод англ слова");
            System.out.println("2.Перевод русского слова");
            System.out.println("3.Выход");

            action = scanner.nextInt();
            if (action == 1) {
                System.out.println("Введите слово ");
                String word = scanner.next();

                boolean find = false;
                for(var p : map.entrySet()) {
                    if (p.getValue().contains(word)) {
                        System.out.println(p.getKey());
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    System.out.println("Нет такого слова");
                }
            }
            else if (action == 2) {
                System.out.println("Введите слово ");
                String word = scanner.next();

                if (map.containsKey(word)) {
                    for(String p : map.get(word)) {
                        System.out.println(p);
                    }
                }
                else {
                    System.out.println("Нет такого слова");
                }
            }
        }
        while (action != 3);
    }
}
