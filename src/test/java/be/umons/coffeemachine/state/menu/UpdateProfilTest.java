package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.model.enums.Quantity;
import be.umons.coffeemachine.state.config.StateConfigTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.lang.ref.PhantomReference;
import java.util.List;

import static be.umons.coffeemachine.model.enums.Intensity.NORMAL;
import static be.umons.coffeemachine.model.enums.Quantity.MEDIUM;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UpdateProfilTest extends StateConfigTest {

    @InjectMocks
    private UpdateProfil updateProfil;

    @Mock
    private Drink drink;

    @Mock
    private Profile profile;

    @Test
    void intensity() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.getIntensity()).thenReturn(NORMAL);

        updateProfil.intensity(coffeeMachine);

        verify(coffeeMachine, times(1)).setIntensityDisplay(NORMAL.getName());
        verify(drink, times(1)).changeIntensity();
    }

    @Test
    void quantity() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.getQuantity()).thenReturn(MEDIUM);

        updateProfil.quantity(coffeeMachine);

        verify(coffeeMachine, times(1)).setQuantityDisplay(MEDIUM.getName());
        verify(drink, times(1)).changeQuantity();
    }

    @Test
    void coffee() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.getQuantity()).thenReturn(MEDIUM);
        when(drink.getIntensity()).thenReturn(NORMAL);
        when(drink.getName()).thenReturn("Test");
        when(profile.getFavorite(drink)).thenReturn(drink);

        updateProfil.coffee(coffeeMachine);

        verify(profile, times(1)).addFavorite(drink);
        verify(profile, times(1)).getFavorite(drink);

        verify(coffeeMachine, times(1)).setTitleDisplay("Favoris : Test");
        verify(coffeeMachine, times(1)).setIntensityDisplay(NORMAL.getName());
        verify(coffeeMachine, times(1)).setQuantityDisplay(MEDIUM.getName());
    }

    @Test
    void milky() {
        when(coffeeMachine.getDrink()).thenReturn(drink);
        when(drink.getQuantity()).thenReturn(MEDIUM);
        when(drink.getIntensity()).thenReturn(NORMAL);
        when(drink.getName()).thenReturn("Test");
        when(profile.getFavorite(drink)).thenReturn(drink);

        updateProfil.coffee(coffeeMachine);

        verify(profile, times(1)).addFavorite(drink);
        verify(profile, times(1)).getFavorite(drink);

        verify(coffeeMachine, times(1)).setTitleDisplay("Favoris : Test");
        verify(coffeeMachine, times(1)).setIntensityDisplay(NORMAL.getName());
        verify(coffeeMachine, times(1)).setQuantityDisplay(MEDIUM.getName());
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
    }

    @Test
    void back() {
        updateProfil.back(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Favorite.class));
    }
}
