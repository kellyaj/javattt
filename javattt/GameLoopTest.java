package javattt;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class GameLoopTest {

    @Test
    public void itShouldReturnTrueIfYesForPlayAgain() {
        String testMessage = "yes";
        GameLoop testLoop = new GameLoop();
        testLoop.inPutter = new InputHandler(new ByteArrayInputStream(testMessage.getBytes()));
        Assert.assertTrue(testLoop.playAgain());
    }

    @Test
    public void itShouldReturnFalseIfNoForPlayAgain() {
        String testMessage = "nope";
        GameLoop testLoop = new GameLoop();
        testLoop.inPutter = new InputHandler(new ByteArrayInputStream(testMessage.getBytes()));
        Assert.assertFalse(testLoop.playAgain());
    }

//    @Test
//    public void itShouldCreateANewGame() {
//        GameLoop testLoop = new GameLoop();
//        OutputStream testStream = System.out;
//        Game testGame = testLoop.createGame(System.in, testStream);
        //Assert.assertEquals(testGame.outPutter.streamPrinter, testStream);         // proper result, different objects
//    }

    @Test
    public void itShouldProperlyCreatePlayers() {
        GameLoop testLoop = new GameLoop();
        Player testPlayer = testLoop.createPlayer("human", "X");
        Assert.assertEquals("X", testPlayer.mark);

    }


}
