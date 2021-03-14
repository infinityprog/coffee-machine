package be.umons.coffeemachine.model.enums;

public enum DescalingError {

    WATER_FILTER("Si nécess., retirez filtre eau -> start"),

    COLLECTING_TRAY("Vider le bac collecteur");

    private String name;

    DescalingError(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
