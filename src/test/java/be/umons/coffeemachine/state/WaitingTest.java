package be.umons.coffeemachine.state;

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
        waiting.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay("En attente");
        verifyResetDrink(coffeeMachine);
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
        waiting.coffee(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(CoffeeDrink.class));
    }

    @Test
    void milky() {
        waiting.milky(coffeeMachine);

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
}
