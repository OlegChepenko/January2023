package array_tasks;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sherenga {
    //разворачивает массив задом на перед
    static void reverseArray(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
    }
    // Распечатывает элементы
    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    //Заполнение массива в ручную
    static void fillHandArray(int[] a) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
    }
    //Заполнение массива рандомно
    static void fillRandArray(int[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(150, 190);
        }

        Arrays.sort(a);
        reverseArray(a);
    }

    static boolean checkDown(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i+1]) {
                return false;
            }
        }
        return true;
    }

    static int findPlace(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < x) {
                return i;
            }
        }
        return a.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите кол-во эл-тов");
        int n = scanner.nextInt();

        int[] a = new int[n];

        System.out.println("Как заполнить? 1.Вручную 2.Рандомно");
        int sortMode = scanner.nextInt();
        if (sortMode == 1) {
            fillHandArray(a);
        }
        else {
            fillRandArray(a);
        }

        if (checkDown(a)) {
            printArray(a);

            System.out.println("Введите рост пети");
            int x = scanner.nextInt();

            int place = findPlace(a, x);
            System.out.println("Место пети = " + (place + 1));
        }
        else {
            System.out.println("Массив заполнен некорректно");
            System.exit(1);
        }
    }
}
