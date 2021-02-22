package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;

public class SpecialDrink extends TakeDrink {

    private static SpecialDrink instance;

    public static SpecialDrink instance() {
        if (instance == null) {
            instance = new SpecialDrink();
        }

        return instance;
    }

    @Override
    public void back(CoffeeMachine coffeeMachine) {
        super.back(coffeeMachine);
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
    public void quantity(CoffeeMachine coffeeMachine) {
        super.quantity(coffeeMachine);
    }
}
