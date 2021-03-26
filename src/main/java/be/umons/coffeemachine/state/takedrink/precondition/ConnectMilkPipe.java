package be.umons.coffeemachine.state.takedrink.precondition;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.state.takedrink.Preparing;
import be.umons.coffeemachine.state.takedrink.TakeDrink;

public class ConnectMilkPipe extends TakeDrink {

    private static ConnectMilkPipe instance;


    public static ConnectMilkPipe instance() {
        if (instance == null) {
            instance = new ConnectMilkPipe();
        }

        return instance;
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        coffeeMachine.getMilkPipe().connecte();
        coffeeMachine.transition(Preparing.instance());
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        enableBtn(coffeeMachine);
        coffeeMachine.setTitleDisplay("Connecetez le tuyaux à lait");
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();
        coffeeMachine.setEnableBtnStartStop(true);
    }
}
