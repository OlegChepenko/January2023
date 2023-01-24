//2022-12-09
package KamenNoznicyBumaga;

import java.util.Random;
import java.util.Scanner;

public class KamenNoznicyBumaga {

    //метод вычисляет победителя в раунде
    static int victory(int manNumber, int computerNumber) {
        switch (manNumber) {
            case 1 -> System.out.println("Вы: Камень");
            case 2 -> System.out.println("Вы: Ножницы");
            case 3 -> System.out.println("Вы: Бумага");
        }
        switch (computerNumber) {
            case 1 -> System.out.println("Компьютер: Камень");
            case 2 -> System.out.println("Компьютер: Ножницы");
            case 3 -> System.out.println("Компьютер: Бумага");
        }
        if (manNumber == computerNumber) {
            return 0;
        } else if (manNumber == 1 && computerNumber == 3 || manNumber == 2 && computerNumber == 1 ||
                manNumber == 3 && computerNumber == 2) {
            return 1;
        }
        return -1;
    }
    //метод вычисляет победителя в игре
    static void win(int result) {
        if (result == 0) System.out.println("Итог игры: Ничья!");
        else if (result < 0) System.out.println("Итог игры: Поздравляю! Вы победили!");
        else {
            System.out.println("Итог игры: Победил компьютер");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Введите количество партий");
        int count = scanner.nextInt();
        int computer = 0;
        int man = 0;
        int result = 0;
        int win = 0;
        for (int i = 0; i < count; i++) {
            System.out.println("Введите ваш вариант: 1:Камень, 2:Ножницы, 3Бумага");
            int manСhoice = scanner.nextInt();
            int computerСhoice = random.nextInt(1, 4);
            result = victory(manСhoice, computerСhoice);
            win += result;
            switch (result) {
                case 1 -> {
                    computer++;
                    System.out.println("Счет: " + man + " : " +computer);
                    break;
                }
                case -1 -> {
                    man++;
                    System.out.println("Счет: " + man + " : " +computer);
                    break;
                }
                case 0 -> {
                    System.out.println("Счет: " + man + " : " + computer);
                }
            }
        }
            win(win);
    }
}
