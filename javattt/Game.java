package javattt;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class Game {
    public Board gameBoard;
    private Printer gamePrinter;
    public OutputHandler outPutter;
    public InputHandler inPutter;
    public MessageHandler messagePutter;
    public Player currentPlayer;
    public Player player1;
    public Player player2;

    public Game(Board theBoard,InputStream newInStream, OutputStream newOutStream, Player firstPlayer, Player secondPlayer) {
        gameBoard = theBoard;
        outPutter = new OutputHandler(newOutStream);
        inPutter = new InputHandler(newInStream);
        gamePrinter = new Printer(outPutter);
        messagePutter = new MessageHandler(outPutter);
        player1 = firstPlayer;
        player2 = secondPlayer;
        currentPlayer = firstPlayer;

    }

    public Game() {
        gameBoard = new Board();
        outPutter = new OutputHandler(System.out);
        inPutter = new InputHandler(System.in);
        messagePutter = new MessageHandler(outPutter);
        gamePrinter = new Printer(outPutter);
        player1 = new HumanPlayer(new String("X"), inPutter, outPutter, messagePutter);
        player2 = new MinimaxComputer();
        currentPlayer = player1;
    }

    public void printBoard() {
        gamePrinter.printBoard(gameBoard);
    }

    public String getPlayerMove() {
        return currentPlayer.getMove(gameBoard);
    }

    public void placePlayerMove() {
        gameBoard.placeMove(getPlayerMove(), currentPlayer.getMark());
    }

    public void cyclePlayers() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean isGameOver(Board gameBoard) {
        boolean result = Scorer.isGameOver(gameBoard.getPositions(), gameBoard.availableSpots());
        if (Scorer.isGameWon(gameBoard.getPositions())) {
            messagePutter.winnerMessage(currentPlayer.getMark());
        } else if (Scorer.isGameStalemate(gameBoard.availableSpots())) {
            messagePutter.stalemateMessage();
        }
        return result;
    }

    public boolean isGameWon(HashMap<String, String> boardPositions) {
        return Scorer.isGameWon(boardPositions);
    }

    public boolean isGameStalemate() {
        return Scorer.isGameStalemate(gameBoard.availableSpots());
    }




}
