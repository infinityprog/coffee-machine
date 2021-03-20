package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;
import javafx.animation.PauseTransition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RinsingTest {

    @InjectMocks
    private Rinsing rinsing;

    @Mock
    private CoffeeMachine coffeeMachine;

    @Mock
    private PauseTransition pauseTransition;

    @Test
    void entry() {
        rinsing.entry(coffeeMachine);

        verify(pauseTransition, times(1)).play();
    }
}
