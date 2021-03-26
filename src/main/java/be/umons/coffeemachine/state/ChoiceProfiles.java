package be.umons.coffeemachine.state;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.Profile;

import java.util.List;
import java.util.stream.Collectors;

public class ChoiceProfiles extends State {

    private static ChoiceProfiles instance;

    private Profile currentProfile;

    public static ChoiceProfiles instance() {
        if (instance == null) {
            instance = new ChoiceProfiles();
        }

        return instance;
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        enableBtn(coffeeMachine);
        List<Profile> profiles = coffeeMachine.getProfils();

        if (profiles.stream().anyMatch(Profile::isUsed)) {
            if (currentProfile == null) {
                currentProfile = coffeeMachine.getProfils()
                        .stream()
                        .filter(Profile::isUsed)
                        .findFirst()
                        .get();
            }

            coffeeMachine.setTitleDisplay("Profile : " + currentProfile.getName().name());

        } else {
            coffeeMachine.setTitleDisplay("Tous les profiles sont vide");
        }

        coffeeMachine.setQuantityDisplay("");
        coffeeMachine.setIntensityDisplay("");
    }

    @Override
    public void scrolling(CoffeeMachine coffeeMachine) {
        List<Profile> profilesCoffeeMachine = coffeeMachine.getProfils();
        if (profilesCoffeeMachine.stream().anyMatch(Profile::isUsed)) {
            List<Profile> profiles = profilesCoffeeMachine
                    .stream().filter(Profile::isUsed)
                    .collect(Collectors.toList());

            currentProfile = changeProfil(profiles);

            coffeeMachine.setTitleDisplay("Profile : " + currentProfile.getName().name());
        }
    }

    @Override
    public void favori(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Waiting.instance());
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();

        coffeeMachine.setEnableBtnFavorite(true);
        coffeeMachine.setEnableBtnOk(true);
        coffeeMachine.setEnableBtnScrolling(true);
    }

    private Profile changeProfil(List<Profile> profiles) {
        if (currentProfile == null) {
            return profiles.get(0);
        }

        for (int i = 0; i < profiles.size(); i++) {
            if (profiles.get(i) == currentProfile &&  i + 1 < profiles.size()) {
                return profiles.get(i + 1);
            } else if (profiles.get(i) == currentProfile &&  i + 1 == profiles.size()) {
                return profiles.get(0);
            }
        }

        return null;
    }

    @Override
    public void ok(CoffeeMachine coffeeMachine) {
        coffeeMachine.setSelectedProfile(currentProfile);
        coffeeMachine.transition(ChoiceFavorite.instance());
    }

    protected ChoiceProfiles setCurrentProfile(Profile currentProfile) {
        this.currentProfile = currentProfile;
        return this;
    }
}
