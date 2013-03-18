package spec;

import javattt.Board;
import javattt.MinimaxComputer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimaxComputerTest {

    @Test
    public void itShouldCyclePlayers() {
        String playerMark = "O";
        String otherPlayer = "X";
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals(otherPlayer, testComputer.cyclePlayers(playerMark));

    }

    @Test
    public void itShouldChooseObviousWin() {
        String playerMark = "X";
        Board gameBoard = new Board(new String[] {"1", "X", "X", "O", "X", "O", "O", "O", "X"});
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("1", testComputer.getMove(gameBoard));
    }

    @Test
    public void itShouldChooseARowWinIfItIsAvailable() {
        String playerMark = "X";
        ArrayList<String> positions = new ArrayList<String>();
        positions.add(0, "X");
        positions.add(1, "X");
        positions.add(2, "3");
        positions.add(3, "4");
        positions.add(4, "O");
        positions.add(5, "6");
        positions.add(6, "7");
        positions.add(7, "O");
        positions.add(8, "O");
        Board gameBoard = new Board(positions);
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("3", testComputer.getMove(gameBoard));

    }

    @Test
    public void itShouldChooseAColumnWinIfAvailable() {
        String playerMark = "X";
        ArrayList<String> positions = new ArrayList<String>();
        positions.add(0, "X");
        positions.add(1, "2");
        positions.add(2, "O");
        positions.add(3, "X");
        positions.add(4, "O");
        positions.add(5, "6");
        positions.add(6, "7");
        positions.add(7, "8");
        positions.add(8, "9");
        Board gameBoard = new Board(positions);
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("7", testComputer.getMove(gameBoard));
    }

    @Test
    public void itShouldChooseADiagonalWinIfAvailable() {
        String playerMark = "X";
        ArrayList<String> positions = new ArrayList<String>();
        positions.add(0, "1");
        positions.add(1, "2");
        positions.add(2, "X");
        positions.add(3, "4");
        positions.add(4, "X");
        positions.add(5, "O");
        positions.add(6, "O");
        positions.add(7, "O");
        positions.add(8, "X");
        Board gameBoard = new Board(positions);
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("1", testComputer.getMove(gameBoard));
    }

    @Test
    public void itShouldOptForImmediateWin() {
        String playerMark = "O";
        ArrayList<String> positions = new ArrayList<String>();
        positions.add(0, "X");
        positions.add(1, "2");
        positions.add(2, "X");
        positions.add(3, "O");
        positions.add(4, "O");
        positions.add(5, "6");
        positions.add(6, "X");
        positions.add(7, "8");
        positions.add(8, "9");
        Board gameBoard = new Board(positions);
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("6", testComputer.getMove(gameBoard));
    }

    @Test
    public void itShouldChooseAWinOverABlock() {
        String playerMark = "O";
        ArrayList<String> positions = new ArrayList<String>();
        positions.add(0, "X");
        positions.add(1, "X");
        positions.add(2, "3");
        positions.add(3, "4");
        positions.add(4, "X");
        positions.add(5, "6");
        positions.add(6, "O");
        positions.add(7, "O");
        positions.add(8, "9");
        Board gameBoard = new Board(positions);
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("9", testComputer.getMove(gameBoard));
    }
}
