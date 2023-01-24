package array_tasks;
//16.12.2022 Расход чистого времени на эту задачу: 5 часов
//Напишите программу, которая находит самые большие верхние целые
//числа в массиве. Большое верхнее число – число, которое больше всех
//элементов справа.
public class BolshieChisla {
    static void findNumber(int[] a) {
        int var=Integer.MIN_VALUE;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length ; j++) {
                if (a[i] > a[j]) var = a[i];
                else var=a[j];
            }
            if (a[i] == var)
                System.out.print(a[i] + " ");
        }
        System.out.println(a[a.length-1]);
    }

    public static void main(String[] args) {
        int[] a = {14, 24, 3, 19, 15, 17};
        findNumber(a);
    }
}
