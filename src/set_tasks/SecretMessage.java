package set_tasks;

import java.util.HashSet;

public class SecretMessage {

    static boolean checkSecret(String message, int x) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < message.length() - x; i++) {
            String p = message.substring(i, i + x);
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
