import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Класс для представления колоды
class Deck {
    private List<Domino> dominoes;

    public Deck(int maxDots) {
        dominoes = new ArrayList<>();

        for (int i = 0; i <= maxDots; i++) {
            for (int j = i; j <= maxDots; j++) {
                dominoes.add(new Domino(i, j));
            }
        }
        Collections.shuffle(dominoes);
    }

    public Domino draw() {
        if (dominoes.isEmpty()) {
            return null;
        }
        return dominoes.remove(0);
    }

    public boolean isEmpty() {
        return dominoes.isEmpty();
    }
}

