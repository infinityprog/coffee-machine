package be.umons.coffeemachine.model.enums;

public enum Intensity {

    VERY_SOFT("Très doux"),

    SOFT("Doux"),

    NORMAL("Normal"),

    STRONG("Fort"),

    VERY_STRONG("Très fort"),

    DOUBLESHOT_STRONG("Doubleshot fort"),

    DOUBLESHOT_STRONG_MORE("Doubleshot fort +"),

    COMP_POWDER("En poudre");

    private String name;

    Intensity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
