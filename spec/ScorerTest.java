package spec;

import javattt.Scorer;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ScorerTest {

    @Test
    public void itShouldInitializeWithWinCombos() {
        Scorer gameScorer = new Scorer();
        String[] firstRow = gameScorer.getWinCombos()[0];
        String[] expectedRow = {"1", "2", "3"};
        Assert.assertArrayEquals(expectedRow, firstRow);
    }

    @Test
    public void itShouldReturnTrueIfWonCaseRow() {
        HashMap<String, String> newPositions = new HashMap<String, String>();
        newPositions.put("1", "X");
        newPositions.put("2", "X");
        newPositions.put("3", "X");
        newPositions.put("4", "4");
        newPositions.put("5", "5");
        newPositions.put("6", "6");
        newPositions.put("7", "7");
        newPositions.put("8", "8");
        newPositions.put("9", "9");
        HashMap<String, String> positions = newPositions;
        Scorer gameScorer = new Scorer();
        Assert.assertTrue(gameScorer.isGameWon(positions));
    }

    @Test
    public void itShouldReturnTrueIfWonCaseColumn() {
        HashMap<String, String> newPositions = new HashMap<String, String>();
        newPositions.put("1", "X");
        newPositions.put("2", "2");
        newPositions.put("3", "3");
        newPositions.put("4", "X");
        newPositions.put("5", "5");
        newPositions.put("6", "6");
        newPositions.put("7", "X");
        newPositions.put("8", "8");
        newPositions.put("9", "9");
        HashMap<String, String> positions = newPositions;
        Scorer gameScorer = new Scorer();
        Assert.assertTrue(gameScorer.isGameWon(positions));
    }

    @Test
    public void itShouldReturnTrueIfWonCaseDiagonal() {
        HashMap<String, String> newPositions = new HashMap<String, String>();
        newPositions.put("1", "X");
        newPositions.put("2", "2");
        newPositions.put("3", "3");
        newPositions.put("4", "X");
        newPositions.put("5", "X");
        newPositions.put("6", "6");
        newPositions.put("7", "7");
        newPositions.put("8", "8");
        newPositions.put("9", "X");
        HashMap<String, String> positions = newPositions;
        Scorer gameScorer = new Scorer();
        Assert.assertTrue(gameScorer.isGameWon(positions));
    }

    @Test
    public void itShouldReturnFalseIfNotWon() {
        HashMap<String, String> newPositions = new HashMap<String, String>();
        newPositions.put("1", "X");
        newPositions.put("2", "2");
        newPositions.put("3", "X");
        newPositions.put("4", "4");
        newPositions.put("5", "5");
        newPositions.put("6", "6");
        newPositions.put("7", "7");
        newPositions.put("8", "8");
        newPositions.put("9", "9");
        HashMap<String, String> positions = newPositions;
        Scorer gameScorer = new Scorer();
        Assert.assertFalse(gameScorer.isGameWon(positions));
    }

    @Test
    public void itShouldReturnTrueIfStalemate() {
        List<String> availableSpots = new LinkedList<String>();
        Scorer gameScorer = new Scorer();
        Assert.assertTrue(gameScorer.isGameStalemate(availableSpots));
    }

    @Test
    public void itShouldReturnFalseIfNotStalemate() {
        List<String> availableSpots = new LinkedList<String>();
        availableSpots.add("1");
        Scorer gameScorer = new Scorer();
        Assert.assertFalse(gameScorer.isGameStalemate(availableSpots));
    }
}
