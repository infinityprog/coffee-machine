package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.state.Waiting;
import be.umons.coffeemachine.state.config.TakeDrinkConfigTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PreparingTest extends TakeDrinkConfigTest {

    @InjectMocks
    private Preparing preparing;

    @Test
    void entry() {
        when(coffeeMachine.getDrink()).thenReturn(drink);

        preparing.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setIntensityDisplay("");
        verify(coffeeMachine, times(1)).setQuantityDisplay("");
        verify(drink, times(1)).onFinish(any(Runnable.class));
        verify(drink, times(1)).makeDrink(coffeeMachine);

    }

    @Test
    void startStopIsNotPreparing() {
        when(coffeeMachine.getDrink()).thenReturn(drink);

        preparing.startStop(coffeeMachine);

        verify(drink, times(1)).stop(coffeeMachine);
        verify(coffeeMachine, never()).transition(any(Waiting.class));

    }

    @Test
    void startStopIsPreparing() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.isPreparing()).thenReturn(true);

        preparing.startStop(coffeeMachine);

        verify(drink, times(1)).stop(coffeeMachine);
        verify(coffeeMachine, times(1)).transition(any(Waiting.class));

    }

    @Test
    void exitIsNotPreparing() {
        when(coffeeMachine.getDrink()).thenReturn(drink);

        preparing.exit(coffeeMachine);

        verify(coffeeMachine, times(1)).setIntensityDisplay("");
        verify(coffeeMachine, times(1)).setQuantityDisplay("");
        verify(drink, never()).resetPieces(coffeeMachine);
    }

    @Test
    void exitIsPreparing() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.isPreparing()).thenReturn(true);

        preparing.exit(coffeeMachine);

        verify(coffeeMachine, times(1)).setIntensityDisplay("");
        verify(coffeeMachine, times(1)).setQuantityDisplay("");
        verify(drink, times(1)).resetPieces(coffeeMachine);
    }


}
