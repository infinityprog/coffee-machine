package be.umons.coffeemachine.state.menu.programme;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.model.factory.ProgramFactory;
import be.umons.coffeemachine.state.menu.Menu;
import be.umons.coffeemachine.state.menu.MenuChoice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static be.umons.coffeemachine.model.enums.MenuName.CALC_AND_CLEAN;
import static be.umons.coffeemachine.model.enums.MenuName.CLEANING;
import static be.umons.coffeemachine.model.enums.MenuName.CLEANING_AND_MAINTENANCE;
import static be.umons.coffeemachine.model.enums.MenuName.CLEANING_MILK_FROTH;
import static be.umons.coffeemachine.model.enums.MenuName.DESCALING;

public class ChoiceProgram extends Menu {

    private static ChoiceProgram instance;

    private Program currentOptions;

    public static ChoiceProgram instance() {
        if (instance == null) {
            instance = new ChoiceProgram();
        }

        return instance;
    }

    public ChoiceProgram() {
        super(CLEANING_AND_MAINTENANCE);
    }

    @Override
    public void ok(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(currentOptions);
    }

    @Override
    public void scrolling(CoffeeMachine coffeeMachine) {
        currentOptions = choiceProgram();
        coffeeMachine.setTitleDisplay(currentOptions.getName().getName());
    }

    @Override
    public void back(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(MenuChoice.instance());
    }

    @Override
    public void security(CoffeeMachine coffeeMachine) {
        super.security(coffeeMachine);
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        if (currentOptions == null) {
            currentOptions = Cleaning.instance();
        }

        coffeeMachine.setQuantityDisplay("");
        coffeeMachine.setIntensityDisplay("");
        coffeeMachine.setTitleDisplay(currentOptions.getName().getName());
    }

    public Program getCurrentOptions() {
        return currentOptions;
    }

    public ChoiceProgram setCurrentOptions(Program currentOptions) {
        this.currentOptions = currentOptions;
        return this;
    }

    private Program choiceProgram() {
        if (currentOptions == null) {
            return Cleaning.instance();
        }

        List<MenuName> programmes = Arrays.stream(MenuName.values())
                .filter(programme -> isProgramme(programme))
                .collect(Collectors.toList());
        MenuName currentMenuName = this.currentOptions.getName();
        ProgramFactory programFactory = new ProgramFactory();

        for (int i = 0; i < programmes.size(); i++) {
            if (programmes.get(i) == currentMenuName &&  i + 1 < programmes.size()) {
                return programFactory.getProgram(programmes.get(i + 1));
            } else if (programmes.get(i) == currentMenuName &&  i + 1 == programmes.size()) {
                return programFactory.getProgram(programmes.get(0));
            }
        }

        return null;
    }

    private boolean isProgramme(MenuName name) {
        return name == CLEANING || name == DESCALING || name == CLEANING_MILK_FROTH || name == CALC_AND_CLEAN;
    }
}
