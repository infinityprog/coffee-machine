package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;

public class Security extends State {

    private static Security instance;

    public static Security instance() {
        if (instance == null) {
            instance = new Security();
        }

        return instance;
    }

    @Override
    public void security(CoffeeMachine coffeeMachine) {
        super.security(coffeeMachine);
    }
}
