package be.umons.coffeemachine.state.menu.program;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.menu.Menu;

public abstract class Program extends Menu {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public Program setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public Program(MenuName name) {
        super(name);
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();
        coffeeMachine.setEnableBtnStartStop(true);
        coffeeMachine.setEnableBtnMenu(true);
        coffeeMachine.setEnableBtnBack(true);
    }
}
