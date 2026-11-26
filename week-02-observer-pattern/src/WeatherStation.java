import java.util.ArrayList;
import java.util.List;

public final class WeatherStation {
    private final List<Observer> observers = new ArrayList<>();
    private WeatherReading current;
    public void subscribe(Observer observer) { observers.add(observer); }
    public void unsubscribe(Observer observer) { observers.remove(observer); }
    public void publish(WeatherReading reading) { current = reading; observers.forEach(o -> o.update(current)); }
    public int subscriberCount() { return observers.size(); }
}
