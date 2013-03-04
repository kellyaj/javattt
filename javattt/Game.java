package javattt;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class Game {
    public Board gameBoard;
    private Printer gamePrinter;
    public Scorer gameScorer;
    public OutputHandler outPutter;
    public InputHandler inPutter;
    public MessageHandler messagePutter;
    public HumanPlayer theHuman;
    public EasyComputer theComputer;
    public Player currentPlayer;
    public Player player1;
    public Player player2;

    public Game(Board theBoard, OutputStream newOutStream, InputStream newInStream) {
        gameBoard = theBoard;
        outPutter = new OutputHandler(newOutStream);
        inPutter = new InputHandler(newInStream);
        gamePrinter = new Printer(outPutter);
        messagePutter = new MessageHandler(outPutter);
        gameScorer = new Scorer();
        theHuman = new HumanPlayer(new String("X"), inPutter, outPutter, messagePutter);
        theComputer = new EasyComputer();
        currentPlayer = theHuman;  // defaulting to this for now
        player1 = theHuman;
        player2 = theComputer;

    }

    public Game() {
        gameBoard = new Board();
        outPutter = new OutputHandler(System.out);
        inPutter = new InputHandler(System.in);
        messagePutter = new MessageHandler(outPutter);
        gamePrinter = new Printer(outPutter);
        gameScorer = new Scorer();
        theHuman = new HumanPlayer(new String("X"), inPutter, outPutter, messagePutter);
        theComputer = new EasyComputer();
        currentPlayer = theHuman;  // defaulting to this for now
        player1 = theHuman;
        player2 = theComputer;
    }

    public void printBoard() {
        gamePrinter.printBoard(gameBoard);
    }

    public String getPlayerMove() {
        return currentPlayer.getMove(gameBoard.availableSpots());
    }

    public void placePlayerMove() {
        gameBoard.placeMove(getPlayerMove(), currentPlayer.mark);
    }

    public void cyclePlayers() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean isGameOver() {
        if (gameScorer.isGameWon(gameBoard.getPositions())){
            messagePutter.winnerMessage(currentPlayer.mark);
            return true;
        } else if (gameScorer.isGameStalemate(gameBoard.availableSpots())) {
            messagePutter.stalemateMessage();
            return true;
        }
        return false;
    }

    public boolean isGameWon(HashMap<String, String> boardPositions) {
        return gameScorer.isGameWon(boardPositions);
    }

    public boolean isGameStalemate() {
        return gameScorer.isGameStalemate(gameBoard.availableSpots());
    }




}
