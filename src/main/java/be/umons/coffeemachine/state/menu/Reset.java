package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;

public class Reset extends Menu {

    private static Reset instance;

    public static Reset instance() {
        if (instance == null) {
            instance = new Reset();
        }

        return instance;
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }
}
