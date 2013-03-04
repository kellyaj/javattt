package javattt;

import junit.framework.Assert;
import org.junit.After;
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

    @After
    public void cleanStream() {
        outContent.reset();
    }

    @Test
    public void itShouldOutputSomething() {
        OutputHandler outPutter = new OutputHandler(System.out);
        String testMessage = "Choose a move: ";
        outPutter.printOutput(testMessage);
        Assert.assertEquals(outContent.toString(), testMessage);
    }

    @Test
    public void itShouldDefaultToSystemOut() {
        OutputHandler outPutter = new OutputHandler();
        String testMessage = "Hello World";
        outPutter.printOutput(testMessage);
        Assert.assertEquals(outContent.toString(), testMessage);
    }
}
