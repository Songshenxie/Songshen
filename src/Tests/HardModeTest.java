package Tests;

import org.junit.Before;
import org.junit.Test;
import ui2.HardMode;

import static java.lang.Math.ceil;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HardModeTest {
    private HardMode hard;

    @Before
    public void setup() {
        hard = new HardMode();
        hard.GenerateSeriesNumber();
    }

    @Test
    public void testGenerateSeriesNumber() {
        assertTrue(ceil(hard.GenerateSeriesNumber()) == hard.GenerateSeriesNumber());
    }

    @Test
    public void testDecipheredNumber() {
        int Number = hard.GenerateSeriesNumber();
        String ExpectedAnswer = Integer.toHexString(Number);

        assertEquals(ExpectedAnswer,hard.DecipheredNumber());
    }

    @Test
    public void testShowLevelAndResult() {
        assertEquals("Your current Level is Hard!",hard.PrintLevel());
    }
}
