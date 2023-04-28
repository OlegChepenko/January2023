package map_tasks;

import java.util.HashMap;
import java.util.Scanner;

public class Numericals {

    static String numericals(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            else {
                map.put(s.charAt(i), 1);
            }
            builder.append(map.get(s.charAt(i)));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String result = numericals(s);
        System.out.println(result);
    }
}
