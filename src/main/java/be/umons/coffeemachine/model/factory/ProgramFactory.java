package be.umons.coffeemachine.model.factory;

import be.umons.coffeemachine.model.enums.MenuName;
import be.umons.coffeemachine.state.menu.program.*;

import java.security.InvalidParameterException;

public class ProgramFactory {

    public Program getProgram(MenuName name) {

        switch (name) {
            case CLEANING:
                return Cleaning.instance();
            case CLEANING_MILK_FROTH:
                return CleaningMilkFrother.instance();
            case DESCALING:
                return Descaling.instance();
            case CALC_AND_CLEAN:
                return CalcAndClean.instance();
            default:
                throw new InvalidParameterException("these menu name " + name + " is not a CAMOptions menu");
        }
    }
}
