package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.special.WarmWater;
import be.umons.coffeemachine.state.config.TakeDrinkConfigTest;
import be.umons.coffeemachine.state.takedrink.special.WaterDrink;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static be.umons.coffeemachine.model.enums.SpecialName.AMERICANO;
import static be.umons.coffeemachine.model.enums.SpecialName.CORDATO_COFFEE;
import static org.mockito.Mockito.*;

class SpecialDrinkTest extends TakeDrinkConfigTest {

    @InjectMocks
    private SpecialDrink specialDrink;

    @Test
    void entryWithDrinkNameLess() {
        specialDrink.setDrink(null);
        specialDrink.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(WaterDrink.class));
        verify(coffeeMachine, times(1)).setDrink(any(WarmWater.class));
    }

    @Test
    void entryWithDrink() {
        Drink drink = new Coffee(AMERICANO.getName());
        specialDrink.setDrink(drink);
        specialDrink.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(CoffeeDrink.class));
        verify(coffeeMachine, times(1)).setDrink(any(Coffee.class));
    }

    @Test
    void entryRestart() {
        Drink drink = new Coffee(CORDATO_COFFEE.getName());
        specialDrink.setDrink(drink);
        specialDrink.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(WaterDrink.class));
        verify(coffeeMachine, times(1)).setDrink(any(WarmWater.class));
    }

    @Override
    protected void verifyEnableBtn() {

    }
}
