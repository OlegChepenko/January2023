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
        int count = 0;
        int i = 0;
        while ( i < 10 ) {
            fillMatrix(a);
         count += placeAnt(a);
         i++;
            System.out.println("Сделано шагов за этот цикл: " + count);
            System.out.println("Пройдено циклов " + i) ;
            sum += count;
            count = 0;
        }
        int result = sum/10;
        System.out.println("Среднее количество шагов, чтобы упереться в край доски за один цикл: " + result);
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
        //установка муравья в рандомную ячейку
        Random random = new Random();
        int m = random.nextInt(0, a.length);
        int n = random.nextInt(0, a[0].length);
        a[m][n] = 'X';
        printMatrix(a);
      //подсчет сделанных шагов
        int count = 0;
        while (true) {
            int move = random.nextInt(0, 4);
            if (move == 0) {
//Вверх
                System.out.println("up");
                //проверка, что туда можно ходить
                if (m - 1 >= 0) {
                    //то муравей ходит в эту ячейку
                    a[m - 1][n] = 'X';
                    a[m][n] = '*';
                    m = m - 1;
                    count++;
                    printMatrix(a);
                    System.out.println("Выполнено ходов: " + count);
                }else {
                    System.out.println("Уперся в стену!");break;}
            } else if (move == 1) {
//Вниз
                System.out.println("down");
                //проверка, что туда можно ходить
                if (m + 1 < a.length && m + 1 > 0) {
                    //то муравей ходит в эту ячейку
                    a[m + 1][n] = 'X';
                    a[m][n] = '*';
                    m = m + 1;
                    count++;
                    printMatrix(a);
                    System.out.println("Выполнено ходов: " + count);
                }else {
                    System.out.println("Уперся в стену!");break;}
            } else if (move == 2) {
//На право
                System.out.println("right");
                //проверка, что туда можно ходить
                if (n + 1 < a.length && n + 1 > 0) {
                    //то муравей ходит в эту ячейку
                    a[m][n + 1] = 'X';
                    a[m][n] = '*';
                    n = n + 1;
                    count++;
                    printMatrix(a);
                    System.out.println("Выполнено ходов: " + count);
                }else {
                    System.out.println("Уперся в стену!");break;}
            } else if (move == 3) {
//На лево
                System.out.println("left");
                //проверка, что туда можно ходить
                if (n - 1 >= 0) {
                    //то муравей ходит в эту ячейку
                    a[m][n - 1] = 'X';
                    a[m][n] = '*';
                    n = n - 1;
                    count++;
                    printMatrix(a);
                    System.out.println("Выполнено ходов: " + count);
                }else {
                    System.out.println("Уперся в стену!");break;}
            }
        }
        return count;
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
