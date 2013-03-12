package javattt;

import java.util.List;

public class HumanPlayer implements Player {
    //fields
    public String mark;
    public InputHandler inPutter;
    public OutputHandler outPutter;
    public MessageHandler messagePutter;


    // constructor
    public HumanPlayer(String playerMark, InputHandler newInPutter, OutputHandler newOutPutter, MessageHandler newMessagePutter) {
        mark = playerMark;
        inPutter = newInPutter;
        outPutter = newOutPutter;
        messagePutter = newMessagePutter;
    }
    public HumanPlayer() {
        mark = "X";
        inPutter = new InputHandler(System.in);
        outPutter = new OutputHandler(System.out);
        messagePutter = new MessageHandler();
    }

    // methods
    public String getMove(Board gameBoard) {
        List<String> availableMoves = gameBoard.availableSpots();
        messagePutter.chooseMovePrompt();
        String chosenMove = inPutter.getInput();
        if (!availableMoves.contains(chosenMove)) {
            messagePutter.invalidMoveMessage();
            chosenMove = this.getMove(gameBoard);
        }
        return chosenMove;
    }


    public String getMark() {
        return this.mark;
    }

    public void displayAvailableMoves(List<String> availableMoves) {
        String[] spotsArray = availableMoves.toArray(new String[0]);
        String listString = "";
        for (String s : spotsArray) {
            listString += s + "\t";
        }
        outPutter.printOutput(listString);
        outPutter.printOutput(" \n");
    }

}
