package demokratyaVopasnosti;

import java.sql.Array;
import java.util.Arrays;

public class Demokratya {
    static int minimumIzbirateley(int[] izb, int group) {
        Arrays.sort(izb);
        int minimum = 0;
        int minGroup = group / 2 + 1;// это мин. количество групп для победы
//делю весь массив на два, чтобы выяснить, сколько нужно избирателей, для победы внутри каждой группы
        for (int i = 0; i < minGroup; i++) {
            minimum = minimum + izb[i]/2+1;
        }
        return minimum;
    }
    public static void main(String[] args) {
        int group = 3;
        int[] izbirately = {5,7,5};
        int min = minimumIzbirateley(izbirately, group);
        System.out.println(min);
    }
}
