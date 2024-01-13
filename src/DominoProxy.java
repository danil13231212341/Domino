public class DominoProxy implements DominoStatus {
    private final Domino domino;


    public DominoProxy(Domino domino) {
        this.domino = domino;

    }

    @Override
    public int getLeftHalf() {
        return domino.getLeftHalf();
    }

    @Override
    public int getRightHalf() {
        return domino.getRightHalf();
    }

    @Override
    public String toString() {
        int leftHalf = domino.getLeftHalf();
        int rightHalf = domino.getRightHalf();

        return "[" + leftHalf + "|" + rightHalf + "]";

    }
}
