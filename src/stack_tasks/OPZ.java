package stack_tasks;

import java.util.*;

public class OPZ {
    static void fillMap(HashMap<Character, Integer> map) {
        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('^', 3);
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
                    s.append(stackPriority.pop());// то оператор извлекается из стека и записывается в строку результата.
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
            s.append(c);
        }

    }

    static void calculation(String s) {


    }

    public static void main(String[] args) {
        Stack<Character> stackPriority = new Stack<>();
        Stack<Character> stackNumbers = new Stack<>();
        HashMap<Character, Integer> mapOperators = new HashMap<>();
        fillMap(mapOperators);
        StringBuilder sOut = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение");
        String s = scanner.nextLine();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (Character.isDigit(c)) {
                //           if (c != '(' && c != ')' && !mapOperators.containsKey(c)) {//это проверка, если операнд явл. переменной.

                sOut.append(c);
            }
            if (c == '(') {
                stackPriority.push(c);//Если очередной символ из исходной строки открывающая скобка, то он сразу заносится в стек.
            } else if (mapOperators.containsKey(c)) {//если это опратор... то вызываю метод, который выполняет все условия
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
        calculation(String.valueOf(sOut));
    }
}

