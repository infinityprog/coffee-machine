package be.umons.coffeemachine.model.drink.coffee;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;

public class MilkyDrink extends Drink {

    private MilkFroth milkFroth;

    public MilkyDrink(String name, String milkName) {
        super(name);
        this.milkFroth = new MilkFroth(milkName);
    }

    @Override
    public void makeDrink(CoffeeMachine coffeeMachine) {
        milkFroth.getEndPreparation().setOnFinished(event -> onPreparing(coffeeMachine));
        milkFroth.makeDrink(coffeeMachine);
    }

    @Override
    public void stop(CoffeeMachine coffeeMachine) {
        if (!milkFroth.isPreparing()){
            milkFroth.stop(coffeeMachine);
            onPreparing(coffeeMachine);
        } else {
            pause.stop();
            preparing = true;
        }
    }
}
