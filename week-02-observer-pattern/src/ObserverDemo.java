public final class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        Observer current = r -> System.out.printf("Current: %.1f°C, %.0f%% humidity%n", r.temperature(), r.humidity());
        Observer warning = r -> { if (r.temperature() > 30) System.out.println("Warning: hot day"); };
        station.subscribe(current); station.subscribe(warning);
        station.publish(new WeatherReading(31.5, 58, 1012));
        station.unsubscribe(warning);
        System.out.println("Remaining observers: " + station.subscriberCount());
    }
}
