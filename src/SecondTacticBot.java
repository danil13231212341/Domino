import java.util.List;

// Класс для бота со второй тактикой
class SecondTacticBot extends Bot {
    public SecondTacticBot(String name) {
        super(name);
    }

    @Override
    public Domino makeMove(Board board) {
        List<Domino> matchingDominoes = findMatchingDominoes(board);

        if (matchingDominoes.isEmpty()) {
            return null;
        }

        Domino dominoToPlay = matchingDominoes.get(0);
        int maxSum = dominoToPlay.getSum();

        for (Domino domino : matchingDominoes) {
            if (domino.getSum() > maxSum) {
                maxSum = domino.getSum();
                dominoToPlay = domino;
            }
        }

        hand.remove(dominoToPlay);
        return dominoToPlay;
    }
}

