package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;

public class FrostProtection extends Menu {

    private static FrostProtection instance;

    public static FrostProtection instance() {
        if (instance == null) {
            instance = new FrostProtection();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        super.entry(coffeeMachine);
    }
}
