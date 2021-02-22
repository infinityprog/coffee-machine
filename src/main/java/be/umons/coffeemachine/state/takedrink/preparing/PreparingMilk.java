package be.umons.coffeemachine.state.takedrink.preparing;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.state.takedrink.TakeDrink;

public class PreparingMilk extends TakeDrink {

    private static PreparingMilk instance;

    public static PreparingMilk instance() {
        if (instance == null) {
            instance = new PreparingMilk();
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
