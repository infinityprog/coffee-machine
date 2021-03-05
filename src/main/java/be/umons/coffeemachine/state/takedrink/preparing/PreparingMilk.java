package be.umons.coffeemachine.state.takedrink.preparing;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.state.Waiting;
import be.umons.coffeemachine.state.takedrink.TakeDrink;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class PreparingMilk extends TakeDrink {

    private static PreparingMilk instance;

    private PauseTransition pause;

    public static PreparingMilk instance() {
        if (instance == null) {
            instance = new PreparingMilk();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        onPreparing(coffeeMachine);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Preparing.instance());
    }

    private void onPreparing(CoffeeMachine coffeeMachine) {
        pause = new PauseTransition(Duration.millis(100));
        onPreparing(pause, coffeeMachine, 0, 100);
    }

    private void onPreparing(PauseTransition pause, CoffeeMachine coffeeMachine, int nbrNow, int end) {
        Drink drink = coffeeMachine.getDrink();
        pause.setOnFinished(event -> {
            coffeeMachine.setTitleDisplay("Préparation lait\n" + nbrNow + "/100");
            int resultNbr = nbrNow + 1;
            if (nbrNow >= end) {
                PauseTransition endPause = new PauseTransition(Duration.seconds(0.5));
                if (drink.isCoffee()){
                    endPause.setOnFinished(event1 -> coffeeMachine.transition(Preparing.instance()));
                } else {
                    endPause.setOnFinished(event1 -> coffeeMachine.transition(Waiting.instance()));
                }
                endPause.play();
            } else {
                onPreparing(pause, coffeeMachine, resultNbr, end);
            }
        });
        pause.play();
    }
}
