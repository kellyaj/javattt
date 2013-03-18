package spec;

import javattt.Scorer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ScorerTest {

    @Test
    public void itShouldInitializeWithWinCombos() {
        String[] firstRow = Scorer.getWinCombos()[0];
        String[] expectedRow = {"1", "2", "3"};
        Assert.assertArrayEquals(expectedRow, firstRow);
    }

    @Test
    public void itShouldReturnTrueIfWonCaseRow() {
        ArrayList<String> newPositions = new ArrayList<String>();
        newPositions.add(0, "X");
        newPositions.add(1, "X");
        newPositions.add(2, "X");
        newPositions.add(3, "4");
        newPositions.add(4, "5");
        newPositions.add(5, "6");
        newPositions.add(6, "7");
        newPositions.add(7, "8");
        newPositions.add(8, "9");
        Assert.assertTrue(Scorer.isGameWon(newPositions));
    }

    @Test
    public void itShouldReturnTrueIfWonCaseColumn() {
        ArrayList<String> newPositions = new ArrayList<String>();
        newPositions.add(0, "X");
        newPositions.add(1, "2");
        newPositions.add(2, "3");
        newPositions.add(3, "X");
        newPositions.add(4, "5");
        newPositions.add(5, "6");
        newPositions.add(6, "X");
        newPositions.add(7, "8");
        newPositions.add(8, "9");
        Assert.assertTrue(Scorer.isGameWon(newPositions));
    }

    @Test
    public void itShouldReturnTrueIfWonCaseDiagonal() {
        ArrayList<String> newPositions = new ArrayList<String>();
        newPositions.add(0, "X");
        newPositions.add(1, "2");
        newPositions.add(2, "3");
        newPositions.add(3, "X");
        newPositions.add(4, "X");
        newPositions.add(5, "6");
        newPositions.add(6, "7");
        newPositions.add(7, "8");
        newPositions.add(8, "X");
        Assert.assertTrue(Scorer.isGameWon(newPositions));
    }

    @Test
    public void itShouldReturnFalseIfNotWon() {
        ArrayList<String> newPositions = new ArrayList<String>();
        newPositions.add(0, "X");
        newPositions.add(1, "2");
        newPositions.add(2, "X");
        newPositions.add(3, "4");
        newPositions.add(4, "5");
        newPositions.add(5, "6");
        newPositions.add(6, "7");
        newPositions.add(7, "8");
        newPositions.add(8, "9");
        Assert.assertFalse(Scorer.isGameWon(newPositions));
    }

    @Test
    public void itShouldReturnTrueIfStalemate() {
        List<String> availableSpots = new LinkedList<String>();
        Assert.assertTrue(Scorer.isGameStalemate(availableSpots));
    }

    @Test
    public void itShouldReturnFalseIfNotStalemate() {
        List<String> availableSpots = new LinkedList<String>();
        availableSpots.add("1");
        Assert.assertFalse(Scorer.isGameStalemate(availableSpots));
    }
}
