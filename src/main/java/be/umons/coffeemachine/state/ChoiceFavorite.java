package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.state.takedrink.Preparing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ChoiceFavorite extends State {

    private static ChoiceFavorite instance;

    private Drink currentDrink;

    public static ChoiceFavorite instance() {
        if (instance == null) {
            instance = new ChoiceFavorite();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        enableBtn(coffeeMachine);

        Set<Drink> drinks = coffeeMachine.getSelectedProfile()
                .getFavoris();

        currentDrink = new ArrayList<>(drinks).get(0);

        display(coffeeMachine);
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();

        coffeeMachine.setEnableBtnFavorite(true);
        coffeeMachine.setEnableBtnStartStop(true);
        coffeeMachine.setEnableBtnScrolling(true);
    }

    @Override
    public void scrolling(CoffeeMachine coffeeMachine) {
        Set<Drink> drinks = coffeeMachine.getSelectedProfile()
                .getFavoris();

        currentDrink = changeFavorite(new ArrayList<>(drinks));

        display(coffeeMachine);
    }

    @Override
    public void startStop(CoffeeMachine coffeeMachine) {
        coffeeMachine.setDrink(currentDrink);
        coffeeMachine.transition(Preparing.instance());
    }

    @Override
    public void favori(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Waiting.instance());
    }

    private Drink changeFavorite(List<Drink> drinks) {

        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getName().equals(currentDrink.getName()) &&  i + 1 < drinks.size()) {
                return drinks.get(i + 1);
            } else if (drinks.get(i).getName().equals(currentDrink.getName()) &&  i + 1 == drinks.size()) {
                return drinks.get(0);
            }
        }

        return null;
    }

    private void display(CoffeeMachine coffeeMachine) {
        coffeeMachine.setTitleDisplay("Favori \n" + currentDrink.getName());
        coffeeMachine.setIntensityDisplay(currentDrink.getIntensity().getName());
        coffeeMachine.setQuantityDisplay(currentDrink.getQuantity().getName());
    }

    protected ChoiceFavorite setCurrentDrink(Drink currentDrink) {
        this.currentDrink = currentDrink;
        return this;
    }
}
