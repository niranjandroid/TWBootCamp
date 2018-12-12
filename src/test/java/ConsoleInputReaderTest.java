import com.tw.bc.ConsoleInputReader;
import com.tw.bc.InputReader;
import com.tw.bc.TrustChoice;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ConsoleInputReaderTest {

    @Test
    public void shouldReadInputFromConsole() {

        InputReader inputReader = new ConsoleInputReader();
        setMockInput("+");
        Assert.assertEquals(TrustChoice.COOPERATE, inputReader.readTrustChoice());


        setMockInput("-");
        Assert.assertEquals(TrustChoice.CHEAT, inputReader.readTrustChoice());


        setMockInput("+-");
        setMockInput("+");
        Assert.assertEquals(TrustChoice.COOPERATE, inputReader.readTrustChoice());
    }

    private void setMockInput(String input) {
        InputStream in = null;
        try {
            in = new ByteArrayInputStream(input.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.setIn(in);
    }
}
