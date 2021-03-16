package be.umons.coffeemachine.model.drink.coffee;


import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.model.pieces.WaterReservoir;
import be.umons.coffeemachine.state.takedrink.precondition.FillReservoir;
import javafx.animation.PauseTransition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeTest {

    @InjectMocks
    private Coffee coffee;

    @Mock
    private CoffeeMachine coffeeMachine;

    @Mock
    private WaterReservoir waterReservoir;

    @Mock
    PauseTransition pauseTransition;

    @Test
    public void testMakeDrink_waterReservoirIsEmpty() {
        when(coffeeMachine.getWaterReservoir()).thenReturn(waterReservoir);
        when(waterReservoir.isEmpty()).thenReturn(true);

        coffee.makeDrink(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(FillReservoir.class));

    }

    @Test
    public void testMakeDrink_intensityIsPowder() throws Exception {
        when(coffeeMachine.getWaterReservoir()).thenReturn(waterReservoir);
        when(waterReservoir.isEmpty()).thenReturn(false);
        coffee.setIntensity(Intensity.COMP_POWDER);

        doNothing().when(pauseTransition).play();

        coffee.setPause(pauseTransition);
        coffee.setName("test");

        coffee.makeDrink(coffeeMachine);

        assertEquals("test Percolation", coffee.getName());
        //verify(coffeeMachine, times(1)).transition(any(FillReservoir.class));

    }

    @Test
    public void testResetPieces() {
        when(coffeeMachine.getWaterReservoir()).thenReturn(waterReservoir);
        coffee.resetPieces(coffeeMachine);

        verify(waterReservoir, times(1)).useWater();
    }
}
