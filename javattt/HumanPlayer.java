package javattt;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer implements Player {
  //fields
  public String mark;
  public InputHandler inPutter;
  public OutputHandler outPutter;
  public MessageHandler messagePutter;


  // constructor
  public HumanPlayer(String playerMark, InputHandler newInPutter, OutputHandler newOutPutter, MessageHandler newMessagePutter) {
      //super(playerMark);
      mark = playerMark;
      inPutter = newInPutter;
      outPutter = newOutPutter;
      messagePutter = newMessagePutter;
  }
  public HumanPlayer() {
      //super(new String("X"));
      mark = "X";
      inPutter = new InputHandler(System.in);
      outPutter = new OutputHandler(System.out);
      messagePutter = new MessageHandler();
  }

  // methods
  public String getMove(Board gameBoard) {

    List<String> availableMoves = gameBoard.availableSpots();
    messagePutter.chooseMovePrompt();
    displayAvailableMoves(availableMoves);
    String chosenMove = inPutter.getInput();
      if (availableMoves.contains(chosenMove)) {
          return chosenMove;
      } else {
          messagePutter.invalidMoveMessage();
          messagePutter.chooseMovePrompt();
          this.getMove(gameBoard);   // choose move again
      }
     return chosenMove;
  }

    public String getMark() {
        return this.mark;
    }

    public void displayAvailableMoves(List<String> availableMoves) {
        String[] spotsArray = availableMoves.toArray(new String[0]);     // should I use ArrayList here? Array size issue
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
