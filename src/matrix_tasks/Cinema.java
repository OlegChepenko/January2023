package matrix_tasks;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();

        System.out.print("m = ");
        int m = scanner.nextInt();

        int[][] a = new int[n][m];
        int action;

        do {
            System.out.println("1.Купить билет");
            System.out.println("2.Вывести схему зала");
            System.out.println("3.Посчитать кол-во проданных мест в заданном ряду");
            System.out.println("4.Посчитать кол-во полностью свободных рядов");
            System.out.println("5.Продать к рандомных мест");
            System.out.println("6.Освободить первый ряд");
            System.out.println("7.Найти ряды в которых есть к свободных мест рядом");
            System.out.println("8. Посчитать доход"); //билеты по 500р, центральные 700р
            System.out.println("0.Выход");

            action = scanner.nextInt();
            if (action == 1) {
                System.out.println("В каком ряду желаете билет?");
                int row = scanner.nextInt();
                System.out.println("место :");
                int place = scanner.nextInt();
                boolean check1 = buyTicket(a, row, place);
                if (check1) {
                    System.out.println("Ваш билет: ряд " + row + " место " + place);
                } else {
                    System.out.println("Место занято");
                }//сделал если нужен один билет. Доделать, если нужно больше билетов.
            } else if (action == 2) showFloorPlan(a);
            else if (action == 3) {
                System.out.println("Введите ряд, в котором нужно посчитать количество проданных билетов ");
                int row = scanner.nextInt();
                int count = countPlaceInRow(a, row);
                System.out.println("В ряду " + row + "количество проданных билетов = " + count);
            } else if (action == 4) {
                int count = freeRows(a);
                System.out.println("Количество пустых рядов = " + count);
            } else if (action == 5) {
                System.out.println("Введите количество мест, которые нужно продать рандомно: ");
                int k = scanner.nextInt();
                randomTickets(a, k);
                //int randomTickets = randomTickets(a, k);
                // System.out.println("Продано "+ randomTickets +"мест");
            } else if (action == 6) {
                clearFirstRow(a);
                showFloorPlan(a);
            } else if (action == 7) {
                System.out.println("Сколько свободных мест должно быть в ряду? ");
                int amount = scanner.nextInt();
                System.out.println("Ряды с указанным свободным количеством мест: " + findRowWithKfreePlaces(a, amount));
            } else if (action == 8) {
                System.out.println("Доход от продажи билетов: " + countIncome(a));
            }
        }
        while (action != 0);
    }

    //Купить билет (без проверки входных данных)
    static boolean buyTicket(int[][] a, int row, int place) {
        boolean check1 = false;

        if (a[row - 1][place - 1] == 0) {
            a[row - 1][place - 1] = 1;
            check1 = true;
        }
        return check1;
    }

    // Показать карту зала
    static void showFloorPlan(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Подсчет свободных мест в выбранном ряду
    static int countPlaceInRow(int[][] a, int row) {
        int count = 0;
        for (int j = 0; j < a[row - 1].length; j++) {
            if (a[row - 1][j] == 1) {
                count++;
            }
        }
        return count;
    }

    //подсчет полностью свободных рядов
    static int freeRows(int[][] a) {

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            boolean check = true;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    check = false;
                    break;
                }
            }
            if (check) count++;
        }
        return count;
    }

    //Продать к рандомных мест (без проверки входных данных)
    static void randomTickets(int[][] a, int k) {

        Random random = new Random(k);
        for (int i = 0; i < k; i++) {
            int n = random.nextInt(0, a.length);
            int m = random.nextInt(0, a[0].length);
            if (a[n][m] == 0) a[n][m] = 1;
            else i--;
        }
    }

    //освободить первый ряд, зрителей переместить в ближайшие ряды
    static void clearFirstRow(int[][] a) {
        for (int j = 0; j < a[0].length; j++) { //проверяем, какое место в первом ряду занято
            if (a[0][j] == 1) {
                boolean y = false;
                for (int i = 1; i < a.length; i++) {
                    if (y) break;
                    for (int k = 0; k < a[i].length; k++) {
                        if (a[i][k] == 0) {
                            a[i][k] = 1;
                            a[0][j] = 0;
                            y = true;
                            break;
                        }
                    }
                }
            }
        }
    }

    //Найти ряды с "к" свободными местами
    static ArrayList<Integer> findRowWithKfreePlaces(int[][] a, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    count++;
                    if (count == k) {
                        list.add(i + 1); //чтобы не высвечивать нулевой ряд, сделаем первый ряд, первым рядом, а не нулевым
                        break;
                    }
                }else count = 0;
            }
        }
        return list;
    }

    //8. Посчитать доход
    static int countIncome(int[][] a) {
        int thirdPartStr = (a.length / 3);
        int thirdPartCol = (a[0].length / 3);
        int cheapTickets = 0;
        int expensiveTickets = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    if (i < thirdPartStr || i >= thirdPartStr*2   &&  j < thirdPartCol || j >= thirdPartCol * 2) {
                        cheapTickets++;
                    }else {
                        expensiveTickets++;
                    }
                }
            }
        }
        System.out.println(cheapTickets + "Дешевых билетов");
        System.out.println(expensiveTickets + "Дорогих билетов");
        int summ = cheapTickets * 500 + expensiveTickets * 700;
        return summ;
    }
}
