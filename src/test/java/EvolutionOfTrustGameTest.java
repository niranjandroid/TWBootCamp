import com.tw.bc.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static com.tw.bc.EvolutionOfTrust.NO_OF_ROUNDS;
import static org.mockito.Mockito.*;

public class EvolutionOfTrustGameTest {

    @Test
    public void shouldInitializeGame() {
        Player playerOne = new Player();
        Player playerTwo = new Player();
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
        InputReader inputReader = new ConsoleInputReader();
        when(playerOne.play(inputReader)).thenReturn(TrustChoice.COOPERATE);
        when(playerTwo.play(inputReader)).thenReturn(TrustChoice.CHEAT);
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust(playerOne, playerTwo, consoleDisplay);
        evolutionOfTrust.start(inputReader, inputReader);
        Assert.assertEquals(0, playerOne.getScore());
        Assert.assertEquals(0, playerTwo.getScore());
        verify(playerOne, times(NO_OF_ROUNDS)).play(inputReader);
        verify(playerTwo, times(NO_OF_ROUNDS)).play(inputReader);
    }

    @Test
    public void shouldPrintInitialScore() {
        Player playerOne = Mockito.mock(Player.class);
        Player playerTwo = Mockito.mock(Player.class);
        IDisplay consoleDisplay = Mockito.mock(ConsoleDisplay.class);
        InputReader inputReader = new ConsoleInputReader();

        when(playerOne.play(inputReader)).thenReturn(TrustChoice.COOPERATE);
        when(playerTwo.play(inputReader)).thenReturn(TrustChoice.CHEAT);
        EvolutionOfTrust evolutionOfTrust = new EvolutionOfTrust(playerOne, playerTwo, consoleDisplay);
        evolutionOfTrust.start(inputReader, inputReader);
        verify(consoleDisplay, times(NO_OF_ROUNDS + 1)).display(playerOne, playerTwo);

        evolutionOfTrust = new EvolutionOfTrust(playerOne, playerTwo, new ConsoleDisplay());
        evolutionOfTrust.start(inputReader, inputReader);
        verify(playerOne, times(NO_OF_ROUNDS + 1)).getScore();
        verify(playerTwo, times(NO_OF_ROUNDS + 1)).getScore();
    }

    @Test
    public void shouldUpdateScore() {
        InputReader inputReader = Mockito.mock(ConsoleInputReader.class);
        Player playerOne = new Player();
        Player playerTwo = new Player();
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
        evolutionOfTrust.start(inputReader, inputReader);
        Assert.assertEquals(-1, playerOne.getScore());
        Assert.assertEquals(3, playerTwo.getScore());
    }
}
