package javattt;

import java.util.HashMap;

public class Printer {

  // how do I deal with output stuff in Java?

  // constructor
  public Printer() {
  }

  public boolean printBoard(Board gameBoard) {
    String rowOne = " " + gameBoard.getPositions().get("1") + " | " + gameBoard.getPositions().get("2") + " | " + gameBoard.getPositions().get("3");
    String rowTwo = " " + gameBoard.getPositions().get("4") + " | " + gameBoard.getPositions().get("5") + " | " + gameBoard.getPositions().get("6");
    String rowThree = " " + gameBoard.getPositions().get("7") + " | " + gameBoard.getPositions().get("8") + " | " + gameBoard.getPositions().get("9");
    System.out.println(rowOne);
    System.out.println("-----------");
    System.out.println(rowTwo);
    System.out.println("-----------");
    System.out.println(rowThree);
    return true;
  }

  // void thing
  public static void main(String[] args) {
    // nothing here either
  }
}