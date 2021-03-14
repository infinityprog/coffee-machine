package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.State;
import be.umons.coffeemachine.state.Waiting;

public abstract class Menu extends State {

    private MenuName name;

    public Menu(MenuName name) {
        this.name = name;
    }

    public MenuName getName() {
        return name;
    }

    public void setName(MenuName name) {
        this.name = name;
    }

    @Override
    public void menu(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Waiting.instance());
    }
}
