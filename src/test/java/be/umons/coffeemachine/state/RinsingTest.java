package be.umons.coffeemachine.state;

import be.umons.coffeemachine.state.config.StateConfigTest;
import javafx.animation.PauseTransition;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class RinsingTest extends StateConfigTest {

    @InjectMocks
    private Rinsing rinsing;

    @Mock
    private PauseTransition pauseTransition;

    @Test
    void entry() {
        rinsing.entry(coffeeMachine);

        verify(pauseTransition, times(1)).play();
        verifyEnableBtn();
    }

    @Override
    protected void verifyEnableBtn() {
        verifyCoffeeMachineOnce().resetDisplayBtn();
    }
}
