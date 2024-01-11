// Класс для представления костяшек
class Domino {
    private int firstHalf;
    private int secondHalf;
    private boolean flipped;

    public Domino(int firstHalf, int secondHalf) {
        this.firstHalf = firstHalf;
        this.secondHalf = secondHalf;
    }

    public int getFirstHalf() {
        return firstHalf;
    }

    public int getSecondHalf() {
        return secondHalf;
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