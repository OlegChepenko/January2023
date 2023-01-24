package array_tasks;
//17.12.2022
//Затречено времени грязное: 2 дня обдумывания, чистое - не засекал.
//Напишите программу, которая печатает все уникальные пары в массиве
//целых чисел, сумма которых равна заданному числу.
public class MagicSumm {
    static void magicSumm(int[] massiv, int summ) {
        for (int i = 0; i < massiv.length - 1; i++) {
            for (int j = i + 1; j < massiv.length; j++) {
                if (massiv[i] + massiv[j] == summ) {
                    System.out.println(" " + massiv[i] + " " + massiv[j]);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] massiv = {1, 7, 6, 2, 19, 23, 4, 4};
        int summ = 8;
        magicSumm(massiv, summ);
    }
}
