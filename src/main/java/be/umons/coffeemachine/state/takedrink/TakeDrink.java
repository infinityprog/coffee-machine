package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.state.State;

public abstract class TakeDrink extends State {

    protected boolean isMilky;

    protected boolean isCoffee;

    protected boolean ground;

    @Override
    public void back(CoffeeMachine coffeeMachine) {
        super.back(coffeeMachine);
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        coffeeMachine.setTitleDisplay(coffeeMachine.getDrink().getName());
    }
}
