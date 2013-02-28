package javattt;

import java.util.Scanner;

public class HumanPlayer {

  //fields
  public String mark;
  public InputHandler inPutter;
  public OutputHandler outPutter;


  // constructor
  public HumanPlayer(String playerMark, InputHandler NewInPutter, OutputHandler NewOutPutter) {
      mark = playerMark;
      inPutter = NewInPutter;
      outPutter = NewOutPutter;
  }
  public HumanPlayer() {
      mark = new String("X");
      inPutter = new InputHandler(System.in);
      outPutter = new OutputHandler(System.out);
  }

  // methods

  public String getMove() {
    outPutter.printOutput("Please enter a number to choose a move: ");
    String chosenMove = inPutter.getInput();
    return chosenMove;
  }


  // void thing
  public static void main(String[] args) {
  }
}
