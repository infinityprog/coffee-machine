package be.umons.coffeemachine.state.takedrink.precondition;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.state.takedrink.Preparing;
import be.umons.coffeemachine.state.takedrink.TakeDrink;

public class FillReservoir extends TakeDrink {

    private static FillReservoir instance;


    public static FillReservoir instance() {
        if (instance == null) {
            instance = new FillReservoir();
        }

        return instance;
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        coffeeMachine.getWaterReservoir().fillUp();
        coffeeMachine.transition(Preparing.instance());
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        coffeeMachine.setTitleDisplay("Le réservoir d'eau doit être remplit");
    }
}
