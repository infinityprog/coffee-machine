package be.umons.coffeemachine.state.menu.program;

import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.model.program.Program;
import be.umons.coffeemachine.state.Waiting;
import be.umons.coffeemachine.state.config.StateConfigTest;
import be.umons.coffeemachine.state.menu.Favorite;
import be.umons.coffeemachine.state.menu.MenuChoice;
import be.umons.coffeemachine.state.menu.SettingsQuantity;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static be.umons.coffeemachine.model.enums.MenuName.CALC_AND_CLEAN;
import static be.umons.coffeemachine.model.enums.MenuName.CLEANING;
import static be.umons.coffeemachine.model.enums.MenuName.CLEANING_AND_MAINTENANCE;
import static be.umons.coffeemachine.model.enums.MenuName.DESCALING;
import static be.umons.coffeemachine.model.enums.MenuName.FAVORI;
import static be.umons.coffeemachine.model.enums.MenuName.SETTINGS_DRINK_QUANTITY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ChoiceProgramTest extends StateConfigTest {

    @InjectMocks
    private ChoiceProgram choiceProgram;

    @Mock
    private Program currentOptions;

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
}
