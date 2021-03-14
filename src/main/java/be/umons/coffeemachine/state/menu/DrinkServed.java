package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.model.enums.MenuName;

public class DrinkServed extends Menu {
    private static DrinkServed instance;

    public static DrinkServed instance() {
        if(instance == null) {
            instance = new DrinkServed();
        }

        return instance;
    }

    public DrinkServed() {
        super(MenuName.DRINK_SERVED);
    }
}
