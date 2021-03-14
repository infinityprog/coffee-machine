package be.umons.coffeemachine.state.menu.programme;

import be.umons.coffeemachine.context.CoffeeMachine;

import static be.umons.coffeemachine.model.enums.MenuName.CLEANING_MILK_FROTH;

public class CleaningMilkFrother extends Program {

    private static CleaningMilkFrother instance;

    public static CleaningMilkFrother instance() {
        if (instance == null) {
            instance = new CleaningMilkFrother();
        }

        return instance;
    }

    public CleaningMilkFrother() {
        super(CLEANING_MILK_FROTH);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }
}
