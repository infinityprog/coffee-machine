package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.drink.Drink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

public class UpdateProfil extends Menu {

    private static final Logger LOGGER = LogManager.getLogger(UpdateProfil.class);

    private static UpdateProfil instance;

    private Profile profile;

    private Drink currentDrink;

    public static UpdateProfil instance() {
        if (instance == null) {
            instance = new UpdateProfil();
        }

        return instance;
    }

    public UpdateProfil() {
        super(null);
    }

    @Override
    public void intensity(CoffeeMachine coffeeMachine) {
        LOGGER.info("Change intensity");

        if (currentDrink != null) {
            currentDrink.changeIntensity();
            coffeeMachine.setIntensityDisplay(currentDrink.getIntensity().getName());
        }
    }

    @Override
    public void quantity(CoffeeMachine coffeeMachine) {
        LOGGER.info("Change quantity");

        if (currentDrink != null) {
            currentDrink.changeQuantity();
            coffeeMachine.setQuantityDisplay(currentDrink.getQuantity().getName());
        }
    }

    @Override
    public void coffee(CoffeeMachine coffeeMachine, Drink drink) {

        profile.addFavorite(drink);
        currentDrink = profile.getFavorite(drink);

        enableBtnDrinkState(coffeeMachine, drink.getName());

        coffeeMachine.setTitleDisplay("Favoris : " + currentDrink.getName());
        coffeeMachine.setIntensityDisplay(currentDrink.getIntensity().getName());
        coffeeMachine.setQuantityDisplay(currentDrink.getQuantity().getName());

    }

    @Override
    public void milky(CoffeeMachine coffeeMachine, Drink drink) {

        profile.addFavorite(drink);
        currentDrink = profile.getFavorite(drink);

        enableBtnDrinkState(coffeeMachine, drink.getName());

        coffeeMachine.setTitleDisplay("Favoris : " + currentDrink.getName());
        coffeeMachine.setIntensityDisplay(currentDrink.getIntensity().getName());
        coffeeMachine.setQuantityDisplay(currentDrink.getQuantity().getName());
    }

    @Override
    public void enableBtn(CoffeeMachine coffeeMachine) {
        coffeeMachine.resetDisplayBtn();
        coffeeMachine.setEnableBtnBack(true);
        coffeeMachine.setEnableBtnMenu(true);
        enableDrink(coffeeMachine);
    }

    private void enableBtnDrinkState(CoffeeMachine coffeeMachine, String name) {
        coffeeMachine.setEnableBtnQuantity(true);
        coffeeMachine.setEnableBtnIntensity(true);
        coffeeMachine.setEnableBtnOk(true);
        coffeeMachine.setEnableBtnSpecial(false);
        changeModeBtn(coffeeMachine, name, false);
    }

    @Override
    public void ok(CoffeeMachine coffeeMachine) {
        if (currentDrink != null) {

            Profile profile = coffeeMachine.getSelectedProfile();

            profile.setFavoris(this.profile.getFavoris());

            this.back(coffeeMachine);
        }
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        enableBtn(coffeeMachine);
        profile = clone(coffeeMachine.getSelectedProfile());
        coffeeMachine.setTitleDisplay("Choisissez une boisson pour " + profile.getName());
    }



    @Override
    public void back(CoffeeMachine coffeeMachine) {
        currentDrink = null;
        coffeeMachine.transition(Favorite.instance());
    }

    private Profile clone(Profile profile) {
        return new Profile(profile.getName(), new HashSet<>(profile.getFavoris()));
    }

    /**
     * Use only for testing
     * @param drink
     */
    protected void setCurrentDrink(Drink drink) {
        currentDrink = drink;
    }
}
