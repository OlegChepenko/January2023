package system_test;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


class User {
    String login;
    String password;
}

class Question {
    String name;
    ArrayList<String> answers;
    int rightAnswer;
}

public class Main {
    static ArrayList<User> readUsers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("users.txt"));
        ArrayList<User> users = new ArrayList<>();
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            User user = new User();
            String s1 = s.substring(0, s.indexOf(" "));
            String s2 = s.substring(s.indexOf(" ") + 1);
            user.login = s1;
            user.password = s2;
            users.add(user);
        }
        bufferedReader.close();
        return users;
    }

    static User findUser(ArrayList<User> users, String login, String password) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.login.equals(login) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    //    Идея получить Ip адрес и записать его в файл. По моему избыточно. Все Ip хранить смысла нет,
//    записывать нужно только те, что заблокированы, и когда блокировка закончится.
    static String ipAddress() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        String ipAddress = "" + ip.getHostAddress();
        return ipAddress;
    }

    //Идея в том, чтобы читать из файла Ip, если период времени меньше 0,5ч, то блокировать. Это не верный путь!
    static void block(String ipAddress) throws IOException {
        // Тут надо заблокировать пользователю вход.
        LocalDateTime now = LocalDateTime.now();
        BufferedWriter writer = new BufferedWriter(new FileWriter("resultIp.txt", true));
        writer.write(ipAddress + ";" + now);
        writer.close();
    }

    //метод возвращает false, если ip нет в списке, и true, если есть.
    static boolean checkBlocked(String ipAdress) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("resultIp.txt"));
        String s = "";
        while ((s = reader.readLine()) != null) {
            String[] strings = s.split(";");
            String ip = strings[0];
            if (ip.equals(ipAdress)) {
               return true;
            }
        }
        reader.close();
        return false;
    }

    // TODO: 20.04.2023  теперь эта функция проверяет и удаляет устаревшие строки из файла
    static void deleteStringFromFile() throws IOException {
        LocalDateTime now = LocalDateTime.now();
        File sourceFile = new File("resultIp.txt");
        File outputFile = new File("resultTmp.txt");
        BufferedReader reader = new BufferedReader(new FileReader("resultIp.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("resultTmp.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] strings = line.split(";");
            LocalDateTime time2 = LocalDateTime.parse(strings[1]).plusMinutes(30);
            if (time2.isAfter(now)) {
                writer.write(line);
            }
        }
        reader.close();
        writer.close();
        sourceFile.delete();
        outputFile.renameTo(sourceFile);
    }

    static User authorization(ArrayList<User> users) throws IOException {
        Scanner scanner = new Scanner(System.in);
        User user = null;
//подсчет попыток не верных авторизаций
        int attempt = 0;
        while (user == null) {
            System.out.println("Введите логин");
            String login = scanner.nextLine();
            System.out.println("Введите пароль");
            String password = scanner.nextLine();
            user = findUser(users, login, password);
            if (user == null) {
                System.out.println("Введен не верный логин или пароль");
                attempt++;
            }
            String ipAddress = ipAddress();
//Проверка, не вводил ли пользователь неверно пароль три раза подряд? Если вводил, в лист блокировки его.
            if (attempt == 3) {
                block(ipAddress);
                System.out.println("Попытки входа заблокированы на 30 минут");
                break;
            }
        }
        return user;
    }

    static boolean twentyFourHours(User user, String testName) throws IOException, ParseException {
        LocalDateTime now = LocalDateTime.now();
        BufferedReader reader = new BufferedReader(new FileReader("result.txt"));
//В эту переменн. кладем дату ровно сутки назад (24ч назад)
        LocalDateTime dayBeforeNow = now.minusDays(1);
//переменная для проверки, сколько раз пользователь сдавал тест (чтобы не больше 3-х раз)
        int checkThreeTimes = 0;
        //В эту перем. считываем строку с инфой юзером, датой и проч.
        String s = " ; ";
        //В эту перем. кладем элемент с датой
        String dateStr = "";
        //В этот массив разобью строку на элементы по пробелу
        while (!((s = reader.readLine()) == null)) {
            String[] strings = s.split(";");
//проверяю на совпадение логина и номера теста, если сдавал три раза, больше нельзя
            if (strings[0].equals(user.login) && strings[1].equals(testName)) {
                checkThreeTimes++;
                dateStr = strings[3];
//если пользователь сдал экзамен три раза, то возвращаем false
                if (checkThreeTimes == 3) {
                    System.out.println("Вы достигли предела в количестве попыток сдать тест " + testName + " - 3 раза");
                    return false;
                }
            }
        }
//Дата последнего входа пользователя в программу для сдачи именно этого теста. Если ранее 24ч. назад, то нельзя.
        if (!dateStr.isEmpty()) {
            LocalDateTime date = LocalDateTime.parse(dateStr);
            if (date.isAfter(dayBeforeNow)) {
                System.out.println("После последней попытки прошло менее 24ч. Попробуйте снова позже.");
                return false;
            }
        }
        return true;
    }

    static String selectTest() {
        Scanner scanner = new Scanner(System.in);
        File file = new File("files");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName().replace(".txt", "");
            System.out.println(i + 1 + "." + name);
        }
        System.out.println("Выберете номер теста");
        //Проверка введенного значения - это цифра или нет?
        int n;
        while (true) {
            String s = scanner.nextLine();
            if (!s.isEmpty() && isDigit(s)) {
                 n = Integer.parseInt(s);
                if (n <= files.length&&n>0) {
                    break;
                }else {
                    System.out.println("Выберете номер теста");
                }
            } else {
                System.out.println("Выберете номер теста");
            }
        }
        return files[n - 1].getName();
    }

    //открываем файл, считываем данные, формируем список вопросов
    static ArrayList<Question> readQuestions(String test) throws IOException {
        ArrayList<Question> questions = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\ОлегЧепенко\\IdeaProjects\\January2023\\files\\" + test));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            ArrayList<String> answers = new ArrayList<>();
            //Подразумевается, что ответов строго 4.
            for (int i = 0; i < 4; i++) {
                answers.add(bufferedReader.readLine());
            }
            int n = Integer.parseInt(bufferedReader.readLine());
            Question q = new Question();
            q.name = line;
            q.answers = answers;
            q.rightAnswer = n;
            questions.add(q);
        }
        bufferedReader.close();
        return questions;
    }

//бегаем по вопросам, выводим на экран название вопросов, варианты ответов, пользователь отвечает,
// мы считаем количество правильных ответов
    static double runTest(ArrayList<Question> questions) {
        Scanner scanner = new Scanner(System.in);
        int count = 0; //количество правильных ответов.
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println(q.name);
            for (int j = 0; j < q.answers.size(); j++) {
                System.out.println((j + 1) + "." + q.answers.get(j));
            }
            int varAnsw = 0;
//цикл проверки введенных данных, чтобы это была цифра из возможных вариантов
            System.out.println("Введите номер правильного варианта ответа");
            while (true) {
                String s = scanner.nextLine();
                if (!isDigit(s)) {
                    System.out.println("Введите пожалуйста цифру");
                } else {
                    varAnsw = Integer.parseInt(s);
                    if (!answersSize(varAnsw, q)) {
                        System.out.println("Введенное значение не подходит. Введите номер ответа от 1 до " + q.answers.size());
                    } else break;
                }
            }
            if (varAnsw == q.rightAnswer) {
                count++;
                System.out.println("Вы ответили верно!");
            } else {
                System.out.println("Ответ не верный");
            }
        }
        double p = (double) count / questions.size() * 100.0; //процент правильных ответов
        System.out.format("%.2f.", p);
        return p;
    }

    static boolean isDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    static boolean answersSize(int varAnsw, Question q) {
        return varAnsw > 0 && varAnsw <= q.answers.size();
    }
    //Записываю результат теста: пользователь, что за тест, оценку в процентах, время входа.
    static void writeResult(User user, String test, double p) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt", true));
        writer.write(user.login + ";" + test + ";" + p + ";" + now);
        writer.newLine();
        writer.close();
    }

    public static void main(String[] args) throws IOException, ParseException {
        deleteStringFromFile();
        String ipAddress = ipAddress();
        if (!checkBlocked(ipAddress)) {   //checkBlocked возвращает true если адрес присутствует в списке
            ArrayList<User> users = readUsers();
            User user = authorization(users);
//Проверка логина пароля. Если ввел три раза не верный пароль, то блокировка.
            if (user != null) {
                String test = selectTest();
//Проверка, что вход был не чаще чем раз в сутки для повторной сдачи
                boolean twentyFourHours = twentyFourHours(user, test);
                if (twentyFourHours) {
                    ArrayList<Question> questions = readQuestions(test);
                    Collections.shuffle(questions);
                    double p = runTest(questions);
                    writeResult(user, test, p);
                }
            }
        }else {
            System.out.println("С момента блокировки не истекло 30 минут. Повторите вход позже.");
        }
    }
}
