package be.umons.coffeemachine.model.drink.special;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.Quantity;
import be.umons.coffeemachine.model.enums.SpecialName;
import javafx.util.Duration;

public class Verseuse extends Special {

    public Verseuse() {
        super(SpecialName.VERSEUSE.getName());

        if (getQuantity() == Quantity.SMALL) {
            setQuantity(Quantity.MEDIUM);
        }
    }

    @Override
    public void makeDrink(CoffeeMachine coffeeMachine) {

        if (getQuantity() == Quantity.LARGE) {
            pause.setDuration(Duration.millis(600));
        } else {
            pause.setDuration(Duration.millis(400));
        }

        super.makeDrink(coffeeMachine);
    }
}
