package be.umons.coffeemachine.state;

import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.model.drink.coffee.MilkyDrink;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.model.enums.ProfileName;
import be.umons.coffeemachine.model.enums.Quantity;
import be.umons.coffeemachine.state.config.StateConfigTest;
import be.umons.coffeemachine.state.takedrink.Preparing;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.Set;

import static org.mockito.Mockito.*;

class ChoiceFavoriteTest extends StateConfigTest {

    @InjectMocks
    private ChoiceFavorite choiceFavorite;

    @Test
    void entry() {
        when(coffeeMachine.getSelectedProfile()).thenReturn(new Profile(ProfileName.A, Set.of(new Coffee("test"))));

        choiceFavorite.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay("Favori \ntest");
        verify(coffeeMachine, times(1)).setIntensityDisplay(Intensity.NORMAL.getName());
        verify(coffeeMachine, times(1)).setQuantityDisplay(Quantity.MEDIUM.getName());

        verifyEnableBtn();
    }

    @Test
    void scrolling() {
        Set<Drink> drinks = getFavoriteDrinks();
        choiceFavorite.setCurrentDrink(new ArrayList<>(drinks).get(0));
        when(coffeeMachine.getSelectedProfile()).thenReturn(new Profile(ProfileName.A, drinks));

        choiceFavorite.scrolling(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(anyString());
        verify(coffeeMachine, times(1)).setIntensityDisplay(anyString());
        verify(coffeeMachine, times(1)).setQuantityDisplay(anyString());
    }

    @Test
    void scrollingRefresh() {
        Set<Drink> drinks = getFavoriteDrinks();
        choiceFavorite.setCurrentDrink(new ArrayList<>(drinks).get(2));
        when(coffeeMachine.getSelectedProfile()).thenReturn(new Profile(ProfileName.A, drinks));

        choiceFavorite.scrolling(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(anyString());
        verify(coffeeMachine, times(1)).setIntensityDisplay(anyString());
        verify(coffeeMachine, times(1)).setQuantityDisplay(anyString());
    }

    @Test
    void startStop() {
        Drink drink = new Coffee("test");
        choiceFavorite.setCurrentDrink(drink);

        choiceFavorite.startStop(coffeeMachine);

        verify(coffeeMachine, times(1)).setDrink(drink);
        verify(coffeeMachine, times(1)).transition(Preparing.instance());
    }

    @Test
    void favori() {
        choiceFavorite.favori(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Waiting.class));
    }

    private Set<Drink> getFavoriteDrinks() {
        Drink coffee = new Coffee("test");
        Drink milky = new MilkyDrink("Cappuccino", "Mousse de lait");
        Drink milkFroth = new MilkFroth("Mousse de lait");

        return Set.of(coffee, milky, milkFroth);
    }

    @Override
    protected void verifyEnableBtn() {
        verifyCoffeeMachineOnce().resetDisplayBtn();
        verifyCoffeeMachineOnce().setEnableBtnFavorite(true);
        verifyCoffeeMachineOnce().setEnableBtnStartStop(true);
        verifyCoffeeMachineOnce().setEnableBtnScrolling(true);
    }
}
