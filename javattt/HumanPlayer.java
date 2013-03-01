package javattt;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {

  //fields
  public String mark;
  public InputHandler inPutter;
  public OutputHandler outPutter;
  public MessageHandler messagePutter;


  // constructor
  public HumanPlayer(String playerMark, InputHandler newInPutter, OutputHandler newOutPutter, MessageHandler newMessagePutter) {
      super(playerMark);
      inPutter = newInPutter;
      outPutter = newOutPutter;
      messagePutter = newMessagePutter;
  }
  public HumanPlayer() {
      super(new String("X"));
      inPutter = new InputHandler(System.in);
      outPutter = new OutputHandler(System.out);
      messagePutter = new MessageHandler();
  }

  // methods

  public String getMove(List<String> availableMoves) {
    messagePutter.chooseMovePrompt();
    displayAvailableMoves(availableMoves);
    String chosenMove = inPutter.getInput();
      if (availableMoves.contains(chosenMove)) {
          return chosenMove;
      } else {
          messagePutter.invalidMoveMessage();
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
