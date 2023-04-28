package strings;
//10.03.2023
// + спрашиваем крутить барабан или назвать слово целиком
// + окончание игры оформить
// + если такая буква уже названа то корректно обработать
// + когда крутим барабан то рандомно выпадают очки
// + добавляем игроку очки когда буква правильная+

import com.sun.source.tree.IfTree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

class Question {
    String name;
    String answer;
}

class Player {
    String name;
    int points;
}

public class FieldDream {
    static ArrayList<Question> readQuestion() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("вопросы.txt"));
        ArrayList<Question> questions = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String answer = reader.readLine();
            Question q = new Question();
            q.name = line;
            q.answer = answer;
            questions.add(q);
        }
        reader.close();
        return questions;
    }

    static ArrayList<Player> createPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите имя");
            String name = scanner.next();
            Player player = new Player();
            player.name = name;
            players.add(player);
        }
        return players;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Question> questions = readQuestion();
        int pos = random.nextInt(questions.size());
        Question q = questions.get(pos);

        ArrayList<Player> players = createPlayers();
        System.out.println(q.name);

        int currentPlayer = 0;
        String secret = "#".repeat(q.answer.length());
        String answer = q.answer;
        //int currentPlayerPoints = players.get(currentPlayer).points;//как присвоить конкретному игроку его очки в игре?

        while (true) {
            System.out.println(secret);
            System.out.println("Сейчас ходит " + players.get(currentPlayer).name);
            System.out.println("Введите \"1\", если хотите крутить барабан, \"2\", если вы готовы назвать слово целиком");
            //этот сканер мешает работе нижеследующего сканера. Пришлось сделать метод сканер отдельно. Заработало.
            String viborIgroka = scanner.nextLine();
            int n = checkNumber(viborIgroka);

            //Если крутит барабан, то играем.
            if (n == 1) {
                //Очки на барабане
                int pointsBaraban = points();
                System.out.println("На барабане " + pointsBaraban + " очков");
                System.out.println("Введите букву");
                char c = scanner.nextLine().charAt(0);
                while (secret.contains(c + "")){
                    System.out.println("Такую букву уже называли. Пожалуйста, назовите другу букву: ");
                    c = scanner.nextLine().charAt(0);
                }
                if (answer.contains(c + "")) {
                    System.out.println("Вы угадали");
                    for (int i = 0; i < answer.length(); i++) {
                        if (answer.charAt(i) == c) {
                            secret = secret.substring(0, i) + c + secret.substring(i + 1);
                            players.get(currentPlayer).points += pointsBaraban;
                        }
                    }
                    System.out.println("У вас всего " + players.get(currentPlayer).points + " очков");
                    //Проверка, не кончились ли буквы?
                    if (!secret.contains('#' + "")){
                        break;
                    }
                } else {
                    System.out.println("Нет такой буквы");
                    currentPlayer = (currentPlayer + 1) % players.size();
                }
                //Если говорит слово целиком
            } else if (n == 2) {
                System.out.println("Напишите слово");
                String s1 = scanner.nextLine();
                if (s1.equals(answer)) {
                    System.out.println("Вы угадали! Вы выиграли!");
                    break;
                } else {
                    System.out.println("Вы покидаете игру!");
                    players.remove(currentPlayer);
                    //Если всех игроков выгнали, игру заканчиваем
                    if (players.size() == 0) {
                        System.out.println("Игроков не осталось, игра завершена");
                        break;
                    }
                    //Проверяю, если номер игрока последний в списке, то меняю его на первого, если нет,
                    // то не трогаю, сам поменяется из-за удаления одного элемента из списка
                    if (currentPlayer == players.size()){
                        currentPlayer = 0;
                    }
                }
            }
        }
        if (players.size()>0) {
            System.out.println("Победителем объявляется игрок " + players.get(currentPlayer).name);
        }else {
            System.out.println("Победителей нет");
        }
    }

      static int points() {
        Random random = new Random();
        int points = random.nextInt(0, 20) * 50;
        return points;
    }
    static int checkNumber(String s){
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (true){
            if (s.length() == 1 && Character.isDigit(s.charAt(0))){
                n = Character.digit(s.charAt(0), 10);
                if (n != 1 && n != 2){
                    System.out.println("\"Введите \"1\", если хотите крутить барабан, \"2\", если вы готовы назвать слово целиком\"");
                    s = scanner.nextLine();
                } else break;
            }   else  {
                System.out.println("\"Введите \"1\", если хотите крутить барабан, \"2\", если вы готовы назвать слово целиком\"");
                s = scanner.nextLine();
            }
        }
        return n;
    }
}
