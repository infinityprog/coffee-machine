package be.umons.coffeemachine.model.drink.coffee;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;

public class MilkyDrink extends Drink {

    private MilkFroth milkFroth;

    public MilkyDrink(String name) {
        super(name);
        this.milkFroth = new MilkFroth("Milk Froth");
    }

    public MilkFroth getMilkFroth() {
        return milkFroth;
    }

    @Override
    public void makeDrink(CoffeeMachine coffeeMachine) {

    }
}
