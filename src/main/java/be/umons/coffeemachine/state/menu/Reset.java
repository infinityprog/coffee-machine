package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.MenuName;

public class Reset extends Menu {

    private static Menu instance;

    public static Menu instance() {
        if (instance == null) {
            instance = new Reset();
        }

        return instance;
    }

    public Reset() {
        super(MenuName.RESET);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {

    }

}
