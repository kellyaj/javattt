package javattt;


import java.io.InputStream;

public class InputHandler {
    InputStream stdin;

    public InputHandler(InputStream inputType){
        stdin = inputType;
    }

    public InputHandler() {
        stdin = System.in;
    }

//    public String getInput() {
//        // do something to get input
//    }
}
