package javattt;

import java.io.OutputStream;

public class OutputHandler {
    OutputStream stdout;

    public OutputHandler(OutputStream outputType) {
        stdout = outputType;
    }

    public String printOutput (String outputData) {
        // prints something
    }
}
