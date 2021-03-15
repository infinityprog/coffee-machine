package be.umons.coffeemachine.model.program;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.CleaningError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static be.umons.coffeemachine.model.enums.CleaningError.COLLECTING_TRAY;
import static be.umons.coffeemachine.model.enums.CleaningError.INSERT_TABLET;
import static be.umons.coffeemachine.model.enums.MenuName.CLEANING;

public class Cleaning extends Program{
    private static final Logger LOGGER = LogManager.getLogger(Descaling.class);

    private static Cleaning instance;

    private boolean insertTablet;

    private boolean collectingTray;

    private CleaningError error;

    public static Cleaning instance() {
        if (instance == null) {
            instance = new Cleaning();
        }

        return instance;
    }

    public Cleaning() {
        super(CLEANING.getName());
    }

    @Override
    public void start(CoffeeMachine coffeeMachine) {
        fixError();

        if (isReady()) {
            onPreparing(coffeeMachine);
        } else {
            coffeeMachine.setTitleDisplay(errorMessage());
        }

    }

    @Override
    boolean isReady() {
        return collectingTray && insertTablet;
    }

    @Override
    String errorMessage() {
        if (!collectingTray) {
            error = COLLECTING_TRAY;
        } if (!insertTablet) {
            error = INSERT_TABLET;
        }

        return error.getName();
    }

    @Override
    void fixError() {
        if (error == null) {
            LOGGER.debug("Do nothing");
            return;
        }

        switch (error) {
            case COLLECTING_TRAY:
                collectingTray = true;
                break;
            case INSERT_TABLET:
                insertTablet = true;
                break;
        }
    }
}
