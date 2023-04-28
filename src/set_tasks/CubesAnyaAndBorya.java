package set_tasks;

import java.io.*;
import java.util.HashSet;

//https://pythontutor.ru/lessons/sets/problems/cubes/
public class CubesAnyaAndBorya {
    public static void main(String[] args) throws IOException {
        HashSet<String> anya = new HashSet<>();
        HashSet<String> borya = new HashSet<>();
        HashSet<String> both;
        HashSet<String> anyaOnly = new HashSet<>();
        HashSet<String > boryaOnly = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader("CubesAnyaAndBorya.txt"));
        String s = reader.readLine();
        String[] numbers = s.split(" ");
        int numAnya = Integer.parseInt(numbers[0]);
        int numBorya = Integer.parseInt(numbers[1]);
        for (int i = 0; i < numAnya; i++) {
            anya.add(reader.readLine());
        }
        for (int i = 0; i < numBorya; i++) {
            String color = reader.readLine();
            borya.add(color);
        }
        anyaOnly = new HashSet<>(anya);
        anyaOnly.removeAll(borya);
        boryaOnly = new HashSet<>(borya);
        boryaOnly.removeAll(anya);
        both = new HashSet<>(anya);
        both.retainAll(borya);
        BufferedWriter writer = new BufferedWriter(new FileWriter("CubesAnyaAndBoryaResult.txt"));
        writer.write(both.size() + "\n");
        for (String s3 : both) {
            writer.write(s3 + " ");
        }
        writer.write("\n");
        writer.write(anyaOnly.size() + "\n");
        for (String s4 : anyaOnly) {
            writer.write(s4 + " ");
        }
        writer.write("\n");
        writer.write(boryaOnly.size() + "\n");
        for (String s5 : boryaOnly) {
            writer.write(s5 + " ");
        }
        writer.write("\n");
        writer.close();
    }
}
