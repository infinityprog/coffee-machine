package be.umons.coffeemachine.state.menu.cleaningandmaintenance;

import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.menu.Menu;

public class CalcAndClean extends CAMOptions {

    private static Menu instance;

    private boolean calcAndClean;

    public static Menu instance() {
        if (instance == null) {
            instance = new CalcAndClean();
        }

        return instance;
    }

    public CalcAndClean() {
        super(MenuName.CALC_AND_CLEAN);
    }

    public CalcAndClean(MenuName name) {
        super(name);
    }

    public boolean isCalcAndClean() {
        return calcAndClean;
    }

    public CalcAndClean setCalcAndClean(boolean calcAndClean) {
        this.calcAndClean = calcAndClean;
        return this;
    }
}
