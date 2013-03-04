package javattt;

import java.util.List;

public class MinimaxComputer extends Player {

    public String mark;
    private Scorer gameScorer;

    public MinimaxComputer(String playerMark) {
        super(playerMark);
        gameScorer = new Scorer();

    }

    public MinimaxComputer() {
        super(new String("O"));
        gameScorer = new Scorer();
    }

    public String getMove(Board gameBoard) {
        String currentPlayer = this.mark;
        int startingDepth = 0;
        this.miniMaxMove(gameBoard, currentPlayer, startingDepth);
        return "1"; //placeholder
    }

    public String miniMaxMove(Board gameBoard, String currentPlayer, int depth) {
        int spotScore = -1;
        String primeMove = null;
        int highestScore = -1;
        depth = depth;       // need a way to depth = 0 as a param like in Ruby
        // return scoreMove(...) if gameScorer.gameIsOver
        depth++;
        // start iterating over each available spot and doing the recursion
        if (spotScore > highestScore) {
            primeMove = "temp"; //the spot iterated over
            highestScore = "othertemp"; //
        }
        return "1";  //placeholder

    }

    public double scoreMove(Board gameBoard, String currentPlayer, int depth) {
        if (gameScorer.isGameWon(gameBoard.getPositions())) {
            return (1.0 / -depth);
        } else {
            return 0;
        }
    }

    public String cyclePlayers(String currentPlayer) {
        if (currentPlayer.equals("X")) {
            return "O";
        } else {
            return "X";
        }
    }

}
