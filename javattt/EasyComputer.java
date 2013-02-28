package javattt;
import sun.jvm.hotspot.memory.FreeList;
import java.util.List;
import java.util.Random;

public class EasyComputer extends Player {
    public String mark;

    public EasyComputer() {
        super(new String("O"));

    }

    public String getMove(List<String> availableSpots) {
        Random random = new Random();
        return availableSpots.get(random.nextInt(availableSpots.size()));
    }
}
