package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;

public abstract class State {
    private Boolean isHot;

    private Boolean isServed;

    private Integer quantity;

    public void entry(CoffeeMachine coffeeMachine) {

    }

    public void exit(CoffeeMachine coffeeMachine) {

    }

    public void startStop(CoffeeMachine coffeeMachine) {

    }

    public void intensity(CoffeeMachine coffeeMachine) {

    }

    public void ok(CoffeeMachine coffeeMachine) {

    }

    public void menu(CoffeeMachine coffeeMachine) {

    }

    public void two(CoffeeMachine coffeeMachine) {

    }

    public void back(CoffeeMachine coffeeMachine) {

    }

    public void quantity(CoffeeMachine coffeeMachine) {

    }

    public void security(CoffeeMachine coffeeMachine) {

    }

    public void scrolling(CoffeeMachine coffeeMachine) {

    }

    public void coffee(CoffeeMachine coffeeMachine) {

    }

    public void milky(CoffeeMachine coffeeMachine) {

    }

    public void special(CoffeeMachine coffeeMachine) {

    }

    public void favori(CoffeeMachine coffeeMachine) {

    }

    public void changeOption() {

    }
}
