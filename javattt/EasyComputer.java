package javattt;
import java.util.Random;

public class EasyComputer implements Player {
    public String mark;

    public EasyComputer() {
        mark = "O";

    }

    public String getMove(Board board) {
        Random random = new Random();
        return board.availableSpots().get(random.nextInt(board.availableSpots().size()));
    }

    public String getMark() {
        return this.mark;
    }
}
