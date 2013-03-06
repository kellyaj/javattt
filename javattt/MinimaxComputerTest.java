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

    @Test
    public void itShouldChooseAnyMove() {
            String playerMark = "O";
            Board testBoard = new Board();
            MinimaxComputer testComputer = new MinimaxComputer(playerMark);
            Assert.assertEquals("5", testComputer.getMove(testBoard));
    }
}
