package spec;
import javattt.Board;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BoardTest {

  public Board gameBoard;


  @Test
  public void itShouldConstructWithoutParams() {
      gameBoard = new Board();
      String testPos = gameBoard.getPositions().get(1);
      Assert.assertEquals("2", testPos);
  }

  @Test
  public void itShouldBeAbleToBeCreatedWithAnArray() {
      String[] spots = {"X", "O", "X", "X", "O", "X", "X", "O", "X"};
      Board board = new Board(spots);
     ArrayList<String> positions = board.getPositions();
      for (int i=0; i < positions.size(); i++) {
        Assert.assertEquals(spots[i], positions.get(i));
      }
  }

  @Test
  public void itShouldAddAPlayerMove() {
      gameBoard = new Board();
      gameBoard.placeMove("1", "X");
      Assert.assertEquals(gameBoard.getPositions().get(0), "X");
  }


  @Test
   public void itShouldReturnAListOfAvailableSpots() {
      gameBoard = new Board();
      List untakenSpots = gameBoard.availableSpots();
      int listSize = untakenSpots.size();
      Assert.assertEquals(listSize, 9);
   }

  @Test
    public void itShouldCreateWithA4x4Array() {
      String[] spots = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
      Board board = new Board(spots);
      ArrayList<String> positions = board.getPositions();
      for (int i=0; i < positions.size(); i++) {
          Assert.assertEquals(spots[i], positions.get(i));
      }
  }

    @Test
    public void itShouldProperlyGetRowSizeForFourByFour() {
        String[] spots = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};
        Board board = new Board(spots);
        Assert.assertEquals(4, board.getRowSize());

    }

    @Test
    public void itShouldProperlyGetRowSizeForThreeByThree() {
        Board board = new Board();
        Assert.assertEquals(3, board.getRowSize());
    }
}
