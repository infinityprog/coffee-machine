package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;

public class MilkFroth extends TakeDrink {

    private static MilkFroth instance;

    public static MilkFroth instance() {
        if (instance == null) {
            instance = new MilkFroth();
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

    @Override
    public void quantity(CoffeeMachine coffeeMachine) {
        super.quantity(coffeeMachine);
    }
}
