package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;

import java.security.InvalidParameterException;

public abstract class State {

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

    public void coffee(CoffeeMachine coffeeMachine, Drink drink) {

    }

    public void milky(CoffeeMachine coffeeMachine, Drink drink) {

    }

    public void special(CoffeeMachine coffeeMachine) {

    }

    public void favori(CoffeeMachine coffeeMachine) {

    }

    public void water(CoffeeMachine coffeeMachine) {

    }

    public void verseuse(CoffeeMachine coffeeMachine) {

    }

    public void stop(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(StartAndStop.instance());
    }

    protected final void enableDrink(CoffeeMachine coffeeMachine) {
        coffeeMachine.setEnableBtnExpresso(true);
        coffeeMachine.setEnableBtnExpressoMacch(true);
        coffeeMachine.setEnableBtnCoffee(true);
        coffeeMachine.setEnableCappuccino(true);
        coffeeMachine.setEnableBtnLatteMacchiate(true);
        coffeeMachine.setEnableBtnMilkCoffee(true);
        coffeeMachine.setEnableBtnMilkFroth(true);
        coffeeMachine.setEnableBtnSpecial(true);
    }

    protected void changeModeBtn(CoffeeMachine coffeeMachine, String name, boolean value) {
        switch (name) {
            case "Expresso":
                coffeeMachine.setEnableBtnExpresso(value);
                break;
            case "Expresso Macchiato":
                coffeeMachine.setEnableBtnExpressoMacch(value);
                break;
            case "Caffé":
                coffeeMachine.setEnableBtnCoffee(value);
                break;
            case "Cappuccino":
                coffeeMachine.setEnableCappuccino(value);
                break;
            case "Latte Machiate":
                coffeeMachine.setEnableBtnLatteMacchiate(value);
                break;
            case "Caffé au lait":
                coffeeMachine.setEnableBtnMilkCoffee(value);
                break;
            case "Mousse de Lait":
                coffeeMachine.setEnableBtnMilkFroth(value);
                break;
            case "Eau chaude":
            case "Laît chaud":
            case "Verseuse":
            case "Flat white":
            case "Café cordato":
            case "Americano":
//                coffeeMachine.setEnableBtnSpecial(value);
                break;
            default:
                throw new InvalidParameterException("this coffee " + name + " don't exist");
        }
    }

    abstract public void enableBtn(CoffeeMachine coffeeMachine);
}
