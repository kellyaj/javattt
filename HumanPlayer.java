import java.util.Scanner;

public class HumanPlayer {

  //fields
  public String mark;
  Scanner in = new Scanner(System.in);


  // constructor
  public HumanPlayer(String playerMark) {
    mark = playerMark;
  }

  // methods

  public String getMove() {
    System.out.println("Please enter a number to choose a move: ");
    String chosenMove = in.nextLine();
    return chosenMove;
  }


  // void thing
  public static void main(String[] args) {
    HumanPlayer testHuman = new HumanPlayer("X");
    System.out.println(testHuman.mark);
    String theMove = testHuman.getMove();
    System.out.println("You Chose " + theMove);
  }
}
