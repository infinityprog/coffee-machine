package be.umons.coffeemachine.model.enums;

public enum CleaningError {
    INSERT_TABLET("Insérer une pastille de nettoyage"),

    COLLECTING_TRAY("Vider le bac collecteur");

    private String name;

    CleaningError(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
