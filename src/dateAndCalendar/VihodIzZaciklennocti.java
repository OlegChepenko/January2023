package dateAndCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
/*
Выход из зацикленности
Цикл while должен был завершиться за 31 итерацию, но почему-то зациклился. Найди и исправь ошибку.
Требования:
•	Исправь одну ошибку, чтобы программа успешно завершилась.
https://javarush.com/quests/lectures/questsyntaxpro.level16.lecture02
*/
public class VihodIzZaciklennocti {
    public static void main(String[] args) {
    Calendar start = new GregorianCalendar(2014, Calendar.JANUARY, 2);
    Calendar end = new GregorianCalendar(2014, Calendar.FEBRUARY, 2);

        System.out.print("Старт");
        while (start.before(end)) {
        start.add(Calendar.DATE, 1);
        System.out.print(".");
    }
        System.out.print("Финиш");
}
}
