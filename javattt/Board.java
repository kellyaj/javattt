package javattt;

import java.util.*;

public class Board {

    // fields
    private HashMap<String, String> positions;
    private static String x = "X";
    private static String o = "O";

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

    public Board(String[] spots) {
        positions = new HashMap<String, String>();
        for (int i=0; i < spots.length; i++) {
            positions.put(Integer.toString(i+1), spots[i]);
        }
    }

    // methods
    public HashMap<String, String> getPositions() {
        return this.positions;
    }

    public boolean placeMove(String chosenSpace, String playerMark) {
        this.positions.put(chosenSpace, playerMark);
        return true;
    }

    public List<String> availableSpots() {
        String[] positionsArray = this.positions.values().toArray(new String[0]);
        List<String> untakenSpots = new LinkedList<String>();
        for (String position : positionsArray) {
            if (position.equals(x)) {
                // do nothing
            } else if (position.equals(o)){
                // do nothing
            } else {
                untakenSpots.add(position);
            }
        }
        return untakenSpots;
    }


}
