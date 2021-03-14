package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.MenuName;

public class FrostProtection extends Menu {

    private static FrostProtection instance;

    public static FrostProtection instance() {
        if (instance == null) {
            instance = new FrostProtection();
        }

        return instance;
    }

    public FrostProtection() {
        super(MenuName.FROST_PROTECTION);
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        super.entry(coffeeMachine);
    }
}
