package array_list_tasks;
//28,12,2022

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//В первой строке программе будет предоставлен список вагонов (целых
//чисел). Каждое целое число представляет количество пассажиров,
//которые в настоящее время находятся в каждом вагоне. 32 54 21 12 4 0 23
//В следующей строке программе будет предоставлена максимальная
//вместимость каждого вагона (одно целое число). 75  Пока вы не получите
//«End», программа может ожидать два типа ввода:
//− Add {пассажиров} - добавить вагон в конец с указанным
//количеством пассажиров.Add 10  Add 0
//− {пассажиры} - найти существующий вагон, подходящий для
//добавления всех пассажиров (начиная с первого вагона) 30.10.75
//В конце программа выводит окончательное состояние поезда (все вагоны
//разделены пробелом)
public class Poezd {
    static void fillWagons(ArrayList<Integer> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько будет вагонов?");
        int w = scanner.nextInt();
        System.out.println("Введите число пассажиров, размещенных группами в каждом вагоне отдельно");
        for (int i = 0; i < w; i++) {
            int n = scanner.nextInt();
            list.add(n);
        }
    }
    static void pass(ArrayList<Integer> wagons, int vmestimost, int passangers) {
        System.out.println("вагонов до добавления" + wagons);
        for (int j = 0; j < wagons.size(); j++) {
            int capacity = vmestimost - wagons.get(j);
            if (capacity>=passangers){
                wagons.set(j, passangers+ wagons.get(j));
                break;
            }
        }
        System.out.println("после добавления: " + wagons);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите вместимость вагона");
        int vmestimostWagons = scanner.nextInt();
        ArrayList<Integer> wagons = new ArrayList<>(/*List.of(32,54,21,12,4,0,23)*/);
        fillWagons(wagons);
        while (true){
            System.out.println("Введите команду");
            String comand = scanner.next();
            if ( comand.equalsIgnoreCase("end")){
                System.out.println("Конец");
                break;
            }
            else if (comand.equalsIgnoreCase("add")){
                System.out.println("Введите число пассажиров в вагоне");
                int number = scanner.nextInt();
                wagons.add(number);
            }
            else {
                int passengers = Integer.parseInt(comand);
                pass(wagons, vmestimostWagons, passengers);
            }
            System.out.println(wagons);
        }
    }
}
