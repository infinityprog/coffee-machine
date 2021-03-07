package be.umons.coffeemachine.model.pieces;

public class MilkPipe {

    private boolean connected = false;

    public void  connecte() {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

    public boolean isDisconnected() {
        return !connected;
    }
}
