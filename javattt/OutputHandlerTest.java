package javattt;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputHandlerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void itShouldOutputSomething() {
        OutputHandler outPutter = new OutputHandler(System.out);
        String testMessage = "Choose a move";
        final String realOutput = outContent.toString();
        Assert.assertEquals(realOutput, outPutter.printOutput(testMessage));
        outContent.reset();
    }

    @Test
    public void itShouldDefaultToSystemOut() {
        OutputHandler outPutter = new OutputHandler();
        String testMessage = "Hello World";
        final String realOutput = outContent.toString();
        Assert.assertEquals(realOutput, outPutter.printOutput(testMessage));
        outContent.reset();
    }
}
