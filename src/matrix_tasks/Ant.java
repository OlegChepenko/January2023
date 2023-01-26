package matrix_tasks;
//Дана матрица. Размещаем муравья в рандомную ячейку.
// Муравей рандомно перемещается в одном из направлений (вверх, вниз, влево, вправо) на одну ячейку.
// Если он достиг края доски, то за доску шагать нельзя.
// Задача посчитать кол-во шагов сделанных муравьем, чтобы обойти всю доску.
// (при перемещении он оставляет след). Данный процесс симуляции нужно запустить 10 раз и найти среднее кол-во шагов

import java.util.Random;

public class Ant {
    public static void main(String[] args) {
        char[][] a = new char[5][5];
        fillMatrix(a);
        placeAnt(a);
        printMatrix(a);
        rout(a);
        printMatrix(a);
    }

    static void fillMatrix(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = '.';
            }
        }
    }

    static void placeAnt(char[][] a) {
        Random random = new Random();
        int m = random.nextInt(0, a.length);
        int n = random.nextInt(0, a[0].length);
        a[m][n] = 'X';
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

    static void rout(char[][] a) {
        Random random = new Random();
        boolean flag = true;
        while (flag) {
            int move = random.nextInt(0, 4);
            if (move == 0) {
                flag = up(a);
            }else if (move == 1){
                flag = down(a);
            }
        }
    }


    static boolean up(char[][] a) {
        System.out.println("up");
        for (int i = 1; i < a.length; i++) {//если Х стоит в строчке 0, то ходить некуда, значит начнем с 1.
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 'X'){
                    if (a[i - 1][j] == '.') {
                        a[i - 1][j] = '*';
                        return true; //если компилятор прошел в этот иф,
                        // значит шаг сделан, выход из цикла с положительным результатом
                    }
                }
            }
        }
        return false;// если компилятор добрался сюда, значит либо Х не найден (он в нулевой строке), либо нельзя ходить за край
        //либо уже тут ходили.
    }

    static boolean down(char[][] a) {
        System.out.println("down");
        for (int i = 0; i < a.length-1; i++) { // обход до предпоследней строки, чтобы было куда ходить.
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 'X'){
                    if (a[i + 1][j] == '.') {
                        a[i + 1][j] = '*';
                        return true;//если компилятор прошел в этот иф,
                        // значит шаг сделан, выход из цикла с положительным результатом
                    }
                }

            }
        }
        return false;// если компилятор добрался сюда, значит либо Х не найден (он в нулевой строке), либо нельзя ходить за край
        //либо уже тут ходили.
    }

    static boolean right(char[][] a) {
        System.out.println("right");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length-1; j++) {
                if ( a[i][j] == 'X'){
                    if (a[i][j+1] == '.') {
                        a[i][j+1] = '*';
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean left(char[][] a) {
        System.out.println("left");
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a[i].length; j++) {
                if (j>0 && a[i][j] == 'X'){
                    if (a[i][j-1] == '.') {
                        a[i][j-1] = '*';
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
