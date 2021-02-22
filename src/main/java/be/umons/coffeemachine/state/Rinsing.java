package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;

public class Rinsing extends State {

    private static Rinsing instance;

    public static Rinsing instance() {
        if (instance == null) return new Rinsing();

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        super.entry(coffeeMachine);
    }
}
