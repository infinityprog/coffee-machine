package be.umons.coffeemachine.state.takedrink.special;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.state.takedrink.CoffeeDrink;
import be.umons.coffeemachine.state.takedrink.MilkyDrink;
import be.umons.coffeemachine.state.takedrink.TakeDrink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WaterDrink extends TakeDrink {

    private static final Logger LOGGER = LogManager.getLogger(WaterDrink.class);

    private static WaterDrink instance;

    public static WaterDrink instance() {
        if (instance == null) {
            instance = new WaterDrink();
        }

        return instance;
    }

    @Override
    public void quantity(CoffeeMachine coffeeMachine) {
        LOGGER.info("Change quantity");

        Drink drink = coffeeMachine.getDrink();
        drink.changeQuantity();

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
