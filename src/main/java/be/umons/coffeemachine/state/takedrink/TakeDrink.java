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

    protected PauseTransition pause = new PauseTransition(Duration.seconds(3));

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

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Preparing.instance());
    }

    protected void displayErrorMessage(CoffeeMachine coffeeMachine, String message) {
        coffeeMachine.setTitleDisplay(message);
        pause.setOnFinished(event -> this.entry(coffeeMachine));
        pause.play();
    }
}
