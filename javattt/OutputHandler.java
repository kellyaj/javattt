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

                 // this feels wrong to have it return a boolean, rather than void
    public boolean printOutput(String outputData) {
        streamPrinter.println(outputData);
        return true;
    }


}
