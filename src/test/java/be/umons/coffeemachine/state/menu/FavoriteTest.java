package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.enums.ProfileName;
import be.umons.coffeemachine.state.Waiting;
import be.umons.coffeemachine.state.config.StateConfigTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FavoriteTest extends StateConfigTest {

    @InjectMocks
    private Favorite favorite;

    @Mock
    private List<Profile> profiles;

    @Test
    void ok() {

        favorite.ok(coffeeMachine);

        verify(coffeeMachine, times(1)).setSelectedProfile(any());
        verify(coffeeMachine, times(1)).transition(any(UpdateProfil.class));
    }

    @Test
    void back() {
        favorite.back(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(MenuChoice.class));
    }

    @Test
    void entry() {
        when(coffeeMachine.getProfils()).thenReturn(profiles);
        Profile profile = new Profile(ProfileName.A, true);
        when(profiles.get(0)).thenReturn(profile);
        favorite.entry(coffeeMachine);

        verify(profiles, times(1)).get(0);
        verify(coffeeMachine, times(1)).setTitleDisplay(profile.getNameToDisplay());
        verify(coffeeMachine, times(1)).setQuantityDisplay("");
        verify(coffeeMachine, times(1)).setIntensityDisplay("");
    }

    @Test
    void scrollingCurrentIsNull() {
        List<Profile> profiles = createProfil();

        when(coffeeMachine.getProfils()).thenReturn(profiles);

        favorite.scrolling(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(profiles.get(0).getNameToDisplay());
    }

    private List<Profile> createProfil() {
        List<Profile> profiles = new ArrayList<>();
        ProfileName[] profileNames = ProfileName.values();

        for (int i = 0; i < profileNames.length; i++) {
            boolean used = i % 2 == 0;
            profiles.add(new Profile(profileNames[i], used));
        }

        return profiles;
    }
}
