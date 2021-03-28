package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.state.takedrink.special.VerseuseDrink;
import be.umons.coffeemachine.state.takedrink.special.WaterDrink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoffeeDrink extends TakeDrink {

    private Logger logger = LogManager.getLogger(CoffeeDrink.class);

    private static CoffeeDrink instance;

    public static CoffeeDrink instance() {
        if (instance == null) {
            instance = new CoffeeDrink();
        }

        return instance;
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Preparing.instance());
    }

    @Override
    public void intensity(CoffeeMachine coffeeMachine) {
        logger.info("Change intensity");

        Drink drink = coffeeMachine.getDrink();
        drink.changeIntensity();

        super.entry(coffeeMachine);
    }

    @Override
    public void two(CoffeeMachine coffeeMachine) {
        Drink drink = coffeeMachine.getDrink();
        if (drink.getIntensity() != Intensity.DOUBLESHOT_STRONG_MORE
                && drink.getIntensity() != Intensity.DOUBLESHOT_STRONG
                && drink.getIntensity() != Intensity.COMP_POWDER) {
            drink.setTwo(!drink.isTwo());
        } else {
            displayErrorMessage(coffeeMachine,"Vous ne pouvez pas faire deux café si l'intensité est sur double shot");
        }

    }

    @Override
    public void quantity(CoffeeMachine coffeeMachine) {
        logger.info("Change quantity");

        Drink drink = coffeeMachine.getDrink();
        drink.changeQuantity();

        super.entry(coffeeMachine);
    }

    @Override
    public void coffee(CoffeeMachine coffeeMachine, Drink drink) {
        coffeeMachine.setDrink(drink);
        coffeeMachine.transition(CoffeeDrink.instance());
    }

    @Override
    public void milky(CoffeeMachine coffeeMachine, Drink drink) {
        coffeeMachine.setDrink(drink);
        coffeeMachine.transition(MilkyDrink.instance());
    }

    @Override
    public void water(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(WaterDrink.instance());
    }

    @Override
    public void verseuse(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(VerseuseDrink.instance());
    }
}
