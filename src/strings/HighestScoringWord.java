package strings;
//https://www.codewars.com/kata/57eb8fcdf670e99d9b000272
import java.util.Arrays;

//10.02.2023
/*
Дана строка из слов. От вас требуется найти слово, стоящее наиболее дорого.
Каждая буква оценивается очками, в соответствии с ее позицией в алфавите:  a = 1, b = 2, c = 3 etc.
Например: abad is 8 (1 + 2 + 1 + 4).
Требуется вернуть наиболее ценное слово в формате строки.
Если два слова имеют одинаковоую ценность, вернуть первое в очереди.
Все буквы в нижнем регистре, и имеют валидный ввод.
 */
//13.02.2023 получена задача вывести получение цены слова в отдельную функцию.
public class HighestScoringWord {
    public static void main(String[] args) {
        String s = "man i need a taxi up to ubud";
        System.out.println(high(s));
    }
    static String high(String s) {
        String[] str = s.split(" ");
        int max = 0;
        String maxStr = "";
        for (int i = 0; i < str.length; i++) {
            int sum = powerOfWord(str[i]);//получил цену слова
                if (sum > max) {
                    max = sum;
                    maxStr = str[i];
                }
            }
        return maxStr;
    }
    static int powerOfWord(String str){
        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        int sum = 0;
        for (int j = 0; j < str.length(); j++) {//бегу по слову, по его буквам
            sum += alphabet.indexOf(str.charAt(j));//получается сумма - цена слова
            }
        return sum;
    }

//второе решение
    static String high2(String s) {
        String winner = "";
        int highScore = 0;

        for (String word : s.split(" ")) {
            int score = 0;
            for (char c : word.toCharArray()) {
                System.out.println(c);
                score += c - 'a' + 1;
            }
            if (score > highScore) {
                winner = word;
                highScore = score;
            }
        }

        return winner;
    }
}
