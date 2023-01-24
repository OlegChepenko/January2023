package array_tasks;
//17.12.2022 затраты времени: 2ч
import java.util.Arrays;

//Напишите программу, которая получает массив и количество вращений,
//которые она должна выполнить (одно вращение – сдвиг влево (первый
//элемент станет последним, второй - первым так далее)). Выведите
//итоговый массив.
public class VrashenieMassiva {
    static void vrashaiMassiv(int[] massiv, int n){
        for (int k = 0; k < n; k++) {
        int first = massiv[0];
        for (int i = 0; i < massiv.length-1; i++) {
            massiv[i]=massiv[i+1];
        }
            massiv[massiv.length-1]=first;
    }

    }
    public static void main(String[] args) {
        int[] a = {51,47,32,61,21};
        int n = 1;
        vrashaiMassiv(a, n);
        System.out.println(Arrays.toString(a));
    }

}
