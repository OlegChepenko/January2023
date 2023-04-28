package zagotovki;

public class ifStringContains {
    static boolean checkVowel(char c){
        String vowels = "aeiou";
        if (vowels.contains(c + ""))
            return true;
        else return false;
    }
}
