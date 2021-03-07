package be.umons.coffeemachine.model.pieces;

public class WaterReservoir {

    private boolean empty = true;

    public void fillUp() {
        empty = false;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void useWater() {
        empty = true;
    }
}
