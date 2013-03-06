package javattt;

import org.junit.Assert;
import org.junit.Test;

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
        HashMap<String, String> positions = new HashMap<String, String>();
        positions.put("1", "1");
        positions.put("2", "X");
        positions.put("3", "X");
        positions.put("4", "O");
        positions.put("5", "X");
        positions.put("6", "O");
        positions.put("7", "O");
        positions.put("8", "O");
        positions.put("9", "X");
        Board gameBoard = new Board(positions);
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("1", testComputer.getMove(gameBoard));
    }

    @Test
    public void itShouldChooseARowWinIfItIsAvailable() {
        String playerMark = "X";
        HashMap<String, String> positions = new HashMap<String, String>();
        positions.put("1", "X");
        positions.put("2", "X");
        positions.put("3", "3");
        positions.put("4", "4");
        positions.put("5", "O");
        positions.put("6", "6");
        positions.put("7", "7");
        positions.put("8", "O");
        positions.put("9", "O");
        Board gameBoard = new Board(positions);
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("3", testComputer.getMove(gameBoard));

    }

    @Test
    public void itShouldChooseAColumnWinIfAvailable() {
        String playerMark = "X";
        HashMap<String, String> positions = new HashMap<String, String>();
        positions.put("1", "X");
        positions.put("2", "2");
        positions.put("3", "O");
        positions.put("4", "X");
        positions.put("5", "O");
        positions.put("6", "6");
        positions.put("7", "7");
        positions.put("8", "8");
        positions.put("9", "9");
        Board gameBoard = new Board(positions);
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("7", testComputer.getMove(gameBoard));
    }

    @Test
    public void itShouldChooseADiagonalWinIfAvailable() {
        String playerMark = "X";
        HashMap<String, String> positions = new HashMap<String, String>();
        positions.put("1", "1");
        positions.put("2", "2");
        positions.put("3", "X");
        positions.put("4", "4");
        positions.put("5", "X");
        positions.put("6", "O");
        positions.put("7", "O");
        positions.put("8", "O");
        positions.put("9", "X");
        Board gameBoard = new Board(positions);
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("1", testComputer.getMove(gameBoard));
    }

    @Test
    public void itShouldOptForImmediateWin() {
        String playerMark = "O";
        HashMap<String, String> positions = new HashMap<String, String>();
        positions.put("1", "X");
        positions.put("2", "2");
        positions.put("3", "X");
        positions.put("4", "O");
        positions.put("5", "O");
        positions.put("6", "6");
        positions.put("7", "X");
        positions.put("8", "8");
        positions.put("9", "9");
        Board gameBoard = new Board(positions);
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("6", testComputer.getMove(gameBoard));
    }

    @Test
    public void itShouldChooseAWinOverABlock() {
        String playerMark = "O";
        HashMap<String, String> positions = new HashMap<String, String>();
        positions.put("1", "X");
        positions.put("2", "X");
        positions.put("3", "3");
        positions.put("4", "4");
        positions.put("5", "X");
        positions.put("6", "6");
        positions.put("7", "O");
        positions.put("8", "O");
        positions.put("9", "9");
        Board gameBoard = new Board(positions);
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals("9", testComputer.getMove(gameBoard));
    }
}
