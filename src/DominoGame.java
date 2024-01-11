
import java.util.Scanner;
public class DominoGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество ботов:");
        int numBots = scanner.nextInt();
        System.out.print("Введите максимальное значение доминошки: ");
        int maxDots = scanner.nextInt();

        GameLogic game = new GameLogic(numBots, maxDots);
        game.startGame();
    }
}

