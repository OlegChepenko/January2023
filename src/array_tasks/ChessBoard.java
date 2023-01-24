package array_tasks;
import java.util.Scanner;

public class ChessBoard {


            static void razmerDoski(int n){
            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    for (int i = 0; i < n; i++) {
                        if (i % 2 != 0) System.out.print("#");
                        else System.out.print(".");
                    }
                }
                else {
                    for (int i = 0; i < n; i++) {
                        if (i % 2 == 0) System.out.print("#");
                        else System.out.print(".");
                    }
                }
                System.out.println();
            }
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите размер шахматной доски");
            int n = scanner.nextInt();
            razmerDoski(n);
        }
}
