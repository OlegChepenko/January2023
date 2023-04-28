package link_list_task;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
// Игра. Два игрока выбирают по очереди из двух чисел. Числа - одно начало списка, второе конец списка. Выбрать наибольшее из них.
// Сложить результат первого, результат второго, вывести на экран счет
//вар.1 через LinkedList, вар.2 через ArrayList с удалением, вар.3 через массив без удаления.
public class GameNumberArray {
    static void fillRandArrayList(int[] array, int count){
      Random random = new Random();
        for (int i = 0; i < count; i++) {
            array[i] = random.nextInt(100);
        }
    }
    static void print(int[] array, int first, int last){
        for (int i = first; i <= last; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }
    static int[] gameArray(int[] array){
        int p1 = 0;
        int p2 = 0;
        int max = 0;
        int start = 0;
        int first = array[start];
        int finish = array.length-1;
        int last = array[finish];
        int i = 0;
        while (start != finish){
            if (first > last){
                max = first;
                start++;
                first = array[start];
            }else {
                max = last;
                finish--;
                last= array[finish];
            }
            if (i%2 == 0){
                p1 += max;
            }else {
                p2 += max;
            }
            i++;
//            print(array, start, finish);
        }
        System.out.println(p1 + " : " + p2);
        return array;
    }
    public static void main(String[] args) {
        long d = new Date().getTime();
        int n = 1000;
        int[] array = new int[n];
        fillRandArrayList(array, n);
//        print(array, 0, array.length-1);
        gameArray(array);
        long e = new Date().getTime();
        System.out.println(e-d);
    }
}
