package javattt;

import java.io.OutputStream;
import java.io.PrintStream;


public class OutputHandler {
    PrintStream streamPrinter;

    public OutputHandler(OutputStream outputType) {
        streamPrinter = new PrintStream(outputType);
    }

    public OutputHandler() {
        streamPrinter = new PrintStream(System.out);
    }


    public void printOutput(String outputData) {
        streamPrinter.print(outputData);
    }


}
