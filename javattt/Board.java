package javattt;

import java.util.*;

public class Board {

    // fields
    private ArrayList<String> positions;
    private static String x = "X";
    private static String o = "O";

    // constructor
    public Board(ArrayList<String> startingSpots) {
        positions = startingSpots;
    }

    public Board() {
        positions = new ArrayList<String>();
        positions.add(0, "1");
        positions.add(1, "2");
        positions.add(2, "3");
        positions.add(3, "4");
        positions.add(4, "5");
        positions.add(5, "6");
        positions.add(6, "7");
        positions.add(7, "8");
        positions.add(8, "9");
    }

    public Board(String[] spots) {
        positions = new ArrayList<String>();
        for (int i=0; i < spots.length; i++) {
            positions.add(i, spots[i]);
        }
    }

    // methods
    public ArrayList<String> getPositions() {
        return this.positions;
    }

    public boolean placeMove(String chosenSpace, String playerMark) {
        this.positions.set((Integer.parseInt(chosenSpace)-1), playerMark);
        return true;
    }

    public List<String> availableSpots() {
        String[] positionsArray = this.positions.toArray(new String[positions.size()]);
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

    public int getRowSize() {
        int[] divisors = new int[] {3, 4, 5, 6, 7, 8, 9};
        for (int i : divisors) {
            if (positions.size() % i == 0) {
                return i;
            }

        }
        return 0;
    }


}
