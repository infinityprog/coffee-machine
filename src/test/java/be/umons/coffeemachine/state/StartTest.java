package be.umons.coffeemachine.state;

import be.umons.coffeemachine.state.config.StateConfigTest;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StartTest extends StateConfigTest {

    @InjectMocks
    private Start start;

    @Test
    void startStopRising() {
        when(coffeeMachine.isHot()).thenReturn(false);
        when(coffeeMachine.isServed()).thenReturn(false);

        start.startStop(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Rinsing.class));
    }

    @Test
    void startStopWaiting() {
        when(coffeeMachine.isHot()).thenReturn(true);

        start.startStop(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Waiting.class));
    }
}
