package be.umons.coffeemachine.model.factory;

import be.umons.coffeemachine.config.TestConfig;
import be.umons.coffeemachine.state.State;
import be.umons.coffeemachine.state.menu.DrinkServed;
import be.umons.coffeemachine.state.menu.Favorite;
import be.umons.coffeemachine.state.menu.Reset;
import be.umons.coffeemachine.state.menu.SettingsQuantity;
import be.umons.coffeemachine.state.menu.program.ChoiceProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static be.umons.coffeemachine.model.enums.MenuName.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Menu Factory")
class MenuFactoryTest extends TestConfig {

    private MenuFactory menuFactory = new MenuFactory();

    @Test
    @DisplayName("Get State Rest")
    void getMenuReset() {
        State result = menuFactory.getMenu(RESET);

        assertThat(result).isInstanceOf(Reset.class);
    }

    @Test
    @DisplayName("Get State Favori")
    void getMenuFavori() {
        State result = menuFactory.getMenu(FAVORI);

        assertThat(result).isInstanceOf(Favorite.class);
    }

    @Test
    @DisplayName("Get State SettingsQuantity")
    void getMenuSettingsQuantity() {
        State result = menuFactory.getMenu(SETTINGS_DRINK_QUANTITY);

        assertThat(result).isInstanceOf(SettingsQuantity.class);
    }

    @Test
    @DisplayName("Get State DrinkServed")
    void getMenuDrinkServed() {
        State result = menuFactory.getMenu(DRINK_SERVED);

        assertThat(result).isInstanceOf(DrinkServed.class);
    }

    @Test
    @DisplayName("Get State ChoiceProgram")
    void getMenuChoiceProgram() {
        State result = menuFactory.getMenu(CLEANING_AND_MAINTENANCE);

        assertThat(result).isInstanceOf(ChoiceProgram.class);
    }

    @Test
    @DisplayName("Get Menu throw exception")
    void getMenuThrowException() {

        Assertions.assertThrows(InvalidParameterException.class, () -> {
            menuFactory.getMenu(CLEANING);
        });
    }
}
