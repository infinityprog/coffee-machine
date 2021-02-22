package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;

public class Waiting extends State {

    private static Waiting instance;

    public static Waiting instance() {
        if (instance == null) {
            instance = new Waiting();
        }

        return instance;
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }

    @Override
    public void menu(CoffeeMachine coffeeMachine) {
        super.menu(coffeeMachine);
    }

    @Override
    public void security(CoffeeMachine coffeeMachine) {
        super.security(coffeeMachine);
    }

    @Override
    public void coffee(CoffeeMachine coffeeMachine) {
        super.coffee(coffeeMachine);
    }

    @Override
    public void milky(CoffeeMachine coffeeMachine) {
        super.milky(coffeeMachine);
    }

    @Override
    public void special(CoffeeMachine coffeeMachine) {
        super.special(coffeeMachine);
    }

    @Override
    public void favori(CoffeeMachine coffeeMachine) {
        super.favori(coffeeMachine);
    }
}
