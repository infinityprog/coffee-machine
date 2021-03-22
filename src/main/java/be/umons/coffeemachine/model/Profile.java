package be.umons.coffeemachine.model;

import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.ProfileName;

import java.util.HashSet;
import java.util.Set;

public class Profile {

    private ProfileName name;

    private Set<Drink> favoris = new HashSet<>();

    public ProfileName getName() {
        return name;
    }

    public Profile(ProfileName name) {
        this.name = name;
    }

    public Profile(ProfileName name, Set<Drink> favoris) {
        this.name = name;
        this.favoris = favoris;
    }

    public void addFavorite(Drink drink) {
        favoris.add(drink);
    }

    public Drink getFavorite(Drink drink) {
        return favoris.stream().filter(drink::equals).findAny().orElse(null);
    }

    public void setFavoris(Set<Drink> favoris) {
        this.favoris = favoris;
    }

    public Set<Drink> getFavoris() {
        return favoris;
    }

    public boolean isUsed() {
        return favoris.size() > 0;
    }

    public String getNameToDisplay() {
        return name + " : " + (isUsed() ? "Utilisé" : "Vide");
    }
}
