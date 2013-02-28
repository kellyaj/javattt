package javattt;

import org.junit.Assert;
import org.junit.Test;

public class ScorerTest {

    @Test
    public void itShouldInitializeWithWinCombos() {
        Scorer gameScorer = new Scorer();
        String[] firstRow = gameScorer.winCombos[1];
        String[] expectedRow = {"1", "2", "3"};
        Assert.assertArrayEquals(expectedRow, firstRow);
    }
}
