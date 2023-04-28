package file_tasks;
//13,02,2023 на уроке, не д.з.
import java.io.*;
import java.util.Scanner;

public class Buildings {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите искомую высоту");
        int findH = scanner.nextInt();

        BufferedReader reader = new BufferedReader(new FileReader("здания.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("здания_out.txt"));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] a = line.split(" ");
            String hStr = a[a.length - 1];
            int h = Integer.parseInt(hStr);
            if (h > findH) {
                writer.write(line);
                writer.newLine();
                //writer.flush();
            }
        }


        reader.close();
        writer.close();
    }
}
