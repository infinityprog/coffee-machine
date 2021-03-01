package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.format.Intensity;
import be.umons.coffeemachine.state.takedrink.preparing.Preparing;
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
    public void entry(CoffeeMachine coffeeMachine) {
        super.entry(coffeeMachine);
        coffeeMachine.setMilky(false);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Preparing.instance());
    }

    @Override
    public void intensity(CoffeeMachine coffeeMachine) {
        logger.info("Change intensity");

        Drink drink = coffeeMachine.getDrink();
        Intensity actulalIntensity = drink.getIntensity();

        Intensity newIntensity = changeIntensity(actulalIntensity);
        drink.setIntensity(newIntensity);

        System.out.println(newIntensity);

        entry(coffeeMachine);
    }

    @Override
    public void two(CoffeeMachine coffeeMachine) {
        super.two(coffeeMachine);
    }

    @Override
    public void quantity(CoffeeMachine coffeeMachine) {
        super.quantity(coffeeMachine);
    }
}
