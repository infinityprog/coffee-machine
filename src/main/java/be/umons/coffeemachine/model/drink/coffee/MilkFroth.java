package be.umons.coffeemachine.model.drink.coffee;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.state.takedrink.precondition.ConnectMilkPipe;

public class MilkFroth extends Drink {


    public MilkFroth(String name) {
        super(name);
    }

    @Override
    public void makeDrink(CoffeeMachine coffeeMachine) {
        if(coffeeMachine.getMilkPipe().isDisconnected()) {
            coffeeMachine.transition(ConnectMilkPipe.instance());
        } else {
            super.makeDrink(coffeeMachine);
        }

    }

    @Override
    public void resetPieces(CoffeeMachine coffeeMachine) {
        coffeeMachine.getMilkPipe().disconnect();
    }
}
