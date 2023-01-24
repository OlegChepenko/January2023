package matrix_tasks;
//https://acmp.ru/index.asp?main=task&id_task=58
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class prettyМatrix {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк в таблице");
        int n = scanner.nextInt();
        System.out.println("Введите количество столбцов в таблице");
        int m = scanner.nextInt();
        System.out.println("Введите симпатичность");
        int s = scanner.nextInt();
        // Пытаюсь считать данные из файла, не завершено!
       /* Scanner scanner = new Scanner(new File("PrettyMatrix.txt"));
        int tables = scanner.nextInt();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < tables; i++) {*/
            int[][] a = new int[n][m];
            fillMatrix(a);
            printMatrix(a);
            //boolean x = check(a);
        boolean x = check2(a, s);
            if (x) System.out.println("YES");
            else System.out.println("NO");
        //}


    }
    //принимает из метода check2 матрицу, координату числа которое нужно сравнивать с окружением, и число симпатичности.
    static boolean check3(int[][] a, int x, int y, int s){
        int sum = 0;
        for (int i = x; i < x+s; i++) { //ограничиваю область проверки, длинною строки от координаты х до конца симпатичности
            for (int j = y; j < y+s; j++) {//ограничиваю область проверки, длинною строки от координаты y до конца симпатичности
                sum += a[i][j];//суммирую все, что там есть
            }
        }
        if(sum == 0 || sum == (s*s)){//т.к. в ячейках либо нули либо единицы, то сумма одинаковых цифр может быть либо ноль либо s*s
            return true;//если ответ сошелся, то матрица не симпотичная возврат тру.
        }
        return false;// если ответ не сошелся, возврат фальшь и можно принимать сюда следующее число для проверки.
    }
    //Берет число, берет число симпотичности, передает это все в метод check3 на проверку
    static boolean check2(int[][] a, int s){

        for (int i = 0; i < a.length-s+1; i++) {
            for (int j = 0; j < a[i].length-s+1; j++) {
                if (check3(a, i, j, s)) return false;
            }
        }
        return true;
    }
    static boolean check(int[][]a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a[i].length-1; j++) {
                if (a[i][j]==a[i][j+1]&&a[i+1][j]==a[i][j+1]&&a[i+1][j+1]==a[i][j+1]){
                    return false;
                }
            }
        }
        return true;
    }
    static void fillMatrix(int[][] a){
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = random.nextInt(0,2);
            }
        }
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
}
