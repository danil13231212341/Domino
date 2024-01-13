import java.util.List;

public class BoardProxy implements BoardStatus {
    private final Board board;

    public BoardProxy(Board board) {
        this.board = board;
    }


    @Override
    public boolean canPlaceLeft(Domino domino) {
        return board.canPlaceLeft(domino);
    }

    @Override
    public boolean canPlaceRight(Domino domino) {
        return board.canPlaceRight(domino);
    }

    @Override
    public void placeLeft(Domino domino) {
        board.placeLeft(domino);
    }

    @Override
    public void placeRight(Domino domino) {
        board.placeRight(domino);
    }

    @Override
    public int getLeftValue() {
        return board.getLeftValue();
    }

    @Override
    public int getRightValue() {
        return board.getRightValue();
    }

    @Override
    public boolean isEmpty() {
        return board.isEmpty();
    }

    @Override
    public DominoStatus peek(int index) {
        return board.peek(index);
    }

    @Override
    public int size() {
        return board.size();
    }
}
