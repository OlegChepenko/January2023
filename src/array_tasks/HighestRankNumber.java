package array_tasks;
//11.12.2022 если несколько эл-тов встречаются одинаково часто то взять наибольший из них
//Посчитать кол-во уникальных эл-тов массива, те которые встречаются только 1 раз
import java.util.Random;
import java.util.Scanner;
public class HighestRankNumber {
    static void /*int[]*/ fillArray(int[] a) {
       // int[] array = new  int[]{3,3,3,2,2,4,4,4,4,5,5,1,1,18};
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(0, 10);
        }
        //return array;
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static int highestNumber(int[] a) {
        int maxCount = 0;
        int maxNumber = 0;

        for (int i = 0; i < a.length; i++) {
            int count = 1;

            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    count++;

                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxNumber = a[i];
            }
            else if (count==maxCount){
                if (a[i]>maxNumber) {
                    maxNumber=a[i];
                }
            }

        }
        return maxNumber;
    }
    //Проверка на уникальность + посчитать кол-во уникальных эл-тов массива, те которые встречаются только 1 раз
    static int checkUnikum(int[] array) {
        int unikum = 0;
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = array.length-1; j >= 0; j--) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count==1){
                unikum++;
            }
        }
        return unikum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите кол-во эл-тов");
        int n = scanner.nextInt();

        int[] a = new int[n];
        //int[]a = fillArray();
        fillArray(a);
        printArray(a);
        int res = highestNumber(a);
        System.out.println("если несколько эл-тов встречаются одинаково часто то взять наибольший из них = " + res);
        System.out.println("Количество уникальных элементов: "+checkUnikum(a));
    }
}
