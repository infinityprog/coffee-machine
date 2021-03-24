package be.umons.coffeemachine.context;

import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.model.drink.coffee.MilkyDrink;
import be.umons.coffeemachine.state.State;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CoffeeMachineTest {

    @InjectMocks
    private CoffeeMachine coffeeMachine;

    @Mock
    State state;

    @Test
    public void btnStartStop() {
        coffeeMachine.setState(state);

        coffeeMachine.btnStartStop();

        verify(state, times(1)).startStop(coffeeMachine);
    }

    @Test
    public void btnOk() {
        coffeeMachine.setState(state);

        coffeeMachine.btnOk();

        verify(state, times(1)).ok(coffeeMachine);
    }

    @Test
    public void btnMenu() {
        coffeeMachine.setState(state);

        coffeeMachine.btnMenu();

        verify(state, times(1)).menu(coffeeMachine);
    }

    @Test
    public void btnQuantity() {
        coffeeMachine.setState(state);

        coffeeMachine.btnQuantity();

        verify(state, times(1)).quantity(coffeeMachine);
    }

    @Test
    public void btnIntensity() {
        coffeeMachine.setState(state);

        coffeeMachine.btnIntensity();

        verify(state, times(1)).intensity(coffeeMachine);
    }

    @Test
    public void btnDouble() {
        coffeeMachine.setState(state);

        coffeeMachine.btnDouble();

        verify(state, times(1)).two(coffeeMachine);
    }

    @Test
    public void btnBack() {
        coffeeMachine.setState(state);

        coffeeMachine.btnBack();

        verify(state, times(1)).back(coffeeMachine);
    }

    @Test
    public void btnSecurity() {
        coffeeMachine.setState(state);

        coffeeMachine.btnSecurity();

        verify(state, times(1)).security(coffeeMachine);
    }

    @Test
    public void btnScrolling() {
        coffeeMachine.setState(state);

        coffeeMachine.btnScrolling();

        verify(state, times(1)).scrolling(coffeeMachine);
    }

    @Test
    public void btnSpecial() {
        coffeeMachine.setState(state);

        coffeeMachine.btnSpecial();

        verify(state, times(1)).special(coffeeMachine);
    }

    @Test
    public void btnExpresso() {
        coffeeMachine.setState(state);

        coffeeMachine.btnExpresso();

        verify(state, times(1)).coffee(coffeeMachine, new Coffee("Expresso"));
    }

    @Test
    public void btnExpressoMacch() {
        coffeeMachine.setState(state);

        coffeeMachine.btnExpressoMacch();

        verify(state, times(1)).coffee(coffeeMachine, new Coffee("Expresso Macchiato"));
    }

    @Test
    public void btnCoffee() {
        coffeeMachine.setState(state);

        coffeeMachine.btnCoffee();

        verify(state, times(1)).coffee(coffeeMachine, new Coffee("Caffé"));
    }

    @Test
    public void btnCappuccino() {
        coffeeMachine.setState(state);

        coffeeMachine.btnCappuccino();

        verify(state, times(1)).coffee(coffeeMachine, new MilkyDrink("Cappuccino", "Mousse de lait"));
    }

    @Test
    public void btnLatteMacchiate() {
        coffeeMachine.setState(state);

        coffeeMachine.btnLatteMacchiate();

        verify(state, times(1)).milky(coffeeMachine, new MilkyDrink("Latte Machiate", "Lait"));
    }

    @Test
    public void btnMilkCoffee() {
        coffeeMachine.setState(state);

        coffeeMachine.btnMilkCoffee();

        verify(state, times(1)).milky(coffeeMachine, new MilkyDrink("Caffé au lait", "Lait"));
    }

    @Test
    public void btnMilkFroth() {
        coffeeMachine.setState(state);

        coffeeMachine.btnMilkFroth();

        verify(state, times(1)).milky(coffeeMachine, new MilkFroth("Mousse de Lait"));
    }

    @Test
    public void btnFavorite() {
        coffeeMachine.setState(state);

        coffeeMachine.btnFavorite();

        verify(state, times(1)).favori(coffeeMachine);
    }

    @Test
    public void transition() {
        coffeeMachine.setState(state);

        coffeeMachine.transition(state);

        verify(state, times(1)).exit(coffeeMachine);
        verify(state, times(1)).entry(coffeeMachine);
    }
}
