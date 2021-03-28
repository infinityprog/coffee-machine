package be.umons.coffeemachine.model.drink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.model.enums.Quantity;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Objects;

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

    public void changeQuantity() {
        Quantity[] quantities;

        if (intensity == Intensity.DOUBLESHOT_STRONG || intensity == Intensity.DOUBLESHOT_STRONG_MORE) {
            quantities = Arrays.stream(Quantity.values())
                    .filter(filter -> filter != Quantity.SMALL)
                    .toArray(Quantity[]::new);
        } else {
            quantities = Quantity.values();
        }

        for (int i = 0; i < quantities.length; i++) {
            if (quantities[i] == quantity &&  i + 1 < quantities.length) {
                quantity = quantities[i + 1];
                return;
            } else if (quantities[i] == quantity &&  i + 1 == quantities.length) {
                quantity = quantities[0];
                return;
            }
        }
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public Drink setIntensity(Intensity intensity) {
        this.intensity = intensity;
        return this;
    }

    public void changeIntensity() {
        Intensity[] intensities;

        if (isTwo() || quantity == Quantity.SMALL) {
            intensities = Arrays.stream(Intensity.values())
                    .filter(filter -> filter != Intensity.DOUBLESHOT_STRONG && filter != Intensity.DOUBLESHOT_STRONG_MORE)
                    .toArray(Intensity[]::new);
        } else {
            intensities = Intensity.values();
        }


        for (int i = 0; i < intensities.length; i++) {
            if (intensities[i] == intensity &&  i + 1 < intensities.length) {
                intensity = intensities[i + 1];
                return;
            } else if (intensities[i] == intensity &&  i + 1 == intensities.length) {
                intensity = intensities[0];
                return;
            }
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return name.equals(drink.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Use only for testing
     * @param pause
     * @return
     */
    public Drink setPause(PauseTransition pause) {
        this.pause = pause;
        return this;
    }

    /**
     * Use only for testing
     * @param endPreparation
     * @return
     */
    protected Drink setEndPreparation(PauseTransition endPreparation) {
        this.endPreparation = endPreparation;
        return this;
    }
}
