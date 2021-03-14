package be.umons.coffeemachine.state.menu.programme;

import be.umons.coffeemachine.context.CoffeeMachine;

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
        be.umons.coffeemachine.model.program.Descaling descaling = be.umons.coffeemachine.model.program.Descaling.instance();
        descaling.start(coffeeMachine);
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        coffeeMachine.setTitleDisplay(getName().getName());
    }
}
