package be.umons.coffeemachine.observer;

public class Subject {
    private Observer observer;

    public void attach(Observer observer) {
        this.observer = observer;
    }

    public void delete() {
        this.observer = null;
    }

    public void notif() {
         observer.update();
    }
}
