package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.Waiting;
import be.umons.coffeemachine.state.config.StateConfigTest;
import be.umons.coffeemachine.state.menu.program.ChoiceProgram;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static be.umons.coffeemachine.model.enums.MenuName.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MenuChoiceTest extends StateConfigTest {

    @InjectMocks
    private MenuChoice menuChoice;

    @Test
    void ok() {
        menuChoice.setCurrentMenu(Favorite.instance());
        menuChoice.ok(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Favorite.class));
    }

    @Test
    void back() {
        menuChoice.back(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Waiting.class));
    }

    @Test
    void menu() {
        menuChoice.menu(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Waiting.class));
    }

    @Test
    void scrolling() {
        Favorite favorite = mock(Favorite.class);
        when(favorite.getName()).thenReturn(FAVORI);
        menuChoice.setCurrentMenu(favorite);
        menuChoice.scrolling(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(SETTINGS_DRINK_QUANTITY.getName());
        assertThat(menuChoice.getCurrentMenu()).isInstanceOf(SettingsQuantity.class);
    }

    @Test
    void scrollingReset() {
        ChoiceProgram choiceProgram = mock(ChoiceProgram.class);
        when(choiceProgram.getName()).thenReturn(CLEANING_AND_MAINTENANCE);

        menuChoice.setCurrentMenu(choiceProgram);
        menuChoice.scrolling(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(FAVORI.getName());
        assertThat(menuChoice.getCurrentMenu()).isInstanceOf(Favorite.class);
    }

    @Test
    void entry() {

        menuChoice.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setQuantityDisplay("");
        verify(coffeeMachine, times(1)).setIntensityDisplay("");
        verify(coffeeMachine, times(1)).setTitleDisplay(MenuName.FAVORI.getName());

        verifyEnableBtn();
    }

    @Override
    protected void verifyEnableBtn() {
        verifyCoffeeMachineOnce().resetDisplayBtn();
        verifyCoffeeMachineOnce().setEnableBtnMenu(true);
        verifyCoffeeMachineOnce().setEnableBtnBack(true);
        verifyCoffeeMachineOnce().setEnableBtnOk(true);
        verifyCoffeeMachineOnce().setEnableBtnScrolling(true);
    }
}
