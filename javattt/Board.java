package javattt;

import java.util.*;

public class Board {

  // fields
  private HashMap<String, String> positions;
  private String xPlayer;
  private String oPlayer;

  // constructor
  public Board(HashMap<String, String> startingSpots) {
    positions = startingSpots;
      xPlayer = "X";
      oPlayer = "O";
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
      xPlayer = "X";
      oPlayer = "O";
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
    return (spotValue.equals(chosenSpot));
  }

  public List availableSpots() {
    String[] positionsArray = this.positions.values().toArray(new String[0]);
    List<String> untakenSpots = new LinkedList<String>();
      // problem when positionsArray is empty?
      //ArrayList<String> testList = new ArrayList<String>(Arrays.asList(positionsArray));
      //if (testList.size() > 0) {
        for (String position : positionsArray) {
            System.out.println(position);
            if (position.equals(xPlayer)) {
              // do nothing
            } else if (position.equals(oPlayer)){
              // do nothing
            } else {
            untakenSpots.add(position);
            }
        }
      //}
    return untakenSpots;
  }


}
