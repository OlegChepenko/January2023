package map_tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//сколько раз купили каждый вкус - количество покупателей
//сколько раз купили каждый вкус независимо от покупателей
public class IceCream {
    static void printMap(HashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    static void clientsChoice(String filename) throws IOException {
        //второй вариант: подсчет сколько клиентов купили каждый вкус
        HashMap<String, Integer> temp = new HashMap<>();
        HashMap<String, Integer> clientsPreference = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String s = "";
        int topIceCream = 0;
        String name = "";
        while ((s = reader.readLine()) != null) {
            String[] strings = s.split(";");
            for (String flavor : strings) {
                temp.put(flavor, 1);
            }
            for (Map.Entry<String, Integer> entry : temp.entrySet()) {
                if (clientsPreference.containsKey(entry.getKey())) {
                    clientsPreference.put(entry.getKey(), clientsPreference.get(entry.getKey()) + 1);
                } else {
                    clientsPreference.put(entry.getKey(), 1);
                }
            }
            temp.clear();
        }
        System.out.println("Вкусы выбранные клиентами. Если клиент выбрал одинаковый вкус неоднократно, это учитывается как один");
        printMap(clientsPreference);
        for (Map.Entry<String, Integer> entry : clientsPreference.entrySet()) {
            if (entry.getValue() > topIceCream){
                topIceCream = entry.getValue();
                name = entry.getKey();
            }
        }
        System.out.println("Больше всего клиентам понравился вкус: " + name + ". " + topIceCream + " Клиентов предпочли этот вкус.");
    }

    static void total(String filename) throws IOException {
//первый вариант: подсчет сколько всего раз купили каждый вкус, независимо от количества клиентов
        String content = Files.readString(Path.of(filename));
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(content, " \t\n\r,.!?-;");
        int topIceCream = 0;
        String name = "";
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
            if (map.get(word) > topIceCream) {
                topIceCream = map.get(word);
                name = word;
            }
        }
        System.out.println("Общее количество проданных шариков мороженного, по вкусам");
        printMap(map);
        System.out.println("Самый продаваемый вкус: " + name + " " + topIceCream);
    }

    public static void main(String[] args) throws IOException {
        total("ice-cream.txt");
        clientsChoice("ice-cream.txt");

    }

}
