package be.umons.coffeemachine.model.program;

import be.umons.coffeemachine.context.CoffeeMachine;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

public abstract class Program {

    protected PauseTransition pause = new PauseTransition(Duration.millis(100));;

    protected PauseTransition endPreparation = new PauseTransition(Duration.seconds(1));

    protected boolean finish;

    private String name;

    public Program(String name) {
        this.name = name;
    }

    abstract void start(CoffeeMachine coffeeMachine);

    abstract boolean isReady();

    abstract String errorMessage();

    abstract void fixError();

    protected void onPreparing(CoffeeMachine coffeeMachine) {
        onPreparing(coffeeMachine, 0, 100);
    }

    private void onPreparing(CoffeeMachine coffeeMachine, int nbrNow, int end) {
        pause.setOnFinished(event -> {
            coffeeMachine.setTitleDisplay( getName() + " en cours" + "\n" + nbrNow + "/100");
            int resultNbr = nbrNow + 1;
            if (nbrNow >= end) {
                endPreparation.play();
                finish = true;
            } else {
                onPreparing(coffeeMachine, resultNbr, end);
            }
        });
        pause.play();
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public String getName() {
        return name;
    }
}
