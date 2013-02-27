package javattt;
import sun.jvm.hotspot.memory.FreeList;
import java.util.List;
import java.util.Random;

public class EasyComputer {
    public String mark;

    public EasyComputer(String playerMark) {
        mark = playerMark;
    }

    public String getMove(List<String> availableSpots) {
        Random random = new Random();
        String chosenMove = availableSpots.get(random.nextInt(availableSpots.size()));
        return chosenMove;
    }
}
