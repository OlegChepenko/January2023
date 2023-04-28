package map_tasks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PeteBaker {

    static HashMap<String, Integer> readFile(String filename) throws FileNotFoundException {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNext()) {
            String name = scanner.next();
            int amount = scanner.nextInt();
            map.put(name, amount);
        }
        scanner.close();
        return map;
    }

    static int cakes(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        int minVal = Integer.MAX_VALUE;

        for(Map.Entry<String, Integer> p : map1.entrySet()) {

            if (map2.containsKey(p.getKey())) {
                int count = map2.get(p.getKey()) / p.getValue();
                if (count < minVal) {
                    minVal = count;
                }
            }
            else {
                return 0;
            }
        }
        return minVal;
    }

    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> map1 =  readFile("Рецепт.txt");
        HashMap<String, Integer> map2 =  readFile("Кухня.txt");

        int result = cakes(map1, map2);
        System.out.println(result);
    }
}
