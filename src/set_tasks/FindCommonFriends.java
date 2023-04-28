package set_tasks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class FindCommonFriends {
    static HashSet<String> readFile(String filename) throws IOException {
        HashSet<String> set = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            set.add(line);
        }
        reader.close();
        return set;
    }

    public static void main(String[] args) throws IOException {
        HashSet<String> friends1 = readFile("Друзья1.txt");
        HashSet<String> friends2 = readFile("Друзья2.txt");

        friends1.retainAll(friends2);

        for(String s : friends1) {
            System.out.println(s);
        }
    }
}
