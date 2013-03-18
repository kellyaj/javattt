package javattt;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Scorer {
//    public static final String[][] winCombos = new String[][]{
//        {"1", "2", "3"},
//        {"4", "5", "6"},
//        {"7", "8", "9"},
//        {"1", "4", "7"},
//        {"2", "5", "8"},
//        {"3", "6", "9"},
//        {"1", "5", "9"},
//        {"3", "5", "7"}
//    };

    public static String[][] getWinCombos(int size) {
        if (size == 9) {
            return new String[][]{
                    {"1", "2", "3"},
                    {"4", "5", "6"},
                    {"7", "8", "9"},
                    {"1", "4", "7"},
                    {"2", "5", "8"},
                    {"3", "6", "9"},
                    {"1", "5", "9"},
                    {"3", "5", "7"}};
        } else if (size == 16) {
                return new String[][]{
                        {"1", "2", "3", "4"},
                        {"5", "6", "7", "8"},
                        {"9", "10", "11", "12"},
                        {"13", "14", "15", "16"},
                        {"1", "5", "9", "13"},
                        {"2", "6", "10", "14"},
                        {"3", "7", "11", "15"},
                        {"4", "8", "12", "16"},
                        {"1", "6", "11", "16"},
                        {"4", "7", "10", "13"}};
        } else {
            return getWinCombos(size);
        }
    }

    public static boolean isGameWon(ArrayList<String> gameBoard) {
        String[][] winCombos = getWinCombos(gameBoard.size());
        for (String[] row : winCombos) {
            ArrayList<String> currentRow = new ArrayList<String>();
            for (String i : row) {
                currentRow.add(gameBoard.get(Integer.parseInt(i)-1));
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

    public static boolean isGameOver(ArrayList<String> gameBoard, List<String> availableSpots) {
        if (isGameWon(gameBoard)) {
            return true;
        } else if (isGameStalemate(availableSpots)) {
            return true;
        }
        return false;
    }

}
