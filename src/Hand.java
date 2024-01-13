import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Hand implements HandStatus {
    private List<Domino> dominoes;
    private final HandStatus handStatus;

    public Hand() {
        this.dominoes = new ArrayList();
        handStatus = new HandProxy(this);
    }

    public HandStatus getStatus() {
        return handStatus;
    }

    public List<Domino> getDominoes() {
        return Collections.unmodifiableList(dominoes);
    }

    @Override
    public Domino peek(int index) {
        return dominoes.get(index);
    }

    @Override
    public int size() {
        return dominoes.size();
    }


    public void addDomino(Domino domino) {
        dominoes.add(domino);

    }


    public Domino take(int index) {
        return dominoes.remove(index);
    }


    public void remove(Domino domino) {
        dominoes.remove(domino);
    }
}