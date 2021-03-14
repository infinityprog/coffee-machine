package be.umons.coffeemachine.state.menu.cleaningandmaintenance;

import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.menu.Menu;
import be.umons.coffeemachine.state.menu.MenuChoice;

public class CAMOptions extends Menu {

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public CAMOptions setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public CAMOptions(MenuName name) {
        super(name);
    }
}
