package be.umons.coffeemachine.state.menu.cleaningandmaintenance;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.state.menu.Reset;

public class CleaningMilkFrother extends CAMOptions {

    private static CleaningMilkFrother instance;

    public static CleaningMilkFrother instance() {
        if (instance == null) {
            instance = new CleaningMilkFrother();
        }

        return instance;
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }
}
