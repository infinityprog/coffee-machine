package be.umons.coffeemachine.state.menu;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.ProfileName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.List;

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

        Drink drink = coffeeMachine.getDrink();
        drink.changeIntensity();

        coffeeMachine.setIntensityDisplay(drink.getIntensity().getName());
    }

    @Override
    public void quantity(CoffeeMachine coffeeMachine) {
        LOGGER.info("Change quantity");

        Drink drink = coffeeMachine.getDrink();
        drink.changeQuantity();

        coffeeMachine.setQuantityDisplay(drink.getQuantity().getName());
    }

    @Override
    public void coffee(CoffeeMachine coffeeMachine) {
        Drink drink = coffeeMachine.getDrink();

        profile.addFavorite(drink);
        currentDrink = profile.getFavorite(drink);

        coffeeMachine.setTitleDisplay("Favoris : " + currentDrink.getName());
        coffeeMachine.setIntensityDisplay(currentDrink.getIntensity().getName());
        coffeeMachine.setQuantityDisplay(currentDrink.getQuantity().getName());

    }

    @Override
    public void milky(CoffeeMachine coffeeMachine) {
        Drink drink = coffeeMachine.getDrink();

        profile.addFavorite(drink);
        currentDrink = profile.getFavorite(drink);

        coffeeMachine.setTitleDisplay("Favoris : " + currentDrink.getName());
        coffeeMachine.setIntensityDisplay(currentDrink.getIntensity().getName());
        coffeeMachine.setQuantityDisplay(currentDrink.getQuantity().getName());
    }

    @Override
    public void special(CoffeeMachine coffeeMachine) {
        super.special(coffeeMachine);
    }

    @Override
    public void ok(CoffeeMachine coffeeMachine) {
        Profile profile = coffeeMachine.getSelectedProfile();

        profile.setFavoris(this.profile.getFavoris());

        this.back(coffeeMachine);
    }

    @Override
    public void entry(CoffeeMachine coffeeMachine) {
        profile = clone(coffeeMachine.getSelectedProfile());
        coffeeMachine.setTitleDisplay("Choisissez une boisson pour " + profile.getName());
    }

    @Override
    public void back(CoffeeMachine coffeeMachine) {
        coffeeMachine.transition(Favorite.instance());
    }

    private Profile findProfile(List<Profile> profiles, ProfileName targetProfile) {
        return profiles.stream()
                .filter(profile -> profile.getName() == targetProfile)
                .findAny()
                .get();
    }

    private Profile clone(Profile profile) {
        return new Profile(profile.getName(), profile.isUsed(), new HashSet<>(profile.getFavoris()));
    }
}
