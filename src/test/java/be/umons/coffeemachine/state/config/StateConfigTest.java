package be.umons.coffeemachine.state.config;

import be.umons.coffeemachine.context.CoffeeMachine;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public abstract class StateConfigTest {

    @Mock
    protected CoffeeMachine coffeeMachine;

    protected void verifyResetDrink(CoffeeMachine coffeeMachine) {
        verify(coffeeMachine, times(1)).setEnableBtnExpresso(true);
        verify(coffeeMachine, times(1)).setEnableBtnExpressoMacch(true);
        verify(coffeeMachine, times(1)).setEnableBtnCoffee(true);
        verify(coffeeMachine, times(1)).setEnableCappuccino(true);
        verify(coffeeMachine, times(1)).setEnableBtnLatteMacchiate(true);
        verify(coffeeMachine, times(1)).setEnableBtnMilkCoffee(true);
        verify(coffeeMachine, times(1)).setEnableBtnMilkFroth(true);
        verify(coffeeMachine, times(1)).setEnableBtnSpecial(true);
    }
}
