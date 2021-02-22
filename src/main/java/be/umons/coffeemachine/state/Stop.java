package be.umons.coffeemachine.state;

public class Stop extends State {

    private static Stop instance;

    public static Stop instance() {
        if (instance == null) {
            instance = new Stop();
        }

        return instance;
    }
}
