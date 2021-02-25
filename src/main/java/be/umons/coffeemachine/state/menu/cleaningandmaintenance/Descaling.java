package be.umons.coffeemachine.state.menu.cleaningandmaintenance;

import be.umons.coffeemachine.context.CoffeeMachine;

public class Descaling extends CalcAndClean {

    private static Descaling instance;

    public static Descaling instance() {
        if (instance == null) {
            instance = new Descaling();
        }

        return instance;
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }
}
