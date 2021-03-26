package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.MenuName;

public class SettingsQuantity extends Menu {

    private static Menu instance;

    private Drink currentDrink;

    public static Menu instance() {
        if (instance == null) {
            instance = new SettingsQuantity();
        }

        return instance;
    }

    public SettingsQuantity() {
        super(MenuName.SETTINGS_DRINK_QUANTITY);
    }

    @Override
    public void ok(CoffeeMachine coffeeMachine) {
        super.ok(coffeeMachine);
    }

    @Override
    public void scrolling(CoffeeMachine coffeeMachine) {
        super.scrolling(coffeeMachine);
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {

    }
}
