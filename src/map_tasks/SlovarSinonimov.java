package map_tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://pythontutor.ru/lessons/dicts/problems/synonym_dictionary/
//Вам дан словарь, состоящий из пар слов. Каждое слово является синонимом к парному ему слову. Все слова в словаре различны.
//Для слова из словаря, записанного в последней строке, определите его синоним.
public class SlovarSinonimov {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("slovarSinonimov.txt"));
        HashMap<String, String> map = new HashMap<>();
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            String s2 = scanner.next();
            map.put(s, s2);
            map.put(s2, s);
        }
        String word = scanner.next();

        if (map.containsKey(word)){
            System.out.println("Синоним слова " + word +" ---> " + map.get(word));
        }
    }
}
