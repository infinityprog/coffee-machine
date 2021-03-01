package be.umons.coffeemachine.state.takedrink.preparing;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.state.Waiting;
import be.umons.coffeemachine.state.takedrink.TakeDrink;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class Preparing extends TakeDrink {

    private static Preparing instance;

    private boolean preparing;

    private PauseTransition pause;

    public static Preparing instance() {
        if (instance == null) {
            instance = new Preparing();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        preparing = true;
        onPreparing(coffeeMachine);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        pause.stop();
        coffeeMachine.transition(Waiting.instance());
    }

    @Override
    public void exit(CoffeeMachine coffeeMachine) {
        coffeeMachine.setIntensityDisplay("");
        coffeeMachine.setQuantityDisplay("");
    }

    private void onPreparing(CoffeeMachine coffeeMachine) {
        pause = new PauseTransition(Duration.millis(100));
        onPreparing(pause, coffeeMachine, 0, 100);
    }

    private void onPreparing(PauseTransition pause, CoffeeMachine coffeeMachine, int nbrNow, int end) {
        String drinkName = coffeeMachine.getDrink().getName();
        System.out.println(drinkName);
        pause.setOnFinished(event -> {
            coffeeMachine.setTitleDisplay("Préparation " + drinkName + "\n" + nbrNow + "/100");
            int resultNbr = nbrNow + 1;
            if (nbrNow >= end) {
                PauseTransition endPause = new PauseTransition(Duration.seconds(1));
                endPause.setOnFinished(event1 -> coffeeMachine.transition(Waiting.instance()));
                endPause.play();
            } else {
                onPreparing(pause, coffeeMachine, resultNbr, end);
            }
        });
        pause.play();
    }
}
