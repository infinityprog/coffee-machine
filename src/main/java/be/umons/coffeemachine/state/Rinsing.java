package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Rinsing extends State {

    private Logger logger = LogManager.getLogger(Rinsing.class);

    private static Rinsing instance;

    public static Rinsing instance() {
        if (instance == null) {
            instance = new Rinsing();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        logger.info("Execute entry method");

        onPause(coffeeMachine,3);
    }

    private void onPause(CoffeeMachine coffeeMachine, int nbr) {
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        onPause(pause, coffeeMachine, 0, nbr);
    }

    private void onPause(PauseTransition pause, CoffeeMachine coffeeMachine, int start, int end) {
        pause.setOnFinished(event -> {
            String evolution = "";
            for (int i = 0; i < start; i++) {
                evolution += ".";
            }
            coffeeMachine.setTitleDisplay("Rinsage" + evolution);
            int startResult = start + 1;
            if (start >= end) {
                PauseTransition endPause = new PauseTransition(Duration.seconds(1));
                endPause.setOnFinished(event1 -> coffeeMachine.transition(Waiting.instance()));
                endPause.play();
            } else {
                onPause(pause, coffeeMachine, startResult, end);
            }
        });
        pause.play();
    }


}
