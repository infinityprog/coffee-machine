package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.MenuName;

public class DrinkServed extends Menu {
    private static DrinkServed instance;

    public static DrinkServed instance() {
        if(instance == null) {
            instance = new DrinkServed();
        }

        return instance;
    }

    public DrinkServed() {
        super(MenuName.DRINK_SERVED);
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        enableBtn(coffeeMachine);

        coffeeMachine.setIntensityDisplay("");
        coffeeMachine.setQuantityDisplay("");
        coffeeMachine.setTitleDisplay(coffeeMachine.getNbrDrinksServed());
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();
        coffeeMachine.setEnableBtnMenu(true);
        coffeeMachine.setEnableBtnBack(true);
    }

    @Override
    public void back(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(MenuChoice.instance());
    }
}
