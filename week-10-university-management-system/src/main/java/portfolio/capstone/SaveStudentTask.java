package portfolio.capstone;
import javafx.concurrent.Task;
public final class SaveStudentTask extends Task<Void> { private final StudentDao dao; private final Student student; public SaveStudentTask(StudentDao dao,Student student){this.dao=dao;this.student=student;} @Override protected Void call() throws Exception{dao.insert(student);return null;} }
