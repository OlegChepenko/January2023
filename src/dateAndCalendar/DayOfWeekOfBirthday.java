package dateAndCalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
//Проинициализируй переменную birthDate объектом GregorianCalendar с датой своего рождения. Реализуй метод getDayOfWeek(Calendar calendar), чтобы он возвращал русское название дня недели аргумента calendar.
//        Помни, что в григорианском календаре неделя начинается с воскресенья.
//
//        Требования:
//        •	Переменная birthDate должна быть проинициализирована при объявлении.
//        •	Метод getDayOfWeek(Calendar calendar) должен возвращать день недели аргумента calendar.
//https://javarush.com/quests/lectures/questsyntaxpro.level16.lecture02

public class DayOfWeekOfBirthday {
    static Calendar birthDate = new GregorianCalendar(1976, Calendar.JUNE, 14);

    public static void main(String[] args) {

        System.out.println(getDayOfWeek(birthDate));
    }
    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case 1:
                return "Воскресенье";
            case 2:
                return "Понедельник";
            case 3:
                return "Вторник";
            case 4:
                return "Среда";
            case 5:
                return "Четверг";
            case 6:
                return "Пятница";
            case 7:
                return "Суббота";
        }
        return null;
    }
}
