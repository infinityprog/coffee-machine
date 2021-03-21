package be.umons.coffeemachine.state.menu.program;

import be.umons.coffeemachine.state.config.StateConfigTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static be.umons.coffeemachine.model.enums.MenuName.CALC_AND_CLEAN;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class CalcAndCleanTest extends StateConfigTest {

    @InjectMocks
    private CalcAndClean calcAndClean;

    @Test
    void entry() {
        calcAndClean.setName(CALC_AND_CLEAN);
        calcAndClean.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(CALC_AND_CLEAN.getName());
    }

    @Test
    void startStop() {
        calcAndClean.startStop(coffeeMachine);

        assertTrue(calcAndClean.isCalcAndClean());
        verify(coffeeMachine, times(1)).transition(any(Descaling.class));
    }

    @Test
    void back() {
        calcAndClean.back(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(ChoiceProgram.class));
    }
}
