package be.umons.coffeemachine.model;

import be.umons.coffeemachine.model.drink.Drink;

import java.util.ArrayList;
import java.util.List;

public class Profil {

    private String name;

    private List<Drink> favoris = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Profil setName(String name) {
        this.name = name;
        return this;
    }

    public List<Drink> getFavoris() {
        return favoris;
    }

    public Profil setFavoris(List<Drink> favoris) {
        this.favoris = favoris;
        return this;
    }
}
