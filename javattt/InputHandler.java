package javattt;


import java.io.InputStream;
import java.util.Scanner;

public class InputHandler {
    Scanner inputGrabber;

    public InputHandler(InputStream inputType){
        inputGrabber = new Scanner(inputType);
    }

    public InputHandler() {
        inputGrabber = new Scanner(System.in);
    }

    public String getInput() {
        return inputGrabber.nextLine();
    }
}
