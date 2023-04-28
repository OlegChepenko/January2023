package matrix_tasks;
//26.01.2023
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//https://acmp.ru/index.asp?main=task&id_task=413
//Все постройки высечены из кубов льда и имеют на фотографии квадратную форму и не имеют общих фрагментов стен ненулевой длины
//оказалось, что стены разных построек параллельны границам фотографии
//необходимо узнать, сколько зданий находятся на базе
//Входные данные
//В первой строке входного файла INPUT.TXT записаны числа N и M (1 ≤ M, N ≤ 500) – размеры фотографии
// в пикселях по вертикали и по горизонтали.
// Следующие N строк содержат по M символов каждая: символ '.' соответствует пустому месту, '#' – элементу постройки.
public class MilitaryBase {
    public static void main(String[] args) throws FileNotFoundException {
        char[][] a = readMatrix();
        printMatrix(a);
        System.out.println("Количество зданий: " + countBuldignsInMillitaryBase(a));

    }
    static int countBuldignsInMillitaryBase(char[][] a){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == '#' && checkStartBase(a, i, j)){
                    count++;
                }
            }
        }
         return count;
    }
    static boolean checkStartBase(char[][] a, int str, int col){
        if (str != 0 && a[str-1][col] != '.' ){
            return false;
        }
        if (col != 0 && a[str][col-1] != '.'){
            return false;
        }
        return true;
    }
    static char[][] readMatrix() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("MilitaryBase.txt"));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        scanner.close();
        return a;
    }
    static void printMatrix(char[][]a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
