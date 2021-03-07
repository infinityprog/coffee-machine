package be.umons.coffeemachine.model.drink.coffee;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.drink.Drink;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MilkyDrink extends Drink {

    private static final Logger LOGGER = LogManager.getLogger(MilkyDrink.class);

    private MilkFroth milkFroth;
    private Coffee coffee;

    public MilkyDrink(String name, String milkName) {
        super(name);
        this.milkFroth = new MilkFroth(milkName);
        this.coffee = new Coffee(name);

    }

    @Override
    public void makeDrink(CoffeeMachine coffeeMachine) {
        if (!milkFroth.isPreparing()){
            milkFroth.onFinish(() -> {
                coffee.setIntensity(getIntensity());
                coffee.makeDrink(coffeeMachine);
                preparing = true;
            });
            milkFroth.makeDrink(coffeeMachine);
        } else {
            coffee.makeDrink(coffeeMachine);
        }
    }

    @Override
    public void stop(CoffeeMachine coffeeMachine) {
        if (!milkFroth.isPreparing()){
            milkFroth.stop(coffeeMachine);
            coffee.setIntensity(getIntensity());
            coffee.makeDrink(coffeeMachine);
        } else {
            coffee.stop(coffeeMachine);
            preparing = true;
        }
    }

    @Override
    public void resetPieces(CoffeeMachine coffeeMachine) {
        milkFroth.resetPieces(coffeeMachine);
        coffee.resetPieces(coffeeMachine);
        preparing = false;
    }

    @Override
    public void onFinish(Runnable finishFunc) {

        coffee.getEndPreparation().setOnFinished(event -> {
            try {
                finishFunc.run();
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
            }
        });

    }
}
