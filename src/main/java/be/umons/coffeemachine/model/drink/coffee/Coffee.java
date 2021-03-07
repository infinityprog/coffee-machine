package be.umons.coffeemachine.model.drink.coffee;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.state.takedrink.precondition.FillReservoir;

public class Coffee extends Drink {

    public Coffee(String name) {
        super(name);
    }

    @Override
    public void makeDrink(CoffeeMachine coffeeMachine) {
        if(coffeeMachine.getWaterReservoir().isEmpty()) {
            coffeeMachine.transition(FillReservoir.instance());
        } else {
            if (getIntensity() == Intensity.COMP_POWDER) {
                setName(getName() + " Percolation");
            }
            super.makeDrink(coffeeMachine);
        }

    }

    @Override
    public void resetPieces(CoffeeMachine coffeeMachine) {
        coffeeMachine.getWaterReservoir().useWater();
    }
}
