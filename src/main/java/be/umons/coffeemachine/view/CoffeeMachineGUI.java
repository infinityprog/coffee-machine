package be.umons.coffeemachine.view;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.observer.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class CoffeeMachineGUI implements Initializable, Observer {

    private static String ENABLE_BTN = "#008037";

    private static String DISABLE_BTN = "#d9d9d9; -fx-cursor: default;";

    private Logger logger = LogManager.getLogger(CoffeeMachineGUI.class);

    private CoffeeMachine coffeeMachine;

    private Long beginTime = 0L;

    private boolean interrupt = false;

    @FXML
    private Pane window;

    //Sort of coffee
    @FXML
    private Button btnExpresso;

    @FXML
    private Button btnExpressoMacc;

    @FXML
    private Button btnCoffee;

    @FXML
    private Button btnCappuccino;

    @FXML
    private Button btnLatteMacc;

    @FXML
    private Button btnMilkCoffee;

    @FXML
    private Button btnMilkFroth;

    @FXML
    private Button btnSpecial;

    @FXML
    private Button btnStartStop;

    //action
    @FXML
    private Button btnScrolling;

    @FXML
    private Button btnDouble;

    @FXML
    private Button btnIntensity;

    @FXML
    private Button btnExit;

    @FXML
    private Button btnQuantity;

    @FXML
    private Button btnFavorite;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnMenu;

    @FXML
    private Label lbTitle;

    @FXML
    private Label lbIntensity;

    @FXML
    private Label lbQuantity;

    public CoffeeMachineGUI() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coffeeMachine = new CoffeeMachine(this);
        btnStartStop.setStyle("-fx-border-color: " + ENABLE_BTN);
        btnSpecial.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnExpresso.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnExpressoMacc.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnCoffee.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnCappuccino.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnLatteMacc.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnMilkCoffee.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnMilkFroth.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnScrolling.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnExit.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnDouble.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnIntensity.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnOk.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnQuantity.setStyle("-fx-border-color: " +DISABLE_BTN);
        btnMenu.setStyle("-fx-border-color: " + DISABLE_BTN);
        btnFavorite.setStyle("-fx-border-color: " + DISABLE_BTN);
    }

    @Override
    public void update() {
        lbTitle.setText(coffeeMachine.getTitleDisplay());
        lbQuantity.setText(coffeeMachine.getQuantityDisplay());
        lbIntensity.setText(coffeeMachine.getIntensityDisplay());
        btnStartStop.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnStartStop()? ENABLE_BTN : DISABLE_BTN));
        btnSpecial.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnSpecial()? ENABLE_BTN : DISABLE_BTN));
        btnExpresso.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnExpresso()? ENABLE_BTN : DISABLE_BTN));
        btnExpressoMacc.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnExpressoMacch()? ENABLE_BTN : DISABLE_BTN));
        btnCoffee.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnCoffee()? ENABLE_BTN : DISABLE_BTN));
        btnCappuccino.setStyle("-fx-border-color: " + (coffeeMachine.isEnableCappuccino()? ENABLE_BTN : DISABLE_BTN));
        btnLatteMacc.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnLatteMacchiate()? ENABLE_BTN : DISABLE_BTN));
        btnMilkCoffee.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnMilkCoffee()? ENABLE_BTN : DISABLE_BTN));
        btnMilkFroth.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnMilkFroth()? ENABLE_BTN : DISABLE_BTN));
        btnScrolling.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnScrolling()? ENABLE_BTN : DISABLE_BTN));
        btnExit.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnBack()? ENABLE_BTN : DISABLE_BTN));
        btnDouble.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnDouble()? ENABLE_BTN : DISABLE_BTN));
        btnIntensity.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnIntensity()? ENABLE_BTN : DISABLE_BTN));
        btnOk.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnOk()? ENABLE_BTN : DISABLE_BTN));
        btnQuantity.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnQuantity()? ENABLE_BTN : DISABLE_BTN));
        btnMenu.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnMenu()? ENABLE_BTN : DISABLE_BTN));
        btnFavorite.setStyle("-fx-border-color: " + (coffeeMachine.isEnableBtnFavorite()? ENABLE_BTN : DISABLE_BTN));

        onStop();
    }


    public void onExpresso(ActionEvent event) {
        coffeeMachine.btnExpresso();
    }

    public void onExpressoMacc(ActionEvent event) {
        coffeeMachine.btnExpressoMacch();
    }

    public void onCoffee(ActionEvent event) {
        coffeeMachine.btnCoffee();
    }

    public void onCappucino(ActionEvent event) {
        coffeeMachine.btnCappuccino();
    }

    public void onLatteMacc(ActionEvent event) {
        coffeeMachine.btnLatteMacchiate();
    }

    public void onMilkCoffee(ActionEvent event) {
        coffeeMachine.btnMilkCoffee();
    }

    public void onMilkFroth(ActionEvent event) {
        coffeeMachine.btnMilkFroth();
    }

    public void onSpecial(ActionEvent event) {
        coffeeMachine.btnSpecial();
    }

    public void onStartStop(ActionEvent event) {
        coffeeMachine.btnStartStop();
    }

    public void onScrolling(ActionEvent event) {
        coffeeMachine.btnScrolling();
    }

    public void onDouble(ActionEvent event) {
        coffeeMachine.btnDouble();
    }

    public void onIntensity(ActionEvent event) {
        logger.info("User click on intensity");
        System.out.println("User click on intensity");

        coffeeMachine.btnIntensity();
    }

    public void onExit(ActionEvent event) {
        coffeeMachine.btnBack();
    }

    public void onQuantity(ActionEvent event) {
        coffeeMachine.btnQuantity();
    }

    public void onSecurity(ActionEvent event) {
        coffeeMachine.btnFavorite();
    }

    public void onOk(ActionEvent event) {
        coffeeMachine.btnOk();
    }

    public void onMenu(ActionEvent event) {
        coffeeMachine.btnMenu();
    }

    public void onStop() {

        btnStartStop.setOnMousePressed(event -> {

            Thread stop = new Thread(() -> {
                beginTime = System.currentTimeMillis();
                interrupt = false;

                try {
                    Thread.sleep(650);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (!interrupt) {
                    btnStartStop.setStyle("-fx-border-color: red");
                }

            });

            stop.start();
        });

        btnStartStop.setOnMouseReleased(event -> {
            interrupt = true;
            long resultTime = System.currentTimeMillis() - beginTime;

            if (resultTime > 600) {
                coffeeMachine.stop();
            }

            beginTime = 0L;
        });
    }

    public CoffeeMachineGUI setCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
        return this;
    }

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }
}
