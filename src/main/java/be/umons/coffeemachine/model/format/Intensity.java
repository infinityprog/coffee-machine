package be.umons.coffeemachine.model.format;

public enum Intensity {

    VERY_SOFT("Très faible"),

    SOFT("Faible"),

    NORMAL("Normal"),

    STRONG("Fort"),

    VERY_STRONG("Très fort"),

    DOUBLESHOT_STRONG("Double shot fort"),

    DOUBLESHOT_STRONG_MORE("Double shot fort +"),

    COMP_POWDER("En poudre");

    private String name;

    Intensity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
