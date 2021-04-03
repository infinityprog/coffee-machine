package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkyDrink;
import be.umons.coffeemachine.model.enums.ProfileName;
import be.umons.coffeemachine.state.Waiting;
import be.umons.coffeemachine.state.config.StateConfigTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ResetTest extends StateConfigTest {

    @InjectMocks
    private Reset reset;

    @Test
    void startStop() {
        List<Profile> profiles = createProfile();
        when(coffeeMachine.getProfils()).thenReturn(profiles);

        reset.startStop(coffeeMachine);

        verifyCoffeeMachineOnce().transition(any(Waiting.class));

        for (Profile profile : profiles) {
            assertEquals(0, profile.getFavoris().size());
        }

    }

    @Test
    void back() {
        reset.back(coffeeMachine);

        verifyCoffeeMachineOnce().transition(any(MenuChoice.class));
    }

    @Test
    void entry() {
        reset.entry(coffeeMachine);

        verifyEnableBtn();
    }

    @Override
    protected void verifyEnableBtn() {
        verifyCoffeeMachineOnce().resetDisplayBtn();
        verifyCoffeeMachineOnce().setEnableBtnMenu(true);
        verifyCoffeeMachineOnce().setEnableBtnBack(true);
        verifyCoffeeMachineOnce().setEnableBtnStartStop(true);
    }

    private List<Profile> createProfile() {
        Profile profile1 = new Profile(ProfileName.A);

        profile1.addFavorite(new Coffee("Expresso"));
        profile1.addFavorite(new MilkyDrink("Cappucino", "Mousse de laît"));

        Profile profile2 = new Profile(ProfileName.B);

        profile2.addFavorite(new Coffee("Expresso"));
        profile2.addFavorite(new MilkyDrink("Cappucino", "Mousse de laît"));

        return Arrays.asList(profile1, profile2);
    }
}
