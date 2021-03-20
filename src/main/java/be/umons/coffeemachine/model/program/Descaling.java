package be.umons.coffeemachine.model.program;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.DescalingError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static be.umons.coffeemachine.model.enums.MenuName.DESCALING;

public class Descaling extends Program {

    private static final Logger LOGGER = LogManager.getLogger(Descaling.class);

    private static Descaling instance;

    private boolean waterFilter;

    private boolean collectingTray;

    private DescalingError error;

    public static Descaling instance() {
        if (instance == null) {
            instance = new Descaling();
        }

        return instance;
    }

    public Descaling() {
        super(DESCALING.getName());
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
        return collectingTray && waterFilter;
    }

    @Override
    String errorMessage() {
        if (!collectingTray) {
            error = DescalingError.COLLECTING_TRAY;
        } else if (!waterFilter) {
            error = DescalingError.WATER_FILTER;
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
            case WATER_FILTER:
                waterFilter = true;
                break;
        }
    }

    protected boolean isWaterFilter() {
        return waterFilter;
    }

    protected void setWaterFilter(boolean waterFilter) {
        this.waterFilter = waterFilter;
    }

    protected boolean isCollectingTray() {
        return collectingTray;
    }

    protected void setCollectingTray(boolean collectingTray) {
        this.collectingTray = collectingTray;
    }

    protected DescalingError getError() {
        return error;
    }

    protected void setError(DescalingError error) {
        this.error = error;
    }
}
