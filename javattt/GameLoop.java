package javattt;


import java.io.InputStream;
import java.io.OutputStream;

public class GameLoop {
    private static Game currentGame;
    public OutputHandler outPutter;
    public InputHandler inPutter;
    private MessageHandler messagePutter;
    public InputStream inPutterStream;
    public OutputStream outPutterStream;
    private Player[] chosenPlayers;

    public GameLoop(InputStream newInputStream, OutputStream newOutStream) {
        inPutter = new InputHandler(newInputStream);
        outPutter = new OutputHandler(newOutStream);
        inPutterStream = newInputStream;
        outPutterStream = newOutStream;
        messagePutter = new MessageHandler(outPutter);
        Player[] chosenPlayers = choosePlayers();
        currentGame = createGame(chooseBoard(), newInputStream, newOutStream, chosenPlayers[0], chosenPlayers[1]);
    }

    public GameLoop() {
        inPutter = new InputHandler(System.in);
        outPutter = new OutputHandler(System.out);
        inPutterStream = System.in;
        outPutterStream = System.out;
        messagePutter = new MessageHandler(outPutter);
        Player[] chosenPlayers = choosePlayers();
        currentGame = createGame(chooseBoard(), inPutterStream, outPutterStream, chosenPlayers[0], chosenPlayers[1]);
    }

    public void startGame(Game currentGame) {
        this.playGame(currentGame);
    }

    public void playGame(Game theGame) {
        while (!theGame.isGameOver(theGame.gameBoard)) {
              theGame.printBoard();
              theGame.placePlayerMove();
              if (theGame.isGameOver(theGame.gameBoard)) {
                  theGame.printBoard();
                  break;
              }
              theGame.cyclePlayers();
        }
        if (playAgain()) {
            playGame(createGame(chooseBoard(), inPutterStream, outPutterStream, chosenPlayers[0], chosenPlayers[1]));
        }
    }

    public boolean playAgain() {
        messagePutter.playAgainMessage();
        String response = inPutter.getInput();
        return response.equals("yes");
    }

    public Game createGame(Board newBoard, InputStream gameInputStream, OutputStream gameOutputStream, Player gameFirstPlayer, Player gameSecondPlayer) {
        return new Game(newBoard, gameInputStream, gameOutputStream, gameFirstPlayer, gameSecondPlayer);
    }

    public Player[] choosePlayers() {
        chosenPlayers = new Player[2];
        messagePutter.firstPlayerMessage();
        chosenPlayers[0] = createPlayer(inPutter.getInput(), "X");
        messagePutter.secondPlayerMessage();
        chosenPlayers[1] = createPlayer(inPutter.getInput(), "O");
        return chosenPlayers;
    }

    public Board chooseBoard() {
        messagePutter.boardSizeMessage();
        String boardChoice = inPutter.getInput();
        if (boardChoice.equals("1")) {
            return new Board();
        } else if (boardChoice.equals("2")) {
            String[] spots = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
            return new Board(spots);
        } else {
            messagePutter.invalidBoardSizeMessage();
            return this.chooseBoard();
        }
    }

    public Player createPlayer(String rawUserChoice, String playerMark) {
        if (rawUserChoice.equals("human")) {
            return new HumanPlayer(playerMark, inPutter, outPutter, messagePutter);
        } else {
            return new MinimaxComputer(playerMark);
        }
    }

    public static void main(String[] args) {
        GameLoop theLoop = new GameLoop();
        theLoop.startGame(currentGame);

    }

}
