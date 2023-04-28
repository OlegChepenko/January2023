package stack_tasks;

import java.util.Scanner;
import java.util.Stack;

public class CheckerBrackets {

    public static boolean checkBracket(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (stack.empty()) {
                    return false;
                }
                char c = stack.pop();
                if (s.charAt(i) == ')' && c != '(' || s.charAt(i) == ']' && c != '[' || s.charAt(i) == '}' && c != '{') {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String s = scanner.nextLine();

        if (checkBracket(s)) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
