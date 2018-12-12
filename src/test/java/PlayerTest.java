import com.tw.bc.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class PlayerTest {

    @Test
    public void shouldAddScore() {
        InputReader inputReader = Mockito.mock(ConsoleInputReader.class);
        Player player = new Player(inputReader);
        Assert.assertEquals(0, player.getScore());
        player.addScore(Score.LOSER_SCORE);
        Assert.assertEquals(-1, player.getScore());
        player.addScore(Score.COOP_SCORE);
        Assert.assertEquals(1, player.getScore());
        player.addScore(Score.CHEAT_SCORE);
        Assert.assertEquals(4, player.getScore());
        player.addScore(Score.NEUTRAL_SCORE);
        Assert.assertEquals(4, player.getScore());
    }

    @Test
    public void shouldPlay() {
        InputReader inputReader = Mockito.mock(ConsoleInputReader.class);
        Player player = new Player(inputReader);
        when(inputReader.readTrustChoice())
                .thenReturn(TrustChoice.COOPERATE);
        Assert.assertEquals(TrustChoice.COOPERATE, player.play());
    }

}
