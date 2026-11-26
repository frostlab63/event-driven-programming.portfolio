package legacy;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public final class LegacyObserverDemo {
    private static final class Temperature extends Observable {
        void set(double value) { setChanged(); notifyObservers(value); }
    }
    public static void main(String[] args) {
        Temperature subject = new Temperature();
        Observer display = (source, value) -> System.out.println("Legacy observer received: " + value);
        subject.addObserver(display);
        subject.set(24.5);
        subject.deleteObserver(display);
    }
}
