package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;

public class CoffeeDrink extends TakeDrink {

    private static CoffeeDrink instance;

    public static CoffeeDrink instance() {
        if (instance == null) {
            instance = new CoffeeDrink();
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
    public void intensity(CoffeeMachine coffeeMachine) {
        super.intensity(coffeeMachine);
    }

    @Override
    public void two(CoffeeMachine coffeeMachine) {
        super.two(coffeeMachine);
    }

    @Override
    public void quantity(CoffeeMachine coffeeMachine) {
        super.quantity(coffeeMachine);
    }
}
