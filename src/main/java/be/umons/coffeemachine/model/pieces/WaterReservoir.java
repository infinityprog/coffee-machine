package be.umons.coffeemachine.model.pieces;

public class WaterReservoir {

    private boolean empty;

    public void fillUp() {
        empty = true;
    }

    public boolean isEmpty() {
        return empty;
    }
}
