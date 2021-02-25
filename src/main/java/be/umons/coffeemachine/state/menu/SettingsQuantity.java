package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;

public class SettingsQuantity extends Menu {

    private static SettingsQuantity instance;

    private Drink currentDrink;

    public static SettingsQuantity instance() {
        if (instance == null) {
            instance = new SettingsQuantity();
        }

        return instance;
    }

    @Override
    public void ok(CoffeeMachine coffeeMachine) {
        super.ok(coffeeMachine);
    }

    @Override
    public void scrolling(CoffeeMachine coffeeMachine) {
        super.scrolling(coffeeMachine);
    }
}
