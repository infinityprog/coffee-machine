package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.model.enums.Quantity;
import be.umons.coffeemachine.state.State;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.util.Arrays;

public abstract class TakeDrink extends State {

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

    protected void changeIntensity(Drink drink) {
        Intensity[] intensities;
        Intensity currentIntensity = drink.getIntensity();

        if (drink.isTwo() || drink.getQuantity() == Quantity.SMALL) {
             intensities = Arrays.stream(Intensity.values())
                     .filter(filter -> filter != Intensity.DOUBLESHOT_STRONG && filter != Intensity.DOUBLESHOT_STRONG_MORE)
                     .toArray(Intensity[]::new);
        } else {
            intensities = Intensity.values();
        }


        for (int i = 0; i < intensities.length; i++) {
            if (intensities[i] == currentIntensity &&  i + 1 < intensities.length) {
                drink.setIntensity(intensities[i + 1]);
            } else if (intensities[i] == currentIntensity &&  i + 1 == intensities.length) {
                drink.setIntensity(intensities[0]);
            }
        }
    }

    protected void changeQuantity(Drink drink) {
        Quantity[] quantities;
        Quantity currentQuantity = drink.getQuantity();

        if (drink.getIntensity() == Intensity.DOUBLESHOT_STRONG || drink.getIntensity() == Intensity.DOUBLESHOT_STRONG_MORE) {
            quantities = Arrays.stream(Quantity.values())
                    .filter(filter -> filter != Quantity.SMALL)
                    .toArray(Quantity[]::new);
        } else {
            quantities = Quantity.values();
        }

        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == currentQuantity &&  i + 1 < quantities.length) {
                drink.setQuantity(quantities[i + 1]);
            } else if (quantities[i] == currentQuantity &&  i + 1 == quantities.length) {
                drink.setQuantity(quantities[0]);
            }
        }
    }

    protected void displayErrorMessage(CoffeeMachine coffeeMachine, String message) {
        coffeeMachine.setTitleDisplay(message);
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> this.entry(coffeeMachine));
        pause.play();
    }
}
