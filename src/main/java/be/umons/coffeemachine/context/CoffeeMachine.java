package be.umons.coffeemachine.context;

import be.umons.coffeemachine.model.Profil;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.model.drink.coffee.MilkyDrink;
import be.umons.coffeemachine.model.format.Quantity;
import be.umons.coffeemachine.model.pieces.MilkFrother;
import be.umons.coffeemachine.model.pieces.MilkPipe;
import be.umons.coffeemachine.model.pieces.WaterReservoir;
import be.umons.coffeemachine.observer.Observer;
import be.umons.coffeemachine.observer.Subject;
import be.umons.coffeemachine.state.Rinsing;
import be.umons.coffeemachine.state.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class CoffeeMachine extends Subject {

    private Logger logger = LogManager.getLogger(CoffeeMachine.class);

    private Map<Quantity, Integer> quantity;
    private Drink drink;
    private State state;
    private WaterReservoir waterReservoir;
    private MilkFrother milkFrother;
    private MilkPipe milkPipe;
    private Observer observer;
    private String titleDisplay;
    private String intensityDisplay;
    private String quantityDisplay;
    private List<Profil> profils;

    public CoffeeMachine(Observer observer) {
        state = Rinsing.instance();
        attach(observer);
        waterReservoir = new WaterReservoir();
        milkFrother = new MilkFrother();
        milkPipe = new MilkPipe();
    }

    public void btnStartStop() {
        logger.info("User presses on btn start stop");
        state.startStop(this);
    }

    public void btnOk() {
        logger.info("User presses on btn ok");
        state.ok(this);
    }

    public void btnMenu() {
        logger.info("User presses on btn menu");
        state.menu(this);
    }

    public void btnQuantity() {
        logger.info("User presses on btn quantity");
        state.quantity(this);
    }

    public void btnIntensity() {
        logger.info("User presses on btn intensity");
        state.intensity(this);
    }

    public void btnDouble() {
        logger.info("User presses on btn double for add two drinks");
        state.two(this);
    }

    public void btnBack() {
        logger.info("User presses on btn back");
        state.back(this);
    }

    public void btnSecurity() {
        logger.info("User presses on btn security");
        state.security(this);
    }

    public void btnScrolling() {
        logger.info("User presses on btn scrolling");
        state.scrolling(this);
    }

    public void btnSpecial() {
        logger.info("User presses on btn special");
        //todo add drink
        //drink =
        state.special(this);
    }

    public void btnExpresso() {
        logger.info("User presses on btn Expresso");
        drink = new Coffee("Expresso");

        state.coffee(this);
    }

    public void btnExpressoMacch() {
        logger.info("User presses on btn Expresso Macch");
        drink = new Coffee("Expresso Macch");

        state.coffee(this);
    }

    public void btnCoffee() {
        logger.info("User presses on btn Coffee");
        drink = new Coffee("Coffee");

        state.coffee(this);
    }

    public void btnCappuccino() {
        logger.info("User presses on btn Cappuccino");
        drink = new Coffee("Cappuccino");

        state.coffee(this);
    }

    public void btnLatteMacchiate() {
        logger.info("User presses on btn Latte Macchiate");
        drink = new MilkyDrink("Latte Machiate");

        state.milky(this);
    }

    public void btnMilkCoffee() {
        logger.info("User presses on btn Milk Coffee");
        drink = new MilkyDrink("Milk Coffee");

        state.milky(this);
    }

    public void btnMilkFroth() {
        logger.info("User presses on btn Milk Froth");
        drink = new MilkyDrink("Milk Froth");

        state.milky(this);
    }

    public void transition(State next) {
        logger.info("Change state to " + next.getClass().getName());
        state = next;
    }

    public Map<Quantity, Integer> getQuantity() {
        return quantity;
    }

    public CoffeeMachine setQuantity(Map<Quantity, Integer> quantity) {
        this.quantity = quantity;
        return this;
    }

    public WaterReservoir getWaterReservoir() {
        return waterReservoir;
    }

    public CoffeeMachine setWaterReservoir(WaterReservoir waterReservoir) {
        this.waterReservoir = waterReservoir;
        return this;
    }

    public MilkFrother getMilkFrother() {
        return milkFrother;
    }

    public CoffeeMachine setMilkFrother(MilkFrother milkFrother) {
        this.milkFrother = milkFrother;
        return this;
    }

    public MilkPipe getMilkPipe() {
        return milkPipe;
    }

    public CoffeeMachine setMilkPipe(MilkPipe milkPipe) {
        this.milkPipe = milkPipe;
        return this;
    }

    public Observer getObserver() {
        return observer;
    }

    public CoffeeMachine setObserver(Observer observer) {
        this.observer = observer;
        return this;
    }

    public String getTitleDisplay() {
        return titleDisplay;
    }

    public CoffeeMachine setTitleDisplay(String titleDisplay) {
        this.titleDisplay = titleDisplay;
        return this;
    }

    public String getIntensityDisplay() {
        return intensityDisplay;
    }

    public CoffeeMachine setIntensityDisplay(String intensityDisplay) {
        this.intensityDisplay = intensityDisplay;
        return this;
    }

    public String getQuantityDisplay() {
        return quantityDisplay;
    }

    public CoffeeMachine setQuantityDisplay(String quantityDisplay) {
        this.quantityDisplay = quantityDisplay;
        return this;
    }

    public List<Profil> getProfils() {
        return profils;
    }

    public CoffeeMachine setProfils(List<Profil> profils) {
        this.profils = profils;
        return this;
    }
}
