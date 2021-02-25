package be.umons.coffeemachine.state.menu.cleaningandmaintenance;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.state.menu.Favorite;
import be.umons.coffeemachine.state.menu.Menu;

public class CleaningAndMaintenance extends Menu {

    private static CleaningAndMaintenance instance;

    private CAMOptions currentOptions;

    public static CleaningAndMaintenance instance() {
        if (instance == null) {
            instance = new CleaningAndMaintenance();
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

    @Override
    public void security(CoffeeMachine coffeeMachine) {
        super.security(coffeeMachine);
    }

    private CAMOptions choiceProgram() {
        return null;
    }

    public CAMOptions getCurrentOptions() {
        return currentOptions;
    }

    public CleaningAndMaintenance setCurrentOptions(CAMOptions currentOptions) {
        this.currentOptions = currentOptions;
        return this;
    }
}
