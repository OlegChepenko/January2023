package matrix_tasks;
//2023-01-10
import java.util.Scanner;

public class Chess {

    static void fillMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1) {
                    matrix[i][j] = '#';
                } else {
                    matrix[i][j] = '.';
                }
            }
        }
    }

    static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void placeLadya(char[][] matrix, int row, int col) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = '*';
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = '*';
        }
        matrix[row][col] = 'X';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();

        char[][] matrix = new char[n][n];
        fillMatrix(matrix);
        printMatrix(matrix);

        System.out.print("Введите строку: ");
        int row = scanner.nextInt();
        System.out.print("Введите столбец: ");
        int col = scanner.nextInt();

        placeLadya(matrix, row, col);
        printMatrix(matrix);
    }
}
