package be.umons.coffeemachine.state.menu.program;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.state.Waiting;

import static be.umons.coffeemachine.model.enums.MenuName.DESCALING;

public class Descaling extends CalcAndClean {

    private static Descaling instance;

    public static Descaling instance() {
        if (instance == null) {
            instance = new Descaling();
        }

        return instance;
    }

    public Descaling() {
        super(DESCALING);
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
        be.umons.coffeemachine.model.program.Descaling descaling = be.umons.coffeemachine.model.program.Descaling.instance();
        if (!descaling.isInPreparing()) {
            if (CalcAndClean.instance().isCalcAndClean()) {
                descaling.onFinish(() -> coffeeMachine.transition(Cleaning.instance()));
            } else {
                descaling.onFinish(() -> coffeeMachine.transition(Waiting.instance()));
            }

            descaling.start(coffeeMachine);
        }
    }
}
