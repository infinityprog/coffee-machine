package be.umons.coffeemachine.model.drink.coffee;

import be.umons.coffeemachine.config.TestConfig;
import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.Intensity;
import javafx.animation.PauseTransition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Miky Drink Model")
class MilkyDrinkTest extends TestConfig {

    @InjectMocks
    private MilkyDrink milkyDrink;

    @Mock
    private Coffee coffee;

    @Mock
    private MilkFroth milkFroth;

    @Mock
    private CoffeeMachine coffeeMachine;

    @Mock
    PauseTransition pauseTransition;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Make drink : milky drink not preparing")
    public void makeDrinkMilkDrinkNotPreparing() {
        milkyDrink.setMilkFroth(milkFroth);
        when(milkFroth.isPreparing()).thenReturn(false);
        doNothing().when(milkFroth).makeDrink(coffeeMachine);

        milkyDrink.makeDrink(coffeeMachine);

        verify(milkFroth, times(1)).onFinish(any(Runnable.class));
        verify(milkFroth, times(1)).makeDrink(coffeeMachine);
    }

    @Test
    @DisplayName("Make drink : milky drink is preparing")
    public void makeDrinkCoffeePreparing() {
        milkyDrink.setMilkFroth(milkFroth);
        milkyDrink.setCoffee(coffee);
        when(milkFroth.isPreparing()).thenReturn(true);
        doNothing().when(coffee).makeDrink(coffeeMachine);

        milkyDrink.makeDrink(coffeeMachine);

        verify(coffee, times(1)).makeDrink(coffeeMachine);
    }



    @Test
    @DisplayName("Stop : milk froth is not preparing")
    void stopMilkFrothINotsPreparing() {
        milkyDrink.setMilkFroth(milkFroth);
        milkyDrink.setCoffee(coffee);
        milkyDrink.setIntensity(Intensity.SOFT);

        when(milkFroth.isPreparing()).thenReturn(false);
        doNothing().when(milkFroth).stop(coffeeMachine);
        doNothing().when(coffee).makeDrink(coffeeMachine);

        milkyDrink.stop(coffeeMachine);


        verify(milkFroth, times(1)).stop(coffeeMachine);
        verify(coffee, times(1)).setIntensity(Intensity.SOFT);
        verify(coffee, times(1)).makeDrink(coffeeMachine);
    }

    @Test
    @DisplayName("Stop : milk froth is preparing")
    void stopMilkFrothIsPreparing() {
        milkyDrink.setMilkFroth(milkFroth);
        milkyDrink.setCoffee(coffee);

        when(milkFroth.isPreparing()).thenReturn(true);
        doNothing().when(coffee).stop(coffeeMachine);

        milkyDrink.stop(coffeeMachine);


        assertTrue(milkyDrink.isPreparing());
        verify(coffee, times(1)).stop(coffeeMachine);
    }

    @Test
    void resetPieces() {
        milkyDrink.setMilkFroth(milkFroth);
        milkyDrink.setCoffee(coffee);

        milkyDrink.resetPieces(coffeeMachine);

        assertFalse(milkyDrink.isPreparing());
        verify(milkFroth, times(1)).resetPieces(coffeeMachine);
        verify(coffee, times(1)).resetPieces(coffeeMachine);
    }
}
