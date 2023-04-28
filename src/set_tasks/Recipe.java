package set_tasks;
//https://drive.google.com/file/d/1sWtefQnObZm30UHsZZHwq3EUYf3N6rl6/view?usp=share_link

import java.io.*;
import java.util.HashSet;

public class Recipe {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Recipe.txt"));
        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            set.add(reader.readLine());
        }
        int recipe = Integer.parseInt(reader.readLine());
        for (int i = 0; i < recipe; i++) {
            String dishName = reader.readLine();
            int num = Integer.parseInt(reader.readLine());
            boolean flag = true;
            for (int j = 0; j < num; j++) {
                String ingredients = reader.readLine();
                if (!set.contains(ingredients)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println(dishName);
            }
        }
    }
}
