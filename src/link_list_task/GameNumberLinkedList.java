package link_list_task;
// Игра. Два игрока выбирают по очереди из двух чисел. Числа - одно начало списка,
// второе конец списка. Выбрать наибольшее из них.
//вар.1 через LinkedList, вар.2 через ArrayList с удалением, вар.3 через массив без удаления.
import java.util.*;

public class GameNumberLinkedList {
    static void fillRandLinkedList(LinkedList<Integer> list, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int k  = random.nextInt(100);
            list.addLast(k);
        }
    }

    static void gameLinkedList(LinkedList<Integer> list){
        int p1 = 0;
        int p2 = 0;
        int i = 0;

        while (list.size() > 0) {
            int max;
            if (list.getLast() > list.getFirst()) {
                max = list.getLast();
                list.removeLast();
            }
            else {
                max = list.getFirst();
                list.removeFirst();
            }
            if (i % 2 == 0) {
                p1 += max;
            }
            else {
                p2 += max;
            }
            i++;
//            printLinkedList(list);
        }

        System.out.println(p1 + ":" + p2);
    }

    static void printLinkedList(LinkedList<Integer> list) {

        for(Integer p : list) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        long d = new Date().getTime();
        //Scanner scanner = new Scanner(System.in);
        //System.out.print("n = ");
        int n = 1000; //scanner.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        fillRandLinkedList(list, n);
        gameLinkedList(list);
        long e = new Date().getTime();
        System.out.println(e-d);
    }
}
