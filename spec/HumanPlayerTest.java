package spec;
import javattt.*;
import junit.framework.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
;

public class HumanPlayerTest {
    @Test
    public void itShouldInitializeWithTheProperFields() {
        OutputHandler testOutPutter = new OutputHandler(System.out);
        InputHandler testInPutter = new InputHandler(System.in);
        MessageHandler testMessenger =  new MessageHandler(testOutPutter);
        String testMark = "X";
        HumanPlayer testHuman = new HumanPlayer(testMark, testInPutter, testOutPutter, testMessenger);
        Assert.assertEquals("X", testHuman.mark);
    }

    @Test
    public void itShouldInitializeWithDefaults() {
        String expectedMark = new String("X");
        HumanPlayer testHuman = new HumanPlayer();
        Assert.assertTrue(expectedMark.equals(testHuman.mark));
    }

    @Test
    public void itShouldProperlyGetInput() {
        OutputHandler testOutPutter = new OutputHandler(System.out);
        MessageHandler testMessenger =  new MessageHandler(testOutPutter);
        String testMessage = "Water";

        InputHandler testInPutter = new InputHandler(new ByteArrayInputStream(testMessage.getBytes()));
        String testMark = "X";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "Water");
        map.put("2", "Coffee");
        Board board = new Board(map);

        HumanPlayer testHuman = new HumanPlayer(testMark, testInPutter, testOutPutter, testMessenger);
        String receivedMessage = new String(testHuman.getMove(board));
        testOutPutter.printOutput(receivedMessage);

        Assert.assertEquals(receivedMessage, testMessage);

    }

//    @Test public void itShouldRecurseUponReceivingImproperInput() {
//        OutputHandler testOutPutter = new OutputHandler(System.out);
//        MessageHandler testMessenger =  new MessageHandler(testOutPutter);
//        String testMessage = new String("5\n7");
//        InputHandler testInPutter = new InputHandler(new ByteArrayInputStream(testMessage.getBytes()));
//        String testMark = "X";
//
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("1", "1");
//        map.put("2", "2");
//        map.put("7", "7");
//        Board board = new Board(map);
//
//
//        HumanPlayer testHuman = new HumanPlayer(testMark, testInPutter, testOutPutter, testMessenger);
//
//        String receivedMessage = new String(testHuman.getMove(board));
//
//        testOutPutter.printOutput(receivedMessage);
//        Assert.assertEquals("7", receivedMessage);
//    }


}
