package map_tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class FrequencyWords {
    public static void main(String[] args) throws IOException {
//Этот метод считывает весь файл целиком в память
        String content = Files.readString(Path.of("alice.txt"));

        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(content, " \t\n\r,.!?-");
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (map.containsKey(word)) {
                map.replace(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }

        for(var entry : map.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
