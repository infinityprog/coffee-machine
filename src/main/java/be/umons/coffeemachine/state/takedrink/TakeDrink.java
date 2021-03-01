package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.format.Intensity;
import be.umons.coffeemachine.model.format.Quantity;
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
        Drink drink = coffeeMachine.getDrink();
        coffeeMachine.setTitleDisplay(drink.getName());
        coffeeMachine.setIntensityDisplay(drink.getIntensity().getName());
        coffeeMachine.setQuantityDisplay(drink.getQuantity().getName());
    }

    protected Intensity changeIntensity(Intensity intensity) {
        Intensity[] intensities = Intensity.values();
        for (int i = 0; i < intensities.length; i++) {
            if (intensities[i] == intensity &&  i + 1 < intensities.length) {
                return intensities[i + 1];
            } else if (intensities[i] == intensity &&  i + 1 == intensities.length) {
                return intensities[0];
            }
        }

        return intensity;
    }

    protected Quantity changeQuantity(Quantity quantity) {
        Quantity[] quantities = Quantity.values();
        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == quantity &&  i + 1 < quantities.length) {
                return quantities[i + 1];
            } else if (quantities[i] == quantity &&  i + 1 == quantities.length) {
                return quantities[0];
            }
        }

        return quantity;
    }
}
