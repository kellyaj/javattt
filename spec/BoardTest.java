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
  public void itShouldBeAbleToBeCreatedWithAnArray() {
      String[] spots = {"X", "O", "X", "X", "O", "X", "X", "O", "X"};
      Board board = new Board(spots);
      HashMap<String, String> positions = board.getPositions();
      for (int i=0; i < positions.size(); i++) {
        String key = Integer.toString(i+1);
        Assert.assertEquals(spots[i], positions.get(key));
      }
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

  @Test
    public void itShouldCreateWithA4x4Array() {
      String[] spots = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
      Board board = new Board(spots);
      HashMap<String, String> positions = board.getPositions();
      for (int i=0; i < positions.size(); i++) {
          String key = Integer.toString(i+1);
          Assert.assertEquals(spots[i], positions.get(key));
      }
  }
}
