package be.umons.coffeemachine.model.format;

public enum Quantity {

    SMALL("Petit"),

    MEDIUM("Moyen"),

    LARGE("Grand");

    private String name;

    Quantity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
