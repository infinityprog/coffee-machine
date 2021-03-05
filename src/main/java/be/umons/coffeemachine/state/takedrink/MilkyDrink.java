package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;

public class MilkyDrink extends TakeDrink {

    private static MilkyDrink instance;

    public static MilkyDrink instance() {
        if (instance == null) {
            instance = new MilkyDrink();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        super.entry(coffeeMachine);
        coffeeMachine.setMilky(true);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Preparing.instance());
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
