package be.umons.coffeemachine.state.takedrink.special;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.Quantity;
import be.umons.coffeemachine.state.takedrink.CoffeeDrink;
import be.umons.coffeemachine.state.takedrink.MilkyDrink;
import be.umons.coffeemachine.state.takedrink.TakeDrink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VerseuseDrink extends TakeDrink {

    private static final Logger LOGGER = LogManager.getLogger(VerseuseDrink.class);

    private static VerseuseDrink instance;

    public static VerseuseDrink instance() {
        if (instance == null) {
            instance = new VerseuseDrink();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        super.entry(coffeeMachine);

        Drink drink = coffeeMachine.getDrink();
        if (drink.getQuantity() == Quantity.LARGE) {
            coffeeMachine.setQuantityDisplay("6 boissons");
        } else {
            coffeeMachine.setQuantityDisplay("4 boissons");
        }
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }

    @Override
    public void quantity(CoffeeMachine coffeeMachine) {
        Drink drink = coffeeMachine.getDrink();

        if (drink.getQuantity() == Quantity.LARGE) {
            drink.setQuantity(Quantity.MEDIUM);
            coffeeMachine.setQuantityDisplay("4 boissons");
        } else {
            drink.setQuantity(Quantity.LARGE);
            coffeeMachine.setQuantityDisplay("6 boissons");
        }
    }

    @Override
    public void intensity(CoffeeMachine coffeeMachine) {
        LOGGER.info("Change intensity");

        Drink drink = coffeeMachine.getDrink();

        changeIntensity(drink);

        super.entry(coffeeMachine);
    }

    @Override
    public void coffee(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(CoffeeDrink.instance());
    }

    @Override
    public void milky(CoffeeMachine coffeeMachine) {
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
