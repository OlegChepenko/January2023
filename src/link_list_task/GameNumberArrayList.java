package link_list_task;
// Игра. Два игрока выбирают по очереди из двух чисел. Числа - одно начало списка, второе конец списка. Выбрать наибольшее из них.
// Сложить результат первого, результат второго, вывести на экран счет
//вар.1 через LinkedList, вар.2 через ArrayList с удалением, вар.3 через массив без удаления.
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class GameNumberArrayList {

    static void fillRandArrayList(ArrayList<Integer> arrayList, int count){
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int k = random.nextInt(100);
            arrayList.add(k);
        }
    }

    static void gameArrayList(ArrayList<Integer> arrayList){
        int p1 = 0;
        int p2 = 0;
        int i = 0;


        while (arrayList.size() > 0) {
            int first = arrayList.get(0);
            int last = arrayList.get(arrayList.size()-1);
            int max;
            if (first > last) {
                max = first;
                arrayList.remove(0);
            }
            else {
                max = last;
                arrayList.remove(arrayList.size()-1);
            }
            if (i % 2 == 0) {
                p1 += max;
            }
            else {
                p2 += max;
            }
            i++;
 //           printArrayList(arrayList);
        }

        System.out.println(p1 + ":" + p2);

    }
    static void printArrayList(ArrayList<Integer> arrayList){
        for (Integer p : arrayList) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        long d = new Date().getTime();
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("n = ");
        int n = 1000; //scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        fillRandArrayList(arrayList, n);
        gameArrayList(arrayList);
        long e = new Date().getTime();
        System.out.println(e-d);


    }
}
