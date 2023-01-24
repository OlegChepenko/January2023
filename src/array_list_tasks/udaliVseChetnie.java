package array_list_tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//27.12.2022 Удалить все четные элементы

public class udaliVseChetnie {
        static ArrayList<Integer> fillArrayList (int n){
            ArrayList<Integer> list = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                list.add(i, random.nextInt(1, 100));
            }
            return list;
    }
    static void remoove (ArrayList<Integer> list ){

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)%2==0){
                list.remove(i);
                i--;
            }
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество элементов массива");
        int n= scanner.nextInt();
        ArrayList <Integer> list = fillArrayList(n);
        System.out.println(list);
        remoove(list);
        System.out.println(list);

    }
}
