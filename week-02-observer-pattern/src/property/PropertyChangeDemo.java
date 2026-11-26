package property;

import java.beans.PropertyChangeSupport;

public final class PropertyChangeDemo {
    private static final class Person {
        private final PropertyChangeSupport changes = new PropertyChangeSupport(this);
        private String name;
        void onChange(java.beans.PropertyChangeListener listener) { changes.addPropertyChangeListener(listener); }
        void setName(String next) { String previous = name; name = next; changes.firePropertyChange("name", previous, next); }
    }
    public static void main(String[] args) {
        Person person = new Person();
        person.onChange(event -> System.out.println(event.getPropertyName() + ": " + event.getOldValue() + " -> " + event.getNewValue()));
        person.setName("Alice");
        person.setName("Bob");
    }
}
