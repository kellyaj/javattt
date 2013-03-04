package javattt;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Board {

  // fields
  private HashMap<String, String> positions;

  // constructor
  public Board(HashMap<String, String> startingSpots) {
    positions = startingSpots;
  }

  public Board() {
      HashMap<String, String> newPositions = new HashMap<String, String>();
      newPositions.put("1", "1");
      newPositions.put("2", "2");
      newPositions.put("3", "3");
      newPositions.put("4", "4");
      newPositions.put("5", "5");
      newPositions.put("6", "6");
      newPositions.put("7", "7");
      newPositions.put("8", "8");
      newPositions.put("9", "9");
      positions = newPositions;
  }

  // methods
  public HashMap<String, String> getPositions() {
      return this.positions;
  }

  public boolean placeMove(String chosenSpace, String playerMark) {
    this.positions.put(chosenSpace, playerMark);
    return true;
  }

  public boolean spotIsTaken(String chosenSpot) {
    String spotValue = this.positions.get(chosenSpot);
    if (spotValue.equals(chosenSpot))
      return false;
    return true;
  }

  public List availableSpots() {
    String[] positionsArray = this.positions.values().toArray(new String[0]);
    List<String> untakenSpots = new LinkedList<String>();
    for (String position : positionsArray) {
      if (position.equals("X") || position.equals("O")){
        // do nothing
      } else {
        untakenSpots.add(position);
      }
    }
    return untakenSpots;
  }


}
