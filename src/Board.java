import java.util.ArrayList;
import java.util.List;
// Класс для представления доски
class Board {
    private List<Domino> dominoes;

    public Board() {
        dominoes = new ArrayList<>();
    }

    public void addDomino(Domino domino) {
        dominoes.add(domino);
    }

    public List<Domino> getDominoes() {
        return dominoes;
    }

    public boolean canPlace(Domino domino) {
        if (dominoes.isEmpty()) {
            return true;
        }
        int firstHalf = domino.getFirstHalf();
        int secondHalf = domino.getSecondHalf();
        int firstHalfBoard = dominoes.get(0).getFirstHalf();
        int secondHalfBoard = dominoes.get(dominoes.size() - 1).getSecondHalf();

        return firstHalf == firstHalfBoard || secondHalf == firstHalfBoard ||
                firstHalf == secondHalfBoard || secondHalf == secondHalfBoard;
    }
    public void placeTile(Domino tile, boolean left) {
        if (dominoes.isEmpty()) {
            dominoes.add(tile);
        } else if (left) {
            if (tile. getFirstHalf() == dominoes.get(0).getSecondHalf()) {
                tile.flip();
                dominoes.add(0, tile);
            } else {
                tile.flip();
                dominoes.add(0, tile);
            }
        } else {
            if (tile.getSecondHalf() == dominoes.get(dominoes.size() - 1). getFirstHalf()) {
                tile.flip();
                dominoes.add(tile);
            } else {
                tile.flip();
                dominoes.add(tile);
            }
        }
    }
}
