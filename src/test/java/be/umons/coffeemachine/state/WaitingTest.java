package be.umons.coffeemachine.state;

import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.state.config.StateConfigTest;
import be.umons.coffeemachine.state.menu.MenuChoice;
import be.umons.coffeemachine.state.takedrink.CoffeeDrink;
import be.umons.coffeemachine.state.takedrink.MilkyDrink;
import be.umons.coffeemachine.state.takedrink.special.VerseuseDrink;
import be.umons.coffeemachine.state.takedrink.special.WaterDrink;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class WaitingTest extends StateConfigTest {

    @InjectMocks
    private Waiting waiting;

    @Test
    void entry() {
        when(coffeeMachine.isError()).thenReturn(false);

        waiting.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay("En attente");
        verify(coffeeMachine, times(1)).setQuantityDisplay("");
        verify(coffeeMachine, times(1)).setIntensityDisplay("");

        verifyEnableBtn();
    }

    @Test
    void entryError() {
        when(coffeeMachine.isError()).thenReturn(true);

        waiting.entry(coffeeMachine);

        verify(coffeeMachine, never()).setTitleDisplay("En attente");
        verify(coffeeMachine, never()).setQuantityDisplay("");
        verify(coffeeMachine, never()).setIntensityDisplay("");

        verifyCoffeeMachineOnce().transition(any(Error.class));
    }

    @Test
    void startStop() {
        waiting.startStop(coffeeMachine);

        verifyZeroInteractions(coffeeMachine);
    }

    @Test
    void menu() {
        waiting.menu(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(MenuChoice.class));
    }

    @Test
    void security() {

    }

    @Test
    void coffee() {
        Drink drink = new Coffee("Expresso");
        waiting.coffee(coffeeMachine, drink);

        verify(coffeeMachine, times(1)).setDrink(drink);
        verify(coffeeMachine, times(1)).transition(any(CoffeeDrink.class));
    }

    @Test
    void milky() {
        Drink drink = new MilkFroth("test");
        waiting.milky(coffeeMachine, drink);

        verify(coffeeMachine, times(1)).setDrink(drink);
        verify(coffeeMachine, times(1)).transition(any(MilkyDrink.class));
    }

    @Test
    void water() {
        waiting.water(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(WaterDrink.class));
    }

    @Test
    void verseuse() {
        waiting.verseuse(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(VerseuseDrink.class));

    }

    @Test
    void special() {

    }

    @Test
    void favori() {
        waiting.favori(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(ChoiceProfiles.class));
    }

    @Override
    protected void verifyEnableBtn() {
        verify(coffeeMachine, times(1)).resetDisplayBtn();
        verifyEnableDrink(coffeeMachine);
    }
}
