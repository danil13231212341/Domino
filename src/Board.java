import java.util.ArrayList;
import java.util.List;

// Класс для представления доски
class Board implements BoardStatus {
    private List<DominoStatus> dominoes;
    private final BoardProxy boardStatus;

    public Board() {
        dominoes = new ArrayList<>();
        this.boardStatus = new BoardProxy(this);
    }

    public void addDomino(Domino domino) {
        dominoes.add(domino);
    }

    public BoardStatus getStatus() {
        return boardStatus;
    }

    @Override
    public int getLeftValue() {
        if (dominoes.isEmpty()) return 0;
        return dominoes.get(0).getLeftHalf();
    }

    @Override
    public int getRightValue() {
        if (dominoes.isEmpty()) return 0;
        return dominoes.get(dominoes.size() - 1).getRightHalf();
    }

    @Override
    public boolean isEmpty() {
        return dominoes.isEmpty();
    }

    @Override
    public DominoStatus peek(int index) {
         return dominoes.get(index);
    }

    @Override
    public int size() {
        return dominoes.size();
    }

    @Override
    public boolean canPlaceLeft(Domino domino) {
        return isEmpty() || getLeftValue() == domino.getRightHalf();
    }

    @Override
    public boolean canPlaceRight(Domino domino) {
        return isEmpty() || getRightValue() == domino.getLeftHalf();
    }

    @Override
    public void placeLeft(Domino domino) {
        dominoes.add(0, new DominoProxy(domino));
    }

    @Override
    public void placeRight(Domino domino) {
        dominoes.add(new DominoProxy(domino));
    }
}
