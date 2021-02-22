package be.umons.coffeemachine.state.takedrink.preparing;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.state.takedrink.TakeDrink;

public class Preparing extends TakeDrink {

    private static Preparing instance;

    private boolean preparing;

    public static Preparing instance() {
        if (instance == null) {
            instance = new Preparing();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        super.entry(coffeeMachine);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }
}
