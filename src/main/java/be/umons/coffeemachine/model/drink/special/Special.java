package be.umons.coffeemachine.model.drink.special;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;

public abstract class Special extends Drink {

    public Special(String name) {
        super(name);
    }

    @Override
    public void resetPieces(CoffeeMachine coffeeMachine) {

    }
}
