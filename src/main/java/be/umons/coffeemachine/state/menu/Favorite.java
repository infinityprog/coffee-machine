package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;

public class Favorite extends Menu{

    private static Favorite instance;

    public static Favorite instance() {
        if (instance == null) {
            instance = new Favorite();
        }

        return instance;
    }

    @Override
    public void ok(CoffeeMachine coffeeMachine) {
        super.ok(coffeeMachine);
    }

    @Override
    public void scrolling(CoffeeMachine coffeeMachine) {
        super.scrolling(coffeeMachine);
    }
}
