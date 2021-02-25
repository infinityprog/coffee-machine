package be.umons.coffeemachine.state.menu.cleaningandmaintenance;

public class CalcAndClean extends CAMOptions {

    private static CalcAndClean instance;

    private boolean calcAndClean;

    public static CalcAndClean instance() {
        if (instance == null) {
            instance = new CalcAndClean();
        }

        return instance;
    }

    public boolean isCalcAndClean() {
        return calcAndClean;
    }

    public CalcAndClean setCalcAndClean(boolean calcAndClean) {
        this.calcAndClean = calcAndClean;
        return this;
    }
}
