package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.state.config.TakeDrinkConfigTest;
import be.umons.coffeemachine.state.takedrink.special.VerseuseDrink;
import be.umons.coffeemachine.state.takedrink.special.WaterDrink;
import javafx.animation.PauseTransition;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class MilkyDrinkTest extends TakeDrinkConfigTest {

    @InjectMocks
    private MilkyDrink milkyDrink;

    @Mock
    PauseTransition pause;

    @Test
    void entry() {
        mockEntry();
        milkyDrink.entry(coffeeMachine);
        verifyEntry();
    }


    @Test
    void startStop() {
        milkyDrink.startStop(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Preparing.class));
    }

    @Test
    void intensity() {
        mockEntry();

        milkyDrink.intensity(coffeeMachine);

        verify(drink, times(1)).changeIntensity();
        verifyEntry();
    }

    @Test
    void twoIsDoubleShot() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.getIntensity()).thenReturn(Intensity.DOUBLESHOT_STRONG);
        doNothing().when(pause).play();

        milkyDrink.two(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(anyString());
    }

    @Test
    void two() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.getIntensity()).thenReturn(Intensity.SOFT);

        milkyDrink.two(coffeeMachine);

        verify(drink, times(1)).setTwo(any(boolean.class));
        verify(coffeeMachine, never()).setTitleDisplay(anyString());
        verifyCoffeeMachineOnce().setTwo(any(boolean.class));
    }

    @Test
    void quantity() {
        mockEntry();

        milkyDrink.quantity(coffeeMachine);

        verify(drink, times(1)).changeQuantity();
        verifyEntry();
    }

    @Test
    void coffee() {
        Drink drink = new Coffee("Expresso");
        milkyDrink.coffee(coffeeMachine, drink);

        verify(coffeeMachine, times(1)).setDrink(drink);
        verify(coffeeMachine, times(1)).transition(any(CoffeeDrink.class));
    }

    @Test
    void milky() {
        Drink drink = new MilkFroth("test");
        milkyDrink.milky(coffeeMachine, drink);

        verify(coffeeMachine, times(1)).setDrink(drink);
        verify(coffeeMachine, times(1)).transition(any(MilkyDrink.class));

    }

    @Test
    void water() {
        milkyDrink.water(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(WaterDrink.class));

    }

    @Test
    void verseuse() {
        milkyDrink.verseuse(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(VerseuseDrink.class));

    }
}
