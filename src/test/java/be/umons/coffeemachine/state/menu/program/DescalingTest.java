package be.umons.coffeemachine.state.menu.program;

import be.umons.coffeemachine.state.config.StateConfigTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DescalingTest extends StateConfigTest {

    @InjectMocks
    private Descaling descaling;

    @Test
    void startStop() {
        CalcAndClean.instance().setCalcAndClean(false);

        descaling.startStop(coffeeMachine);

        assertFalse(CalcAndClean.instance().isCalcAndClean());
    }

    @Test
    void entry() {
        CalcAndClean.instance().setCalcAndClean(false);

        descaling.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(anyString());
    }
}
