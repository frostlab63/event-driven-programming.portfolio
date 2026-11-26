# Week 10 setup and acceptance record

## Clean setup

```bash
mysql -u "$DB_USER" -p < sql/schema.sql
export DB_URL='jdbc:mysql://localhost:3306/university_db'
export DB_USER='root'
export DB_PASSWORD='your-local-password'
cd week-10-university-management-system
mvn javafx:run
```

## Acceptance sequence

1. The shell opens with the Students view.
2. Programs are loaded from MySQL into the program selector.
3. The Save button remains disabled until registration, name, and email are present.
4. Saving creates a `SaveStudentTask`; SQL work is not performed on the JavaFX Application Thread.
5. A successful save clears the form and starts `LoadStudentsTask`.
6. The table displays registration, name, email, and program.
7. Every five seconds the scheduler calls back onto the JavaFX thread, updates the shell status, and requests a reload.

The build is verified in the sandbox. Steps that require MySQL and a visible desktop window remain explicitly marked as database/desktop checks until run on a configured workstation.
