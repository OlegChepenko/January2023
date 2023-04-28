package map_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.codewars.com/kata/5571f712ddf00b54420000ee/train/java
//создать функцию, которая принимает сумму в валюте США в центах и возвращает словарь/хэш,
// который показывает наименьшее количество монет, использованных для создания этой суммы.
// В этом упражнении учитываются только номиналы монет:
// Pennies (1¢), Nickels (5¢), Dimes (10¢) and Quarters (25¢),
// Поэтому возвращаемый словарь должен содержать ровно 4 пары ключ/значение.
//Примечания:
//Если функции передано либо 0, либо отрицательное число, функция должна вернуть словарь со всеми значениями, равными 0.
//Если в функцию передается число с плавающей запятой, его значение должно быть округлено в меньшую сторону,
// а результирующий словарь никогда не должен содержать доли монеты.
public class LooseChange {
    static HashMap<String, Integer> looseChange(int cent){
        HashMap<String, Integer> map = new HashMap<>();
        if (cent <= 0) return map;
        int quarters = cent/25;
        cent = cent%25;
        int dimes = cent/10;
        cent = cent%10;
        int nickels = cent/5;
        cent = cent%5;
        int pennies = cent;
        map.put("Pennies", pennies);
        map.put("Nickels", nickels);
        map.put("Dimes", dimes);
        map.put("Quarters", quarters);
        return map;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число");
        int cent = scanner.nextInt();
    //Почему печатает не по порядку? Пенни печатает первым, а затем задом наперед, а не по очереди
    HashMap<String, Integer> map = looseChange(cent);
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " ---> " + value);
        }

    }
}
