package Tests;

import org.junit.Before;
import org.junit.Test;
import ui2.NormalMode;

import static java.lang.Math.ceil;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NormalModeTest {

        private NormalMode normal;

        @Before
        public void setup() {
            normal = new NormalMode();
            normal.GenerateSeriesNumber();
        }

        @Test
        public void testGenerateSeriesNumber() {
            assertTrue(ceil(normal.GenerateSeriesNumber()) == normal.GenerateSeriesNumber());
        }

        @Test
        public void testDecipheredNumber() {
            String CoolinString = "Riddle";
            String ActualAnswer = normal.DecipheredNumber();
            assertEquals(CoolinString,ActualAnswer);
        }

        @Test
        public void testShowLevelAndResult() {
            assertEquals("Your current Level is Normal!",normal.PrintLevel());
        }

}