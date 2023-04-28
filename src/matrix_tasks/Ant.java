package matrix_tasks;
//Дана матрица. Размещаем муравья в рандомную ячейку.
// Муравей рандомно перемещается в одном из направлений (вверх, вниз, влево, вправо) на одну ячейку.
// Если он достиг края доски, то за доску шагать нельзя.
// Задача посчитать кол-во шагов сделанных муравьем, чтобы обойти всю доску.
// (при перемещении он оставляет след). Данный процесс симуляции нужно запустить 10 раз и найти среднее кол-во шагов

import java.util.Random;
import java.util.Scanner;

public class Ant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите количество горизонтальных полей доски ");
        int m = scanner.nextInt();
        System.out.println("Укажите количество вертикальных полей доски ");
        int n = scanner.nextInt();
        char[][] a = new char[n][m];


        int sum = 0;
        int count;
       for (int i = 0;i < 10;i++) {
            fillMatrix(a);
            count = placeAnt(a);
            System.out.println("Сделано шагов за этот цикл: " + count);
            System.out.println("Пройдено циклов " + (i+1));
            sum += count;
        }
        int result = sum / 10;
        System.out.println("Муравей совершил в среднем " + result + " шагов");
    }

    static void fillMatrix(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = '.';
            }
        }
    }

    //рандомно устанавливаем муравья
    static int placeAnt(char[][] a) {
        Random random = new Random();
        int m = random.nextInt(0, a.length);
        int n = random.nextInt(0, a[0].length);
        a[m][n] = 'X';
        printMatrix(a);
        //подсчет сделанных шагов
        int count = 0;
        while (!finish(a)) {

            int step = random.nextInt(0, 4);
            int newM = m;
            int newN = n;
            if (step == 0) {
                newM--;

            } else if (step == 1) {
                newM++;
            } else if (step == 2) {
                newN++;
            } else if (step == 3) {
                newN--;
            }
            if (newM >= 0 && newN >=0 && newN < a.length && newM < a.length){
                count++;
                a[m][n] = '*';
                m = newM;
                n = newN;
                a[m][n] = 'X';
            }
        }
        return count;
    }
    //проверка, осталась ли еще ячейка, куда не ходил муравей
    static boolean finish(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == '.')
                    return false;
            }
        }
        return true;
    }



    static void printMatrix(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


