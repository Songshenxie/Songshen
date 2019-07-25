package ui2;

public class EasyMode extends AbstractMode implements ShowLevelAndResult{
    public int MythNumber = (int) (Math.random()*10000);
    @Override
    public int GenerateSeriesNumber() {
        return MythNumber;
    }
    @Override
    public String DecipheredNumber() {
        int Answer = MythNumber + 1900;
        return String.valueOf(Answer);
    }

    @Override
    public String PrintLevel() {
        return "Your current Level is Easy!";
    }

}
