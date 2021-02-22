package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;

public class Favorite extends State {

    private static Favorite instance;

    public static Favorite instance() {
        if (instance == null) {
            instance = new Favorite();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        super.entry(coffeeMachine);
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


}
