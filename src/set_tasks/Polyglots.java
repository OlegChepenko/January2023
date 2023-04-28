package set_tasks;
//https://pythontutor.ru/lessons/sets/problems/polyglotes/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class Polyglots {
    static void printHashSetArray(HashSet<String>[] sets) {
        for (int i = 0; i < sets.length; i++) {
            System.out.println(sets[i]);
        }
    }
    static void printArray(String[] array){
        for (String p : array) {
            System.out.println(p);
        }
    }
    static String[] allStudentsKnow(HashSet<String>[] sets) {
        HashSet<String> result = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            result.retainAll(sets[i]);
        }
        String[] array = result.toArray(new String[0]);
        Arrays.sort(array);
        return array;
    }

    static String[] LangSomeoneKnow(HashSet<String>[] sets){
        HashSet<String> result = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            for (String p : sets[i]) {
                result.add(p);
            }
        }
        String[] array = new String[result.size()];
        result.toArray(array);
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("polyglots.txt"));
        int students = Integer.parseInt(reader.readLine());
        HashSet<String>[] sets = new HashSet[students];
        for (int i = 0; i < students; i++) {
            sets[i] = new HashSet<>();
            int languages = Integer.parseInt(reader.readLine());
            for (int j = 0; j < languages; j++) {
                String lang = reader.readLine();
                sets[i].add(lang);
            }
        }
//        printHashSetArray(sets);
        String[] array1 = allStudentsKnow(sets);
        System.out.println(array1.length);
        printArray(array1);
        String[] array2 = LangSomeoneKnow(sets);
        System.out.println(array2.length);
        printArray(array2);
    }
}
