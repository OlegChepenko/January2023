package array_tasks;

public class ObshieElementi {
    //Напишите программу, которая печатает общие элементы в двух массивах.
//Вы должны сравнить элементы второго массива с элементами первого.

        static void findElements(int[]a, int[]b){
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (a[i]==b[j]){
                        System.out.print(a[i]);
                    }
                }
            }
        }
        public static void main(String[] args) {
            int[] a = {1,2,3,4,5};
            int[] b = {3,4,5,6,7};
            findElements(a,b);

        }
}
