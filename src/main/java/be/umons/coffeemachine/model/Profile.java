package be.umons.coffeemachine.model;

import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.enums.ProfileName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Profile {

    private ProfileName name;

    private boolean used;

    private Set<Drink> favoris = new HashSet<>();

    public ProfileName getName() {
        return name;
    }

    public Profile(ProfileName name, boolean used) {
        this.name = name;
        this.used = used;
    }

    public Profile(ProfileName name, boolean used, Set<Drink> favoris) {
        this.name = name;
        this.used = used;
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
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getNameToDisplay() {
        return name + " : " + (used ? "Utilisé" : "Vide");
    }
}
