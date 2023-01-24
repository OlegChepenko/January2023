package array_tasks;

public class CatsDogs {
    static int catchCats(char[] a, int x) {
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'D') {
                for (int j = i - x; (j <= i + x); j++) {
                    if(j < a.length && j>=0) {
                        if (a[j] == 'C') {
                            count++;
                            a[j] = 'c';
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[] a = {'D', 'C', 'D', 'D', 'C', 'D','C'};
        int x = 2;// на сколько шагов может бежать собака, чтобы поймать кота
        int count = catchCats(a, x);
        System.out.println(count);
    }
}
