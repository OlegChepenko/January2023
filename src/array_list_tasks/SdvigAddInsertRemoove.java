package array_list_tasks;

import java.util.ArrayList;
import java.util.Scanner;

//29.12.2022
//В первой строке программе будет предоставлен список вагонов (целых
//чисел). Каждое целое число представляет количество пассажиров,
//которые в настоящее время находятся в каждом вагоне.
//В следующей строке программе будет предоставлена максимальная
//вместимость каждого вагона (одно целое число). Пока вы не получите
//«End», программа может ожидать два типа ввода:
//− Add {пассажиров} - добавить вагон в конец с указанным
//количеством пассажиров.
//− {пассажиры} - найти существующий вагон, подходящий для
//добавления всех пассажиров (начиная с первого вагона)
//В конце программа выводит окончательное состояние поезда (все вагоны
//разделены пробелом)
//System.out.println("Введите команду: ");
//        System.out.println("Add {число} - добавить элемент в конец");
//        System.out.println("Insert {число} {индекс} - вставить элемент по указанному индексу");
//        System.out.println("Remove {index} – удалить элемент по индексу");
//        System.out.println("Shift left {count} – сдвиг влево всех элементов (количество раз)");
//        System.out.println("Shift right {count} – сдвиг вправо всех элементов (количество раз)");

public class SdvigAddInsertRemoove {
    static void fillWagons(ArrayList<Integer> wagons) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов в списке: ");
        int amount = scanner.nextInt();
        System.out.println("Введите элементы в список ");
        for (int i = 0; i < amount; i++) {
            int n = scanner.nextInt();
            wagons.add(n);
        }
    }
    static void printComands() {
        System.out.println("Введите команду: ");
        System.out.println("Add - добавить элемент в конец");
        System.out.println("Insert - вставить элемент по указанному номеру");
        System.out.println("Remove – удалить элемент по номеру");
        System.out.println("Shift left – сдвиг влево всех элементов (количество раз)");
        System.out.println("Shift right – сдвиг вправо всех элементов (количество раз)");
    }
    static void  shiftLeft(ArrayList<Integer>elements, int n){
        int i = 0;
       while (i<n){
           elements.add(elements.get(0));
           elements.remove(0);
            i++;
        }
    }
    static void shiftRight(ArrayList<Integer>elements,int n){
        while (n>0){
            elements.add(0, elements.get(elements.size()-1));
            elements.remove(elements.size()-1);
           n--;
            System.out.println(elements);
        }
    }
    static void insert(ArrayList<Integer>wagons,int index, int n){
// всего одна строчка. см. в мэйне
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> elements = new ArrayList<>();
        fillWagons(elements);
        System.out.println(elements);
        printComands();
        while (true) {
            String comand = scanner.next();
            if (comand.equalsIgnoreCase("End")) break;
            else if (comand.equalsIgnoreCase("add")) {
                System.out.println("Введите элементы, которые хотите добавить в список:");
                int c = scanner.nextInt();
                elements.add(c);
                System.out.println(elements);
                printComands();
            }else if (comand.equalsIgnoreCase("Add")) {
                System.out.println("Введите элемент");
                int c = scanner.nextInt();
                elements.add(c);
                System.out.println(elements);
                printComands();
            }else if (comand.equalsIgnoreCase("Insert")) {
                System.out.println("Введите элемент");
                int c = scanner.nextInt();
                System.out.println("Введите номер, под которым элемент должен стоять в списке");
                int n = scanner.nextInt();
                    if (n >= elements.size()) {
                        System.out.println("Invalid index");
                        break;
                    }
                elements.add(n+1,c);
                System.out.println(elements);
                printComands();
            } else if (comand.equalsIgnoreCase("Remove")) {
                System.out.println("Введите номер элемента, который нужно удалить:");
                int n = scanner.nextInt();
                    if (n >= elements.size()) {
                        System.out.println("Invalid index");
                        break;
                    }
                elements.remove(n+1);
                System.out.println(elements);
                System.out.println("Введите команду: ");
                printComands();
            }else if (comand.equalsIgnoreCase("shiftLeft")){ // Почему не видит команду через пробел?
                System.out.println("Введите, на сколько элементов сдвинуть влево?");
                int n = scanner.nextInt();
                shiftLeft(elements, n);
                System.out.println(elements);
                System.out.println("Введите команду: ");
                printComands();
            }
            else if (comand.equalsIgnoreCase("shiftRight")){// Почему не видит команду через пробел?
                System.out.println("Введите, на сколько элементов сдвинуть вправо?");
                int n = scanner.nextInt();
                shiftRight(elements, n);
                System.out.println(elements);
                System.out.println("Введите команду: ");
                printComands();
            }
        }
    }
}
