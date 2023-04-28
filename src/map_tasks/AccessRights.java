package map_tasks;
//https://pythontutor.ru/lessons/dicts/problems/permissions/
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AccessRights {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("AccessRightsResult.txt"));
        BufferedReader reader = new BufferedReader(new FileReader("AccessRights.txt"));
        HashMap<String, ArrayList<String>> mapArr = new HashMap<>();
        HashMap<String, String> dictionary = new HashMap<>();
       dictionary.put("read", "R");
       dictionary.put("write", "W");
       dictionary.put("execute", "X");
        int num = Integer.parseInt(reader.readLine());
        String s = "";
        for (int i = 0; i < num; i++) {
            ArrayList<String> xwr = new ArrayList<>();
            s = reader.readLine();
            String[] strings = s.split(" ");
            for (int j = 1; j < strings.length; j++) {
            xwr.add(strings[j]);
            }
            mapArr.put(strings[0], xwr);
        }
        num = Integer.parseInt(reader.readLine());
        for (int i = 0; i < num; i++) {
            String[] strings2 = reader.readLine().split(" ");
            String key = strings2[1];
            String value = dictionary.get(strings2[0]);
            boolean flag = false;
            if (mapArr.get(key).contains(value)){
                writer.write("Ok\n");
            } else {
                writer.write("Access denied\n");
            }

/*            for (int j = 0; j < (mapArr.get(key)).size(); j++) {
               // Вот это сложно понять, как достать значение списка, если список это значение по ключу в map

                if ((mapArr.get(key).get(j)).equals(value)){
                    writer.write("Ok\n");
                    flag = true;
                    //System.out.println("Ok");
                    break;
                }
            }
            if (!flag) {
                writer.write("Access denied\n");
            }
*/
        }
        writer.close();
        reader.close();
    }
}
