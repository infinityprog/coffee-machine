package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.enums.MenuName;

import java.util.List;

public class Favorite extends Menu {

    private static Favorite instance;

    private Profile currentProfile;

    public static Favorite instance() {
        if (instance == null) {
            instance = new Favorite();
        }

        return instance;
    }

    public Favorite() {
        super(MenuName.FAVORI);
    }

    @Override
    public void ok(CoffeeMachine coffeeMachine) {
        coffeeMachine.setSelectedProfile(currentProfile);
        coffeeMachine.transition(UpdateProfil.instance());
    }

    @Override
    public void back(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(MenuChoice.instance());
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        enableBtn(coffeeMachine);

        if (currentProfile == null) {
            currentProfile = coffeeMachine.getProfils().get(0);
        }

        coffeeMachine.setTitleDisplay(currentProfile.getNameToDisplay());
        coffeeMachine.setQuantityDisplay("");
        coffeeMachine.setIntensityDisplay("");
    }



    @Override
    public void scrolling(CoffeeMachine coffeeMachine) {
        currentProfile = changeProfil(coffeeMachine.getProfils());

        coffeeMachine.setTitleDisplay(currentProfile.getNameToDisplay());
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();
        coffeeMachine.setEnableBtnScrolling(true);
        coffeeMachine.setEnableBtnOk(true);
        coffeeMachine.setEnableBtnMenu(true);
        coffeeMachine.setEnableBtnBack(true);
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
}
