package be.umons.coffeemachine.model.enums;

public enum MenuName {
    FAVORI("Favoris"),

    SETTINGS_DRINK_QUANTITY("Réglage de la quantité"),

    WATER_HARDNESS("Dureté de l'eau"),

    STOP_AUTO("Arrêt automatique"),

    COFFEE_TEMPERATURE("Température du caffé"),

    WATER_FILTER("Filtre à eau"),

    FROST_PROTECTION("Protection contre le gel"),

    BIP_SONORE("Bip sonore"),

    DRINK_SERVED("Boissons servies"),

    RESET("Préréglage d'usine"),

    CLEANING_AND_MAINTENANCE("Néttoyage et entretien"),

    CALC_AND_CLEAN("Calc'nClean"),

    CLEANING_MILK_FROTH("Nettoyage du mousseur de laît"),

    CLEANING("Nettoyage"),

    DESCALING("Détartrage");

    private String name;

    MenuName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
