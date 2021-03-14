package be.umons.coffeemachine.state.menu.programme;

import be.umons.coffeemachine.model.enums.MenuName;

import static be.umons.coffeemachine.model.enums.MenuName.CALC_AND_CLEAN;

public class CalcAndClean extends Program {

    private static CalcAndClean instance;

    private boolean calcAndClean;

    public static CalcAndClean instance() {
        if (instance == null) {
            instance = new CalcAndClean();
        }

        return instance;
    }

    public CalcAndClean() {
        super(CALC_AND_CLEAN);
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
