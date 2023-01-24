package array_list_tasks;
//23.12.2022 https://www.codewars.com/kata/55eeddff3f64c954c2000059
// You are given a list/array which contains only integers (positive and negative). Your job is to sum only the numbers that are the same and consecutive. The result should be one list.

import java.util.ArrayList;
import java.util.Scanner;

public class SumConsecutives {
    static void fillList(ArrayList<Integer> list, int n) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа");
        for (int i = 0; i < n; i++) {
            int k = scanner.nextInt();
            list.add(k);
        }
    }

    static ArrayList<Integer> sumConsecutives(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();

        //решение
        int count = 1;
        int current = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (current == list.get(i)) {
                count++;
            }else{
                result.add(count*current);
                current = list.get(i);
                count = 1;
            }
        }

        result.add(count*current);  // чтобы не пропустить последний

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("n = ");
        int n = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        fillList(list, n);

        System.out.println(list);
        System.out.println(sumConsecutives(list));
    }
}
