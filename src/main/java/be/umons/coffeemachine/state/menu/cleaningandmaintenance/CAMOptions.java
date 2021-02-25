package be.umons.coffeemachine.state.menu.cleaningandmaintenance;

import be.umons.coffeemachine.state.menu.Menu;

public class CAMOptions extends Menu {

    private String errorMessage;

    private String name;

    public String getErrorMessage() {
        return errorMessage;
    }

    public CAMOptions setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CAMOptions setName(String name) {
        this.name = name;
        return this;
    }
}
