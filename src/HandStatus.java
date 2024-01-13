import java.util.List;

interface HandStatus {
    Domino peek(int index);
    int size();
    default boolean isEmpty(){
        return size()==0;
    }
}
