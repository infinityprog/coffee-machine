package be.umons.coffeemachine.model.factory;

import be.umons.coffeemachine.config.TestConfig;
import be.umons.coffeemachine.state.State;
import be.umons.coffeemachine.state.menu.program.CalcAndClean;
import be.umons.coffeemachine.state.menu.program.Cleaning;
import be.umons.coffeemachine.state.menu.program.Descaling;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static be.umons.coffeemachine.model.enums.MenuName.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Program Factory")
class ProgramFactoryTest extends TestConfig {

    private ProgramFactory programFactory = new ProgramFactory();

    @Test
    @DisplayName("Get State Cleaning")
    void getProgramCleaning() {
        State result = programFactory.getProgram(CLEANING);

        assertThat(result).isInstanceOf(Cleaning.class);
    }

    /*@Test
    @DisplayName("Get State SettingsQuantity")
    void getProgramCleaningMilkFrother() {
        State result = programFactory.getProgram(CLEANING_MILK_FROTH);

        assertThat(result).isInstanceOf(CleaningMilkFrother.class);
    }*/

    @Test
    @DisplayName("Get State Descaling")
    void getProgramDescaling() {
        State result = programFactory.getProgram(DESCALING);

        assertThat(result).isInstanceOf(Descaling.class);
    }

    @Test
    @DisplayName("Get State CalcAndClean")
    void getProgramCalcAndClean() {
        State result = programFactory.getProgram(CALC_AND_CLEAN);

        assertThat(result).isInstanceOf(CalcAndClean.class);
    }

    @Test()
    @DisplayName("Get Menu throw exception")
    void getProgramThrowException() {

        Assertions.assertThrows(InvalidParameterException.class, () -> {
            programFactory.getProgram(DRINK_SERVED);
        });
    }
}
