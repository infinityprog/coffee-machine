package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;
import javafx.application.Platform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Rinsing extends State {

    private Logger logger = LogManager.getLogger(Rinsing.class);

    private static Rinsing instance;

    public static Rinsing instance() {
        if (instance == null) return new Rinsing();

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        logger.info("Execute entry method");

    }

    private void init(CoffeeMachine coffeeMachine) {
        coffeeMachine.setQuantityDisplay("");
        coffeeMachine.setIntensityDisplay("");
        coffeeMachine.setTitleDisplay("Rinsage.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coffeeMachine.setTitleDisplay("Rinsage..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        coffeeMachine.setTitleDisplay("Rinsage...");
    }
}
