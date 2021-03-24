package be.umons.coffeemachine.state.takedrink.special;

import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.state.config.TakeDrinkConfigTest;
import be.umons.coffeemachine.state.takedrink.CoffeeDrink;
import be.umons.coffeemachine.state.takedrink.MilkyDrink;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class WaterDrinkTest extends TakeDrinkConfigTest {

    @InjectMocks
    private WaterDrink waterDrink;

    @Test
    void quantity() {
        mockEntry();

        waterDrink.quantity(coffeeMachine);

        verify(drink, times(1)).changeQuantity();
        verifyEntry();
    }

    @Test
    void coffee() {
        Drink drink = new Coffee("Expresso");
        waterDrink.coffee(coffeeMachine, drink);

        verify(coffeeMachine, times(1)).setDrink(drink);
        verify(coffeeMachine, times(1)).transition(any(CoffeeDrink.class));
    }

    @Test
    void milky() {
        Drink drink = new MilkFroth("test");
        waterDrink.milky(coffeeMachine, drink);

        verify(coffeeMachine, times(1)).setDrink(drink);
        verify(coffeeMachine, times(1)).transition(any(MilkyDrink.class));

    }

    @Test
    void water() {
        waterDrink.water(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(WaterDrink.class));

    }

    @Test
    void verseuse() {
        waterDrink.verseuse(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(VerseuseDrink.class));

    }
}
