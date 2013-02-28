package javattt;

import java.io.InputStream;
import java.io.OutputStream;

public class Game {
    public Board gameBoard;
    public Printer gamePrinter;
    public Scorer gameScorer;
    public OutputHandler outPutter;
    public InputHandler inPutter;
    public HumanPlayer theHuman;
    public EasyComputer theComputer;
    public Player currentPlayer;      // trying to do some Polymorphism magic

    public Game(Board theBoard, OutputStream newOutStream, InputStream newInStream) {
        gameBoard = theBoard;
        outPutter = new OutputHandler(newOutStream);
        inPutter = new InputHandler(newInStream);
        gamePrinter = new Printer(outPutter);
        gameScorer = new Scorer();
        theHuman = new HumanPlayer(new String("X"), inPutter, outPutter);
        theComputer = new EasyComputer();
        currentPlayer = theHuman;  // defaulting to this for now

    }

    public Game() {
        gameBoard = new Board();
        outPutter = new OutputHandler(System.out);
        inPutter = new InputHandler(System.in);
        gamePrinter = new Printer(outPutter);
        gameScorer = new Scorer();
        theHuman = new HumanPlayer(new String("X"), inPutter, outPutter);
        theComputer = new EasyComputer();
        currentPlayer = theHuman;  // defaulting to this for now
    }

    public void printBoard() {
        gamePrinter.printBoard(gameBoard);
    }

    public String getPlayerMove() {
        return currentPlayer.getMove(gameBoard.availableSpots(gameBoard.getPositions()));
    }




}
