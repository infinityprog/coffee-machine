package be.umons.coffeemachine.state.menu.cleaningandmaintenance;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.menu.Menu;

public class Descaling extends CalcAndClean {

    private static Menu instance;

    public static Menu instance() {
        if (instance == null) {
            instance = new Descaling();
        }

        return instance;
    }

    public Descaling() {
        super(MenuName.DESCALING);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }
}
