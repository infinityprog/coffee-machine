package be.umons.coffeemachine.state.config;

import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.model.enums.Quantity;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public abstract class TakeDrinkConfigTest extends StateConfigTest {

    @Mock
    protected Drink drink;

    protected void mockEntry() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.getName()).thenReturn("Expresso");
        when(drink.getIntensity()).thenReturn(Intensity.NORMAL);
        when(drink.getQuantity()).thenReturn(Quantity.MEDIUM);
    }

    protected void verifyEntry() {
        verify(coffeeMachine, times(1)).setTitleDisplay("Expresso");
        verify(coffeeMachine, times(1)).setIntensityDisplay(Intensity.NORMAL.getName());
        verify(coffeeMachine, times(1)).setQuantityDisplay(Quantity.MEDIUM.getName());

    }

    @Override
    protected void verifyEnableBtn() {
        verifyCoffeeMachineOnce().resetDisplayBtn();
        verifyEnableDrink(coffeeMachine);
    }
}
