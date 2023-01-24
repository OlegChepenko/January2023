package matrix_tasks;
//12.01.2023
import java.util.Random;
import java.util.Scanner;
// угадай ячейку таблицы
public class GuessAcellInAtable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задайте количество строк массива");
        int n = scanner.nextInt();
        System.out.println("Задайте количество столбцов массива");
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        fillMatrix(a);
        installCell(a, n, m);
        printMatrix(a);
        game(a, n, m);


    }
    //заполнение массива нулями
    static void fillMatrix(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = 0;
            }
        }
    }
    static void printMatrix(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
    //Рандомный выбор выигрышной ячейки
    static void installCell(int[][] a, int n, int m){
        Random random = new Random();
        int i = random.nextInt(0, n);
        int j = random.nextInt(0, m);
        a[i][j]=1;
    }

    static void game(int[][] a, int n, int m){

        Scanner scanner = new Scanner(System.in);
        boolean z = false;
        for (int i = 0; i<5; i++) {
            System.out.println("У вас осталось "+(5-i)+" попыток");
            System.out.println("Угадайте координаты точки. Введите номер строки:");
            int x = scanner.nextInt();
            System.out.println("Введите номер столбца");
            int y = scanner.nextInt();
            if (x<0||x>a.length-1||y<0||y>a[0].length-1){
                System.out.println("Выход за границу массива");
                i--;
            } else if (a[x][y] == 1){
                System.out.println("Вы угадали");
                z = true;
                break;
            } else if (a[x][y] == 2){
               System.out.println("Эту уже проверяли");
               i--;
           } else if (a[x][y] == 0){
              a[x][y]=2;
              System.out.println("Нет");
          }

        }
        if (z == false) {
            System.out.println("GAME OVER");
        }
    }
}
