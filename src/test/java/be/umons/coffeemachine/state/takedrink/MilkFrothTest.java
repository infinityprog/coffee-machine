package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.state.config.TakeDrinkConfigTest;
import be.umons.coffeemachine.state.takedrink.special.VerseuseDrink;
import be.umons.coffeemachine.state.takedrink.special.WaterDrink;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MilkFrothTest extends TakeDrinkConfigTest {

    @InjectMocks
    private MilkFroth milkFroth;

    @Test
    void entry() {
        mockEntry();
        milkFroth.entry(coffeeMachine);
        verifyEntry();
    }

    @Test
    void startStop() {
        milkFroth.startStop(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Preparing.class));
    }

    @Test
    void quantity() {
        milkFroth.quantity(coffeeMachine);

        verifyZeroInteractions(coffeeMachine);

    }

    @Test
    void coffee() {
        milkFroth.coffee(coffeeMachine, new Coffee("Expresso"));

        verify(coffeeMachine, times(1)).transition(any(CoffeeDrink.class));
    }

    @Test
    void milky() {
        milkFroth.milky(coffeeMachine, new be.umons.coffeemachine.model.drink.coffee.MilkFroth("test"));

        verify(coffeeMachine, times(1)).transition(any(MilkyDrink.class));

    }

    @Test
    void water() {
        milkFroth.water(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(WaterDrink.class));

    }

    @Test
    void verseuse() {
        milkFroth.verseuse(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(VerseuseDrink.class));
    }
}
