import com.tw.bc.ConsoleInputReader;
import com.tw.bc.Player;
import com.tw.bc.ScoreManager;
import com.tw.bc.TrustChoice;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ScoreManagerTest {
    @Test
    public void shouldUpdateScores() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        ScoreManager scoreManager = new ScoreManager();
        scoreManager.updateScores(playerOne, TrustChoice.COOPERATE, playerTwo, TrustChoice.COOPERATE);
        Assert.assertEquals(2, playerOne.getScore());
        Assert.assertEquals(2, playerTwo.getScore());

        scoreManager.updateScores(playerOne, TrustChoice.COOPERATE, playerTwo, TrustChoice.CHEAT);
        Assert.assertEquals(1, playerOne.getScore());
        Assert.assertEquals(5, playerTwo.getScore());

        scoreManager.updateScores(playerOne, TrustChoice.CHEAT, playerTwo, TrustChoice.COOPERATE);
        Assert.assertEquals(4, playerOne.getScore());
        Assert.assertEquals(4, playerTwo.getScore());

        scoreManager.updateScores(playerOne, TrustChoice.CHEAT, playerTwo, TrustChoice.CHEAT);
        Assert.assertEquals(4, playerOne.getScore());
        Assert.assertEquals(4, playerTwo.getScore());
    }
}
