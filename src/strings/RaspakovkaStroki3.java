package strings;
//https://acmp.ru/index.asp?main=task&id_task=231
//вариант программы, с учетом пожеланий тренера
import java.io.*;

public class RaspakovkaStroki3 {
    public static void main(String[] args) throws IOException {
        int num = 40;//максимальная длинна строки, требуемая в ответе
        String fileName = "распаковка_строки.txt";
        String nameOutFile = "распаковка_строки_out.txt";
        String s = readFromFile(fileName);
        s = raspakovka(s);
        String[] strings = lineLength40(num, s);
        writeToFile(strings, nameOutFile);
    }

    static String readFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s = reader.readLine();
        reader.close();
        return s;
    }

    static void writeToFile(String[] strings, String nameOutFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nameOutFile));
        for (int i = 0; i < strings.length; i++) {
            writer.write(strings[i]);
            writer.write("\n");
        }
        writer.close();
    }

    static String raspakovka(String s) throws IOException {
        int num = 0;
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                num = num * 10 + (chars[i] - '0');
            } else if ('A' <= chars[i] && chars[i] <= 'Z') {
                if (num == 0) {
                    num = 1;
                }
                for (int j = 0; j < num; j++) {
                    result.append(chars[i]);
                }
                num = 0;
            }
        }
        return result.toString();//String.valueOf(result);
    }

    static String[] lineLength40(int num, String s) {
        //выясняю, делится ли строка ровно на указанную длину выходной строки
        int lengthOfMassiv = s.length()/num;//s.length()%num;
        //если нет, добавляю один элемент в массив, для последней строки меньшей, чем указанная макс. длинна вых. строки
        if (s.length()%num != 0){
            lengthOfMassiv++;
        }

        //заполняю массив строками, длинной не более указанной в условии
            String[] strings = new String[lengthOfMassiv];
        int start = 0;
        for (int i = 0; i < lengthOfMassiv; i++) {
            if (start + num <= s.length()) {
                strings[i] = s.substring(start, start + num);
                start += num;

            } else {
                strings[i] = s.substring(start);

            }
        }
        return strings;
    }


}
