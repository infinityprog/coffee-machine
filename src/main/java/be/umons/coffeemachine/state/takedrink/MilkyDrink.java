package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.format.Intensity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MilkyDrink extends TakeDrink {

    private static final Logger logger = LogManager.getLogger(MilkyDrink.class);

    private static MilkyDrink instance;

    public static MilkyDrink instance() {
        if (instance == null) {
            instance = new MilkyDrink();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        super.entry(coffeeMachine);
        coffeeMachine.setMilky(true);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Preparing.instance());
    }

    @Override
    public void intensity(CoffeeMachine coffeeMachine) {
        logger.info("Change intensity");

        Drink drink = coffeeMachine.getDrink();

        changeIntensity(drink);

        super.entry(coffeeMachine);
    }

    @Override
    public void two(CoffeeMachine coffeeMachine) {
        Drink drink = coffeeMachine.getDrink();
        if (drink.getIntensity() != Intensity.DOUBLESHOT_STRONG_MORE && drink.getIntensity() != Intensity.DOUBLESHOT_STRONG) {
            drink.setTwo(!drink.isTwo());
        } else {
            displayErrorMessage(coffeeMachine,"Vous ne pouvez pas faire deux café si l'intensité est sur double shot");
        }

    }

    @Override
    public void quantity(CoffeeMachine coffeeMachine) {
        logger.info("Change quantity");

        Drink drink = coffeeMachine.getDrink();

        changeQuantity(drink);

        super.entry(coffeeMachine);
    }
}
