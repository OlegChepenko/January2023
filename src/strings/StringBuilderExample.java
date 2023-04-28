package strings;

public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            s.append("hello welcome");
        }

        long finish = System.currentTimeMillis();
        long time = finish - start;

        System.out.println(time);
    }
}
