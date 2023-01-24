package matrix_tasks;
//2023-01-10
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Students {
    static void fillMatrix(int[][] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = random.nextInt(2, 6);
            }
        }
    }

    static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static double[] averageMarks(int[][] a) {
        double[] marks = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = 0; j < a[i].length; j++) {
                sum += a[i][j];
            }
            marks[i] = (double)sum / a[i].length;
        }
        return marks;
    }

    static int countGoodStudents(int[][] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            boolean check = true;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] < 4) {
                    check = false;
                    break;
                }
            }
            if (check) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();

        System.out.print("m = ");
        int m = scanner.nextInt();

        int[][] a = new int[n][m];
        fillMatrix(a);
        printMatrix(a);

        double[] avg = averageMarks(a);
        System.out.println(Arrays.toString(avg));

        int count = countGoodStudents(a);
        System.out.println("Кол-во хор студентов = " + count);
    }
}
