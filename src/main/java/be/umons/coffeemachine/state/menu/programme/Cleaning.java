package be.umons.coffeemachine.state.menu.programme;

import be.umons.coffeemachine.context.CoffeeMachine;

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
        super.startStop(coffeeMachine);
    }
}
