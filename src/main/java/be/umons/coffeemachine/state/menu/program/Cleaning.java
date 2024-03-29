package be.umons.coffeemachine.state.menu.program;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.state.Waiting;

import static be.umons.coffeemachine.model.enums.MenuName.CLEANING;

public class Cleaning extends CalcAndClean {

    private static Cleaning instance;

    public static Cleaning instance() {
        if (instance == null) {
            instance = new Cleaning();
        }

        return instance;
    }

    public Cleaning() {
        super(CLEANING);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        run(coffeeMachine);
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        enableBtn(coffeeMachine);
        if (CalcAndClean.instance().isCalcAndClean()) {
            run(coffeeMachine);
        } else {
            coffeeMachine.setTitleDisplay(getName().getName());
        }
    }

    private void run(CoffeeMachine coffeeMachine) {
        coffeeMachine.setEnableBtnMenu(false);
        coffeeMachine.setEnableBtnBack(false);
        be.umons.coffeemachine.model.program.Cleaning cleaning = be.umons.coffeemachine.model.program.Cleaning.instance();
        if (!cleaning.isInPreparing()) {
            cleaning.onFinish(() -> coffeeMachine.transition(Waiting.instance()));
            CalcAndClean calcAndClean = CalcAndClean.instance();
            if (calcAndClean.isCalcAndClean()) {
                calcAndClean.setCalcAndClean(false);
            }
            cleaning.start(coffeeMachine);
        }
    }
}
