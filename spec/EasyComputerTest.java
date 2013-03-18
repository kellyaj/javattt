package spec;

import javattt.Board;
import javattt.EasyComputer;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
        ArrayList<String> availableSpots = new ArrayList<String>();
        availableSpots.add(0, "1");
        availableSpots.add(1, "2");
        availableSpots.add(2, "3");
        availableSpots.add(3, "4");
        availableSpots.add(4, "5");
        availableSpots.add(5, "6");
        Board board = new Board(availableSpots);
        String chosenMove = computerPlayer.getMove(board);
        Assert.assertTrue(board.availableSpots().contains(chosenMove));
    }
}
