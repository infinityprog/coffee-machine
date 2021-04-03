package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.Waiting;

public class Reset extends Menu {

    private static Menu instance;

    public static Menu instance() {
        if (instance == null) {
            instance = new Reset();
        }

        return instance;
    }

    public Reset() {
        super(MenuName.RESET);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        for (Profile profil : coffeeMachine.getProfils()) {
            profil.clear();
        }

        coffeeMachine.transition(Waiting.instance());
    }

    @Override
    public void back(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(MenuChoice.instance());
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        enableBtn(coffeeMachine);
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();
        coffeeMachine.setEnableBtnStartStop(true);
        coffeeMachine.setEnableBtnMenu(true);
        coffeeMachine.setEnableBtnBack(true);
    }

}
