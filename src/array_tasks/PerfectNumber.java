package array_tasks;
//дано n, вывести все совершенные числа от 1 до n
import java.util.Scanner;

public class PerfectNumber {
    //Проверка, что число является совершенным
    static boolean findPerfectNumber(int number){
        int sum = 1;
        for (int i = 2; i <= number/2; i++) {
            if (number%i==0){
                sum += i;
            }
        }
        if (sum==number) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число n");
        int n = scanner.nextInt();
        for (int i = 6; i <= n; i++) {
            if (findPerfectNumber(i)){
                System.out.println(i);
            }
        }
    }
}
/*
 int p=1;
        int perfectNumber = 0;
        while (perfectNumber<n){
            perfectNumber = (int) (Math.pow(2, p-1)*(Math.pow(2, p)-1));
            p++;
            if (perfectNumber>n) break;
            System.out.println(perfectNumber);
        }
 */
