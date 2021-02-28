package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;

public class Start extends State {

    private static Start instance;

    public static Start instance() {
        if (instance == null) {
            instance = new Start();
        }

        return instance;
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        if (!coffeeMachine.isHot() && !coffeeMachine.isServed()) {
            coffeeMachine.transition(Rinsing.instance());
        } else {
            coffeeMachine.transition(Waiting.instance());
        }
    }
}
