package javattt;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Scorer {
    public static final String[][] winCombos = new String[][]{
        {"1", "2", "3"},
        {"4", "5", "6"},
        {"7", "8", "9"},
        {"1", "4", "7"},
        {"2", "5", "8"},
        {"3", "6", "9"},
        {"1", "5", "9"},
        {"3", "5", "7"}
    };

    public static boolean isGameWon(HashMap<String, String> gameBoard) {
        for (String[] row : winCombos) {
            ArrayList<String> currentRow = new ArrayList<String>();
            for (String i : row) {
                currentRow.add(gameBoard.get(i));
            }
            if (currentRow.get(0).equals(currentRow.get(1)) && currentRow.get(1).equals(currentRow.get(2))) {
                return true;
            } else {
                currentRow.clear();
            }
        }
      return false;
    }

    public static boolean isGameStalemate(List<String> availableSpots) {
        return availableSpots.size() == 0;
    }

    public static boolean isGameOver(HashMap<String, String> gameBoard, List<String> availableSpots) {
        if (isGameWon(gameBoard)) {
            return true;
        } else if (isGameStalemate(availableSpots)) {
            return true;
        }
        return false;
    }

    public static String[][] getWinCombos() {
        return winCombos;
    }

}
