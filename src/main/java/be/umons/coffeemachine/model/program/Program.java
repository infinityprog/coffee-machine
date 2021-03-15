package be.umons.coffeemachine.model.program;

import be.umons.coffeemachine.context.CoffeeMachine;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Program {

    private static final Logger LOGGER = LogManager.getLogger(Program.class);

    protected PauseTransition pause = new PauseTransition(Duration.millis(100));

    protected PauseTransition endPreparation = new PauseTransition(Duration.seconds(1));

    protected boolean finish;

    protected boolean inPreparing;

    private String name;

    public Program(String name) {
        this.name = name;
    }

    abstract void start(CoffeeMachine coffeeMachine);

    abstract boolean isReady();

    abstract String errorMessage();

    abstract void fixError();

    protected void onPreparing(CoffeeMachine coffeeMachine) {
        inPreparing = true;
        onPreparing(coffeeMachine, 0, 100);
    }

    private void onPreparing(CoffeeMachine coffeeMachine, int nbrNow, int end) {
        pause.setOnFinished(event -> {
            coffeeMachine.setTitleDisplay( getName() + " en cours" + "\n" + nbrNow + "/100");
            int resultNbr = nbrNow + 1;
            if (nbrNow >= end) {
                endPreparation.play();
            } else {
                onPreparing(coffeeMachine, resultNbr, end);
            }
        });
        pause.play();
    }

    public void onFinish(Runnable finishFunc) {

        endPreparation.setOnFinished(event -> {
            try {
                finishFunc.run();
                inPreparing = false;
                finish = true;
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        });

    }

    public boolean isFinish() {
        return finish;
    }

    public boolean isInPreparing() {
        return inPreparing;
    }

    public String getName() {
        return name;
    }
}
