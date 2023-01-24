package array_tasks;
//08.12.2022 https://www.codewars.com/kata/5f6d533e1475f30001e47514/solutions/csharp
//You are given a list of unique integers arr,
// and two integers a and b.
// Your task is to find out whether or not a and b appear consecutively(последовательно) in arr,
// and return a boolean value (True if a and b are consecutive, False otherwise).
//It is guaranteed that a and b are both present in arr.
public class ConsecutiveItems {
    //какой по счету элемент, переменная а и b? Выясняет, подряд или не подряд элементы идут?
    static boolean elementMassiva(int a, int b, int[] massiv) {
        int varA = 0;
        int varB = 0;
        for (int i = 0; i < massiv.length; i++) {
            if (a == massiv[i]) {
                varA = i;
            } else if (b == massiv[i]) {
                varB = i;
            }
        }
        if (varB - varA == 1 || varA - varB == 1) return true;
        return false;
    }
    public static void main(String[] args) {
        int[] intArray = new int[]{1, 5, 9, 8, 9, 10, 24, 15};
        int a = 5;
        int b = 8;
        System.out.println(elementMassiva(a, b, intArray));
    }
}
