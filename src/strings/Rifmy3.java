package strings;
//Рифмы
//        Дан текст (набор слов). Найдите в нем два слова с наилучшей рифмой. Наилучшей будем считать рифму, когда у пары слов совпадает наибольшее число букв с конца.
//        Формат входных данных
//        Первая строчка входных данных содержит натуральное число n, 2<=n<=10000. Затем идет n различных строк, каждая из которых содержит одно слово
//        Формат выходных данных
//        Программа должна вывести в одной строчке число последних совпадающих букв в наилучшей рифме, затем (через пробел) два слова, образующих эту рифму. Если существует несколько наилучших рифм, то программа должна вывести только одну (любую) пару из них. Если никакие два слова входного текста не рифмуются между собой, программа должна вывести одно число 0.
//        Примеры
//        Входные данные:
//        2       олимпиада     программирование
//        Выходные данные:
//        0
//        Входные данные:
//        8      зеленый     том     ученый     кругом     направо     заводит     налево     говорит
//        Выходные данные:
//        4 зеленый ученый
import java.io.*;
class Result {
    String word1;
    String word2;
    int count;
}

public class Rifmy3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("рифмы.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("рифмы_out.txt"));
        String str = reader.readLine();
        String[] s = str.trim().split("\\s+");
        Result result = solution(s);
        writer.write(result.count + " ");
        if (result.count != 0) {
            writer.write(result.word1 + " ");
            writer.write(result.word2 + " ");
        }
        writer.close();
    }
    static Result solution(String[] s){
        Result result = new Result();
        String s1 = "";
        String s2 = "";
        for (int i = 1; i < s.length; i++) {
            s1 = s[i];
            for (int j = i + 1; j < s.length; j++) {
                s2 = s[j];
                // получаю число совпадающих букв в конце двух слов
                int count = compare(s1, s2);
                if (count > result.count) {
                    result.count = count;
                    result.word1 = s1;
                    result.word2 = s2;
                }
            }
        }

        return result;
    }

    static int compare(String s1, String s2) {
        int count = 0;
        int j = s2.length() - 1;
        for (int i = s1.length() - 1; i >= 0; i--) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 == c2) {
                count++;
            } else break;
            j--;
            if (j < 0) break;
        }
        return count;
    }
}
