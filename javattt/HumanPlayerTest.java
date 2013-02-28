package javattt;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class HumanPlayerTest {
    @Test
    public void itShouldInitializeWithTheProperFields() {
        OutputHandler testOutPutter = new OutputHandler(System.out);
        InputHandler testInPutter = new InputHandler(System.in);
        String testMark = new String("X");
        HumanPlayer testHuman = new HumanPlayer(testMark, testInPutter, testOutPutter);
        Assert.assertEquals("X", testHuman.mark);
    }

    @Test
    public void itShouldInitializeWithDefaults() {
        String expectedMark = new String("X");
        HumanPlayer testHuman = new HumanPlayer();
        Assert.assertEquals(expectedMark, testHuman.mark);
    }

    @Test
    public void itShouldProperlyGetInput() {
        OutputHandler testOutPutter = new OutputHandler(System.out);
        String testMessage = new String("Water");
        InputHandler testInPutter = new InputHandler(new ByteArrayInputStream(testMessage.getBytes()));
        String testMark = new String("X");
        HumanPlayer testHuman = new HumanPlayer(testMark, testInPutter, testOutPutter);
        String receivedMessage = new String(testHuman.getMove());
        testOutPutter.printOutput(receivedMessage);
        Assert.assertEquals(receivedMessage, testMessage);

    }
}
