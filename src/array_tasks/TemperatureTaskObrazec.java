package array_tasks;

import java.util.Random;
import java.util.Scanner;

public class TemperatureTaskObrazec {
//Создать массив. Метод создан Евгением.
    static void fillArray(int[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10, 40);
        }
    }
// Распечатать массив. Метод создан Евгением.
    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
//Средняя температура. Метод создан Евгением.
    static double average(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return (double) sum / a.length;
    }
//Найти максимальный элемент. Метод создан Евгением.
    static int findMax(int[] a) {
        int max = a[0];
        for(int k : a) {
            if (k > max) {
                max = k;
            }
        }
        return max;
    }
// Количество максимальных элементов. Метод создан Евгением
    static int findCountMax(int[]a){
        int max = findMax(a);
        int count = 0;
        for (int j : a) {
            if (j == max) {
                count++;
            }
        }
        return count;
    }
 //Найти максимальный элемент и посчитать количество максимальных элементов (температур) за один проход
 //метод создан на уроке, при поддержке Евгения
    static int findMaxPro(int[] a){
        int max = a[0];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max){
                max=a[i];
                count=0;
            }
            if (a[i]==max){
                count++;
            }
        }
        return count;
    }

//Локальная средняя температура. Метод создан Евгением.
    static int countLocalMax(int[] a) {
        int count = 0;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] > a[i-1] && a[i] > a[i+1]) {
                count++;
            }
        }
        return count;
    }
//найти минимальную тем-ру в заданную неделю
    static int minAtWeek(int[] a, int week){
// если массив короче начала требуемой недели, то возвращаем флаг, указывающий на ошибку.
        if (a.length<(week*7-8)){
            return Integer.MIN_VALUE;
        }
        int endOfWeek = week*7;  //Поиск конца недели
        int startOfWeek = week*7-7;//Поиск начала недели
        int min = a[startOfWeek];  //Принимаю за минимум первый элемент
//Если массив длиннее, чем конец требуемой недели, то идем до конца требуемой недели.
        int endOfMassiv = endOfWeek;
//если конец массива короче конца нужной недели, то идем до конца массива.
        if (a.length<endOfWeek){
            endOfMassiv=a.length;
        }
// поиск минимальной температуры в заданную неделю
        for (int i = startOfWeek; i < endOfMassiv; i++) {
            if (min>a[i]) min=a[i];
        }
        return min;
   }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Введите кол-во эл-тов");
        //int n = scanner.nextInt();

        //int[] a = new int[];
        //fillArray(a);
        //printArray(a);
        int[] a = {1,2,2,3,3,3,10,17,17,5};
        int week = 2;

        double avg = average(a);
        System.out.println("Средняя тем-ра = " + avg);

        int max = findMax(a);
        System.out.println("Макс тем-ра = " + max);

        int count = countLocalMax(a);
        System.out.println("Кол-во лок макс темп = " + count);
        int countPro = findMaxPro(a);
        System.out.println(" Кол-во макс элементов за один проход "+countPro);
        int min=minAtWeek(a, week);
        if (min==Integer.MIN_VALUE) {
            System.out.println("В массиве нет такой недели");
        }
        else {
            System.out.println("Минимальная температура в " + week + " неделю " + min + " градусов");
        }
    }
}
