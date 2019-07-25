package ui2;

public class HardMode extends AbstractMode implements ShowLevelAndResult {
    public int MythNumber = (int) (Math.random()*100000000);
    @Override
    public int GenerateSeriesNumber() {
        return MythNumber;
    }
    @Override
    public String DecipheredNumber() {
        String Answer = Integer.toHexString(MythNumber);
        return Answer;
    }

    @Override
    public String PrintLevel() {
        return "Your current Level is Hard!";
    }


}
