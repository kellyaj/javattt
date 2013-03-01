package javattt;

public class MessageHandler {

    public OutputHandler outPutter;

    public MessageHandler(OutputHandler newOutPutter) {
        outPutter = newOutPutter;
    }

    public MessageHandler() {
        outPutter = new OutputHandler();
    }

    public void winnerMessage(String playerMark) {
        outPutter.printOutput(playerMark + " has won the game");
    }

    public void stalemateMessage() {
        outPutter.printOutput("The game has ended in a stalemate.");
    }

    public void chooseMovePrompt() {
        outPutter.printOutput("Please enter a number to choose a move: ");
    }

    public void invalidMoveMessage() {
        outPutter.printOutput("Invalid move.");
    }
}
