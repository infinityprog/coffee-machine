package be.umons.coffeemachine.model.drink.coffee;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;

public class MilkFroth extends Drink {


    public MilkFroth(String name) {
        super(name);
        milk = true;
    }

    @Override
    public void makeDrink(CoffeeMachine coffeeMachine) {

    }
}
