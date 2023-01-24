package matrix_tasks;
//2023-01-10
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Minesweeper {

    static void fillMatrix(char[][] game) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                game[i][j] = '.';
            }
        }
    }

    static void placeBomb(char[][] game, int row, int col) {
        game[row][col] = '*';

        for (int i = row - 1; i < row + 2; i++) {
            for (int j = col - 1; j < col + 2; j++) {
                if(i >= 0 && j >= 0 && i < game.length && j < game[0].length){
                    if (game[i][j] == '.') {
                        game[i][j] = '1';
                    }
                    else if (game[i][j] != '*') {//если там не бомба, значит там цифра, и тогда мы ее увеличиваем на 1
                        game[i][j]++;
                    }
                }
            }
        }
    }

    static void printMatrix(char[][] game) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                System.out.print(game[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Minesweeper.txt"));

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int countBomb = scanner.nextInt();

        char[][] game = new char[n][m];
        fillMatrix(game);
        for (int i = 0; i < countBomb; i++) {
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            placeBomb(game, row, col);
        }
        scanner.close();

        printMatrix(game);
    }
}
