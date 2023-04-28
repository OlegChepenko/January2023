package dateAndCalendar;
import java.util.Calendar;
import java.util.Date;

/*
Лишь бы не в понедельник :) https://javarush.com/quests/lectures/questsyntaxpro.level16.lecture01
*/
//Проинициализируй переменную birthDate объектом Date с датой своего рождения.
//        Реализуй метод getDayOfWeek(Date date), чтобы он возвращал русское название дня недели аргумента date.
//
//        Требования:
//        •	Переменная birthDate должна быть проинициализирована при объявлении.
//        •	Метод getDayOfWeek(Date date) должен возвращать русское название дня недели.
public class DayOfWeekOfBirthday1 {
    static Date birthDate = new Date(76, Calendar.JUNE, 14);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        String result = "";
        int day = date.getDay();
        switch (day) {
            case 0:
                return "воскресенье";
            case 1:
                return "понедельник";
            case 2:
                return "вторник";
            case 3:
                return "среда";
            case 4:
                return "четверг";
            case 5:
                return "пятница";
            case 6:
                return "суббота";
        }
        return result;
    }

}
