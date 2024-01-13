import java.util.List;

public class HandProxy implements HandStatus {
    private final Hand hand;

    public HandProxy(Hand hand) {
        this.hand = hand;
    }

    @Override
    public Domino peek(int index) {
        return hand.peek(index);
    }

    @Override
    public int size() {
        return hand.size();
    }


}
