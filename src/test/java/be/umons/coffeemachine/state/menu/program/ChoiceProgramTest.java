package be.umons.coffeemachine.state.menu.program;

import be.umons.coffeemachine.state.Waiting;
import be.umons.coffeemachine.state.config.StateConfigTest;
import be.umons.coffeemachine.state.menu.MenuChoice;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static be.umons.coffeemachine.model.enums.MenuName.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ChoiceProgramTest extends StateConfigTest {

    @InjectMocks
    private ChoiceProgram choiceProgram;

    @Test
    void ok() {
        choiceProgram.setCurrentOptions(Cleaning.instance());
        choiceProgram.ok(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Cleaning.class));
    }

    @Test
    void back() {
        choiceProgram.back(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(MenuChoice.class));
    }

    @Test
    void menu() {
        choiceProgram.menu(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Waiting.class));
    }

    @Test
    void scrolling() {
        Cleaning cleaning = mock(Cleaning.class);
        when(cleaning.getName()).thenReturn(CLEANING);
        choiceProgram.setCurrentOptions(cleaning);
        choiceProgram.scrolling(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(DESCALING.getName());
        assertThat(choiceProgram.getCurrentOptions()).isInstanceOf(Descaling.class);
    }

    @Test
    void scrollingReset() {
        Descaling descaling = mock(Descaling.class);
        when(descaling.getName()).thenReturn(DESCALING);

        choiceProgram.setCurrentOptions(descaling);
        choiceProgram.scrolling(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(CALC_AND_CLEAN.getName());
        assertThat(choiceProgram.getCurrentOptions()).isInstanceOf(CalcAndClean.class);
    }

    @Test
    void entry() {

        choiceProgram.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setQuantityDisplay("");
        verify(coffeeMachine, times(1)).setIntensityDisplay("");
        verify(coffeeMachine, times(1)).setTitleDisplay(CLEANING.getName());
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
