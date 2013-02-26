import java.util.HashMap;

public class Printer {

  // how do I deal with output stuff in Java?

  // constructor
  public Printer() {
  }

  public boolean printBoard(Board gameBoard) {
    String rowOne = " " + gameBoard.positions.get("1") + " | " + gameBoard.positions.get("2") + " | " + gameBoard.positions.get("3");
    String rowTwo = " " + gameBoard.positions.get("4") + " | " + gameBoard.positions.get("5") + " | " + gameBoard.positions.get("6");
    String rowThree = " " + gameBoard.positions.get("7") + " | " + gameBoard.positions.get("8") + " | " + gameBoard.positions.get("9");
    System.out.println(rowOne);
    System.out.println("-----------");
    System.out.println(rowTwo);
    System.out.println("-----------");
    System.out.println(rowThree);
    return true;
  }

  // void thing
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
    Printer myPrinter = new Printer();
    myPrinter.printBoard(myBoard);
  }
}
