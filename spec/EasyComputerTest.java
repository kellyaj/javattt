package spec;

import javattt.Board;
import javattt.EasyComputer;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EasyComputerTest {

    public EasyComputer computerPlayer;

    @Before
    public void initialize() {
        computerPlayer = new EasyComputer();
    }

    @Test
    public void itShouldPickRandomly() {
        HashMap<String, String> availableSpots = new HashMap<String, String>();
        availableSpots.put("1", "1");
        availableSpots.put("2", "2");
        availableSpots.put("3", "3");
        availableSpots.put("4", "4");
        availableSpots.put("5", "5");
        availableSpots.put("6", "6");
        Board board = new Board(availableSpots);
        String chosenMove = computerPlayer.getMove(board);
        Assert.assertTrue(board.availableSpots().contains(chosenMove));
    }
}
