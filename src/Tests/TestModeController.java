package Tests;

import org.junit.Before;
import org.junit.Test;
import ui2.EasyMode;
import ui2.HardMode;
import ui2.ModeController;
import ui2.NormalMode;

import static org.junit.Assert.assertEquals;

public class TestModeController {
    private ModeController easy;
    private ModeController normal;
    private ModeController hard;
    private ModeController neweasy;
    private ModeController newnormal;
    private ModeController newhard;

    @Before
    public void setup() {
        easy = new EasyMode();
        easy.GenerateSeriesNumber();
        normal = new NormalMode();
        normal.GenerateSeriesNumber();
        hard = new HardMode();
        hard.GenerateSeriesNumber();
        neweasy = new EasyMode();
        neweasy.GenerateSeriesNumber();
        newnormal = new NormalMode();
        newnormal.GenerateSeriesNumber();
        newhard = new HardMode();
        newhard.GenerateSeriesNumber();
    }
//    @Test
//    public void testGenerateSeriesNumber() {
//        assertFalse(easy.GenerateSeriesNumber() == neweasy.GenerateSeriesNumber());
//        assertFalse(normal.GenerateSeriesNumber() == newnormal.GenerateSeriesNumber());
//        assertFalse(hard.GenerateSeriesNumber() == newhard.GenerateSeriesNumber());
//    }
    @Test
    public void testDecipheredNumber() {
        int Number = easy.GenerateSeriesNumber();
        int Number2 = neweasy.GenerateSeriesNumber();
        int Cool = Number + 1900;
        int Cool2 = Number2 + 1900;
        String CoolinString = String.valueOf(Cool);
        String CoolinString2 = String.valueOf(Cool2);

        String Answer = "Riddle";

        int NumberforHard = hard.GenerateSeriesNumber();
        int NumberforHard2 = newhard.GenerateSeriesNumber();

        String ExpectedAnswer = Integer.toHexString(NumberforHard);
        String ExpectedAnswer2 = Integer.toHexString(NumberforHard2);

        assertEquals(CoolinString,easy.DecipheredNumber());
        assertEquals(Answer,normal.DecipheredNumber());
        assertEquals(ExpectedAnswer,hard.DecipheredNumber());
        assertEquals(CoolinString2,neweasy.DecipheredNumber());
        assertEquals(Answer,newnormal.DecipheredNumber());
        assertEquals(ExpectedAnswer2,newhard.DecipheredNumber());
    }
}
