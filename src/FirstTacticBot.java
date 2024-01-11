import java.util.List;

// Класс для бота с первой тактикой
class FirstTacticBot extends Bot {
    public FirstTacticBot(String name) {
        super(name);
    }

    @Override
    public Domino makeMove(Board board) {
        List<Domino> matchingDominoes = findMatchingDominoes(board);

        if (matchingDominoes.isEmpty()) {
            return null;
        }
        Domino dominoToPlay = matchingDominoes.get(0);

        hand.remove(dominoToPlay);
        return dominoToPlay;
    }
}
