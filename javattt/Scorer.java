package javattt;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Scorer {
    // there's got to be a better way to do this
    public static String[][] winCombos;

    public Scorer() {
        // nothing to do here?
    }

    public boolean isGameWon(HashMap<String, String> gameBoard) {
        // compare array of taken positions to winCombo
      return true;
    }

    public boolean isGameStalemate(HashMap<String, String> gameBoard) {
        return true;
    }

    public boolean isGameOver(HashMap<String, String> gameBoard) {
        return true;
    }

    public static void main (String[] args) {
        String[][] winCombos = {
                { "1", "2", "3" },
                { "4", "5", "6" },
                { "7", "8", "9" },
                { "1", "4", "7" },
                { "2", "5", "8" },
                { "3", "6", "9" },
                { "1", "5", "9" },
                { "3", "5", "7" }
        };
    }

}
