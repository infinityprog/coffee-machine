package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StartAndStop extends State {

    private static final Logger LOGGER = LogManager.getLogger(StartAndStop.class);

    private static StartAndStop instance;

    public static StartAndStop instance() {
        if (instance == null) {
            instance = new StartAndStop();
        }

        return instance;
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        if (!coffeeMachine.isHot() && !coffeeMachine.isServed()) {
            coffeeMachine.transition(Rinsing.instance());
        } else {
            coffeeMachine.transition(Waiting.instance());
        }
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        enableBtn(coffeeMachine);
    }

    @Override
    public void stop(CoffeeMachine coffeeMachine) {
        LOGGER.debug("Do nothing");
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();

        coffeeMachine.setIntensityDisplay("");
        coffeeMachine.setQuantityDisplay("");
        coffeeMachine.setTitleDisplay("");
        coffeeMachine.setEnableBtnStartStop(true);
    }
}
