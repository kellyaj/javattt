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
    private Player firstPlayer;
    private Player secondPlayer;
    private Player[] chosenPlayers;

    public GameLoop(InputStream newInputStream, OutputStream newOutStream) {
        inPutter = new InputHandler(newInputStream);
        outPutter = new OutputHandler(newOutStream);
        inPutterStream = newInputStream;
        outPutterStream = newOutStream;
        messagePutter = new MessageHandler(outPutter);
        Player[] chosenPlayers = choosePlayers();
        currentGame = createGame(newInputStream, newOutStream, chosenPlayers[0], chosenPlayers[1]);
    }

    public GameLoop() {
        inPutter = new InputHandler(System.in);
        outPutter = new OutputHandler(System.out);
        inPutterStream = System.in;
        outPutterStream = System.out;
        messagePutter = new MessageHandler(outPutter);
        Player[] chosenPlayers = choosePlayers();
        currentGame = createGame(inPutterStream, outPutterStream, chosenPlayers[0], chosenPlayers[1]);
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
            System.out.println("got here");
            playGame(createGame(inPutterStream, outPutterStream, chosenPlayers[0], chosenPlayers[1]));
        }
    }

    public boolean playAgain() {
        messagePutter.playAgainMessage();
        String response = inPutter.getInput();
        return response.equals("yes");
    }

    public Game createGame(InputStream gameInputStream, OutputStream gameOutputStream, Player gameFirstPlayer, Player gameSecondPlayer) {
        return new Game(new Board(),gameInputStream, gameOutputStream, gameFirstPlayer, gameSecondPlayer);
    }

    public Player[] choosePlayers() {
        chosenPlayers = new Player[2];
        messagePutter.firstPlayerMessage();
        chosenPlayers[0] = createPlayer(inPutter.getInput(), "X");
        messagePutter.secondPlayerMessage();
        chosenPlayers[1] = createPlayer(inPutter.getInput(), "O");
        return chosenPlayers;
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
