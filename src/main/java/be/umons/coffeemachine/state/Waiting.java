package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.state.menu.MenuChoice;
import be.umons.coffeemachine.state.takedrink.CoffeeDrink;
import be.umons.coffeemachine.state.takedrink.MilkyDrink;
import be.umons.coffeemachine.state.takedrink.SpecialDrink;
import be.umons.coffeemachine.state.takedrink.special.VerseuseDrink;
import be.umons.coffeemachine.state.takedrink.special.WaterDrink;

public class Waiting extends State {

    private static Waiting instance;

    public static Waiting instance() {
        if (instance == null) {
            instance = new Waiting();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        enableBtn(coffeeMachine);
        coffeeMachine.setTitleDisplay("En attente");
        coffeeMachine.setQuantityDisplay("");
        coffeeMachine.setIntensityDisplay("");
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();
        enableDrink(coffeeMachine);
        coffeeMachine.setEnableBtnMenu(true);
        coffeeMachine.setEnableBtnFavorite(true);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        super.startStop(coffeeMachine);
    }

    @Override
    public void menu(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(MenuChoice.instance());
    }

    @Override
    public void security(CoffeeMachine coffeeMachine) {
        super.security(coffeeMachine);
    }

    @Override
    public void coffee(CoffeeMachine coffeeMachine, Drink drink) {
        coffeeMachine.setDrink(drink);
        coffeeMachine.transition(CoffeeDrink.instance());
    }

    @Override
    public void milky(CoffeeMachine coffeeMachine, Drink drink) {
        coffeeMachine.setDrink(drink);
        coffeeMachine.transition(MilkyDrink.instance());
    }

    @Override
    public void water(CoffeeMachine coffeeMachine) {
        System.out.println("waiting water");
        coffeeMachine.transition(WaterDrink.instance());
    }

    @Override
    public void verseuse(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(VerseuseDrink.instance());
    }

    @Override
    public void special(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(SpecialDrink.instance());
    }

    @Override
    public void favori(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(ChoiceProfiles.instance());
    }
}
