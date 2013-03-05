package javattt;


import java.io.InputStream;
import java.io.OutputStream;

public class GameLoop {
    private Game currentGame;
    private OutputHandler outPutter;
    private InputHandler inPutter;
    private MessageHandler messagePutter;
    private InputStream inPutterStream;
    private OutputStream outPutterStream;

    public GameLoop(InputStream newInputStream, OutputStream newOutStream) {
        inPutter = new InputHandler(newInputStream);
        outPutter = new OutputHandler(newOutStream);
        inPutterStream = newInputStream;
        outPutterStream = newOutStream;
        messagePutter = new MessageHandler(outPutter);
        currentGame = createGame(newInputStream, newOutStream);
    }

    public GameLoop() {
        inPutter = new InputHandler(System.in);
        outPutter = new OutputHandler(System.out);
        inPutterStream = System.in;
        outPutterStream = System.out;
        currentGame = new Game();
        messagePutter = new MessageHandler(outPutter);
    }

    public void startGame(Game currentGame) {
        this.playGame(currentGame);
    }

    public void playGame(Game theGame) {
        while (!theGame.isGameOver()) {
              theGame.printBoard();
              theGame.placePlayerMove();
              if (theGame.isGameOver()) {
                  theGame.printBoard();
                  break;
              }
              theGame.cyclePlayers();
        }
        if (playAgain()) {
            playGame(createGame(inPutterStream, outPutterStream));
        }
    }

    public boolean playAgain() {
        messagePutter.playAgainMessage();
        String response = inPutter.getInput();
        return response.equals("yes");
    }

    public Game createGame(InputStream gameInputStream, OutputStream gameOutputStream) {
        return new Game(new Board(),gameInputStream, gameOutputStream);
    }

}
