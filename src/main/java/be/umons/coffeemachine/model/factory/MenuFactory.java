package be.umons.coffeemachine.model.factory;

import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.menu.DrinkServed;
import be.umons.coffeemachine.state.menu.Favorite;
import be.umons.coffeemachine.state.menu.Menu;
import be.umons.coffeemachine.state.menu.Reset;
import be.umons.coffeemachine.state.menu.SettingsQuantity;
import be.umons.coffeemachine.state.menu.programme.ChoiceProgram;

public class MenuFactory {

    public Menu getMenu(MenuName name) {

        switch (name) {
            case RESET:
                return Reset.instance();
            case Favori:
                return Favorite.instance();
            case SETTINGS_DRINK_QUANTITY:
                return SettingsQuantity.instance();
            case DRINK_SERVED:
                return DrinkServed.instance();
            case CLEANING_AND_MAINTENANCE:
                return ChoiceProgram.instance();
            default:
                return Reset.instance();

        }
    }
}
