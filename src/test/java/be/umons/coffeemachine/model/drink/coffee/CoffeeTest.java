package be.umons.coffeemachine.model.drink.coffee;


import be.umons.coffeemachine.config.TestConfig;
import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.model.pieces.WaterReservoir;
import be.umons.coffeemachine.state.takedrink.precondition.FillReservoir;
import javafx.animation.PauseTransition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@DisplayName("Coffee Model")
public class CoffeeTest extends TestConfig {

    @InjectMocks
    private Coffee coffee;

    @Mock
    private CoffeeMachine coffeeMachine;

    @Mock
    private WaterReservoir waterReservoir;

    @Mock
    PauseTransition pauseTransition;

    @BeforeEach
    public void setUp() throws Exception {
        when(coffeeMachine.getWaterReservoir()).thenReturn(waterReservoir);
    }

    @Test
    @DisplayName("Make drink : Water reservoir is empty")
    public void testMakeDrink_waterReservoirIsEmpty() {
        when(waterReservoir.isEmpty()).thenReturn(true);

        coffee.makeDrink(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(FillReservoir.class));

    }

    @Test
    @DisplayName("Make drink : Intensity is powder")
    public void testMakeDrink_intensityIsPowder() throws Exception {
        when(waterReservoir.isEmpty()).thenReturn(false);
        coffee.setIntensity(Intensity.COMP_POWDER);

        doNothing().when(pauseTransition).play();

        coffee.setPause(pauseTransition);
        coffee.setName("test");

        coffee.makeDrink(coffeeMachine);

        assertEquals("test Percolation", coffee.getName());
        verify(pauseTransition, times(1)).play();

    }

    @Test
    @DisplayName("Reset pieces")
    public void testResetPieces() {
        coffee.resetPieces(coffeeMachine);

        verify(waterReservoir, times(1)).useWater();
    }
}
