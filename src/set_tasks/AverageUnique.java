package set_tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AverageUnique {
//    static double findAverage(ArrayList<Integer> list) {
//        HashSet<Integer> set = new HashSet<>();
//
//        int sum = 0;
//        int count = 0;
//        for (int i = 0; i < list.size(); i++) {
//            if (!set.contains(list.get(i))) {
//                set.add(list.get(i));
//                sum += list.get(i);
//                count++;
//            }
//        }
//        return (double) sum / count;
//    }

    static double findAverage(ArrayList<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        int sum = 0;
        for(int k : set) {
            sum += k;
        }
        return (double) sum/set.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(2, 3, 5, 3, 7, 2, 3));
        double avg = findAverage(list);
        System.out.println(avg);


    }
}
