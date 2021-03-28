package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.model.enums.Quantity;
import be.umons.coffeemachine.state.config.TakeDrinkConfigTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TakeDrinkTest extends TakeDrinkConfigTest {

    @InjectMocks
    private TakeDrink takeDrink = mock(TakeDrink.class, Mockito.CALLS_REAL_METHODS);;

    @Test
    void back() {

    }

    @Test
    void entry() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.getName()).thenReturn("Expresso");
        when(drink.getIntensity()).thenReturn(Intensity.SOFT);
        when(drink.getQuantity()).thenReturn(Quantity.MEDIUM);

        takeDrink.entry(coffeeMachine);

        verifyCoffeeMachineOnce().setTitleDisplay(drink.getName());
        verifyCoffeeMachineOnce().setIntensityDisplay(drink.getIntensity().getName());
        verifyCoffeeMachineOnce().setQuantityDisplay(drink.getQuantity().getName());

        verifyEnableBtn();
    }

    @Test
    void startStop() {
        takeDrink.startStop(coffeeMachine);

        verifyCoffeeMachineOnce().transition(any(Preparing.class));
    }

    @Test
    void special() {
        takeDrink.special(coffeeMachine);

        verifyCoffeeMachineOnce().transition(any(SpecialDrink.class));
    }
}
