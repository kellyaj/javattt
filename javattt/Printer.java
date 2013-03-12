package javattt;

public class Printer {

    public OutputHandler outPutter;

    public Printer(OutputHandler newOutPutter) {
        outPutter = newOutPutter;
    }

    public Printer() {
        outPutter = new OutputHandler();
    }

    public boolean printBoard(Board gameBoard) {
        String rowOne = " " + gameBoard.getPositions().get("1") + " | " + gameBoard.getPositions().get("2") + " | " + gameBoard.getPositions().get("3") + "\n";
        String rowTwo = " " + gameBoard.getPositions().get("4") + " | " + gameBoard.getPositions().get("5") + " | " + gameBoard.getPositions().get("6") + "\n";
        String rowThree = " " + gameBoard.getPositions().get("7") + " | " + gameBoard.getPositions().get("8") + " | " + gameBoard.getPositions().get("9") + "\n";
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
