package array_list_tasks;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Countries {
    static void showList(ArrayList<String> countries) {
        for (int i = 0; i < countries.size(); i++) {
            System.out.println(i + 1 + "." + countries.get(i));
        }

//        for (String country : countries) {
//            System.out.println(country);
//        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] a = {"Россия"};

        ArrayList<String> list = new ArrayList<>(List.of(a));
        int action;

        do {
            System.out.println("1.Добавить страну");
            System.out.println("2.Вывести страны");
            System.out.println("3.Удалить страну по номеру");
            System.out.println("4.Удалить страну по названию");
            System.out.println("5.Вставка");

            action = scanner.nextInt();

            if (action == 1) {
                System.out.println("Введите название страны");
                String country = scanner.next();

                if (!list.contains(country)) {
                    list.add(country);
                }
                else {
                    System.out.println("Уже добавили");
                }
            }
            else if (action == 2) {
                showList(list);
            }
            else if (action == 3) {
                System.out.println("Введите номер");
                int index = scanner.nextInt();

                list.remove(index);
            }
            else if (action == 4) {
                System.out.println("Введите название страны");
                String country = scanner.next();

                list.remove(country);
            }
            else if (action == 5) {
                System.out.println("Введите название страны");
                String country = scanner.next();

                System.out.println("Введите номер");
                int index = scanner.nextInt();

                list.add(index, country);
            }
        }
        while (action != 0);
    }
}
