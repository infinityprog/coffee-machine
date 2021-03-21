package be.umons.coffeemachine.state.menu.program;

import be.umons.coffeemachine.state.config.StateConfigTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CleaningTest extends StateConfigTest {

    @InjectMocks
    private Cleaning cleaningProgram;

    @Mock
    private be.umons.coffeemachine.model.program.Cleaning cleaning;

    @Test
    void startStopIsNotCalcAndClean() {
        CalcAndClean.instance().setCalcAndClean(false);

        cleaningProgram.startStop(coffeeMachine);

        assertFalse(CalcAndClean.instance().isCalcAndClean());
    }

    @Test
    void startStopIsCalcAndClean() {
        CalcAndClean.instance().setCalcAndClean(true);

        cleaningProgram.startStop(coffeeMachine);

        assertFalse(CalcAndClean.instance().isCalcAndClean());
    }

    @Test
    void entry() {
        CalcAndClean.instance().setCalcAndClean(false);

        cleaningProgram.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(anyString());
    }

    @Test
    void entryIsCalcAndClean() {
        CalcAndClean.instance().setCalcAndClean(true);

        cleaningProgram.entry(coffeeMachine);

        assertFalse(CalcAndClean.instance().isCalcAndClean());
    }
}
