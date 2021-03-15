package be.umons.coffeemachine.state.menu.program;

import be.umons.coffeemachine.context.CoffeeMachine;
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

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        coffeeMachine.setTitleDisplay(getName().getName());
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        coffeeMachine.setCalcAndClean(true);
        coffeeMachine.transition(Descaling.instance());
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
