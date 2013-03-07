package spec;

import javattt.InputHandler;
import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class InputHandlerTest {

    @Test
    public void itShouldGetInput() {
        String testMessage = "Frankenstein";
        InputHandler inPutter = new InputHandler(new ByteArrayInputStream(testMessage.getBytes()));
        System.out.println(inPutter.getInput());
    }

}
