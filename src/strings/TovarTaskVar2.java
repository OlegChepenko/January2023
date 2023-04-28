package strings;

import java.util.Scanner;

public class TovarTaskVar2 {
    static int calcCost1(String text) {
        int total = 0;
        int start = 0;
        while (true) {
            int pos1 = text.indexOf('=', start);
            if (pos1 == -1)
                break;
            int pos2 = text.indexOf("rub", pos1);

            String s = text.substring(pos1 + 1, pos2);
            s = s.strip();
            int cost = Integer.parseInt(s);
            total += cost;

            start = pos2+3;
        }
        return total;
    }

    public static void main(String[] args) {
        String text = "milk = 50 rub, apple =100 rub, water =88rub";

        int total = calcCost1(text);
        System.out.println(total);
    }
    static int calcCost2(String text) {
        int total = 0;
        String[] products = text.split(",");

        for(String product : products) {
            String[] t = product.split("=");
            String costStr = t[1].substring(0, t[1].length() - 3).strip();
            int cost = Integer.parseInt(costStr);
            total += cost;
        }
        return total;
    }

    static int calcCost3(String text) {
        int total = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                String t = "";
                while (Character.isDigit(text.charAt(i))) {
                    t += text.charAt(i);
                    i++;
                }
                int cost = Integer.parseInt(t);
                total += cost;
            }
        }
        return total;
    }


}
