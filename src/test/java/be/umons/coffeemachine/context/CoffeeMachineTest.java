package be.umons.coffeemachine.context;

import be.umons.coffeemachine.observer.Observer;
import be.umons.coffeemachine.state.Start;
import javafx.animation.PauseTransition;
import javafx.animation.Transition;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

@RunWith(MockitoJUnitRunner.class)
@Ignore
public class CoffeeMachineTest {

    @InjectMocks
    private CoffeeMachine coffeeMachine;

    @Mock
    Start start;

    @Mock
    private Observer observer;

    @Test
    public void btnStartStop() {

        coffeeMachine.setHot(true);
        coffeeMachine.setServed(true);

        coffeeMachine.btnStartStop();

        verify(start, times(1)).startStop(coffeeMachine);
    }

    @Test
    public void btnOk() {
    }

    @Test
    public void btnMenu() {
    }

    @Test
    public void btnQuantity() {
    }

    @Test
    public void btnIntensity() {
    }

    @Test
    public void btnDouble() {
    }

    @Test
    public void btnBack() {
    }

    @Test
    public void btnSecurity() {
    }

    @Test
    public void btnScrolling() {
    }

    @Test
    public void btnSpecial() {
    }

    @Test
    public void btnExpresso() {
    }

    @Test
    public void btnExpressoMacch() {
    }

    @Test
    public void btnCoffee() {
    }

    @Test
    public void btnCappuccino() {
    }

    @Test
    public void btnLatteMacchiate() {
    }

    @Test
    public void btnMilkCoffee() {
    }

    @Test
    public void btnMilkFroth() {
    }

    @Test
    public void transition() {
    }
}
