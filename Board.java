import java.util.HashMap;

public class Board {

  // fields
  public HashMap<String, String> positions;

  // constructor
  public Board(HashMap<String, String> startingSpots) {
    positions = startingSpots;
  }

  // methods

  public boolean placeMove(String chosenSpace, String playerMark) {
    this.positions.put(chosenSpace, playerMark);
    return true;
  }

  public boolean isTaken(String chosenSpot) {
    String spotValue = this.positions.get(chosenSpot);
    if (spotValue.equals(chosenSpot))
      return false;
    return true;
  }

  // this thing
  public static void main(String[] args) {
    HashMap<String, String> positions = new HashMap<String, String>();
    positions.put("1", "1");
    positions.put("2", "2");
    positions.put("3", "3");
    positions.put("4", "4");
    positions.put("5", "5");
    positions.put("6", "6");
    positions.put("7", "7");
    positions.put("8", "8");
    positions.put("9", "9");
    Board myBoard = new Board(positions);
    System.out.println(myBoard.positions);
    myBoard.placeMove("1", "X");
    System.out.println(myBoard.positions);
    boolean checkTaken = myBoard.isTaken("1");
    System.out.println(checkTaken);
  }
}
