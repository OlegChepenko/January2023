package matrix_tasks;
//02,02,2023
// https://www.codewars.com/kata/58663693b359c4a6560001d6/ruby
/*
* Ваша цель - пройти лабиринт и добраться до финиша, не касаясь стен.
* Вам будет предоставлен двумерный массив лабиринта и массив направлений. Ваша задача - следовать данным указаниям.
1. Массив лабиринта всегда будет квадратным, т.е. N x N, но его размер и содержимое будут меняться от теста к тесту.
2. В финальных тестах места старта и финиша будут меняться.
3. Массив направлений всегда будет в верхнем регистре и будет иметь формат N = север, E = восток, W = запад и S = юг.
4. Если вы достигли конечной точки до того, как все ваши ходы закончились, вы должны вернуть Finish.
* (проверка на финиш)
5. Если вы наткнулись на любую стену или вышли за границу лабиринта, вы должны вернуть Dead.
* (проверка на стену и границу матрицы)
6. Если вы все еще находитесь в лабиринте после использования всех ходов, вы должны вернуть Lost.
* (проверка на окончание массива директив и на финиш)
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class MazeRunner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("MazeRunner.txt"));
        int[][] a = readMatrix(scanner);
        String[] s = readDirection(scanner);
        mazeRunner(a, s);
        scanner.close();
    }
    static String mazeRunner(int[][] maze, String[] directions) {
//Найти точку старта
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < maze.length; i++) {
            boolean bool = false;
            for (int j = 0; j < maze[0].length; j++) {
//поиск входа в лабиринт
                if (maze[i][j] == 2) {
                    startX = i;
                    startY = j;
                    bool = true;
                    break;
                }
            }
            if (bool) break;
        }
//переменная для проверки не конечный ли это ход.
        //boolean end = false;
//сделать ход       
        String s = "";
        for (int i = 0; i < directions.length; i++) {
           // if (i == directions.length-1) end = true;//значит ход последний
            switch (directions[i]) {
                case "N" -> startX -= 1;
                case "S" -> startX += 1;
                case "W" -> startY -= 1;
                case "E" -> startY += 1;
            }
            s = checkFinish(maze, startX,startY);
            if(!Objects.equals(s, "")){
                return s;
            }
        }
        //return s;//заглушка
        return "Lost";
    }
//Проверка на Finish
    static String checkFinish(int[][] maze, int startX, int startY){
        String s = "";
        if (startX < 0 || startX >= maze.length || startY < 0 || startY >= maze.length ) return "Dead";
        //if (end && maze[startX][startY] == 0) return "Lost";
        if (maze[startX][startY] == 3) return "Finish";
        if (maze[startX][startY] == 1) return "Dead";
        return s;
    }

    static int[][] readMatrix(Scanner scanner) {
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        print(a);
        return a;
    }
    // Считать строку из файла с указанием направлений
    static String[] readDirection(Scanner scanner) {
        scanner.nextLine();
        scanner.nextLine();
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        return s;
    }
    static void print(int[][] a) {
        for (int[] b : a) {
            System.out.println(Arrays.toString(b));
        }
    }
}
