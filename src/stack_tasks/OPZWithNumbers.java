package stack_tasks;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class OPZWithNumbers {
    static boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    static boolean isNextDigit(String s, int i) {
        if ((i + 1) >= s.length()) return false;
        if (Character.isDigit(s.charAt(i + 1))) return true;
        return false;
    }

    static void fillMapOperators(HashMap<Character, Integer> map) {
        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('^', 3);
    }

    static Double operation(Double n1, Double n2, Character c) {
        Double result = 0.0;
        if (c.equals('+')) result = n2 + n1;
        if (c.equals('-')) result = n2 - n1;
        if (c.equals('*')) result = n2 * n1;
        if (c.equals('/')) result = n2 / n1;
        if (c.equals('^')) result = Math.pow(n2, n1);
        return result;
    }

    static void fillMapVar(Character c, HashMap<Character, String> mapVar) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите значение переменной " + c);
            String s1 = scanner.nextLine();
            if (isDigit(s1)) {
                mapVar.put(c, s1);
                break;
            }
        }
    }

    static void ifOperator(Character cNew, HashMap<Character, Integer> mapOperators, Stack<Character> stackPriority, StringBuilder s) {
        if (stackPriority.isEmpty()) {//если стек пустой, заносим оператор в стек
            stackPriority.push(cNew);
        } else {
            int valueNew = mapOperators.get(cNew);//получил значение приоритета обрабатываемого оператора
            while (true) {
                if (stackPriority.isEmpty()) {
                    stackPriority.push(cNew);//добавляем оператор в стек.
                    break;
                }
                Character cOld = stackPriority.peek();//вынул из стека верхний оператор, который там лежит
                int valueOld = mapOperators.get(cOld);//получил значение уже имеющегося оператора
                if (valueNew <= valueOld) {//если приоритет обрабатываемого оператора меньше или равен,
                    // чем приоритет доступного (верхнего) в стеке оператора,
                    s.append(stackPriority.pop() + " ");// то оператор извлекается из стека и записывается в строку результата.
                    // И добавляю пробел, чтобы считывать в дальнейшем отделяя числа от оператора.
                } else {
                    stackPriority.push(cNew);//добавляем оператор в стек.
                    break;
                }
            }
        }
    }

    //3.3 Если очередной символ из исходной строки закрывающая скобка – из стека последовательно извлекаются операции
//и записываются в строку результата.
//Процесс продолжается до первого встретившегося символа «открывающая скобка»,
//которая НЕ заносится в результирующую строку.
    static void ifClosingBracket(Stack<Character> stackPriority, StringBuilder s) {
        while (!stackPriority.isEmpty()) {
            Character c = stackPriority.peek();
            if (c == '(') {
                stackPriority.pop();//когда встретили открывающую скобку, удалил ее и прервал цикл
                break;
            }
            stackPriority.pop();
            s.append(c + " ");
        }

    }
    //(F+254)-2
    static void calculation(String s, HashMap<Character, Integer> mapOperators, HashMap<Character, String> mapVar) {
        Stack<Double> stack = new Stack<>();
        Double result = null;
        String[] elements = s.split(" ");
        for (int i = 0; i < elements.length; i++) {
            String string = elements[i];
            Character c = string.charAt(0);//беру первый символ строки, кот. может быть чем угодно, для проверки
            if (Character.isDigit(c)) {//если символ цифра, значит вся строка точно число
                stack.push(Double.parseDouble(string));
            }
            if (Character.isLetter(c)) {//если символ буква, значит это переменная
                String str = mapVar.get(c);//беру значение этой переменной из словаря
                stack.push(Double.parseDouble(str));
            }
            if (mapOperators.containsKey(c)) {//если символ оператор,
                Double n1 = stack.pop();
                Double n2 = stack.pop();
                result = operation(n1, n2, c);//провожу эту операцию с помощью метода "operation"
                stack.push(result);
            }
            System.out.println(result + " это промежуточный результат ");
        }
        result = stack.pop();
        System.out.println(result + " это конечный результат ");
    }


    public static void main(String[] args) {
        Stack<Character> stackPriority = new Stack<>();
        HashMap<Character, Integer> mapOperators = new HashMap<>();
        HashMap<Character, String> mapVar = new HashMap<>();
        fillMapOperators(mapOperators);
        StringBuilder sOut = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение");
        String s = scanner.nextLine();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                tmp.append(c);
                if (!isNextDigit(s, i)) {
                    sOut.append(tmp + " ");
                    tmp = new StringBuilder();
                }
            } else if (Character.isLetter(c)) {
                fillMapVar(c, mapVar);
                sOut.append(c + " ");
            } else if (c == '(') {
                stackPriority.push(c);//Если очередной символ из исходной строки открывающая скобка, то он сразу заносится в стек.
            } else if (mapOperators.containsKey(c)) {//если это оператор... то вызываю метод, который выполняет все условия
                ifOperator(c, mapOperators, stackPriority, sOut);
            } else if (c == ')') {//3.3.	Если очередной символ из исходной строки закрывающая скобка
                ifClosingBracket(stackPriority, sOut);
            } else {
                System.out.println("Значение не валидно, повторите ввод записи");
            }
            //3.1.	Если очередной символ из исходной строки операнд – он заносится в строку результата.

        }
        while (!stackPriority.isEmpty()) {
            sOut.append(stackPriority.pop());
        }
        System.out.println(sOut);
        calculation(String.valueOf(sOut), mapOperators, mapVar);
    }
}

