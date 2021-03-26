package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;

public class Stop extends State {

    private static Stop instance;

    public static Stop instance() {
        if (instance == null) {
            instance = new Stop();
        }

        return instance;
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {

    }
}
