package stack_tasks;
//https://youtu.be/IqzJ2T-4qww
//36:04 создание теста
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckerBracketsTest {

    @Test
    void checkBracket1() {
        String s = "([])";
        boolean check = CheckerBrackets.checkBracket(s);

        assertTrue(check);
    }
    @Test
    void checkBracket2() {
        String s = "([]{))";
        boolean check = CheckerBrackets.checkBracket(s);

        assertFalse(check);
    }
    @Test
    void checkBracket3() {
        String s = "(()";
        boolean check = CheckerBrackets.checkBracket(s);

        assertFalse(check);
    }
    @Test
    void checkBracket4() {
        String s = "())";
        boolean check = CheckerBrackets.checkBracket(s);

        assertFalse(check);
    }
    @Test
    void checkBracket5() {
        String s = "";
        boolean check = CheckerBrackets.checkBracket(s);

        assertTrue(check);
    }
}