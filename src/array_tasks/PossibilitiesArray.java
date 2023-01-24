package array_tasks;
//23.12.2022 A non-empty array a of length n is called an array of all possibilities if it contains all numbers between [0,a.length-1].Write a method named isAllPossibilities that accepts an integer array and returns true if the array is an array of all possibilities, else false.
//Непустой массив a длины n называется массивом всех возможностей, если он содержит все числа между [0,a.length-1]. Напишите метод с именем isAllPossibilities, который принимает целочисленный массив и возвращает true, если массив представляет собой массив всех возможностей, иначе false.

public class PossibilitiesArray {
    static boolean isAllPossibilities(int[] a) {
// Your code here...
// сортирую массив вставкой
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j=i;
            while (j>0&&a[j-1]>key){
                a[j] = a[j-1];
                j--;
            }
            a[j] = key;
        }
//Сверяю, все ли элементы есть и те ли это элементы
        int x = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] !=i) return false;
        }
        /*    if (a[i] == i) x++;
        }
        if (x==a.length) return true;
        else

         */
            return true;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 0, 3};
        boolean flag = isAllPossibilities(a);
        System.out.println(flag);
    }
}
