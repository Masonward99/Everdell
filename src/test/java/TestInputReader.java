import Everdell.InputReader;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class TestInputReader {
    InputReader inputReader;
    @Before
    public void setUp() {
        inputReader = new InputReader();
    }
    @Test
    public void testGetInt() {
        String inputString = "0\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(byteArrayInputStream);
        inputReader = new InputReader();
        assert(0 == inputReader.getIntInRange(5));
    }
}
