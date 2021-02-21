package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;

public abstract class State {
    private Boolean isHot;

    private Boolean isServed;

    private Integer quantity;

    public abstract void entry(CoffeeMachine coffeeMachine);

    public abstract void exit(CoffeeMachine coffeeMachine);

    public abstract void startStop(CoffeeMachine coffeeMachine);

    public abstract void intensity(CoffeeMachine coffeeMachine);

    public abstract void ok(CoffeeMachine coffeeMachine);

    public abstract void menu(CoffeeMachine coffeeMachine);

    public abstract void two(CoffeeMachine coffeeMachine);

    public abstract void back(CoffeeMachine coffeeMachine);

    public abstract void quantity(CoffeeMachine coffeeMachine);

    public abstract void security(CoffeeMachine coffeeMachine);

    public abstract void scrolling(CoffeeMachine coffeeMachine);

    public abstract void coffee(CoffeeMachine coffeeMachine);

    public abstract void milky(CoffeeMachine coffeeMachine);

    public abstract void special(CoffeeMachine coffeeMachine);

    public abstract void favori(CoffeeMachine coffeeMachine);

    public abstract void changeOption();
}
