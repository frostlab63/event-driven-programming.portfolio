package portfolio.capstone;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public final class StudentController {
    @FXML private TextField registration;
    @FXML private TextField firstName;
    @FXML private TextField lastName;
    @FXML private TextField email;
    @FXML private ComboBox<Program> program;
    @FXML private Button saveButton;
    @FXML private Label status;
    @FXML private ProgressIndicator progress;
    @FXML private TableView<Student> table;
    @FXML private TableColumn<Student, String> regColumn;
    @FXML private TableColumn<Student, String> firstColumn;
    @FXML private TableColumn<Student, String> lastColumn;
    @FXML private TableColumn<Student, String> emailColumn;
    @FXML private TableColumn<Student, String> programColumn;

    private final StudentDao dao = new StudentDao();

    @FXML
    private void initialize() {
        regColumn.setCellValueFactory(c -> c.getValue().registrationNumberProperty());
        firstColumn.setCellValueFactory(c -> c.getValue().firstNameProperty());
        lastColumn.setCellValueFactory(c -> c.getValue().lastNameProperty());
        emailColumn.setCellValueFactory(c -> c.getValue().emailProperty());
        programColumn.setCellValueFactory(c -> new SimpleStringProperty(
                c.getValue().getProgram() == null ? "" : c.getValue().getProgram().name()));

        saveButton.disableProperty().bind(
                registration.textProperty().isEmpty()
                        .or(firstName.textProperty().isEmpty())
                        .or(lastName.textProperty().isEmpty())
                        .or(email.textProperty().isEmpty()));
        loadPrograms();
        loadStudents();
    }

    private void loadPrograms() {
        Task<ObservableList<Program>> task = new Task<>() {
            @Override protected ObservableList<Program> call() throws Exception {
                return FXCollections.observableArrayList(dao.findPrograms());
            }
        };
        task.setOnSucceeded(e -> program.setItems(task.getValue()));
        task.setOnFailed(e -> status.setText("Program load failed: " + task.getException().getMessage()));
        new Thread(task, "program-loader").start();
    }

    public void reload() {
        loadStudents();
    }

    private void loadStudents() {
        LoadStudentsTask task = new LoadStudentsTask(dao);
        task.setOnRunning(e -> status.setText("Loading students..."));
        task.setOnSucceeded(e -> {
            table.setItems(task.getValue());
            status.setText("Loaded " + task.getValue().size() + " students");
        });
        task.setOnFailed(e -> status.setText("Database error: " + task.getException().getMessage()));
        new Thread(task, "student-loader").start();
    }

    @FXML
    private void save() {
        Student student = new Student(0, registration.getText().trim(), firstName.getText().trim(),
                lastName.getText().trim(), email.getText().trim(), program.getValue());
        SaveStudentTask task = new SaveStudentTask(dao, student);
        progress.visibleProperty().bind(task.runningProperty());
        saveButton.disableProperty().bind(task.runningProperty()
                .or(registration.textProperty().isEmpty())
                .or(firstName.textProperty().isEmpty())
                .or(lastName.textProperty().isEmpty())
                .or(email.textProperty().isEmpty()));
        task.setOnSucceeded(e -> {
            status.setText("Saved " + student.getRegistrationNumber());
            registration.clear();
            firstName.clear();
            lastName.clear();
            email.clear();
            program.getSelectionModel().clearSelection();
            loadStudents();
        });
        task.setOnFailed(e -> status.setText("Save failed: " + task.getException().getMessage()));
        new Thread(task, "student-saver").start();
    }
}