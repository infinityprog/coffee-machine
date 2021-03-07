package be.umons.coffeemachine.model.enums;

public enum SpecialName {
    HOT_WATER("Eau chaude"),

    HOT_MILK("Laît chaud"),

    VERSEUSE("Verseuse"),

    AMERICANO("Americano"),

    FLAT_WHITE("Flat white"),

    CORDATO_COFFEE("Café cordato");

    private String name;

    SpecialName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
