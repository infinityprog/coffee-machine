package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;

public class Profil extends Menu {

    private static Profil instance;

    private Drink currentDrink;

    public static Profil instance() {
        if (instance == null) {
            instance = new Profil();
        }

        return instance;
    }

    @Override
    public void intensity(CoffeeMachine coffeeMachine) {
        super.intensity(coffeeMachine);
    }

    @Override
    public void quantity(CoffeeMachine coffeeMachine) {
        super.quantity(coffeeMachine);
    }

    @Override
    public void coffee(CoffeeMachine coffeeMachine) {
        super.coffee(coffeeMachine);
    }

    @Override
    public void milky(CoffeeMachine coffeeMachine) {
        super.milky(coffeeMachine);
    }

    @Override
    public void special(CoffeeMachine coffeeMachine) {
        super.special(coffeeMachine);
    }

    private Drink findDrink(Drink drink) {
        return null;
    }
}
