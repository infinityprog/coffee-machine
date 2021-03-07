package be.umons.coffeemachine.model.drink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.format.Intensity;
import be.umons.coffeemachine.model.format.Quantity;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Drink {

    private static final Logger LOGGER = LogManager.getLogger(Drink.class);

    private String name;

    private Quantity quantity = Quantity.MEDIUM;

    private Intensity intensity = Intensity.NORMAL;

    protected boolean preparing;

    protected int advancement;

    private boolean two = false;

    protected PauseTransition pause = new PauseTransition(Duration.millis(100));;

    protected PauseTransition endPreparation = new PauseTransition(Duration.seconds(1));

    public Drink(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Drink setName(String name) {
        this.name = name;
        return this;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Drink setQuantity(Quantity quantity) {
        this.quantity = quantity;
        return this;
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public Drink setIntensity(Intensity intensity) {
        this.intensity = intensity;
        return this;
    }

    public boolean isTwo() {
        return two;
    }

    public Drink setTwo(boolean two) {
        this.two = two;

        if (two) {
            pause.setDuration(Duration.millis(200));
            endPreparation.setDuration(Duration.seconds(2));
        } else {
            pause.setDuration(Duration.millis(100));
            endPreparation.setDuration(Duration.seconds(1));
        }

        return this;
    }

    public void makeDrink(CoffeeMachine coffeeMachine) {
        onPreparing(coffeeMachine);
    }

    public void stop(CoffeeMachine coffeeMachine) {
        pause.stop();
        preparing = true;
    }

    public boolean isPreparing() {
        return preparing;
    }

    public PauseTransition getEndPreparation() {
        return endPreparation;
    }

    protected void onPreparing(CoffeeMachine coffeeMachine) {
        onPreparing(coffeeMachine, 0, 100);
    }

    private void onPreparing(CoffeeMachine coffeeMachine, int nbrNow, int end) {
        pause.setOnFinished(event -> {
            coffeeMachine.setTitleDisplay("Préparation " + getName() + "\n" + nbrNow + "/100");
            int resultNbr = nbrNow + 1;
            if (nbrNow >= end) {
                endPreparation.play();
                preparing = true;
            } else {
                onPreparing(coffeeMachine, resultNbr, end);
            }
        });
        pause.play();
    }

    public abstract void resetPieces(CoffeeMachine coffeeMachine);

    public void onFinish(Runnable finishFunc) {

            endPreparation.setOnFinished(event -> {
                try {
                    finishFunc.run();
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                }
            });

    }

}
