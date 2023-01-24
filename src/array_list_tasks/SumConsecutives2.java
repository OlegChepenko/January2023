package array_list_tasks;

import java.util.ArrayList;
import java.util.List;

public class SumConsecutives2 {
    static ArrayList<Integer> sumConsecutives(ArrayList<Integer> list){
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int carrent = list.get(i);
            int count = 0;
            while (i< list.size()&&list.get(i) == carrent){
                i++;
                count++;
            }
            i--;
            result.add(carrent*count);
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1,4,4,4,0,4,3,3,1));

        System.out.println(sumConsecutives(list));
    }
    }
