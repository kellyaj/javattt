package javattt;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class GameTest {

    public Game testGame;

    @Before
    public void initialize() {
        testGame = new Game();
    }


    @Test
    public void itShouldHaveProperInitializedThings() {
        HumanPlayer testPlayer = testGame.theHuman;
        Assert.assertTrue(testGame.currentPlayer == testPlayer);
    }

    @Test
    public void itShouldBeAbleToCyclePlayers() {
        testGame.cyclePlayers();
        EasyComputer testComputer = testGame.theComputer;
        HumanPlayer testHuman = testGame.theHuman;
        Assert.assertEquals(testGame.currentPlayer, testComputer);
        testGame.cyclePlayers();
        Assert.assertEquals(testGame.currentPlayer, testHuman);
    }

    @Test
    public void itShouldBeAbleToProperlyPlaceAMove() {
        testGame.cyclePlayers();
        testGame.placePlayerMove();
        HashMap<String, String> testMap = testGame.gameBoard.getPositions();
        Assert.assertTrue(testMap.containsValue("O"));
    }
}
