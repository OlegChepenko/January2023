package array_tasks;
//22.12.2022 поиск простых чисел
//https://youtu.be/snRFphzl-bU
import java.util.Arrays;
import java.util.Scanner;

public class Resheto {
    static void resheto(int [] a){
        for (int i = 2; i < a.length ; i++) {
            if (a[i] != 0) {
                for (int j = 2*i; j < a.length; j+=i) {
                    a[j] = 0;
                }
            }
        }
        System.out.println("Решето готово: "+Arrays.toString(a));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов");
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length ; i++) {
            a[i] = i;
        }
        System.out.println("Изначальный массив: "+Arrays.toString(a));
        resheto(a);
    }
}
