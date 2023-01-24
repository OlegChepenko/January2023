package array_tasks;

//bubbleSort - сортировка пузырьком
//selectSort - сортировка выбором
//
import java.util.Scanner;

public class SortArray {
    static void fillArray(int[] a) {
        //Random random = new Random();
        //for (int i = 0; i < a.length; i++) {
          //  a[i] = random.nextInt(0, 100);
       // }

    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
//Пузырек
    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            boolean change = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    change = true;
                }
            }
            if (change==false) {
                break;
            }
        }
    }

//Сортировка выбором
    static void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            int imin = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    imin = j;
                }
            }
            a[imin] = a[i];
            a[i] = min;
        }
    }
//Сортировка вставкой
    static void insertSort(int[] a){
        for (int i = 0; i < a.length; i++) {
            int key = a[i];// Вытаскиваем значение элемента
            int j = i - 1;// Перемещаемся по элементам, которые перед вытащенным элементом
            for (; j >= 0; j--) {
                if (key < a[j]) { // Если вытащили значение меньшее — передвигаем больший элемент дальше
                    a[j + 1] = a[j];
                } else {
                    break;// Если вытащенный элемент больше — останавливаемся
                }
            }
            a[j + 1] = key;// В освободившееся место вставляем вытащенное значение
        }
    }
    static void insertSort2(int[] a){
            int j;
            for (int i = 1; i < a.length; i++) {//сортировку начинаем со второго элемента, т.к. считается, что первый элемент уже отсортирован
                int key =  a [i];//сохраняем ссылку на индекс предыдущего элемента
                for (j = i; j > 0 && key < a[j - 1]; j--) {
                    a[j] = a[j - 1]; //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                }
                a [j] = key;
        }
    }
//https://youtu.be/jywoZ2XaQoM; https://github.com/Arhiser/java_tutorials/blob/master/src/ru/arhiser/sort/insertion/InsertionSort.java
    static void insertSort4(int[] a){
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i;
            while (j > 0 && a[j - 1] > key) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = key;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите кол-во эл-тов");
        int n = scanner.nextInt();

        //int[] a = new int[n];
        int[] a = {90,50,100,70,200};
        fillArray(a);
        printArray(a);

        System.out.println("1.Пузырьковая 2.Выбором 3.Вставками");
        int sortMode = scanner.nextInt();

        long start = System.currentTimeMillis();

        if (sortMode == 1) {
            bubbleSort(a);
        }
        else if (sortMode == 2) {
            selectSort(a);
        }
        else if (sortMode == 3){
            insertSort4(a);
        }

        long finish = System.currentTimeMillis();
        long time = finish - start;
        System.out.println(time);

        printArray(a);

     }
}
