package be.umons.coffeemachine.model.drink;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.format.Intensity;
import be.umons.coffeemachine.model.format.Quantity;

public abstract class Drink {

    private String name;

    private Quantity quantity = Quantity.MEDIUM;

    private Intensity intensity = Intensity.NORMAL;

    protected boolean coffee = false;

    protected boolean milk = false;

    private boolean two = false;

    public Drink(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Drink setName(String name) {
        this.name = name;
        return this;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Drink setQuantity(Quantity quantity) {
        this.quantity = quantity;
        return this;
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public Drink setIntensity(Intensity intensity) {
        this.intensity = intensity;
        return this;
    }

    public boolean isTwo() {
        return two;
    }

    public Drink setTwo(boolean two) {
        this.two = two;
        return this;
    }

    public abstract void makeDrink(CoffeeMachine coffeeMachine);

    public boolean isCoffee() {
        return coffee;
    }

    public boolean isMilk() {
        return milk;
    }
}
