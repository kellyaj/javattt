package javattt;

import java.util.*;

public class MinimaxComputer implements Player {

    public String mark;

    public MinimaxComputer(String playerMark) {
        this.mark = playerMark;

    }

    public MinimaxComputer() {
        this.mark = "O";
    }

    public String getMove(Board gameBoard) {
        String currentPlayer = this.mark;
        int startingDepth = 0;
        HashMap<Double, String> miniMaxResult= this.miniMaxMove(gameBoard, currentPlayer, startingDepth);
        return miniMaxResult.get(miniMaxResult.keySet().toArray()[0]);
    }

    public String getMark() {
        return this.mark;
    }

    public HashMap<Double, String> miniMaxMove(Board gameBoard, String currentPlayer, int depth) {
        String primeMove = null;
        double highestScore = -1;
        depth = depth;
        if (Scorer.isGameOver(gameBoard.getPositions(), gameBoard.availableSpots())) {
            HashMap<Double, String> scoreMap = new HashMap<Double, String>();
            scoreMap.put(scoreMove(gameBoard, currentPlayer, depth), null);
            return scoreMap;
        } else if (gameBoard.getPositions().size() == 16 && depth == 5) {
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
            Iterator newItr = currentSet.iterator();
            String tempSpotScore = "";
            while (newItr.hasNext()) {
                tempSpotScore = newItr.next().toString();
            }
            Double spotScore = -Double.parseDouble(tempSpotScore);
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
        if (Scorer.isGameWon(gameBoard.getPositions())) {
            return -(1.0 / depth);
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
