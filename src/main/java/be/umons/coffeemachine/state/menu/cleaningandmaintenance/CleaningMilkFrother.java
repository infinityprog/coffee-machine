package be.umons.coffeemachine.state.menu.cleaningandmaintenance;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.menu.Menu;

public class CleaningMilkFrother extends CAMOptions {

    private static Menu instance;

    public static Menu instance() {
        if (instance == null) {
            instance = new CleaningMilkFrother();
        }

        return instance;
    }

    public CleaningMilkFrother() {
        super(MenuName.CLEANING_MILK_FROTH);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }
}
