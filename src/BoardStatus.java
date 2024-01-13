import java.util.List;

interface BoardStatus {
     boolean canPlaceLeft(Domino domino);
     boolean canPlaceRight(Domino domino);
     void placeLeft(Domino domino);
     void placeRight(Domino domino);
     int getLeftValue();
     int getRightValue();
     boolean isEmpty();
     DominoStatus peek(int index);
     int size();
}
