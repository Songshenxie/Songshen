package Tests;

import org.junit.Before;
import org.junit.Test;
import ui2.EasyMode;

import static java.lang.Math.ceil;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class EasyModeTest {

    private EasyMode easy;

    @Before
    public void setup() {
        easy = new EasyMode();
        easy.GenerateSeriesNumber();
    }

    @Test
    public void testGenerateSeriesNumber() {
        assertTrue(ceil(easy.GenerateSeriesNumber()) == easy.GenerateSeriesNumber());
    }

    @Test
    public void testDecipheredNumber() {
        int Number = easy.GenerateSeriesNumber();
        int Cool = Number + 1900;
        String CoolinString = String.valueOf(Cool);
        assertEquals(CoolinString,String.valueOf( Number + 1900));
    }

    @Test
    public void testShowLevelAndResult() {
        assertEquals("Your current Level is Easy!",easy.PrintLevel());
    }
}
