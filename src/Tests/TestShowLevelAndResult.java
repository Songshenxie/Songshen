package Tests;

import org.junit.Before;
import org.junit.Test;
import ui2.*;

import static org.junit.Assert.assertEquals;

public class TestShowLevelAndResult {
    private ShowLevelAndResult easy;
    private ShowLevelAndResult normal;
    private ShowLevelAndResult hard;
    private ShowLevelAndResult neweasy;
    private ShowLevelAndResult newnormal;
    private ShowLevelAndResult newhard;

    @Before
    public void setup() {
        easy = new EasyMode();
        normal = new NormalMode();
        hard = new HardMode();
        neweasy = new EasyMode();
        newnormal = new NormalMode();
        newhard = new HardMode();
    }

    @Test
    public void testPrintLevel() {
        assertEquals("Your current Level is Easy!",easy.PrintLevel());
        assertEquals("Your current Level is Normal!",normal.PrintLevel());
        assertEquals("Your current Level is Hard!",hard.PrintLevel());
        assertEquals("Your current Level is Easy!",neweasy.PrintLevel());
        assertEquals("Your current Level is Normal!",newnormal.PrintLevel());
        assertEquals("Your current Level is Hard!",newhard.PrintLevel());
    }
}
