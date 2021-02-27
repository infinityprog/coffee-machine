package be.umons.coffeemachine.view;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.coffee.Coffee;
import be.umons.coffeemachine.observer.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CoffeeMachineGUI implements Initializable, Observer {

    private CoffeeMachine coffeeMachine;

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
    private Button btnSecurity;

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
        coffeeMachine = new CoffeeMachine(this);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void update() {
        lbTitle.setText(coffeeMachine.getTitleDisplay());
        lbQuantity.setText(coffeeMachine.getQuantityDisplay());
        lbIntensity.setText(coffeeMachine.getIntensityDisplay());
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
        coffeeMachine.btnIntensity();
    }

    public void onExit(ActionEvent event) {
        coffeeMachine.btnBack();
    }

    public void onQuantity(ActionEvent event) {
        coffeeMachine.btnQuantity();
    }

    public void onSecurity(ActionEvent event) {
        coffeeMachine.btnSecurity();
    }

    public void onOk(ActionEvent event) {
        coffeeMachine.btnOk();
    }

    public void onMenu(ActionEvent event) {
        coffeeMachine.btnMenu();
    }
}
