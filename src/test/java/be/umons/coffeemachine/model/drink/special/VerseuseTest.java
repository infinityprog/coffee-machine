package be.umons.coffeemachine.model.drink.special;

import be.umons.coffeemachine.config.TestConfig;
import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.Quantity;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Verseuse Model")
class VerseuseTest extends TestConfig {

    @InjectMocks
    private Verseuse verseuse;

    @Mock
    private CoffeeMachine coffeeMachine;

    @Mock
    PauseTransition pauseTransition;

    @BeforeEach
    void setUp() {
        verseuse.setPause(pauseTransition);
        doNothing().when(pauseTransition).play();
    }

    @Test
    @DisplayName("Make drink : Quantity Large")
    void makeDrinkLargeQuantity() {
        verseuse.setQuantity(Quantity.LARGE);

        verseuse.makeDrink(coffeeMachine);

        verify(pauseTransition, times(1)).setDuration(Duration.millis(600));
        verify(pauseTransition, times(1)).play();
    }

    @Test
    @DisplayName("Make drink : Quantity Large")
    void makeDrinkMediumQuantity() {

        verseuse.makeDrink(coffeeMachine);

        verify(pauseTransition, times(1)).setDuration(Duration.millis(400));
        verify(pauseTransition, times(1)).play();
    }
}
