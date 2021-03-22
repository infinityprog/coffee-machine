package be.umons.coffeemachine.context;

import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.model.drink.coffee.MilkyDrink;
import be.umons.coffeemachine.model.drink.special.WarmWater;
import be.umons.coffeemachine.state.State;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static be.umons.coffeemachine.model.enums.SpecialName.AMERICANO;
import static be.umons.coffeemachine.model.enums.SpecialName.CORDATO_COFFEE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void btnSpecialNotDrink() {
        coffeeMachine.setState(state);

        coffeeMachine.btnSpecial();

        verify(state, times(1)).water(coffeeMachine);
        assertThat(coffeeMachine.getDrink()).isInstanceOf(WarmWater.class);

    }

    @Test
    public void btnSpecialWithDrinkNameLess() {
        coffeeMachine.setState(state);
        coffeeMachine.setDrink(new Coffee(null));

        coffeeMachine.btnSpecial();

        verify(state, times(1)).water(coffeeMachine);
        assertThat(coffeeMachine.getDrink()).isInstanceOf(WarmWater.class);

    }

    @Test
    public void btnSpecialWithDrink() {
        coffeeMachine.setState(state);
        coffeeMachine.setDrink(new Coffee(AMERICANO.getName()));

        coffeeMachine.btnSpecial();

        verify(state, times(1)).coffee(coffeeMachine);
        assertThat(coffeeMachine.getDrink()).isInstanceOf(Coffee.class);

    }

    @Test
    public void btnSpecialRestart() {
        coffeeMachine.setState(state);
        coffeeMachine.setDrink(new Coffee(CORDATO_COFFEE.getName()));

        coffeeMachine.btnSpecial();

        verify(state, times(1)).water(coffeeMachine);
        assertThat(coffeeMachine.getDrink()).isInstanceOf(WarmWater.class);

    }

    @Test
    public void btnExpresso() {
        coffeeMachine.setState(state);

        coffeeMachine.btnExpresso();

        verify(state, times(1)).coffee(coffeeMachine);

        Drink drink = coffeeMachine.getDrink();
        assertThat(drink).isInstanceOf(Coffee.class);
        assertEquals("Expresso", drink.getName());
    }

    @Test
    public void btnExpressoMacch() {
        coffeeMachine.setState(state);

        coffeeMachine.btnExpressoMacch();

        verify(state, times(1)).coffee(coffeeMachine);

        Drink drink = coffeeMachine.getDrink();
        assertThat(drink).isInstanceOf(Coffee.class);
        assertEquals("Expresso Macchiato", drink.getName());
    }

    @Test
    public void btnCoffee() {
        coffeeMachine.setState(state);

        coffeeMachine.btnCoffee();

        verify(state, times(1)).coffee(coffeeMachine);

        Drink drink = coffeeMachine.getDrink();
        assertThat(drink).isInstanceOf(Coffee.class);
        assertEquals("Caffé", drink.getName());
    }

    @Test
    public void btnCappuccino() {
        coffeeMachine.setState(state);

        coffeeMachine.btnCappuccino();

        verify(state, times(1)).coffee(coffeeMachine);

        Drink drink = coffeeMachine.getDrink();
        assertThat(drink).isInstanceOf(MilkyDrink.class);
        assertEquals("Cappuccino", drink.getName());
    }

    @Test
    public void btnLatteMacchiate() {
        coffeeMachine.setState(state);

        coffeeMachine.btnLatteMacchiate();

        verify(state, times(1)).milky(coffeeMachine);

        Drink drink = coffeeMachine.getDrink();
        assertThat(drink).isInstanceOf(MilkyDrink.class);
        assertEquals("Latte Machiate", drink.getName());
    }

    @Test
    public void btnMilkCoffee() {
        coffeeMachine.setState(state);

        coffeeMachine.btnMilkCoffee();

        verify(state, times(1)).milky(coffeeMachine);

        Drink drink = coffeeMachine.getDrink();
        assertThat(drink).isInstanceOf(MilkyDrink.class);
        assertEquals("Caffé au lait", drink.getName());
    }

    @Test
    public void btnMilkFroth() {
        coffeeMachine.setState(state);

        coffeeMachine.btnMilkFroth();

        verify(state, times(1)).milky(coffeeMachine);

        Drink drink = coffeeMachine.getDrink();
        assertThat(drink).isInstanceOf(MilkFroth.class);
        assertEquals("Mousse de Lait", drink.getName());
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
