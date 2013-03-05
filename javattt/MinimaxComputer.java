package javattt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    public HashMap<Double, String> miniMaxMove(Board gameBoard, String currentPlayer, int depth) {
        double spotScore = -1;
        String primeMove = null;
        double highestScore = -1;
        depth = depth;       // need a way to depth = 0 as a param like in Ruby
        if (gameScorer.isGameOver(gameBoard.getPositions(), gameBoard.availableSpots())) {
            HashMap<Double, String> scoreMap = new HashMap<Double, String>();
            scoreMap.put(scoreMove(gameBoard, currentPlayer, depth), null);
            return scoreMap;
        }
        depth++;
        List currentList = gameBoard.availableSpots();
        Iterator itr = currentList.iterator();
        while (itr.hasNext()) {
            String spot = itr.next().toString();
            gameBoard.placeMove(spot, currentPlayer);
            Set currentSet = miniMaxMove(gameBoard, cyclePlayers(currentPlayer), depth).keySet();
            Double spotScore = currentSet.toArray();
            gameBoard.placeMove(spot, spot);
            if (spotScore > highestScore) {
                primeMove = spot;
                highestScore = spotScore;
            }
        }
        HashMap<Double, String> moveRecommendation = new HashMap<Double, String>();
        moveRecommendation.put(highestScore, primeMove);
        return moveRecommendation;

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
