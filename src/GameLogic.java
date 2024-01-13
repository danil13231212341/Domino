import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Класс с логикой игры и отображением процесса в консоли
class GameLogic {
    private List<Bot> bots;
    private Board board;
    private Deck deck;

    public GameLogic(int numBots, int maxDots) {
        board = new Board();
        deck = new Deck(maxDots);
        bots = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= numBots; i++) {
            System.out.println("Выберите тактику для бота " + i + ":");
            System.out.println("1 - Первая тактика");
            System.out.println("2 - Вторая тактика");
            int tacticChoice = scanner.nextInt();

            // Создаем бота в соответствии с выбранной тактикой
            if (tacticChoice == 1) {
                bots.add(new FirstTacticBot("bot " + i));
            } else if (tacticChoice == 2) {
                bots.add(new SecondTacticBot("bot " + i));
            } else {
                System.out.println("Неверный выбор тактики. Попробуйте снова.");
                i--;
            }

        }
    }
    public void startGame() {
        // Раздача костяшек ботам
        for (Bot bot : bots) {
            for (int i = 0; i < 7; i++) {
                bot.addDomino(deck.draw());
            }
        }

        // Находим бота, у которого самая маленькая сумма очков в руке
        Bot winner = findBotWithMinScore();

        while (!deck.isEmpty() || !bots.isEmpty()) {
            // Ход ботов по очереди
            for (Bot bot : bots) {
                displayGameStatus(bot);

                // Бот делает ход по нажатию клавиши Enter
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();

                Domino playedDomino = bot.makeMove(board.getStatus());

                if (playedDomino != null) {
                    board.addDomino(playedDomino);
                } else {
                    // Если бот не может сделать ход, он берет новую костяшку из колоды
                    if (!deck.isEmpty()) {
                        Domino newDomino = deck.draw();
                        bot.addDomino(newDomino);
                        playedDomino = newDomino;
                    }
                }

                // Если боту удалось сделать ход, проверяем победу
                if (playedDomino != null) {
                    if (bot.getHandStatus().isEmpty()) {
                        System.out.println(bot.getName() + " wins!");
                        return;
                    }
                }
            }
        }

        // Если колода пуста и никто не может сделать ход, находим бота с наименьшей суммой очков
        Bot  victor = findBotWithMinScore();
        System.out.println(victor.getName() + " wins!");
    }

    private void displayGameStatus(Bot currentBot) {
        System.out.println("Current board: ");
        for(int i = 0; i < board.getStatus().size(); i++){
            DominoStatus domino = board.getStatus().peek(i);
            System.out.print("[ " + domino.getLeftHalf() + " | " + domino.getRightHalf() + " ] ");
        }
        System.out.println("\n");
        for (Bot bot : bots) {
            if (bot == currentBot) {
                System.out.print("-> " + bot.getName() + ": ");
                 for(int i =0; i<bot.getHandStatus().size();i++) {
                     Domino domino =bot.getHandStatus().peek(i);
                    System.out.print("[ " + domino.getLeftHalf() + " | " + domino.getRightHalf() + " ] ");
                }
                System.out.println();
            } else {
                System.out.print(bot.getName() + ": ");
                for (int i = 0; i < bot.getHandStatus().size(); i++) {
                    System.out.print("[ " + "?" + " | " + "?" + " ] ");
                }
                System.out.println();
            }
        }
    }

    private Bot findBotWithMinScore() {
        Bot botWithMinScore = bots.get(0);
        int minScore = getScore(botWithMinScore);

        for (Bot bot : bots) {
            int score = getScore(bot);
            if (score < minScore) {
                botWithMinScore = bot;
                minScore = score;
            }
        }
        return botWithMinScore;
    }
    private int getScore(Bot bot) {
        int score = 0;
        for(int i =0; i<bot.getHandStatus().size();i++) {
            Domino domino =bot.getHandStatus().peek(i);
            score += domino.getSum();
        }
        return score;
    }
}
