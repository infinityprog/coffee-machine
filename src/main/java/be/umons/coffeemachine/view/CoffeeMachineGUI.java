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
    private Button btnTwo;

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


    public void makeExpresso(ActionEvent event) {
        coffeeMachine.btnExpresso();
    }

    public void makeExpressoMacc(ActionEvent event) {
        coffeeMachine.btnExpressoMacch();
    }
}
