package be.umons.coffeemachine.model.factory;

import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.model.drink.special.Verseuse;
import be.umons.coffeemachine.model.drink.special.WarmWater;
import be.umons.coffeemachine.model.enums.SpecialName;

import java.security.InvalidParameterException;

public class SpecialDrinkFactory {

    public Drink getSpecialDrink(SpecialName specialName) {

        switch (specialName) {
            case HOT_WATER:
                return new WarmWater();
            case HOT_MILK:
                return new MilkFroth(specialName.getName());
            case VERSEUSE:
                return new Verseuse();
            case AMERICANO:
            case CORDATO_COFFEE:
            case FLAT_WHITE:
                return new Coffee(specialName.getName());
            default:
                throw new InvalidParameterException("There is not case for value " + specialName);
        }
    }
}
