package ui2;

public class NormalMode extends AbstractMode implements ShowLevelAndResult{
    public int MythNumber = (int) (Math.random()*1000000);
    @Override
    public int GenerateSeriesNumber() {
        return MythNumber;
    }
    @Override
    public String DecipheredNumber() {
        String Answer = "Riddle";
        return Answer;
    }

    @Override
    public String PrintLevel() {
        return "Your current Level is Normal!";
    }


}
