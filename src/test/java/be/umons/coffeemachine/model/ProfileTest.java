package be.umons.coffeemachine.model;

import be.umons.coffeemachine.config.TestConfig;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.model.enums.ProfileName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProfileTest extends TestConfig {

    private static final String COFFEE = "coffee";

    private static final String MOUSSE = "Mousse";

    private static final String DISPLAY_NAME = "A : Utilisé";

    private Profile profile = new Profile(ProfileName.A);

    @Test
    void getFavorite() {
        Coffee coffee = new Coffee(COFFEE);
        MilkFroth milkFroth = new MilkFroth(MOUSSE);

        profile.addFavorite(coffee);
        profile.addFavorite(milkFroth);

        Drink result = profile.getFavorite(milkFroth);

        assertEquals(MOUSSE, result.getName());
    }

    @Test
    void getNameToDisplay() {

        profile.addFavorite(new Coffee("test"));

        assertEquals(DISPLAY_NAME, profile.getNameToDisplay());
    }
}
