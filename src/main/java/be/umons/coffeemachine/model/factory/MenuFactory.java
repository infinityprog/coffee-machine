package be.umons.coffeemachine.model.factory;

import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.menu.*;
import be.umons.coffeemachine.state.menu.program.ChoiceProgram;

import java.security.InvalidParameterException;

public class MenuFactory {

    public Menu getMenu(MenuName name) {

        switch (name) {
            case RESET:
                return Reset.instance();
            case FAVORI:
                return Favorite.instance();
            case SETTINGS_DRINK_QUANTITY:
                return SettingsQuantity.instance();
            case DRINK_SERVED:
                return DrinkServed.instance();
            case CLEANING_AND_MAINTENANCE:
                return ChoiceProgram.instance();
            default:
                throw new InvalidParameterException("There is not case for value " + name);

        }
    }
}
