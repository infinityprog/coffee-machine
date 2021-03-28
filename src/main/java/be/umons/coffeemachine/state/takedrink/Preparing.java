package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.special.Verseuse;
import be.umons.coffeemachine.state.State;
import be.umons.coffeemachine.state.Waiting;

public class Preparing extends State {

    private static Preparing instance;


    public static Preparing instance() {
        if (instance == null) {
            instance = new Preparing();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        coffeeMachine.setIntensityDisplay("");
        coffeeMachine.setQuantityDisplay("");

        enableBtn(coffeeMachine);

        Drink drink = coffeeMachine.getDrink();
        drink.onFinish(() -> {
            addDrink(coffeeMachine, drink);
            coffeeMachine.setTwo(false);
            coffeeMachine.transition(Waiting.instance());
        });
        drink.makeDrink(coffeeMachine);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        Drink drink = coffeeMachine.getDrink();
        drink.stop(coffeeMachine);
        if (drink.isPreparing()) {
            addDrink(coffeeMachine, drink);
            coffeeMachine.setTwo(false);
            coffeeMachine.transition(Waiting.instance());
        }
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();
        coffeeMachine.setEnableBtnStartStop(true);
    }

    @Override
    public void exit(CoffeeMachine coffeeMachine) {
        Drink drink = coffeeMachine.getDrink();
        coffeeMachine.setIntensityDisplay("");
        coffeeMachine.setQuantityDisplay("");
        coffeeMachine.setTwo(false);
        if (drink.isPreparing()) {
            drink.resetPieces(coffeeMachine);
        }
    }

    private void addDrink(CoffeeMachine coffeeMachine, Drink drink) {

        if (drink instanceof Verseuse && drink.isTwo()) {
            coffeeMachine.addDrinksServed(6);
        } else if (drink instanceof Verseuse && !drink.isTwo()) {
            coffeeMachine.addDrinksServed(4);
        } else if (drink.isTwo()) {
            coffeeMachine.addDrinksServed(2);
        } else {
            coffeeMachine.addDrinksServed(1);
        }
    }
}
