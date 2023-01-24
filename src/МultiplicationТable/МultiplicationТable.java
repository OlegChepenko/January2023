package МultiplicationТable;

public class МultiplicationТable {
    public static void main(String[] args) {
        for (int j = 2; j <= 10; j++) {
            for (int i = 1; i <= 10; i++) {
             int result = j*i;
                System.out.println(j + "*" + i + "=" + result );
             }
            System.out.println("------");
    }
    }
}
