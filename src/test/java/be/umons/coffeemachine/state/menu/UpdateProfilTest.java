package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.state.config.StateConfigTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static be.umons.coffeemachine.model.enums.Intensity.NORMAL;
import static be.umons.coffeemachine.model.enums.Quantity.MEDIUM;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.*;

class UpdateProfilTest extends StateConfigTest {

    @InjectMocks
    private UpdateProfil updateProfil;

    @Mock
    private Drink drink;

    @Mock
    private Profile profile;

    @Test
    void intensity() {
        updateProfil.setCurrentDrink(drink);
        when(drink.getIntensity()).thenReturn(NORMAL);

        updateProfil.intensity(coffeeMachine);

        verify(coffeeMachine, times(1)).setIntensityDisplay(NORMAL.getName());
        verify(drink, times(1)).changeIntensity();
    }

    @Test
    void intensityWithCurrentDrinkNull() {
        updateProfil.setCurrentDrink(null);

        updateProfil.intensity(coffeeMachine);

        verify(coffeeMachine, never()).setIntensityDisplay(NORMAL.getName());
        verify(drink, never()).changeIntensity();
    }

    @Test
    void quantity() {
        updateProfil.setCurrentDrink(drink);
        when(drink.getQuantity()).thenReturn(MEDIUM);

        updateProfil.quantity(coffeeMachine);

        verify(coffeeMachine, times(1)).setQuantityDisplay(MEDIUM.getName());
        verify(drink, times(1)).changeQuantity();
    }

    @Test
    void quantityWithCurrentDrinkNull() {
        updateProfil.setCurrentDrink(null);
        updateProfil.quantity(coffeeMachine);

        verify(coffeeMachine, never()).setQuantityDisplay(MEDIUM.getName());
        verify(drink, never()).changeQuantity();
    }

    @Test
    void coffee() {
        when(drink.getQuantity()).thenReturn(MEDIUM);
        when(drink.getIntensity()).thenReturn(NORMAL);
        when(drink.getName()).thenReturn("Expresso");
        when(profile.getFavorite(drink)).thenReturn(drink);

        updateProfil.coffee(coffeeMachine, drink);

        verify(profile, times(1)).addFavorite(drink);
        verify(profile, times(1)).getFavorite(drink);

        verify(coffeeMachine, times(1)).setTitleDisplay("Favoris : Expresso");
        verify(coffeeMachine, times(1)).setIntensityDisplay(NORMAL.getName());
        verify(coffeeMachine, times(1)).setQuantityDisplay(MEDIUM.getName());

        enableBtnDrinkState();
    }

    @Test
    void milky() {
        when(drink.getQuantity()).thenReturn(MEDIUM);
        when(drink.getIntensity()).thenReturn(NORMAL);
        when(drink.getName()).thenReturn("Expresso");
        when(profile.getFavorite(drink)).thenReturn(drink);

        updateProfil.coffee(coffeeMachine, drink);

        verify(profile, times(1)).addFavorite(drink);
        verify(profile, times(1)).getFavorite(drink);

        verify(coffeeMachine, times(1)).setTitleDisplay("Favoris : Expresso");
        verify(coffeeMachine, times(1)).setIntensityDisplay(NORMAL.getName());
        verify(coffeeMachine, times(1)).setQuantityDisplay(MEDIUM.getName());

        enableBtnDrinkState();
    }

    @Test
    void ok() {
        when(coffeeMachine.getSelectedProfile()).thenReturn(profile);

        updateProfil.ok(coffeeMachine);

        verify(profile, times(1)).setFavoris(anySet());
        verify(coffeeMachine, times(1)).transition(any(Favorite.class));
    }

    @Test
    void entry() {
        when(coffeeMachine.getSelectedProfile()).thenReturn(profile);

        updateProfil.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay("Choisissez une boisson pour " + profile.getName());

        verifyEnableBtn();
    }

    @Test
    void back() {
        updateProfil.back(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Favorite.class));
    }

    @Override
    protected void verifyEnableBtn() {
        verifyCoffeeMachineOnce().resetDisplayBtn();
        verifyCoffeeMachineOnce().setEnableBtnBack(true);
        verifyCoffeeMachineOnce().setEnableBtnMenu(true);
        verifyEnableDrink(coffeeMachine);
    }

    private void enableBtnDrinkState() {
        verify(coffeeMachine, times(1)).setEnableBtnExpresso(false);
        verify(coffeeMachine, times(1)).setEnableBtnQuantity(true);
        verify(coffeeMachine, times(1)).setEnableBtnIntensity(true);
        verify(coffeeMachine, times(1)).setEnableBtnOk(true);
        verify(coffeeMachine, times(1)).setEnableBtnSpecial(false);
    }
}
