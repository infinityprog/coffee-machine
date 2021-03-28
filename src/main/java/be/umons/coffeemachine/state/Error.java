package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;

public class Error extends State{

    private static Error instance;

    public static Error instance() {
        if (instance == null) {
            instance = new Error();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        enableBtn(coffeeMachine);
        coffeeMachine.setQuantityDisplay("");
        coffeeMachine.setIntensityDisplay("");
        coffeeMachine.setTitleDisplay("Une erreur est survenue.\nAppelez la companie ");
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();
    }
}
