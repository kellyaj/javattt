package javattt;

import java.util.*;

public class MinimaxComputer extends Player {

    public String mark;
    private Scorer gameScorer;
    private String xPlayer;
    private String oPlayer;

    public MinimaxComputer(String playerMark) {
        super(playerMark);
        gameScorer = new Scorer();
        xPlayer = "X";
        oPlayer = "O";
        this.mark = playerMark;

    }

    public MinimaxComputer() {
        super(new String("O"));
        this.mark = "O";
        gameScorer = new Scorer();
    }

    public String getMove(Board gameBoard) {
        String currentPlayer = this.mark;
        int startingDepth = 0;
        HashMap<Double, String> miniMaxResult= this.miniMaxMove(gameBoard, currentPlayer, startingDepth);
        System.out.println("ATTENTION, the answer is " + miniMaxResult);
        String[] recommendedMove = miniMaxResult.entrySet().toArray(new String[]{});
        return recommendedMove[0];
    }

    public HashMap<Double, String> miniMaxMove(Board gameBoard, String currentPlayer, int depth) {
        //double spotScore = -1;
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
            Set currentSet = miniMaxMove(gameBoard, cyclePlayers(currentPlayer), depth).keySet();   // this was negative in Ruby
            Iterator newItr = currentSet.iterator();
            String tempSpotScore = "";
            while (newItr.hasNext()) {
                tempSpotScore = newItr.next().toString();
            }
            Double spotScore = Double.parseDouble(tempSpotScore);
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
            return (1.0 / depth);         // this was negative in Ruby
        } else {
            return 0;
        }
    }

    public String cyclePlayers(String currentPlayer) {
        if (currentPlayer == xPlayer) {
            return oPlayer;
        } else {
            return xPlayer;
        }
    }

}
