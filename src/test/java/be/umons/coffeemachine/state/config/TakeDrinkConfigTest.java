package be.umons.coffeemachine.state.config;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.model.enums.Quantity;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public abstract class TakeDrinkConfigTest extends StateConfigTest {

    @Mock
    protected Drink drink;

    protected void mockEntry() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.getName()).thenReturn("Test");
        when(drink.getIntensity()).thenReturn(Intensity.NORMAL);
        when(drink.getQuantity()).thenReturn(Quantity.MEDIUM);
    }

    protected void verifyEntry() {
        verify(coffeeMachine, times(1)).setTitleDisplay("Test");
        verify(coffeeMachine, times(1)).setIntensityDisplay(Intensity.NORMAL.getName());
        verify(coffeeMachine, times(1)).setQuantityDisplay(Quantity.MEDIUM.getName());

    }
}
