// Класс для представления костяшек
class Domino implements DominoStatus {
    private final int firstHalf;
    private final int secondHalf;
    private boolean flipped;

    public Domino(int firstHalf, int secondHalf) {
        this.firstHalf = firstHalf;
        this.secondHalf = secondHalf;
    }

    @Override
    public int getLeftHalf() {
        return flipped ? secondHalf : firstHalf;
    }

    @Override
    public int getRightHalf() {
        return flipped ? firstHalf : secondHalf;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void flip() {
        flipped = !flipped;
    }

    public int getSum() {
        return firstHalf + secondHalf;
    }

    @Override
    public String toString() {
        if (flipped) {
            return "[" + firstHalf + "|" + secondHalf + "]";
        } else {
            return "[" + secondHalf + "|" + firstHalf + "]";
        }
    }
}