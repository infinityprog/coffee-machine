package be.umons.coffeemachine.state.menu.cleaningandmaintenance;

import be.umons.coffeemachine.context.CoffeeMachine;

public class Cleaning extends CalcAndClean {

    private static Cleaning instance;

    public static Cleaning instance() {
        if (instance == null) {
            instance = new Cleaning();
        }

        return instance;
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }
}
