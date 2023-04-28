package set_tasks;
//https://drive.google.com/file/d/1hNcqN0PkfxnELndtJHn_1koBwClv7hkb/view?usp=share_link

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Odnofamilci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("odnofamilci.txt"));
        HashSet<String> set = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        int n = Integer.parseInt(reader.readLine());
        int count = 0;
        String s = "";
        for (int i = 0; i < n; i++) {
            s = reader.readLine();
            if (set.contains(s)){
                count++;
                set2.add(s);
            }else {
                set.add(s);
            }

        }
        count += set2.size();
        System.out.println(count);
    }
}
