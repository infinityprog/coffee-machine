package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.state.State;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public abstract class TakeDrink extends State {

    protected PauseTransition pause = new PauseTransition(Duration.seconds(3));

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        Drink drink = coffeeMachine.getDrink();
        coffeeMachine.setTitleDisplay(drink.getName());
        coffeeMachine.setIntensityDisplay(drink.getIntensity().getName());
        coffeeMachine.setQuantityDisplay(drink.getQuantity().getName());
        enableBtn(coffeeMachine);
        changeModeBtn(coffeeMachine, drink.getName(), false);
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();
        enableDrink(coffeeMachine);
        coffeeMachine.setEnableBtnQuantity(true);
        coffeeMachine.setEnableBtnIntensity(true);
        coffeeMachine.setEnableBtnDouble(true);
        coffeeMachine.setEnableBtnStartStop(true);
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

    @Override
    public void special(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(SpecialDrink.instance());
    }
}
