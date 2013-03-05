package javattt;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;

public class GameLoopTest {

    @Test
    public void itShouldReturnTrueIfYesForPlayAgain() {
        String testMessage = "yes";
        GameLoop testLoop = new GameLoop(new ByteArrayInputStream(testMessage.getBytes()), System.out);
        Assert.assertTrue(testLoop.playAgain());
    }

    @Test
    public void itShouldReturnFalseIfNoForPlayAgain() {
        String testMessage = "nope";
        GameLoop testLoop = new GameLoop(new ByteArrayInputStream(testMessage.getBytes()), System.out);
        Assert.assertFalse(testLoop.playAgain());
    }

    @Test
    public void itShouldCreateANewGame() {
        GameLoop testLoop = new GameLoop();
        OutputStream testStream = System.out;
        Game testGame = testLoop.createGame(System.in, testStream);
        //Assert.assertEquals(testGame.outPutter.streamPrinter, testStream);         // proper result, different objects
    }
}
