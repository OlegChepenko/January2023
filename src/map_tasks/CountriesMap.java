package map_tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountriesMap {
    public static void main(String[] args) {
        HashMap<String, String> countries = new HashMap<>();
        countries.put("Россия", "Москва");
        countries.put("Франция", "Париж");
        countries.put("Турция", "Стамбул");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите страну");
        String country = scanner.next();

        if (countries.containsKey(country)) {
            System.out.println("Столица = " + countries.get(country));
        }
        else {
            System.out.println("Нет такой страны");
        }

        for(Map.Entry<String, String> entry : countries.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
