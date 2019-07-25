package ui2;

public abstract class AbstractMode implements ModeController{
    public double MythNumber = Math.random();

    @Override
    public int GenerateSeriesNumber() {
        return (int) MythNumber * 1000;
    }

    public abstract String DecipheredNumber();
}
