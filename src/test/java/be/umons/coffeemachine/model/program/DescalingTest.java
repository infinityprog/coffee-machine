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

import static be.umons.coffeemachine.model.enums.DescalingError.COLLECTING_TRAY;
import static be.umons.coffeemachine.model.enums.DescalingError.WATER_FILTER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Descaling Model")
class DescalingTest {

    @InjectMocks
    private Descaling descaling;

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
        descaling.setCollectingTray(true);

        descaling.start(coffeeMachine);

        verify(coffeeMachine, times(1)).setTitleDisplay(descaling.errorMessage());
    }

    @Test
    @DisplayName("Start Ready True")
    void startReadyTrue() {
        descaling.setCollectingTray(true);
        descaling.setWaterFilter(true);
        descaling.pause = pauseTransition;

        doNothing().when(pauseTransition).play();

        descaling.start(coffeeMachine);

        verify(pauseTransition, times(1)).play();
    }

    @Test
    @DisplayName("Is Not Ready")
    public void isNotReady() {
        descaling.setCollectingTray(true);

        assertFalse(descaling.isReady());
    }

    @Test
    @DisplayName("Is Ready")
    public void isReady() {
        descaling.setCollectingTray(true);
        descaling.setWaterFilter(true);

        assertTrue(descaling.isReady());
    }

    @Test
    @DisplayName("Error Message Collecting Tray")
    void errorMessageCollectingTray() {
        assertEquals(COLLECTING_TRAY.getName(), descaling.errorMessage());
    }

    @Test
    @DisplayName("Error Message Water Filter")
    void errorMessageInsertTablet() {
        descaling.setCollectingTray(true);
        assertEquals(WATER_FILTER.getName(), descaling.errorMessage());
    }

    @Test
    @DisplayName("Fix Error Null")
    void fixErrorNull() {
        descaling.fixError();

        assertFalse(descaling.isCollectingTray());
        assertFalse(descaling.isWaterFilter());
    }

    @Test
    @DisplayName("Fix Error Collecting Tray")
    void fixErrorCollectingTray() {
        descaling.setError(COLLECTING_TRAY);

        descaling.fixError();

        assertTrue(descaling.isCollectingTray());
        assertFalse(descaling.isWaterFilter());
    }

    @Test
    @DisplayName("Fix Error Water Filter")
    void fixErrorInsertTablet() {
        descaling.setError(WATER_FILTER);

        descaling.fixError();

        assertFalse(descaling.isCollectingTray());
        assertTrue(descaling.isWaterFilter());
    }

}
