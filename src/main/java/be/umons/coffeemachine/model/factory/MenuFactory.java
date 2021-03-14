package be.umons.coffeemachine.model.factory;

import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.menu.DrinkServed;
import be.umons.coffeemachine.state.menu.Favorite;
import be.umons.coffeemachine.state.menu.Menu;
import be.umons.coffeemachine.state.menu.Reset;
import be.umons.coffeemachine.state.menu.SettingsQuantity;
import be.umons.coffeemachine.state.menu.cleaningandmaintenance.CalcAndClean;
import be.umons.coffeemachine.state.menu.cleaningandmaintenance.Cleaning;
import be.umons.coffeemachine.state.menu.cleaningandmaintenance.CleaningMilkFrother;
import be.umons.coffeemachine.state.menu.cleaningandmaintenance.Descaling;

public class MenuFactory {

    public Menu getMenu(MenuName name) {

        switch (name) {
            case RESET:
                return Reset.instance();
            case Favori:
                return Favorite.instance();
            case SETTINGS_DRINK_QUANTITY:
                return SettingsQuantity.instance();
            case CLEANING:
                return Cleaning.instance();
            case CLEANING_MILK_FROTH:
                return CleaningMilkFrother.instance();
            case DESCALING:
                return Descaling.instance();
            case CALC_AND_CLEAN:
                return CalcAndClean.instance();
            case DRINK_SERVED:
                return new DrinkServed();
            default:
                return Reset.instance();

        }
    }
}
