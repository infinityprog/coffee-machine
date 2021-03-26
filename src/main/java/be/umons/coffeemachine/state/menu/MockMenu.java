package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.MenuName;

public class MockMenu extends Menu {

    public MockMenu(MenuName name) {
        super(name);
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {

    }
}
