package spec;

import javattt.EasyComputer;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

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
        List<String> availableSpots = new LinkedList<String>();
        availableSpots.add("1");
        availableSpots.add("2");
        availableSpots.add("3");
        availableSpots.add("4");
        availableSpots.add("5");
        availableSpots.add("6");
        String chosenMove = computerPlayer.getMove(availableSpots);
        Assert.assertTrue(availableSpots.contains(chosenMove));
    }
}
