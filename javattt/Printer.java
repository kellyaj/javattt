package javattt;

public class Printer {

    public static boolean printBoard(OutputHandler outPutter, Board gameBoard) {
        String rowOne = " " + gameBoard.getPositions().get(0) + " | " + gameBoard.getPositions().get(1) + " | " + gameBoard.getPositions().get(2) + "\n";
        String rowTwo = " " + gameBoard.getPositions().get(3) + " | " + gameBoard.getPositions().get(4) + " | " + gameBoard.getPositions().get(5) + "\n";
        String rowThree = " " + gameBoard.getPositions().get(6) + " | " + gameBoard.getPositions().get(7) + " | " + gameBoard.getPositions().get(8) + "\n";
        outPutter.printOutput("\n");
        outPutter.printOutput(rowOne);
        outPutter.printOutput("-----------\n");
        outPutter.printOutput(rowTwo);
        outPutter.printOutput("-----------\n");
        outPutter.printOutput(rowThree);
        outPutter.printOutput(" \n\n");
        return true;
    }

}
