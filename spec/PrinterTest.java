package spec;
import javattt.Board;
import javattt.Printer;
import org.junit.*;
import java.util.HashMap;

public class PrinterTest {
    @Test
    public void itShouldPrintTheBoard() {
        HashMap<String, String> positions = new HashMap<String, String>();
        positions.put("1", "1");
        positions.put("2", "2");
        positions.put("3", "3");
        positions.put("4", "4");
        positions.put("5", "5");
        positions.put("6", "6");
        positions.put("7", "7");
        positions.put("8", "8");
        positions.put("9", "9");
        Board gameBoard = new Board(positions);
        Printer boardPrinter = new Printer();
        Assert.assertTrue(boardPrinter.printBoard(gameBoard));
    }

}
