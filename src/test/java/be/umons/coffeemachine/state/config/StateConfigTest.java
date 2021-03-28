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

    protected void verifyEnableDrink(CoffeeMachine coffeeMachine) {
        verify(coffeeMachine).setEnableBtnExpresso(true);
        verify(coffeeMachine).setEnableBtnExpressoMacch(true);
        verify(coffeeMachine).setEnableBtnCoffee(true);
        verify(coffeeMachine).setEnableCappuccino(true);
        verify(coffeeMachine).setEnableBtnLatteMacchiate(true);
        verify(coffeeMachine).setEnableBtnMilkCoffee(true);
        verify(coffeeMachine).setEnableBtnMilkFroth(true);
        verify(coffeeMachine).setEnableBtnSpecial(true);
    }

    abstract protected void verifyEnableBtn();

    protected CoffeeMachine verifyCoffeeMachineOnce() {
        return verify(coffeeMachine, times(1));
    }

    protected CoffeeMachine verifyCoffeeMachine(int nbr) {
        return verify(coffeeMachine, times(nbr));
    }

//    public StateConfigTest() {
//        Configurator.setRootLevel(Level.DEBUG);
//    }
}
