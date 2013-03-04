package javattt;


public class GameLoop {
    private Game currentGame;
    private OutputHandler outPutter;
    private InputHandler inPutter;

    public GameLoop(InputHandler newInPutter, OutputHandler newOutPutter) {
        inPutter = newInPutter;
        outPutter = newOutPutter;
    }

    public GameLoop() {
        inPutter = new InputHandler();
        outPutter = new OutputHandler();
        currentGame = new Game();
    }

    public void start_game() {
        this.play_game();
    }

    public void play_game() {
        while (!currentGame.isGameOver()) {
              currentGame.printBoard();
              currentGame.placePlayerMove();
              if (currentGame.isGameOver()) {
                  currentGame.printBoard();
                  break;
              }
              currentGame.cyclePlayers();
        }
        // check play again
    }

}
