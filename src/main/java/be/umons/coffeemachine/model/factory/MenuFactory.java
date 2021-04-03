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
//            case SETTINGS_DRINK_QUANTITY:
//                return SettingsQuantity.instance();
            case DRINK_SERVED:
                return DrinkServed.instance();
            case CLEANING_AND_MAINTENANCE:
                return ChoiceProgram.instance();
            /*case WATER_HARDNESS:
                return new MockMenu(WATER_HARDNESS);
            case STOP_AUTO:
                return new MockMenu(STOP_AUTO);
            case COFFEE_TEMPERATURE:
                return new MockMenu(COFFEE_TEMPERATURE);
            case WATER_FILTER:
                return new MockMenu(WATER_FILTER);
            case FROST_PROTECTION:
                return new MockMenu(FROST_PROTECTION);
            case BIP_SONORE:
                return new MockMenu(BIP_SONORE);*/
            default:
                throw new InvalidParameterException("There is not case for value " + name);

        }
    }
}
