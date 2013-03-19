package javattt;

public class Printer {

    public static boolean printBoard(OutputHandler outPutter, Board gameBoard) {
        if (gameBoard.getPositions().size() == 9) {
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
        } else if (gameBoard.getPositions().size() == 16) {
            String rowOne = " " + gameBoard.getPositions().get(0) + "   |   " + gameBoard.getPositions().get(1) + "   |   " + gameBoard.getPositions().get(2) + "   |   " + gameBoard.getPositions().get(3) + "\n";
            String rowTwo = " " + gameBoard.getPositions().get(4) + "   |   " + gameBoard.getPositions().get(5) + "    |   " + gameBoard.getPositions().get(6) + "   |   " + gameBoard.getPositions().get(7) + "\n";
            String rowThree = " " + gameBoard.getPositions().get(8) + "   |   " + gameBoard.getPositions().get(9) + "  |   " + gameBoard.getPositions().get(10) + "  |   " + gameBoard.getPositions().get(11) + "\n";
            String rowFour = " " + gameBoard.getPositions().get(12) + "  |   " + gameBoard.getPositions().get(13) + "  |   " + gameBoard.getPositions().get(14) + "  |   " + gameBoard.getPositions().get(15) + "\n";
            outPutter.printOutput("\n");
            outPutter.printOutput(rowOne);
            outPutter.printOutput("----------------------------\n");
            outPutter.printOutput(rowTwo);
            outPutter.printOutput("----------------------------\n");
            outPutter.printOutput(rowThree);
            outPutter.printOutput("----------------------------\n");
            outPutter.printOutput(rowFour);
            outPutter.printOutput(" \n\n");
            return true;
        }
        return true;
    }

}
