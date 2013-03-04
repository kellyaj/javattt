package javattt;

import org.junit.Assert;
import org.junit.Test;

public class MinimaxComputerTest {

    @Test
    public void itShouldCyclePlayers() {
        String playerMark = "O";
        String otherPlayer = "X";
        MinimaxComputer testComputer = new MinimaxComputer(playerMark);
        Assert.assertEquals(otherPlayer, testComputer.cyclePlayers(playerMark));

    }
}
