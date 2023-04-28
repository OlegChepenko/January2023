package zagotovki;
import java.io.*;
public class UdalenieStrokiIzFaila {
//https://ru.stackoverflow.com/questions/Удаление-строки-из-текстового-файла-в-программе-на-java-swing
    public static void perezapisatFile() throws IOException {
//        Создаём две файловые переменные.
        File sourceFile = new File("Dictio.txt");
        File outputFile = new File("Dictio2.txt");
//        Записываем в новый файл все данные, кроме удаляемой строки.
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String outputLine = "Строка, которую нужно удалить";
            if (!line.equals(outputLine)) {
                writer.write(line);
                writer.newLine();
            }
        }
//        Затем удаляем исходный файл, а получившийся файл переименовываем.
        reader.close();
        writer.close();
        sourceFile.delete();
        outputFile.renameTo(sourceFile);

//        P.S.
//
//В данной ситуации, более рациональным решением было бы прочитать файл в строковый массив,
// а затем удалить в нём нужную строку и перезаписать исходный файл с новыми данными.
    }

}
