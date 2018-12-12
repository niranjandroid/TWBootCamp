import com.tw.bc.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static com.tw.bc.EvolutionOfTrust.NO_OF_ROUNDS;
import static org.mockito.Mockito.*;

public class EvolutionOfTrustGameTest {

    @Test
    public void shouldInitializeGame() {
        InputReader inputReader = Mockito.mock(ConsoleInputReader.class);
        Player playerOne = new Player(inputReader);
        Player playerTwo = new Player(inputReader);
        IDisplay consoleDisplay = Mockito.mock(ConsoleDisplay.class);
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust(playerOne, playerTwo, consoleDisplay);
        Assert.assertEquals(0, playerOne.getScore());
        Assert.assertEquals(0, playerTwo.getScore());
    }

    @Test
    public void shouldStartGame() {
        Player playerOne = Mockito.mock(Player.class);
        Player playerTwo = Mockito.mock(Player.class);
        IDisplay consoleDisplay = Mockito.mock(ConsoleDisplay.class);
        when(playerOne.play()).thenReturn(TrustChoice.COOPERATE);
        when(playerTwo.play()).thenReturn(TrustChoice.CHEAT);
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust(playerOne, playerTwo, consoleDisplay);
        evolutionOfTrust.start();
        Assert.assertEquals(0, playerOne.getScore());
        Assert.assertEquals(0, playerTwo.getScore());
        verify(playerOne, times(NO_OF_ROUNDS)).play();
        verify(playerTwo, times(NO_OF_ROUNDS)).play();
    }

    @Test
    public void shouldPrintInitialScore() {
        Player playerOne = Mockito.mock(Player.class);
        Player playerTwo = Mockito.mock(Player.class);
        IDisplay consoleDisplay = Mockito.mock(ConsoleDisplay.class);

        when(playerOne.play()).thenReturn(TrustChoice.COOPERATE);
        when(playerTwo.play()).thenReturn(TrustChoice.CHEAT);
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust(playerOne, playerTwo, consoleDisplay);
        evolutionOfTrust.start();
        verify(consoleDisplay, times(NO_OF_ROUNDS + 1)).display(playerOne, playerTwo);

        evolutionOfTrust = new EvolutionOfTrust(playerOne, playerTwo, new ConsoleDisplay());
        evolutionOfTrust.start();
        verify(playerOne, times(NO_OF_ROUNDS + 1)).getScore();
        verify(playerTwo, times(NO_OF_ROUNDS + 1)).getScore();
    }

    @Test
    public void shouldUpdateScore() {
        InputReader inputReader = Mockito.mock(ConsoleInputReader.class);
        Player playerOne = new Player(inputReader);
        Player playerTwo = new Player(inputReader);
        when(inputReader.readTrustChoice())
                .thenReturn(TrustChoice.CHEAT)
                .thenReturn(TrustChoice.CHEAT)
                .thenReturn(TrustChoice.CHEAT)
                .thenReturn(TrustChoice.CHEAT)
                .thenReturn(TrustChoice.COOPERATE)
                .thenReturn(TrustChoice.CHEAT)
                .thenReturn(TrustChoice.CHEAT)
                .thenReturn(TrustChoice.CHEAT)
                .thenReturn(TrustChoice.CHEAT)
                .thenReturn(TrustChoice.CHEAT);
        IDisplay consoleDisplay = Mockito.mock(ConsoleDisplay.class);
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust(playerOne, playerTwo, consoleDisplay);
        evolutionOfTrust.start();
        Assert.assertEquals(-1, playerOne.getScore());
        Assert.assertEquals(3, playerTwo.getScore());
    }
}
