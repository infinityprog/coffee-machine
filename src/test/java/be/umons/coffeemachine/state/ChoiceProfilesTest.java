package be.umons.coffeemachine.state;

import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.enums.ProfileName;
import be.umons.coffeemachine.state.config.StateConfigTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ChoiceProfilesTest extends StateConfigTest {

    @InjectMocks
    private ChoiceProfiles choiceProfiles;


    @Test
    void entryNotProfileUsed() {
        when(coffeeMachine.getProfils()).thenReturn(Arrays.asList(new Profile(ProfileName.B)));

        choiceProfiles.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay("Tous les profiles sont vide");
        verify(coffeeMachine, times(1)).setQuantityDisplay("");
        verify(coffeeMachine, times(1)).setIntensityDisplay("");
    }

    @Test
    void entryProfileUsed() {
        when(coffeeMachine.getProfils()).thenReturn(createProfile());

        choiceProfiles.entry(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay("Profile : " + ProfileName.B.name());
        verify(coffeeMachine, times(1)).setQuantityDisplay("");
        verify(coffeeMachine, times(1)).setIntensityDisplay("");
    }

    @Test
    void scrollingNotProfileUsed() {

        choiceProfiles.scrolling(coffeeMachine);

        verify(coffeeMachine, never()).setTitleDisplay(anyString());
    }

    @Test
    void scrollingProfileUsedCurrentNull() {
        when(coffeeMachine.getProfils()).thenReturn(createProfile());

        choiceProfiles.scrolling(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay("Profile : " + ProfileName.B);
    }

    @Test
    void scrollingProfileUsedCurrentNotNull() {
        List<Profile> profiles = createProfile();
        when(coffeeMachine.getProfils()).thenReturn(profiles);
        choiceProfiles.setCurrentProfile(profiles.get(1));

        choiceProfiles.scrolling(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay("Profile : " + ProfileName.E);
    }

    @Test
    void scrollingProfileUsedCurrentReset() {
        List<Profile> profiles = createProfile();
        when(coffeeMachine.getProfils()).thenReturn(profiles);
        choiceProfiles.setCurrentProfile(profiles.get(2));

        choiceProfiles.scrolling(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay("Profile : " + ProfileName.B);
    }

    @Test
    void favori() {
        choiceProfiles.favori(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(Waiting.class));
    }

    @Test
    void ok() {
        Profile profile = new Profile(ProfileName.A);
        choiceProfiles.setCurrentProfile(profile);

        choiceProfiles.ok(coffeeMachine);

        verify(coffeeMachine, times(1)).setSelectedProfile(profile);
        verify(coffeeMachine, times(1)).transition(any(ChoiceFavorite.class));
    }

    private List<Profile> createProfile() {
        Profile profile1 = new Profile(ProfileName.A);
        Profile profile2 = new Profile(ProfileName.B);
        Profile profile3 = new Profile(ProfileName.E);

        profile2.addFavorite(new Coffee("test"));
        profile3.addFavorite(new Coffee("test"));

        return Arrays.asList(profile1, profile2, profile3);
    }
}
