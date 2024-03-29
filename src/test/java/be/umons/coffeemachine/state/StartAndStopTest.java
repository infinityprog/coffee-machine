package be.umons.coffeemachine.state;

import be.umons.coffeemachine.state.config.StateConfigTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class StartAndStopTest extends StateConfigTest {

    @InjectMocks
    private StartAndStop startAndStop;

    @Test
    void startStopRising() {
        when(coffeeMachine.isHot()).thenReturn(false);
        when(coffeeMachine.isServed()).thenReturn(false);

        startAndStop.startStop(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Rinsing.class));
    }

    @Test
    void startStopWaiting() {
        when(coffeeMachine.isHot()).thenReturn(true);

        startAndStop.startStop(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Waiting.class));
    }

    @Test
    void entry() {
        startAndStop.entry(coffeeMachine);


        verify(coffeeMachine, times(1)).setIntensityDisplay("");
        verify(coffeeMachine, times(1)).setQuantityDisplay("");
        verify(coffeeMachine, times(1)).setTitleDisplay("");
        verifyEnableBtn();
    }

    @Override
    protected void verifyEnableBtn() {
        verify(coffeeMachine, times(1)).setEnableBtnStartStop(true);
        verify(coffeeMachine, times(1)).resetDisplayBtn();
    }
}
