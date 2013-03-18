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
        outPutter.printOutput(playerMark + " has won the game. \n");
    }

    public void stalemateMessage() {
        outPutter.printOutput("The game has ended in a stalemate. \n");
    }

    public void chooseMovePrompt() {
        outPutter.printOutput("Please enter a number to choose a move: \n");
    }

    public void invalidMoveMessage() {
        outPutter.printOutput("Invalid move. \n");
    }

    public void playAgainMessage() {
        outPutter.printOutput("Would you like to play again? Type 'yes' or 'no'\n");
    }

    public void firstPlayerMessage() {
        outPutter.printOutput("The first player is... type 'human' or 'computer'\n");
    }

    public void secondPlayerMessage() {
        outPutter.printOutput("The second player is... type 'human' or 'computer'\n");

    }

    public void boardSizeMessage() {
        outPutter.printOutput("Choose your board size: \n");
        outPutter.printOutput("1. 3x3 \n");
        outPutter.printOutput("2. 4x4 \n");
        outPutter.printOutput("Please enter '1' or '2' \n");
    }

    public void invalidBoardSizeMessage() {
        outPutter.printOutput("Invalid selection.\n");
    }

}
