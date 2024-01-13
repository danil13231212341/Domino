import java.util.ArrayList;
import java.util.List;

// Абстрактный класс для бота
abstract class Bot implements BotTactic {
    protected String name;
    protected Hand hand;

    public Bot(String name) {
        this.name = name;
        hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public HandStatus getHandStatus() {
        return hand.getStatus();
    }

    public void addDomino(Domino domino) {
        hand.addDomino(domino);
    }

    public abstract Domino makeMove(BoardStatus board);

    // Определяет, может ли играемая домино быть положена на доску
    protected List<Domino> findMatchingDominoes(BoardStatus board) {
        List<Domino> matchingDominoes = new ArrayList<>();

        for(int i = 0; i < getHandStatus().size(); i++){
            Domino domino = getHandStatus().peek(i);
        }
        return matchingDominoes;
    }

}
