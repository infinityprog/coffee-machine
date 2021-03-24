package be.umons.coffeemachine.context;

import be.umons.coffeemachine.model.Profile;
import be.umons.coffeemachine.model.drink.Drink;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.model.drink.coffee.MilkFroth;
import be.umons.coffeemachine.model.drink.coffee.MilkyDrink;
import be.umons.coffeemachine.model.enums.ProfileName;
import be.umons.coffeemachine.model.enums.Quantity;
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

    private boolean enableBtnStartStop;
    private boolean enableBtnOk;
    private boolean enableBtnMenu;
    private boolean enableBtnQuantity;
    private boolean enableBtnIntensity;
    private boolean enableBtnFavorite;
    private boolean enableBtnBack;
    private boolean enableBtnDouble;
    private boolean enableBtnSpecial;
    private boolean enableBtnExpresso;
    private boolean enableBtnExpressoMacch;
    private boolean enableBtnCoffee;
    private boolean enableCappuccino;
    private boolean enableBtnLatteMacchiate;
    private boolean enableBtnMilkCoffee;
    private boolean enableBtnMilkFroth;
    private boolean enableBtnScrolling;

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

        state.special(this);
    }

    public void btnExpresso() {
        logger.info("User presses on btn Expresso");

        state.coffee(this, new Coffee("Expresso"));
    }

    public void btnExpressoMacch() {
        logger.info("User presses on btn Expresso Macch");

        state.coffee(this, new Coffee("Expresso Macchiato"));
    }

    public void btnCoffee() {
        logger.info("User presses on btn Coffee");

        state.coffee(this, new Coffee("Caffé"));
    }

    public void btnCappuccino() {
        logger.info("User presses on btn Cappuccino");

        state.coffee(this, new MilkyDrink("Cappuccino", "Mousse de lait"));
    }

    public void btnLatteMacchiate() {
        logger.info("User presses on btn Latte Macchiate");

        state.milky(this, new MilkyDrink("Latte Machiate", "Lait"));
    }

    public void btnMilkCoffee() {
        logger.info("User presses on btn Milk Coffee");

        state.milky(this, new MilkyDrink("Caffé au lait", "Lait"));
    }

    public void btnMilkFroth() {
        logger.info("User presses on btn Milk Froth");

        state.milky(this, new MilkFroth("Mousse de Lait"));
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

    public boolean isEnableBtnStartStop() {
        return enableBtnStartStop;
    }

    public CoffeeMachine setEnableBtnStartStop(boolean enableBtnStartStop) {
        this.enableBtnStartStop = enableBtnStartStop;
        notif();
        return this;
    }

    public boolean isEnableBtnOk() {
        return enableBtnOk;
    }

    public CoffeeMachine setEnableBtnOk(boolean enableBtnOk) {
        this.enableBtnOk = enableBtnOk;
        notif();
        return this;
    }

    public boolean isEnableBtnMenu() {
        return enableBtnMenu;
    }

    public CoffeeMachine setEnableBtnMenu(boolean enableBtnMenu) {
        this.enableBtnMenu = enableBtnMenu;
        notif();
        return this;
    }

    public boolean isEnableBtnQuantity() {
        return enableBtnQuantity;
    }

    public CoffeeMachine setEnableBtnQuantity(boolean enableBtnQuantity) {
        this.enableBtnQuantity = enableBtnQuantity;
        notif();
        return this;
    }

    public boolean isEnableBtnIntensity() {
        return enableBtnIntensity;
    }

    public CoffeeMachine setEnableBtnIntensity(boolean enableBtnIntensity) {
        this.enableBtnIntensity = enableBtnIntensity;
        notif();
        return this;
    }

    public boolean isEnableBtnFavorite() {
        return enableBtnFavorite;
    }

    public CoffeeMachine setEnableBtnFavorite(boolean enableBtnFavorite) {
        this.enableBtnFavorite = enableBtnFavorite;
        notif();
        return this;
    }

    public boolean isEnableBtnBack() {
        return enableBtnBack;
    }

    public CoffeeMachine setEnableBtnBack(boolean enableBtnBack) {
        this.enableBtnBack = enableBtnBack;
        notif();
        return this;
    }

    public boolean isEnableBtnDouble() {
        return enableBtnDouble;
    }

    public CoffeeMachine setEnableBtnDouble(boolean enableBtnDouble) {
        this.enableBtnDouble = enableBtnDouble;
        notif();
        return this;
    }

    public boolean isEnableBtnSpecial() {
        return enableBtnSpecial;
    }

    public CoffeeMachine setEnableBtnSpecial(boolean enableBtnSpecial) {
        this.enableBtnSpecial = enableBtnSpecial;
        notif();
        return this;
    }

    public boolean isEnableBtnExpresso() {
        return enableBtnExpresso;
    }

    public CoffeeMachine setEnableBtnExpresso(boolean enableBtnExpresso) {
        this.enableBtnExpresso = enableBtnExpresso;
        notif();
        return this;
    }

    public boolean isEnableBtnExpressoMacch() {
        return enableBtnExpressoMacch;
    }

    public CoffeeMachine setEnableBtnExpressoMacch(boolean enableBtnExpressoMacch) {
        this.enableBtnExpressoMacch = enableBtnExpressoMacch;
        notif();
        return this;
    }

    public boolean isEnableBtnCoffee() {
        return enableBtnCoffee;
    }

    public CoffeeMachine setEnableBtnCoffee(boolean enableBtnCoffee) {
        this.enableBtnCoffee = enableBtnCoffee;
        notif();
        return this;
    }

    public boolean isEnableCappuccino() {
        return enableCappuccino;
    }

    public CoffeeMachine setEnableCappuccino(boolean enableCappuccino) {
        this.enableCappuccino = enableCappuccino;
        notif();
        return this;
    }

    public boolean isEnableBtnLatteMacchiate() {
        return enableBtnLatteMacchiate;
    }

    public CoffeeMachine setEnableBtnLatteMacchiate(boolean enableBtnLatteMacchiate) {
        this.enableBtnLatteMacchiate = enableBtnLatteMacchiate;
        notif();
        return this;
    }

    public boolean isEnableBtnMilkCoffee() {
        return enableBtnMilkCoffee;
    }

    public CoffeeMachine setEnableBtnMilkCoffee(boolean enableBtnMilkCoffee) {
        this.enableBtnMilkCoffee = enableBtnMilkCoffee;
        notif();
        return this;
    }

    public boolean isEnableBtnMilkFroth() {
        return enableBtnMilkFroth;
    }

    public CoffeeMachine setEnableBtnMilkFroth(boolean enableBtnMilkFroth) {
        this.enableBtnMilkFroth = enableBtnMilkFroth;
        notif();
        return this;
    }

    public boolean isEnableBtnScrolling() {
        return enableBtnScrolling;
    }

    public CoffeeMachine setEnableBtnScrolling(boolean enableBtnScrolling) {
        this.enableBtnScrolling = enableBtnScrolling;
        notif();
        return this;
    }

    public void resetDisplayBtn() {
        enableBtnStartStop = false;
        enableBtnOk = false;
        enableBtnMenu = false;
        enableBtnQuantity = false;
        enableBtnIntensity = false;
        enableBtnFavorite = false;
        enableBtnBack = false;
        enableBtnDouble = false;
        enableBtnSpecial = false;
        enableBtnExpresso = false;
        enableBtnExpressoMacch = false;
        enableBtnCoffee = false;
        enableCappuccino = false;
        enableBtnLatteMacchiate = false;
        enableBtnMilkCoffee = false;
        enableBtnMilkFroth = false;
        enableBtnScrolling = false;
        notif();
    }
}
