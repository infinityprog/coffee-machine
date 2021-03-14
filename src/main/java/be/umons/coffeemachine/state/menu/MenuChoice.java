package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.model.factory.MenuFactory;
import be.umons.coffeemachine.state.State;
import be.umons.coffeemachine.state.Waiting;
import be.umons.coffeemachine.state.takedrink.special.WaterDrink;

public class MenuChoice extends State {

    private static MenuChoice instance;

    private Menu currentMenu;

    public static MenuChoice instance() {
        if (instance == null) {
            instance = new MenuChoice();
        }

        return instance;
    }

    @Override
    public void ok(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(currentMenu);
    }

    @Override
    public void back(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Waiting.instance());
    }

    @Override
    public void menu(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Waiting.instance());
    }

    @Override
    public void scrolling(CoffeeMachine coffeeMachine) {
        currentMenu = choiceMenu();
        coffeeMachine.setTitleDisplay(currentMenu.getName().getName());
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        if (currentMenu == null) {
            currentMenu = Favorite.instance();
        }

        coffeeMachine.setQuantityDisplay("");
        coffeeMachine.setIntensityDisplay("");
        coffeeMachine.setTitleDisplay(currentMenu.getName().getName());
    }

    private Menu choiceMenu() {
        if (currentMenu == null) {
            return Favorite.instance();
        }

        MenuName[] menuList = MenuName.values();
        MenuName currentMenuName = this.currentMenu.getName();
        MenuFactory menuFactory = new MenuFactory();

        for (int i = 0; i < menuList.length; i++) {
            if (menuList[i] == currentMenuName &&  i + 1 < menuList.length) {
                return menuFactory.getMenu(menuList[i + 1]);
            } else if (menuList[i] == currentMenuName &&  i + 1 == menuList.length) {
                return menuFactory.getMenu(menuList[0]);
            }
        }

        return null;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public MenuChoice setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
        return this;
    }
}
