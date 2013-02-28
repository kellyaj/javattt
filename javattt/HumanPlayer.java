package javattt;

import java.util.List;
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

  public String getMove(List<String> availableMoves) {
    outPutter.printOutput("Please enter a number to choose a move: ");
    displayAvailableMoves(availableMoves);
    String chosenMove = inPutter.getInput();
      if (availableMoves.contains(chosenMove)) {
          return chosenMove;
      } else {
          outPutter.printOutput("Incorrect Choice.");
          this.getMove(availableMoves);
      }
     return chosenMove;
  }

    public void displayAvailableMoves(List<String> availableMoves) {
        String[] spotsArray = availableMoves.toArray(new String[0]);
        String listString = "";
        for (String s : spotsArray) {
            listString += s + "\t";
        }
        outPutter.printOutput(listString);
    }

  // void thing
  public static void main(String[] args) {
  }
}
