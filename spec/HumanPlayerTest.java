package spec;

import javattt.HumanPlayer;
import javattt.InputHandler;
import javattt.MessageHandler;
import javattt.OutputHandler;
import junit.framework.Assert;
import org.junit.Test;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HumanPlayerTest {
    @Test
    public void itShouldInitializeWithTheProperFields() {
        OutputHandler testOutPutter = new OutputHandler(System.out);
        InputHandler testInPutter = new InputHandler(System.in);
        MessageHandler testMessenger =  new MessageHandler(testOutPutter);
        String testMark = "X";
        HumanPlayer testHuman = new HumanPlayer(testMark, testInPutter, testOutPutter, testMessenger);
        //Assert.assertEquals("X", testHuman.mark);
    }

    @Test
    public void itShouldInitializeWithDefaults() {
        String expectedMark = new String("X");
        HumanPlayer testHuman = new HumanPlayer();
        //Assert.assertTrue(expectedMark.equals(testHuman.mark));
    }

    @Test
    public void itShouldProperlyGetInput() {
        OutputHandler testOutPutter = new OutputHandler(System.out);
        MessageHandler testMessenger =  new MessageHandler(testOutPutter);
        String testMessage = "Water";
        InputHandler testInPutter = new InputHandler(new ByteArrayInputStream(testMessage.getBytes()));
        String testMark = "X";
        List<String> testList = new LinkedList<String>();
        testList.add("Water");
        testList.add("Coffee");
        HumanPlayer testHuman = new HumanPlayer(testMark, testInPutter, testOutPutter, testMessenger);
        String receivedMessage = new String(testHuman.getMove(testList));
        testOutPutter.printOutput(receivedMessage);
        Assert.assertEquals(receivedMessage, testMessage);

    }

    @Test public void itShouldRecurseUponReceivingImproperInput() {
        OutputHandler testOutPutter = new OutputHandler(System.out);
        // need a way to send a second message here
        MessageHandler testMessenger =  new MessageHandler(testOutPutter);
        String testMessage = new String("5\n7");
        InputHandler testInPutter = new InputHandler(new ByteArrayInputStream(testMessage.getBytes()));
        String testMark = "X";
        List<String> testList = new LinkedList<String>();
        testList.add("1");
        testList.add("2");
        testList.add("7");
        HumanPlayer testHuman = new HumanPlayer(testMark, testInPutter, testOutPutter, testMessenger);
        String receivedMessage = new String(testHuman.getMove(testList));
        testOutPutter.printOutput(receivedMessage);
        //Assert.assertEquals("7", receivedMessage);
    }


}
