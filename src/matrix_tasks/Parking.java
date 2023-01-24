package matrix_tasks;

import java.util.Random;
import java.util.Scanner;

//Стоянка автомобилей представаляет собой прямоугольную площадь, разбитую на ряды и парковочные места в ряду. Для автоматизации
//процесса определения свободных мест, было решено представить парковочные места в памяти компьютера в виде двумерного массива.
//Если место свободно, то в соответствующей ячейке хранится 0, если место занято, то хранится номер автомашины(для простоты - целое число).
//Определить ближайшее свободное место в указанном ряду и сделать его занятым.
public class Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество рядов на парковке");
        int n = scanner.nextInt();
        System.out.println("Введите количество мест в ряду");
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        fillMatrix(a); // Заполняем парковку уже имеющимися машинами
        printMatrix(a);
        System.out.println("Укажите ряд, в котором нужно найти свободное место");
        int row = scanner.nextInt()-1;
        int emptySpace = emptySpace(a, row); //поиск свободного места
        if (emptySpace == -1) {
            System.out.println("Свободных мест нет");
        }
        else {
            System.out.println("Свободное место: " + (emptySpace+1));
        }
        System.out.println("После поиска свободного места");
        printMatrix(a);
    }
    static void printMatrix(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static int emptySpace(int[][] a, int row){
        int emptySpace = -1;
        // по указанной строчке, пока не найдем свободный столбец
        for (int col = 0; col < a[row].length; col++) {
                if (a[row][col] == 0){
                    a[row][col] = 5;
                    emptySpace = col;
                    break;
                }
            }
       return emptySpace;
    }
   static void fillMatrix(int[][] a){
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = random.nextInt(0,3);
            }
        }
    }


}
