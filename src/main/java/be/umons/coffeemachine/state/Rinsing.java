package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Rinsing extends State {

    private Logger logger = LogManager.getLogger(Rinsing.class);

    private static Rinsing instance;

    PauseTransition pause = new PauseTransition(Duration.seconds(1));

    public static Rinsing instance() {
        if (instance == null) {
            instance = new Rinsing();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        logger.info("Execute entry method");

        coffeeMachine.resetDisplayBtn();
        onPause(coffeeMachine,3);
    }

    private void onPause(CoffeeMachine coffeeMachine, int nbr) {
        onPause(coffeeMachine, 0, nbr);
    }

    private void onPause(CoffeeMachine coffeeMachine, int start, int end) {
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
                onPause(coffeeMachine, startResult, end);
            }
        });
        pause.play();
    }


}
