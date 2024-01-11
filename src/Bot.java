import java.util.ArrayList;
import java.util.List;
// Абстрактный класс для бота
abstract class Bot {
    protected String name;
    protected List<Domino> hand;

    public Bot(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Domino> getHand() {
        return hand;
    }

    public void addDomino(Domino domino) {
        hand.add(domino);
    }

    public abstract Domino makeMove(Board board);

    protected List<Domino> findMatchingDominoes(Board board) {
        List<Domino> matchingDominoes = new ArrayList<>();

        for (Domino domino : hand) {
            if (board.canPlace(domino)) {
                matchingDominoes.add(domino);
            }
        }
        return matchingDominoes;
    }
}
