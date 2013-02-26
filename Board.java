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
    if (spotValue.equals(null))
      return false;
    return true;
  }

  // this thing
  public static void main(String[] args) {
    HashMap<String, String> positions = new HashMap<String, String>();
    positions.put("1", null);
    positions.put("2", null);
    positions.put("3", null);
    positions.put("4", null);
    positions.put("5", null);
    positions.put("6", null);
    positions.put("7", null);
    positions.put("8", null);
    positions.put("9", null);
    Board myBoard = new Board(positions);
    System.out.println(myBoard.positions);
    myBoard.placeMove("1", "X");
    System.out.println(myBoard.positions);
    boolean checkTaken = myBoard.isTaken("1");
    System.out.println(checkTaken);
  }
}
