package be.umons.coffeemachine.context;

import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.model.drink.coffee.MilkyDrink;
import be.umons.coffeemachine.model.enums.ProfileName;
import be.umons.coffeemachine.model.enums.Quantity;
import be.umons.coffeemachine.model.enums.SpecialName;
import be.umons.coffeemachine.model.factory.SpecialDrinkFactory;
import be.umons.coffeemachine.model.pieces.MilkFrother;
import be.umons.coffeemachine.model.pieces.MilkPipe;
import be.umons.coffeemachine.model.pieces.WaterReservoir;
import be.umons.coffeemachine.observer.Observer;
import be.umons.coffeemachine.observer.Subject;
import be.umons.coffeemachine.state.Start;
import be.umons.coffeemachine.state.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
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
    private boolean hot;
    private boolean served;
    private Observer observer;
    private String titleDisplay;
    private String intensityDisplay;
    private String quantityDisplay;
    private List<Profile> profiles;
    private Profile selectedProfile;

    public CoffeeMachine(Observer observer) {
        attach(observer);
        waterReservoir = new WaterReservoir();
        milkFrother = new MilkFrother();
        milkPipe = new MilkPipe();
        profiles = createProfil();
        state = Start.instance();
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
        System.out.println("User presses on btn intensity");
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

        makeSpecial();
    }

    public void btnExpresso() {
        logger.info("User presses on btn Expresso");

        drink = new Coffee("Expresso");
        state.coffee(this);
    }

    public void btnExpressoMacch() {
        logger.info("User presses on btn Expresso Macch");

        drink = new Coffee("Expresso Macchiato");
        state.coffee(this);
    }

    public void btnCoffee() {
        logger.info("User presses on btn Coffee");

        drink = new Coffee("Caffé");
        state.coffee(this);
    }

    public void btnCappuccino() {
        logger.info("User presses on btn Cappuccino");

        drink = new MilkyDrink("Cappuccino", "Mousse de lait");
        state.coffee(this);
    }

    public void btnLatteMacchiate() {
        logger.info("User presses on btn Latte Macchiate");

        drink = new MilkyDrink("Latte Machiate", "Lait");
        state.milky(this);
    }

    public void btnMilkCoffee() {
        logger.info("User presses on btn Milk Coffee");

        drink = new MilkyDrink("Caffé au lait", "Lait");
        state.milky(this);
    }

    public void btnMilkFroth() {
        logger.info("User presses on btn Milk Froth");

        drink = new MilkFroth("Mousse de Lait");
        state.milky(this);
    }

    public void btnFavorite() {
        logger.info("User presses on btn favoris");

        state.favori(this);
    }

    public void transition(State next) {
        logger.info("Change state to " + next.getClass().getName());
        state.exit(this);
        state = next;
        System.out.println(next.getClass().getName());
        next.entry(this);
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
        notif();
        return this;
    }

    public String getIntensityDisplay() {
        return intensityDisplay;
    }

    public CoffeeMachine setIntensityDisplay(String intensityDisplay) {
        this.intensityDisplay = intensityDisplay;
        notif();
        return this;
    }

    public String getQuantityDisplay() {
        return quantityDisplay;
    }

    public CoffeeMachine setQuantityDisplay(String quantityDisplay) {
        this.quantityDisplay = quantityDisplay;
        notif();
        return this;
    }

    public List<Profile> getProfils() {
        return profiles;
    }

    public CoffeeMachine setProfils(List<Profile> profiles) {
        this.profiles = profiles;
        return this;
    }

    public Boolean isHot() {
        return hot;
    }

    public CoffeeMachine setHot(Boolean hot) {
        this.hot = hot;
        return this;
    }

    public Boolean isServed() {
        return served;
    }

    public CoffeeMachine setServed(Boolean served) {
        this.served = served;
        return this;
    }

    public Drink getDrink() {
        return drink;
    }

    private void  makeSpecial() {

        try {
            System.out.println(drink.getName());
            SpecialName specialName = SpecialName.fromName(drink.getName());
            changeSpecial(specialName);
        } catch (Exception ignored){
            SpecialDrinkFactory specialDrinkFactory = new SpecialDrinkFactory();
            drink = specialDrinkFactory.getSpecialDrink(SpecialName.HOT_WATER);
            state.water(this);
        }

    }

    private void changeSpecial(SpecialName name) {
        SpecialDrinkFactory specialDrinkFactory = new SpecialDrinkFactory();

        if (name == null) {
            drink = specialDrinkFactory.getSpecialDrink(SpecialName.HOT_WATER);
            state.water(this);
        }

        SpecialName[] specialNames = SpecialName.values();

        for (int i = 0; i < specialNames.length; i++) {
            if (specialNames[i] == name &&  i + 1 < specialNames.length) {
                drink = specialDrinkFactory.getSpecialDrink(specialNames[i + 1]);
                choiceSpecialEvent(specialNames[i + 1]);

            } else if (specialNames[i] == name &&  i + 1 == specialNames.length) {
                drink = specialDrinkFactory.getSpecialDrink(specialNames[0]);
                choiceSpecialEvent(specialNames[0]);
            }
        }
    }

    private void choiceSpecialEvent(SpecialName name) {
        switch (name) {
            case HOT_WATER:
                state.water(this);
                break;
            case HOT_MILK:
                state.milky(this);
                break;
            case VERSEUSE:
                state.verseuse(this);
                break;
            default:
                state.coffee(this);
                break;
        }
    }

    private List<Profile> createProfil() {
        List<Profile> profiles = new ArrayList<>();
        ProfileName[] profileNames = ProfileName.values();

        for (ProfileName profileName : profileNames) {
            profiles.add(new Profile(profileName));
        }

        return profiles;
    }

    public Profile getSelectedProfile() {
        return selectedProfile;
    }

    public void setSelectedProfile(Profile selectedProfile) {
        this.selectedProfile = selectedProfile;
    }

    protected CoffeeMachine setState(State state) {
        this.state = state;
        return this;
    }

    public CoffeeMachine setDrink(Drink drink) {
        this.drink = drink;
        return this;
    }
}
