package be.umons.coffeemachine.state.takedrink.special;

import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.model.enums.Quantity;
import be.umons.coffeemachine.state.config.TakeDrinkConfigTest;
import be.umons.coffeemachine.state.takedrink.CoffeeDrink;
import be.umons.coffeemachine.state.takedrink.MilkyDrink;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class VerseuseDrinkTest extends TakeDrinkConfigTest {

    @InjectMocks
    private VerseuseDrink verseuseDrink;

    @Test
    void entryLarge() {
        mockEntry();
        when(drink.getQuantity()).thenReturn(Quantity.LARGE);

        verseuseDrink.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setQuantityDisplay("6 boissons");
    }

    @Test
    void entryMedium() {
        mockEntry();
        when(drink.getQuantity()).thenReturn(Quantity.SMALL);

        verseuseDrink.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setQuantityDisplay("4 boissons");
    }

    @Test
    void quantityLarge() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.getQuantity()).thenReturn(Quantity.SMALL);

        verseuseDrink.quantity(coffeeMachine);

        verify(drink, times(1)).setQuantity(Quantity.LARGE);
        verify(coffeeMachine, times(1)).setQuantityDisplay("6 boissons");
    }

    @Test
    void quantityMedium() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.getQuantity()).thenReturn(Quantity.LARGE);

        verseuseDrink.quantity(coffeeMachine);

        verify(drink, times(1)).setQuantity(Quantity.MEDIUM);
        verify(coffeeMachine, times(1)).setQuantityDisplay("4 boissons");
    }

    @Test
    void intensity() {
        mockEntry();

        verseuseDrink.intensity(coffeeMachine);

        verify(drink, times(1)).changeIntensity();

        verifyEntry();
    }

    @Test
    void coffee() {
        Drink drink = new Coffee("Expresso");
        verseuseDrink.coffee(coffeeMachine, drink);

        verify(coffeeMachine, times(1)).setDrink(drink);
        verify(coffeeMachine, times(1)).transition(any(CoffeeDrink.class));
    }

    @Test
    void milky() {
        Drink drink =  new MilkFroth("test");
        verseuseDrink.milky(coffeeMachine, drink);

        verify(coffeeMachine, times(1)).setDrink(drink);
        verify(coffeeMachine, times(1)).transition(any(MilkyDrink.class));

    }

    @Test
    void water() {
        verseuseDrink.water(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(WaterDrink.class));

    }

    @Test
    void verseuse() {
        verseuseDrink.verseuse(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(VerseuseDrink.class));

    }
}
