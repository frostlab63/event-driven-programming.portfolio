package portfolio.capstone;

import javafx.beans.property.*;

public final class Student {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty registrationNumber = new SimpleStringProperty();
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();
    private final ObjectProperty<Program> program = new SimpleObjectProperty<>();

    public Student() { }
    public Student(int id, String registrationNumber, String firstName, String lastName, String email, Program program) {
        this.id.set(id); this.registrationNumber.set(registrationNumber); this.firstName.set(firstName);
        this.lastName.set(lastName); this.email.set(email); this.program.set(program);
    }
    public IntegerProperty idProperty(){ return id; }
    public StringProperty registrationNumberProperty(){ return registrationNumber; }
    public StringProperty firstNameProperty(){ return firstName; }
    public StringProperty lastNameProperty(){ return lastName; }
    public StringProperty emailProperty(){ return email; }
    public ObjectProperty<Program> programProperty(){ return program; }
    public String getRegistrationNumber(){ return registrationNumber.get(); }
    public String getFirstName(){ return firstName.get(); }
    public String getLastName(){ return lastName.get(); }
    public String getEmail(){ return email.get(); }
    public Program getProgram(){ return program.get(); }
}
