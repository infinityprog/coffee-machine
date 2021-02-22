package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.state.State;

public class Menu extends State {

    private static Menu instance;

    private Menu currentMenu;

    private String name;

    public static Menu instance() {
        if (instance == null) {
            instance = new Menu();
        }

        return instance;
    }

    @Override
    public void ok(CoffeeMachine coffeeMachine) {
        super.ok(coffeeMachine);
    }

    @Override
    public void menu(CoffeeMachine coffeeMachine) {
        super.menu(coffeeMachine);
    }

    @Override
    public void back(CoffeeMachine coffeeMachine) {
        super.back(coffeeMachine);
    }

    @Override
    public void scrolling(CoffeeMachine coffeeMachine) {
        super.scrolling(coffeeMachine);
    }

    public void save(Drink drink) {

    }

    public Menu choiceMenu() {
        return null;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public Menu setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
        return this;
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }
}
