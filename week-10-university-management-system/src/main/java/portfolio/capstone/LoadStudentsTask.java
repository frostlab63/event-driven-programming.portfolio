package portfolio.capstone;

import javafx.collections.FXCollections; import javafx.collections.ObservableList; import javafx.concurrent.Task;

public final class LoadStudentsTask extends Task<ObservableList<Student>> {
    private final StudentDao dao;
    public LoadStudentsTask(StudentDao dao){ this.dao=dao; }
    @Override protected ObservableList<Student> call() throws Exception { return FXCollections.observableArrayList(dao.findAll()); }
}
