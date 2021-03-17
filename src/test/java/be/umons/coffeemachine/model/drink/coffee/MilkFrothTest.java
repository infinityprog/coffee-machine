package be.umons.coffeemachine.model.drink.coffee;

import be.umons.coffeemachine.context.CoffeeMachine;
import be.umons.coffeemachine.model.enums.Intensity;
import be.umons.coffeemachine.model.pieces.MilkPipe;
import be.umons.coffeemachine.state.takedrink.precondition.ConnectMilkPipe;
import javafx.animation.PauseTransition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Miky Froth Model")
public class MilkFrothTest {

    @InjectMocks
    private MilkFroth milkFroth;

    @Mock
    private MilkPipe milkPipe;

    @Mock
    private CoffeeMachine coffeeMachine;

    @Mock
    PauseTransition pauseTransition;

    @BeforeEach
    public void setUp() throws Exception {
        when(coffeeMachine.getMilkPipe()).thenReturn(milkPipe);
    }

    @Test
    @DisplayName("Make drink : Milk pipe is disconnected")
    public void testMakeDrinkWaterReservoirIsEmpty() {
        when(milkPipe.isDisconnected()).thenReturn(true);

        milkFroth.makeDrink(coffeeMachine);

        verify(coffeeMachine, times(1)).transition(any(ConnectMilkPipe.class));

    }

    @Test
    @DisplayName("Make drink : Milk pipe is disconnected")
    public void testMakeDrink(){
        when(milkPipe.isDisconnected()).thenReturn(false);
        milkFroth.setIntensity(Intensity.COMP_POWDER);

        doNothing().when(pauseTransition).play();

        milkFroth.setPause(pauseTransition);
        milkFroth.setName("test");

        milkFroth.makeDrink(coffeeMachine);

        verify(pauseTransition, times(1)).play();

    }

    @Test
    @DisplayName("Reset pieces")
    public void testResetPieces() {
        milkFroth.resetPieces(coffeeMachine);

        verify(milkPipe, times(1)).disconnect();
    }
}
