package be.umons.coffeemachine.state.takedrink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.SpecialName;
import be.umons.coffeemachine.model.factory.SpecialDrinkFactory;
import be.umons.coffeemachine.state.takedrink.special.VerseuseDrink;
import be.umons.coffeemachine.state.takedrink.special.WaterDrink;

public class SpecialDrink extends TakeDrink {

    private static SpecialDrink instance;

    private Drink drink;

    public static SpecialDrink instance() {
        if (instance == null) {
            instance = new SpecialDrink();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        makeSpecial(coffeeMachine);
    }

    private void  makeSpecial(CoffeeMachine coffeeMachine) {

        try {
            SpecialName specialName = SpecialName.fromName(drink.getName());
            changeSpecial(specialName, coffeeMachine);
        } catch (Exception ignored){
            SpecialDrinkFactory specialDrinkFactory = new SpecialDrinkFactory();
            drink = specialDrinkFactory.getSpecialDrink(SpecialName.HOT_WATER);
            coffeeMachine.setDrink(drink);
            coffeeMachine.transition(WaterDrink.instance());
        }

    }

    private void changeSpecial(SpecialName name, CoffeeMachine coffeeMachine) {
        SpecialDrinkFactory specialDrinkFactory = new SpecialDrinkFactory();

        if (name == null) {
            drink = specialDrinkFactory.getSpecialDrink(SpecialName.HOT_WATER);
            coffeeMachine.transition(WaterDrink.instance());
        }

        SpecialName[] specialNames = SpecialName.values();

        for (int i = 0; i < specialNames.length; i++) {
            if (specialNames[i] == name &&  i + 1 < specialNames.length) {
                choiceSpecialDrink(specialNames[i + 1], coffeeMachine);

            } else if (specialNames[i] == name &&  i + 1 == specialNames.length) {
                choiceSpecialDrink(specialNames[0], coffeeMachine);
            }
        }
    }

    private void choiceSpecialDrink(SpecialName name, CoffeeMachine coffeeMachine) {
        SpecialDrinkFactory specialDrinkFactory = new SpecialDrinkFactory();
        drink = specialDrinkFactory.getSpecialDrink(name);
        coffeeMachine.setDrink(drink);

        switch (name) {
            case HOT_WATER:
                coffeeMachine.transition(WaterDrink.instance());
                break;
            case HOT_MILK:
                coffeeMachine.transition(MilkyDrink.instance());
                break;
            case VERSEUSE:
                coffeeMachine.transition(VerseuseDrink.instance());
                break;
            default:
                coffeeMachine.transition(CoffeeDrink.instance());
                break;
        }
    }

    protected void setDrink(Drink drink) {
        this.drink = drink;
    }


}
