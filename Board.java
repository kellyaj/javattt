import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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

  public List availableSpots(HashMap<String, String> gameHashMap) {
    String[] positionsArray = gameHashMap.values().toArray(new String[0]);
    List<String> untakenSpots = new LinkedList<String>();
    for (String position : positionsArray) {
      if (position.equals("X")){
        // do nothing
      } else {
        untakenSpots.add(position);
      }
    }
    return untakenSpots;
  }

  // this should probably be in the Game class or GameSetup class or something
  public static HashMap<String, String> createStandardBoard() {
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
    return positions;
  }

  // this thing
  public static void main(String[] args) {
    HashMap<String, String> positions = createStandardBoard();
    Board myBoard = new Board(positions);
    System.out.println(myBoard.positions);
    myBoard.placeMove("1", "X");
    System.out.println(myBoard.positions);
    boolean checkTaken = myBoard.isTaken("1");
    System.out.println(checkTaken);
    List testing = myBoard.availableSpots(myBoard.positions);
    System.out.println(testing);
  }
}
