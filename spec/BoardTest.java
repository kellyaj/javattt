package spec;
import javattt.Board;
import org.junit.*;
import java.util.HashMap;
import java.util.List;


public class BoardTest {

  public Board gameBoard;


  @Test
  public void itShouldConstructWithoutParams() {
      gameBoard = new Board();
      String testPos = gameBoard.getPositions().get("1");
      Assert.assertEquals("1", testPos);
  }
  @Before
  public void initialize() {
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
    gameBoard = new Board(positions);
  }

  @Test
  public void itShouldHavePositions() {
    HashMap<String, String> gameSpots = gameBoard.getPositions();
    Assert.assertEquals(gameSpots.get("1"),  "1");
  }

  @Test
  public void itShouldAddAPlayerMove() {
    gameBoard.placeMove("1", "X");
    Assert.assertEquals(gameBoard.getPositions().get("1"), "X");
    }


  @Test
   public void itShouldReturnAListOfAvailableSpots() {
    List untakenSpots = gameBoard.availableSpots();
    int listSize = untakenSpots.size();
    Assert.assertEquals(listSize, 9);
   }
}
