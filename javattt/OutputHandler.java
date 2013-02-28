package javattt;

import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputHandler {
    OutputStream stdout;
    PrintWriter printWriter;

    public OutputHandler(OutputStream outputType) {
        stdout = outputType;
    }
    public OutputHandler() {
        stdout = System.out;
    }

    public void printOutput (String outputData) {
        printWriter.print(outputData);
    }


}
