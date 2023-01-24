package matrix_tasks;
//14.01.2023 крестики нолики

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TikTakToe {

    static void fillGame(char[][] game) {
        for (char[] chars : game) {
            Arrays.fill(chars, '.');
        }
    }

    static void move(char[][] game, char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите строку");
            int row = scanner.nextInt();

            System.out.println("Введите столбец");
            int col = scanner.nextInt();
            if (row>=0&&row<game.length&&col>=0&&col<game[0].length){
                if (game[row][col] == '.'){
                    game[row][col] = currentPlayer;
                    break;
                }
                else {
                    System.out.println("место занято, введите другое место");
                }
            }
            else {
                System.out.println("Данные не корректные");
            }
        }
    }


    static boolean checkWin(char[][] game, char currentPlayer) {
        for (int i = 0; i < game.length; i++) {
            if (game[i][0] == currentPlayer && game[i][1] == currentPlayer && game[i][2]==currentPlayer){
                return true;
            }
            if (game[0][i]==currentPlayer && game[1][i]==currentPlayer && game[2][i] == currentPlayer){
                return true;
            }
        }
        if (game[0][0]  == currentPlayer && game[1][1] == currentPlayer &&game[2][2] == currentPlayer) {
            return true;
        }
        if (game[0][2]  == currentPlayer && game[1][1] == currentPlayer &&game[2][0] == currentPlayer){
            return true;
        }

        return false;
    }

    static boolean checkDraw(char[][] game) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                if (game[i][j] == '.'){
                    return false;
                }
            }
        }
        return true;
    }

    static void printGame(char[][] game) {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[i].length; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random random = new Random();

        char[][] game = new char[3][3];
        fillGame(game);
        printGame(game);

        char currentPlayer = random.nextInt(2) == 0 ? 'X' : 'O';

        while (true) {
            System.out.println("Сейчас ходит " + currentPlayer);

            move(game, currentPlayer);
            printGame(game);
            if (checkWin(game, currentPlayer)) {
                System.out.println("Победил " + currentPlayer);
                break;
            } else if (checkDraw(game)) {
                System.out.println("Ничья");
                break;
            } else {
                currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
            }
        }
    }
}
