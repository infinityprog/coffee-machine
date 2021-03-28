package be.umons.coffeemachine.model.factory;

import be.umons.coffeemachine.config.TestConfig;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.model.drink.special.Verseuse;
import be.umons.coffeemachine.model.drink.special.WarmWater;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static be.umons.coffeemachine.model.enums.SpecialName.*;
import static org.assertj.core.api.Assertions.assertThat;

class SpecialDrinkFactoryTest extends TestConfig {

    private SpecialDrinkFactory specialDrinkFactory = new SpecialDrinkFactory();

    @Test
    @DisplayName("Get Drink WarmWater")
    void getSpecialDrinkWarmWater() {
        Drink drink = specialDrinkFactory.getSpecialDrink(HOT_WATER);

        assertThat(drink).isInstanceOf(WarmWater.class);
    }

    @Test
    @DisplayName("Get Drink MilkFroth")
    void getSpecialDrinkMilkFroth() {
        Drink drink = specialDrinkFactory.getSpecialDrink(HOT_MILK);

        assertThat(drink).isInstanceOf(MilkFroth.class);
    }

    @Test
    @DisplayName("Get Drink Verseuse")
    void getSpecialDrinkVerseuse() {
        Drink drink = specialDrinkFactory.getSpecialDrink(VERSEUSE);

        assertThat(drink).isInstanceOf(Verseuse.class);
    }

    @Test
    @DisplayName("Get Drink Americano")
    void getSpecialDrinkCoffee() {
        Drink drink = specialDrinkFactory.getSpecialDrink(AMERICANO);

        assertThat(drink).isInstanceOf(Coffee.class);
    }

    @Test
    @DisplayName("Get Drink Cordato coffee")
    void getSpecialDrinkCordatoCoffee() {
        Drink drink = specialDrinkFactory.getSpecialDrink(CORDATO_COFFEE);

        assertThat(drink).isInstanceOf(Coffee.class);
    }

    @Test
    @DisplayName("Get Drink Flat White")
    void getSpecialDrinkFlatWhite() {
        Drink drink = specialDrinkFactory.getSpecialDrink(FLAT_WHITE);

        assertThat(drink).isInstanceOf(Coffee.class);
    }
}
