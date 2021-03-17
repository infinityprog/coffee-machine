package be.umons.coffeemachine.model.drink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.model.enums.Quantity;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Abstract Drink Model")
class DrinkTest {

    @InjectMocks
    private Drink drink = mock(Drink.class, Mockito.CALLS_REAL_METHODS);

    @Mock
    private PauseTransition pauseTransition;

    @Mock
    private CoffeeMachine coffeeMachine;

    @BeforeEach
    void setUp() {
        drink = mock(Drink.class, Mockito.CALLS_REAL_METHODS);
    }

    @Test
    @DisplayName("Change quantity : set intensity DOUBLESHOT_STRONG")
    void changeQuantityIsDoubleShot() {
        drink.setIntensity(Intensity.DOUBLESHOT_STRONG);
        drink.setQuantity(Quantity.LARGE);

        drink.changeQuantity();

        assertEquals(Quantity.MEDIUM, drink.getQuantity());
    }

    @Test
    @DisplayName("Change quantity : without exception case")
    void changeQuantityWithoutDoubleShot() {
        drink.setQuantity(Quantity.MEDIUM);

        drink.changeQuantity();

        assertEquals(Quantity.LARGE, drink.getQuantity());
    }

    @Test
    @DisplayName("Change quantity : reload first")
    void changeQuantityWithoutReloadFirst() {
        drink.setQuantity(Quantity.LARGE);

        drink.changeQuantity();

        assertEquals(Quantity.SMALL, drink.getQuantity());
    }

    @Test
    @DisplayName("Change intensity : set double")
    void changeIntensityIsTwo() {
        drink = new DrinkMock("Test");
        drink.setTwo(true);
        drink.setIntensity(Intensity.VERY_STRONG);
        drink.setPause(pauseTransition);
        drink.setEndPreparation(pauseTransition);

        drink.changeIntensity();

        assertEquals(Intensity.COMP_POWDER, drink.getIntensity());

    }

    @Test
    @DisplayName("Change intensity : set quantity to small")
    void changeIntensityQuantitySmall() {
        drink.setQuantity(Quantity.SMALL);
        drink.setIntensity(Intensity.VERY_STRONG);

        drink.changeIntensity();

        assertEquals(Intensity.COMP_POWDER, drink.getIntensity());

    }

    @Test
    @DisplayName("Change intensity : without exception case")
    void changeIntensityWithoutTwoAndSmall() {
        drink.setIntensity(Intensity.VERY_STRONG);

        drink.changeIntensity();

        assertEquals(Intensity.DOUBLESHOT_STRONG, drink.getIntensity());

    }

    @Test
    @DisplayName("Change intensity : reload first")
    void changeIntensityReloadFirst() {
        drink.setIntensity(Intensity.COMP_POWDER);

        drink.changeIntensity();

        assertEquals(Intensity.VERY_SOFT, drink.getIntensity());

    }

    @Test
    @DisplayName("Set two at true")
    void setTwoTrue() {
        drink = new DrinkMock("Test");
        drink.setPause(pauseTransition);
        drink.setEndPreparation(pauseTransition);

        drink.setTwo(true);

        verify(pauseTransition, times(1)).setDuration(Duration.millis(200));
        verify(pauseTransition, times(1)).setDuration(Duration.seconds(2));
    }

    @Test
    @DisplayName("Set two at false")
    void setTwoFalse() {
        drink = new DrinkMock("Test");
        drink.setPause(pauseTransition);
        drink.setEndPreparation(pauseTransition);

        drink.setTwo(false);

        verify(pauseTransition, times(1)).setDuration(Duration.millis(100));
        verify(pauseTransition, times(1)).setDuration(Duration.seconds(1));
    }

    @Test
    @DisplayName("Make drink")
    void makeDrink() {
        drink = new DrinkMock("Test");
        drink.setPause(new PauseTransition(Duration.ZERO));
        drink.setEndPreparation(pauseTransition);

        drink.makeDrink(coffeeMachine);

        verify(coffeeMachine, times(101)).setTitleDisplay(anyString());
        verify(pauseTransition, times(1)).play();

        assertTrue(drink.isPreparing());
    }

    @Test
    @DisplayName("Stop")
    void stop() {
        drink = new DrinkMock("Test");
        drink.setPause(pauseTransition);

        drink.stop(coffeeMachine);

        verify(pauseTransition, times(1)).stop();
        assertTrue(drink.isPreparing());
    }
}
