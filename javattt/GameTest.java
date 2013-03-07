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
        Player testPlayer = testGame.player1;
        Assert.assertTrue(testGame.currentPlayer == testPlayer);
    }

    @Test
    public void itShouldBeAbleToCyclePlayers() {
        testGame.cyclePlayers();
        Player testComputer = testGame.player2;
        Player testHuman = testGame.player1;
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
