import com.tw.bc.EvolutionOfTrust;
import com.tw.bc.Player;
import org.junit.Assert;
import org.junit.Test;

public class EvolutionOfTrustGameTest {

    @Test
    public void shouldInitializeGame() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust(playerOne, playerTwo);
        Assert.assertEquals(0, playerOne.getScore());
        Assert.assertEquals(0, playerTwo.getScore());
    }

    @Test
    public void shouldStartGame() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust(playerOne, playerTwo);

    }
}
