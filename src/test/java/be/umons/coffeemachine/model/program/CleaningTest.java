package be.umons.coffeemachine.model.program;

import be.umons.coffeemachine.context.CoffeeMachine;
import javafx.animation.PauseTransition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static be.umons.coffeemachine.model.enums.CleaningError.COLLECTING_TRAY;
import static be.umons.coffeemachine.model.enums.CleaningError.INSERT_TABLET;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Cleaning Model")
class CleaningTest {

    @InjectMocks
    private Cleaning cleaning;

    @Mock
    private CoffeeMachine coffeeMachine;

    @Mock
    private PauseTransition pauseTransition;


    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Start Ready False")
    void startReadyFalse() {
        cleaning.setCollectingTray(true);

        cleaning.start(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(cleaning.errorMessage());
    }

    @Test
    @DisplayName("Start Ready True")
    void startReadyTrue() {
        cleaning.setCollectingTray(true);
        cleaning.setInsertTablet(true);
        cleaning.pause = pauseTransition;

        doNothing().when(pauseTransition).play();

        cleaning.start(coffeeMachine);

        verify(pauseTransition, times(1)).play();
    }

    @Test
    @DisplayName("Is Not Ready")
    public void isNotReady() {
        cleaning.setCollectingTray(true);

        assertFalse(cleaning.isReady());
    }

    @Test
    @DisplayName("Is Ready")
    public void isReady() {
        cleaning.setCollectingTray(true);
        cleaning.setInsertTablet(true);

        assertTrue(cleaning.isReady());
    }

    @Test
    @DisplayName("Error Message Collecting Tray")
    void errorMessageCollectingTray() {
        assertEquals(COLLECTING_TRAY.getName(), cleaning.errorMessage());
    }

    @Test
    @DisplayName("Error Message Insert Tablet")
    void errorMessageInsertTablet() {
        cleaning.setCollectingTray(true);
        assertEquals(INSERT_TABLET.getName(), cleaning.errorMessage());
    }

    @Test
    @DisplayName("Fix Error Null")
    void fixErrorNull() {
        cleaning.fixError();

        assertFalse(cleaning.isCollectingTray());
        assertFalse(cleaning.isInsertTablet());
    }

    @Test
    @DisplayName("Fix Error Collecting Tray")
    void fixErrorCollectingTray() {
        cleaning.setError(COLLECTING_TRAY);

        cleaning.fixError();

        assertTrue(cleaning.isCollectingTray());
        assertFalse(cleaning.isInsertTablet());
    }

    @Test
    @DisplayName("Fix Error Insert Tablet")
    void fixErrorInsertTablet() {
        cleaning.setError(INSERT_TABLET);

        cleaning.fixError();

        assertFalse(cleaning.isCollectingTray());
        assertTrue(cleaning.isInsertTablet());
    }


}
