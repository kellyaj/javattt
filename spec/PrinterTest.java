package spec;
import javattt.Board;
import javattt.OutputHandler;
import javattt.Printer;
import org.junit.*;


public class PrinterTest {
    @Test
    public void itShouldPrintTheBoard() {
        Board gameBoard = new Board(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});
        Assert.assertTrue(Printer.printBoard(new OutputHandler(), gameBoard));
    }

}
