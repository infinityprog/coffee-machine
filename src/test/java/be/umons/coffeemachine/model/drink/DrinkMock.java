package be.umons.coffeemachine.model.drink;

import be.umons.coffeemachine.context.CoffeeMachine;

public class DrinkMock extends Drink{

    public DrinkMock(String name) {
        super(name);
    }

    @Override
    public void resetPieces(CoffeeMachine coffeeMachine) {

    }
}
