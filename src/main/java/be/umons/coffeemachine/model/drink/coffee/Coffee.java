package be.umons.coffeemachine.model.drink.coffee;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;

public class Coffee extends Drink {

    public Coffee(String name) {
        super(name);
        coffee = true;
    }

    @Override
    public void makeDrink(CoffeeMachine coffeeMachine) {

    }
}
